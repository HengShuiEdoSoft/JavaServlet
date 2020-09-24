<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/onepiece/shared/header.jsp"%>
<link href="/assets/layuiadmin/style/page.css" rel="stylesheet" />
<style type="text/css">
.c1 {
	font-weight: 700
}

.layui-table td {
	height: auto;
	overflow: visible;
	white-space: nowrap;
	text-overflow: ellipsis;
}
</style>
</head>
<body>
	<div class="layui-card layadmin-header" style="display: block">
		<div class="layui-breadcrumb" lay-filter="breadcrumb">
			<a lay-href="">主页</a> <a><cite>内容系统</cite></a> <a><cite>分类管理</cite></a>
		</div>
	</div>
	<div class="layui-fluid">
		<div class="layui-card">
			<div class="layui-card-body">
				<div style="padding-bottom: 10px;">
					<a class="layui-btn layuiadmin-btn-admin" href="typeAdd.jsp">添加</a>
				</div>
				<table id="tableList"></table>
				<!-- <table class="layui-table">
					<colgroup>
						<col width="80">
						<col>
						<col width="100">
						<col width="60">
						<col width="150">
						<col width="150">
					</colgroup>
					<thead>
						<tr>
							<th style="text-align: center">ID</th>
							<th>分类名称</th>
							<th style="text-align: center">目录</th>
							<th style="text-align: center">排序</th>
							<th style="text-align: center;">管理员</th>
							<th style="text-align: center">操作</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td align="center">1</td>
							<td rel="" name="TypeName" align="left">分类名称</td>
							<td align="center" name="Catalog" class="typeedit" rel="">目录</td>
							<td align="center" name="SortID" class="typeedit" rel="">排序</td>
							<td align="center" name="TypeMaster" class="typeedit" rel=""
								style="width: 150px; overflow: hidden">管理员</td>
							<td align="center"><a
								class="layui-btn layui-btn-normal layui-btn-xs" href="typeEdit.jsp"><i
									class="layui-icon layui-icon-edit"></i>编辑</a> <a
								class="layui-btn layui-btn-danger layui-btn-xs"
								layadmin-event="del" data-id=""><i
									class="layui-icon layui-icon-delete"></i>删除</a></td>
						</tr>
					</tbody>
				</table> -->
			</div>
		</div>
	</div>
	<script src="/assets/layuiadmin/layui/layui.js"></script>
	<script type="text/html" id="barDemo">
<a class="layui-btn layui-btn-normal layui-btn-xs" href="typeEdit.jsp"><i class="layui-icon layui-icon-edit"></i>编辑</a>
<a class="layui-btn layui-btn-danger layui-btn-xs" layadmin-event="del" data-id=""><i class="layui-icon layui-icon-delete"></i>删除</a>
</script>
	<script>
		layui.config({
			base : '/assets/layuiadmin/' //静态资源所在路径
		}).extend({
			index : 'lib/index' //主入口模块
		}).use([ 'index', 'set', 'table' ], function() {
			var admin = layui.admin, $ = layui.$, table = layui.table;
			admin.events.del = function(othis) {
				console.log(othis.data("id"));
				layer.confirm('删除后不可恢复,确定？', function(index) {
					location.href = '';
				});
			};
			/*   $.get("/Common_Type/listsql", function(res){
				  console.log(res)
				  });
			   */
			  //第一个实例
			  table.render({
			    elem: '#tableList'
			    ,url: '/Common_Type/listsql' //数据接口			   
			    ,cols: [[ //表头
			       {field: 'iD', title: 'ID', width:80, sort: true, fixed: 'left'}
			      ,{field: 'typeName', title: '分类名称'}
			      ,{field: 'tempIndex', title: '目录', width:120}
			      ,{field: 'sortID', title: '排序', width:80,align:'center'} 
			      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
			    ]]
			  });		
		});
	</script>
</body>
</html>
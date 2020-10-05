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
				<table id="tableList" lay-filter="tableList"></table>
			</div>
		</div>
	</div>
	<script src="/assets/layuiadmin/layui/layui.js"></script>
	<script type="text/html" id="barDemo">
<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>编辑</a>
<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon layui-icon-delete"></i>删除</a>
</script>	
	<script>
    layui.config({
        base: '/assets/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'set', 'table'], function () {
        var admin = layui.admin, $ = layui.$, table = layui.table;
        table.render({
            elem: '#tableList',
            url: '/Common_Type/select', 
            cols: [[ //表头
                {field: 'iD', title: 'ID', width: 80, sort: true, fixed: 'left'} ,
                {field: 'typeName', title: '分类名称'}, 
                {field: 'tempIndex', title: '目录', width: 120} , 
                {field: 'sortID', title: '排序', width: 80, align: 'center'}, 
                {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 150}
            ]]
    });
//监听工具条 
  table.on('tool(tableList)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
    var data = obj.data; //获得当前行数据
    var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
    if(layEvent === 'del'){
  	 layer.confirm('删除后不可恢复,确定？', function (index) {
           $.ajax({
               type: 'get',
               url: '/Common_Type/deletesql', 
               data:{ID:data.iD},
               dataType: 'json',
               success: function (res) {
                   layer.msg(res.msg); 
                   window.location.href = '/onepiece/article/typeList.jsp';
               }
           })
           layer.close();
        });
    } else if(layEvent === 'edit'){
  	  location.href = '/onepiece/article/typeEdit.jsp?id='+data.iD;
    }
  });
});
</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/onepiece/shared/header.jsp"%>
</head>
<body>
	<div class="layui-card layadmin-header" style="display: block">
		<div class="layui-breadcrumb" lay-filter="breadcrumb">
			<a lay-href="">主页</a> <a><cite>内容系统</cite></a> <a><cite>文章列表</cite></a>
		</div>
	</div>
	<div class="layui-fluid">
		<div class="layui-card">
			<div class="layui-form layui-card-header layuiadmin-card-header-auto">
					<div class="layui-form-item">
						<div class="layui-inline" style="width: 250px">
							<label class="layui-form-label">文章标题</label>
							<div class="layui-input-block">
								<input type="text" name="Title"  id ="Title" placeholder="请输入" value=""
									autocomplete="off" class="layui-input" />
							</div>
						</div>
						<div class="layui-inline" style="width: 250px">
							<label class="layui-form-label">所属分类</label>
							<div class="layui-input-block">
								<select name="TypeID" id="TypeID">
									<option value="0">全部分类</option>
									<option value="">1</option>
								</select>
							</div>
						</div>
						
						<div class="layui-inline" style="width: 250px">
							<label class="layui-form-label">状态</label>
							<div class="layui-input-block">
								<select name="ArtState" id="ArtState">
									<option value="0">选择状态</option>
									<option value="1">未审核</option>
									<option value="2">审核通过</option>
									<option value="3">审核驳回</option>
								</select>
							</div>
						</div>
								
						<div class="layui-inline" style="width:250px">
                            <label class="layui-form-label">时间</label>
                            <div class="layui-input-block">
                                <input type="text" name="CDate" id="CDate" value="" required
                                       lay-verify="required" autocomplete="off" class="layui-input"/>
                            </div>
						</div>
						<div class="layui-inline">
							<button class="layui-btn layuiadmin-btn-admin" id="search" >
								<i class="layui-icon layui-icon-search layuiadmin-button-btn"></i>
							</button>
						</div>
					</div>
			</div>
			<div class="layui-card-body">
				<div style="padding-bottom: 10px;">
					<a class="layui-btn layuiadmin-btn-admin" href="add.jsp">添加</a> <span
						style="color: #FE0000;">注：文章只要经过顶层部门审核通过即可正常显示.</span>
				</div>
				     <table id="tableList" lay-filter="tableList"></table>
		     </div>
		</div>
	</div>
	<script src="/assets/layuiadmin/layui/layui.js"></script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit"><i
            class="layui-icon layui-icon-edit"></i>编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i
            class="layui-icon layui-icon-delete"></i>删除</a>
</script>


<script>
    layui.config({
        base: '/assets/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'set', 'table'], function () {
        var admin = layui.admin, $ = layui.$, table = layui.table;
        table.render({
            elem: '#tableList'
            , url: '/common/listsql' //数据接口
            , cols: [[ //表头
                {field: 'iD', title: 'ID', width: 50, sort: true, fixed: 'left'}
                , {field: 'title', title: '文章标题'}
                , {field: 'hit', title: '点击量', width: 120}
                , {field: 'typeID', title: '文章类别', width: 120}
                , {field: 'cDate', title: '发布时间', width: 120}
                , {field: 'author', title: '发布人', width: 80}
                , {field: 'artState', title: '状态', width: 80, align: 'center'}
                , {field: 'branchID', title: '处理意见', width: 80}
                , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 150}
            ]],
            id:'tableOne'
        });
        //监听工具条 
        table.on('tool(tableList)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
          var data = obj.data; //获得当前行数据
          var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
          if(layEvent === 'del'){
        	 layer.confirm('删除后不可恢复,确定？', function (index) {
                 $.ajax({
                     type: 'get',
                     url: '/common/deletesql', 
                     data:{ID:data.iD},
                     dataType: 'json',
                     success: function (res) {
                         layer.msg(res.msg); 
                         window.location.href = '/onepiece/article/list.jsp';
                     }
                 })
                 layer.close();
              });
          } else if(layEvent === 'edit'){ 
        	  location.href = '/onepiece/article/edit.jsp?id='+data.iD;
          }
        });    
        // 执行搜索，表格重载
        $('#search').on('click', function () {
            // 搜索条件
            var Title = $('#Title').val();
            var TypeID = $('#TypeID').val();
            var ArtState = $('#ArtState').val();
            var CDate = $('#CDate').val();
            table.reload('tableOne', {
              method: 'post'
              ,url:'/common/listlike'
              , where: {
                'Title': Title,
                'TypeID': TypeID,
                'ArtState': ArtState,
                'CDate': CDate,
              }
              , page: {
                curr: 1
              }
            });
          })
    }).use('laydate', function () {
        var laydate = layui.laydate;
        laydate.render({
            elem: '#CDate'
        });
    });
</script>
</body>
</html>
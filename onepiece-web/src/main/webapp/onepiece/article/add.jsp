<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/onepiece/shared/header.jsp"%>

    <!-- 加载编辑器的容器 -->
    <script id="container" name="content" type="text/plain">
       
    </script>
    <!-- 配置文件 -->
    <script type="text/javascript" src="/ueditor/ueditor.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script type="text/javascript" src="/ueditor/ueditor.all.js"></script>
</head>
<body>
	<div class="layui-fluid">
		<div class="layui-row layui-col-space15">
			<div class="layui-col-md12">
				<div class="layui-card">
					<div class="layui-card-header">添加文章</div>
					<div class="layui-card-body" pad15>
						 <form class="layui-form" wid100>
							<div class="layui-form-item">
								<label class="layui-form-label">文章标题</label>
								<div class="layui-input-block">
									<input type="text" name="Title" value="" lay-verify="required"
										lay-verType="tips" required autocomplete="off"
										class="layui-input" />
									<div class="layui-form-mid layui-word-aux" >*字段名：Title</div>
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">网页标题</label>
								<div class="layui-input-block">
									<textarea name="TitleWeb" class="layui-textarea"></textarea>
									<div class="layui-form-mid layui-word-aux">字段名：TitleWeb</div>
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">网页关键字</label>
								<div class="layui-input-block">
									<textarea name="KeyWords" class="layui-textarea"
										placeholder="多个关键词用英文状态 , 号分割"></textarea>
									<div class="layui-form-mid layui-word-aux">字段名：KeyWords</div>
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">META描述</label>
								<div class="layui-input-block">
									<textarea name="Description" class="layui-textarea"></textarea>
									<div class="layui-form-mid layui-word-aux">字段名：Description</div>
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">来源</label>
								<div class="layui-input-block">
									<input type="text" name="Source" value="" autocomplete="off"
										class="layui-input" />
									<div class="layui-form-mid layui-word-aux">字段名：Source</div>
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">外链</label>
								<div class="layui-input-block">
									<input type="text" name="Url" value="" autocomplete="off"
										class="layui-input" />
									<div class="layui-form-mid layui-word-aux">字段名：Url
										注：当外链不为空时，点击文章链接，会跳转相应外链。</div>
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">作者</label>
								<div class="layui-input-block">
									<input type="text" name="Author" value="" autocomplete="off"
										class="layui-input" />
									<div class="layui-form-mid layui-word-aux">字段名：Author</div>
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">发布日期</label>
								<div class="layui-input-inline">
									<input type="text" name="CDate" value="" id="CDate"
										autocomplete="off" class="layui-input" />
								</div>
								<div class="layui-form-mid layui-word-aux">字段名：CDate</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">类别</label>
								<div class="layui-input-inline">
									<select name="TypeID" lay-verify="required" lay-verType="tips">
										<option value="0">选择分类</option>
										<option value="1">1</option>
									</select>
									<div class="layui-form-mid layui-word-aux">字段名：TypeID</div>
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">文章封面</label>
								<div class="layui-input-inline">
									<input name="Img" id="Img" placeholder="封面地址" value=""
										class="layui-input" />
								</div>
						
								<div class="layui-input-inline layui-btn-container" style="width: auto;">
                                    <button type="button" class="layui-btn layui-btn-primary" id="LAY_ImgUpload">
                                        <i class="layui-icon">&#xe67c;</i>上传图片
                                    </button>	
									
									
									<button class="layui-btn layui-btn-primary" type="button"
										layadmin-event="imgPreview">查看图片</button>
								</div>
								<div class="layui-input-inline layui-form-mid layui-word-aux">字段名：Img</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">独立附件</label>
								<div class="layui-input-inline">
									<input name="FileUrl" id="FileUrl" placeholder="附件地址" value=""
										class="layui-input" />
								</div>
								<div class="layui-input-inline layui-btn-container"
									style="width: auto;">
									<button type="button" class="layui-btn layui-btn-primary"
										id="LAY_fileUpload">
										<i class="layui-icon">&#xe67c;</i>上传附件
									</button>
								</div>
								
								
								<div class="layui-form-mid layui-word-aux">字段名：FileUrl</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">附加属性</label>
								<div class="layui-input-inline">
									<input type="checkbox" name="IsNew" value="1" title="最新" lay-skin="primary" checked> 
									<input type="checkbox" name="Hot" value="1" title="最热" lay-skin="primary" checked>
								 	<input type="checkbox" name="IsSlide" value="1" title="幻灯片"	lay-skin="primary" checked>
								</div>
								<div class="layui-form-mid layui-word-aux">注：当勾选幻灯片时，必须上传封面，否则幻灯片引用失效</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">单独模板</label>
								<div class="layui-input-inline">
									<input type="text" name="TempShow" value="" autocomplete="off"
										class="layui-input" />
								</div>
								<div class="layui-form-mid layui-word-aux">字段名：TempShow.指定文章单独模板，为空则继承分类中设置的详情模板</div>
							</div>
							
						
							
							<div class="layui-form-item">
								<label class="layui-form-label">文章详情</label>
								<div class="layui-input-block">
									<textarea name="Body" id="Body"
										class="layui-textarea edoeditor"></textarea>
									<div class="layui-form-mid layui-word-aux">字段名：Body</div>
								</div>
							</div>
							  <!-- 实例化编辑器 -->

		<!-- 					<div class="layui-form-item layui-hide" id="bd1">
								<label class="layui-form-label">文章详情1</label>
								<div class="layui-input-block">
									<textarea name="Body1" id="Body1"
										class="layui-textarea edoeditor"></textarea>
									<div class="layui-form-mid layui-word-aux">字段名：Body1</div>
								</div>
							</div>
							<div class="layui-form-item layui-hide" id="bd2">
								<label class="layui-form-label">文章详情2</label>
								<div class="layui-input-block">
									<textarea name="Body2" id="Body2"
										class="layui-textarea edoeditor"></textarea>
									<div class="layui-form-mid layui-word-aux">字段名：Body2</div>
								</div>
							</div> -->
							
							<div class="layui-form-item">
								<div class="layui-input-block">
									<button class="layui-btn" lay-submit lay-filter="save">确认保存</button>
								</div>
							</div>
						</div>
					</form>
		       </div>
            </div>
        </div>
    </div>


	<script src="/assets/layuiadmin/layui/layui.js"></script>
	<script>
		layui.config({
			base : '/assets/layuiadmin/' //静态资源所在路径
		}).extend({
				index : 'lib/index' //主入口模块
		}).use([ 'index', 'set' ],function() {
			var $ = layui.$, upload = layui.upload, admin = layui.admin, form = layui.form;
			form.on('submit(save)', function(data) {
				var data = data.field;
				$.ajax({
					type : 'post',
					url : "/common/addsql",
					data : data,
					dataType : 'json',
					timeout : 3000,
					success : function(res) {
						console.log(res)
						if(res.code===0){
							layer.msg(res.msg,function() {
								window.location.href = '/onepiece/article/list.jsp';
							});
						}else{
							layer.msg(res.msg)
						}			
					},
					error : function(xhr, type) {
						alert('Ajax error!')
					}
				});
				return false;
			});
		}).use('laydate', function() {
					var laydate = layui.laydate;
					laydate.render({
						elem : '#CDate'
					});
				})

	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/onepiece/shared/header.jsp" %>
</head>
<body>
    <div class="layui-fluid">
        <div class="layui-row layui-col-space15">
            <div class="layui-col-md12">
                <div class="layui-card">
                    <div class="layui-card-header">编辑文章</div>
                    <div class="layui-card-body" pad15>
                                    <form class="layui-form" wid100 lay-filter="form">
                            <div class="layui-form-item">
                                <label class="layui-form-label">文章标题</label>
                                <div class="layui-input-block">
                                    <input type="text" name="title" value="" lay-verify="required" lay-verType="tips" required autocomplete="off" class="layui-input" />
                                    <div class="layui-form-mid layui-word-aux">*字段名：Title</div>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">网页标题</label>
                                <div class="layui-input-block">
                                    <textarea name="titleWeb" class="layui-textarea"></textarea>
                                    <div class="layui-form-mid layui-word-aux">字段名：TitleWeb</div>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">网页关键字</label>
                                <div class="layui-input-block">
                                    <textarea name="keyWords" class="layui-textarea" placeholder="多个关键词用英文状态 , 号分割"></textarea>
                                    <div class="layui-form-mid layui-word-aux">字段名：KeyWords</div>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">META描述</label>
                                <div class="layui-input-block">
                                    <textarea name="description" class="layui-textarea"></textarea>
                                    <div class="layui-form-mid layui-word-aux">字段名：Description</div>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">来源</label>
                                <div class="layui-input-block">
                                    <input type="text" name="source" value="" autocomplete="off" class="layui-input" />
                                    <div class="layui-form-mid layui-word-aux">字段名：Source</div>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">外链</label>
                                <div class="layui-input-block">
                                    <input type="text" name="url" value="" autocomplete="off" class="layui-input" />
                                    <div class="layui-form-mid layui-word-aux">字段名：Url 注：当外链不为空时，点击文章链接，会跳转相应外链。</div>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">作者</label>
                                <div class="layui-input-block">
                                    <input type="text" name="author" value="" autocomplete="off" class="layui-input" />
                                    <div class="layui-form-mid layui-word-aux">字段名：Author</div>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">发布日期</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="cDate" value="" id="CDate" autocomplete="off" class="layui-input" />
                                </div>
                                <div class="layui-form-mid layui-word-aux">字段名：CDate</div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">类别</label>
                                <div class="layui-input-inline">
                                    <select name="typeID" lay-verify="required" lay-verType="tips">
                                       	<option value="0">选择分类</option>
										<option value="1">1</option>                                 
                                    </select>
                                    <div class="layui-form-mid layui-word-aux">字段名：TypeID</div>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">文章封面</label>
                                <div class="layui-input-inline">
                                    <input name="img" id="Img" placeholder="封面地址" value="" class="layui-input" />
                                </div>
                                <div class="layui-input-inline layui-btn-container" style="width: auto;">
                                    <button type="button" class="layui-btn layui-btn-primary" id="LAY_ImgUpload">
                                        <i class="layui-icon">&#xe67c;</i>上传图片
                                    </button>
                                    <button class="layui-btn layui-btn-primary" type="button" layadmin-event="imgPreview">查看图片</button>
                                </div>
                                <div class="layui-input-inline layui-form-mid layui-word-aux">字段名：Img</div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">独立附件</label>
                                <div class="layui-input-inline">
                                    <input name="fileUrl" id="FileUrl" placeholder="附件地址" value="" class="layui-input" />
                                </div>
                                <div class="layui-input-inline layui-btn-container" style="width: auto;">
                                    <button type="button" class="layui-btn layui-btn-primary" id="LAY_fileUpload">
                                        <i class="layui-icon">&#xe67c;</i>上传附件
                                    </button>
                                </div>
                                <div class="layui-form-mid layui-word-aux">字段名：FileUrl</div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">附加属性</label>
                                <div class="layui-input-inline">
                                    <input type="checkbox" name="isNew" value="1" title="最新" lay-skin="primary" checked >
                                    <input type="checkbox" name="hot" value="1" title="最热" lay-skin="primary"  checked>
                                    <input type="checkbox" name="isSlide" value="1" title="幻灯片" lay-skin="primary" checked>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">单独模板</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="tempShow" value="" autocomplete="off" class="layui-input" />
                                </div>
                                <div class="layui-form-mid layui-word-aux">字段名：TempShow.指定文章单独模板，为空则继承分类中设置的详情模板</div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">文章详情</label>
                                <div class="layui-input-block">
                                    <textarea name="body" id="Body" class="layui-textarea edoeditor"></textarea>
                                    <div class="layui-form-mid layui-word-aux">字段名：Body</div>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <div class="layui-input-block">
                                    <button class="layui-btn" lay-submit  lay-filter="save">确认保存</button><button class="layui-btn" type="button" layadmin-event="back">返回上页</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

<script src="/assets/layuiadmin/layui/layui.js"></script>
<script>
    layui.config({
        base: '/assets/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'set'], function () {
        var $ = layui.$, upload = layui.upload, admin = layui.admin, form = layui.form;
        var ID=getQueryVariable("id");     
        $.ajax({
            type: 'post',
            url: '/common/iDlistsql', 
            data:{ID},
            dataType: 'json',   
            success: function (res) {
            	console.log(res.data)
                form.val('form',res.data)
            }
        })
        form.on('submit(save)', function (data) {
            var data = data.field;
            $.ajax({
                type: 'post',
                url: "/common/editsql?ID="+ID,
                data: data,
                dataType: 'json',
                timeout: 3000,
                success: function (res) {
                    layer.msg(res.msg, function () {
                        window.location.href = '/onepiece/article/list.jsp';
                    });
                },
                error: function (xhr, type) {
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
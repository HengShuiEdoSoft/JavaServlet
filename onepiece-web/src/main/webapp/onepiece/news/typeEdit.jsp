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
                    <div class="layui-card-header">编辑分类</div>
                    <div class="layui-card-body">
                        <form class="layui-form" wid100 lay-filter="" action="" method="post">
                            <div class="layui-form-item">
                                <label class="layui-form-label">分类名称</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="TypeName" value="" lay-verify="required" lay-verType="tips" autocomplete="off" class="layui-input" />
                                </div>
                                <div class="layui-form-mid layui-word-aux">*</div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">所属分类</label>
                                <div class="layui-input-inline">
                                    <select name="ParentID" lay-verify="">
                                        <option  value="0">顶层分类</option>                                       
                                    </select>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">排序ID</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="SortID" value="" lay-verify="number" autocomplete="off" class="layui-input" />
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">分类封面</label>
                                <div class="layui-input-inline">
                                    <input name="Img" id="Img" placeholder="图片地址" value="" class="layui-input" />
                                </div>
                                <div class="layui-input-inline layui-btn-container" style="width: auto;">
                                    <button type="button" class="layui-btn layui-btn-primary" id="LAY_avatarUpload">
                                        <i class="layui-icon">&#xe67c;</i>上传图片
                                    </button>
                                    <button type="button" class="layui-btn layui-btn-primary" layadmin-event="imgview">查看图片</button>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">展示类型</label>
                                <div class="layui-input-block">
                                    <input type="radio" name="PageType" value="0" title="列表"  lay-filter="ptype" />
                                    <input type="radio" name="PageType" value="1" title="封面"  lay-filter="ptype" />
                                    <input type="radio" name="PageType" value="2" title="单页"  lay-filter="ptype" />
                                </div>
                                <div class="layui-input-block">
                                    <div class="layui-form-mid layui-word-aux">*列表模式返回数据列表，对应列表模板；封面模式返回空页面，对应封面模板；单页模式返回当前分类最新文章，对应详情模板</div>
                                </div>
                            </div>
                            <div class="layui-form-item"  id="tmp">
                                <label class="layui-form-label">封面模板</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="TempIndex" value="" autocomplete="off" class="layui-input" />
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">列表模板</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="TempList" value="" autocomplete="off" class="layui-input" />
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">详情模板</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="TempShow" value="" autocomplete="off" class="layui-input" />
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">每页数量</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="PageSize" value="" lay-verify="number" autocomplete="off" class="layui-input" />
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">目录设置</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="Catalog" value="" autocomplete="off" class="layui-input" />
                                </div>
                                <div class="layui-form-mid layui-word-aux">*默认为名称首拼</div>
                            </div>
                            <div class="layui-form-item">
                                <div class="layui-input-block">
                                    <button class="layui-btn" lay-submit>确认保存</button>
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
			base : '/assets/layuiadmin/' //静态资源所在路径
		}).extend({
            index: 'lib/index' //主入口模块
        }).use(['index', 'set'], function () {
            var $ = layui.$, upload = layui.upload, admin = layui.admin, form = layui.form;
            var avatarSrc = $('#Img');
            upload.render({
                url: ''
                , elem: '#LAY_avatarUpload'
                , done: function (res) {
                    if (res.code == 1) {
                        avatarSrc.val(res.data);
                    } else {
                        layer.msg(res.msg);
                    }
                }
            });
            //查看头像
            admin.events.imgview = function (othis) {
                var src = avatarSrc.val() + "?" + new Date();
                layer.photos({
                    photos: {
                        "title": "查看封面" //相册标题
                        , "data": [{
                            "src": src //原图地址
                        }]
                    }
                    , shade: 0.01
                    , closeBtn: 1
                    , anim: 5
                });
            };
            form.on('radio(ptype)', function (data) {
                console.log(data.value);
                var v = data.value;
                if (v == 1) {
                    $('#tmp').slideDown();
                } else {
                    $('#tmp').slideUp();
                }
            });
        });
    </script>
</body>
</html>
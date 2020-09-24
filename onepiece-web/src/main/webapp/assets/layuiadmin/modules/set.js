/**

 @Name：layuiAdmin（iframe版） 设置
 @Author：贤心
 @Site：http://www.layui.com/admin/
 @License: LPPL
    
 */

layui.define(['form', 'upload'], function (exports) {
    var $ = layui.$
        , layer = layui.layer
        , laytpl = layui.laytpl
        , setter = layui.setter
        , view = layui.view
        , admin = layui.admin
        , form = layui.form
        , upload = layui.upload;

    var $body = $('body');

    //自定义验证
    form.verify({
        nickname: function (value, item) { //value：表单的值、item：表单的DOM对象
            if (!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)) {
                return '用户名不能有特殊字符';
            }
            if (/(^\_)|(\__)|(\_+$)/.test(value)) {
                return '用户名首尾不能出现下划线\'_\'';
            }
            if (/^\d+\d+\d$/.test(value)) {
                return '用户名不能全为数字';
            }
        }

        //我们既支持上述函数式的方式，也支持下述数组的形式
        //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
        , pass: [
            /^[\S]{6,12}$/
            , '密码必须6到12位，且不能出现空格'
        ]

        //确认密码
        , repass: function (value) {
            if (value !== $('#LAY_password').val()) {
                return '两次密码输入不一致';
            }
        }
    });

    //网站设置
    form.on('submit(set_website)', function (obj) {
        EdoHttp.ajaxSend(obj.field.action, obj.field, function (data) {
            if (data.code == 1) {
                layer.msg("提交成功");
            } else {
                layer.msg("提交失败");
            }
        });
        return false;
    });

    //邮件服务
    form.on('submit(set_system_email)', function (obj) {
        EdoHttp.ajaxSend(obj.field.action, obj.field, function (data) {
            if (data.code == 1) {
                layer.msg("提交成功");
            } else {
                layer.msg("提交失败");
            }
        });
        return false;
    });


    //设置我的资料
    form.on('submit(setmyinfo)', function (obj) {
        EdoHttp.ajaxSend(obj.field.action, obj.field, function (data) {
            if (data.code == 1) {
                layer.msg("提交成功");
            } else {
                layer.msg(data.msg);
            }
        });
        return false;
    });
    //设置密码
    form.on('submit(setmypass)', function (obj) {
        EdoHttp.ajaxSend(obj.field.action, obj.field, function (data) {
            if (data.code == 1) {
                layer.msg("提交成功");
            } else {
                layer.msg(data.msg);
            }
        });
        return false;
    });
    var EdoHttp = {
        ajaxSend: function (url, data, callback) {
            $.ajax({
                type: (data) ? "POST" : 'GET',
                url: url,
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                dataType: "json",
                data: data,
                cache: false,
                success: function (d) {
                    callback && callback(d);
                }
            });
        },
        httpSend: function (url, data, callback) {
            $.ajax({
                type: (data) ? "POST" : 'GET',
                url: url,
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                data: data,
                cache: false,
                success: function (d) {
                    callback && callback(d);
                }
            });
        },
        httpLoad: function (url) {
            if (url) {
                window.location.href = url;
            } else {
                if (url == '') {
                    window.location.href = "/";
                } else {
                    window.location.reload();
                }
            }
        }
    };
    //对外暴露的接口
    exports('set', EdoHttp);
});
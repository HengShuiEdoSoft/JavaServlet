<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- js索引  -->
<meta charset="utf-8" />
<meta name="renderer" content="webkit" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>title</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link rel="stylesheet" href="/assets/layuiadmin/layui/css/layui.css"media="all" />
<link rel="stylesheet" href="/assets/layuiadmin/style/admin.css"media="all" />
<script src="/assets/script/jquery.min.js"></script>
<script>
function getQueryVariable(variable){
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i=0;i<vars.length;i++) {
        var pair = vars[i].split("=");
        if(pair[0] == variable){return pair[1];}
    }
    return(false);
}
</script>


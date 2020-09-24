<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OnePiece</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<link rel="stylesheet" href="/assets/layuiadmin/layui/css/layui.css"
	media="all">
<link rel="stylesheet" href="/assets/layuiadmin/style/admin.css"
	media="all">
</head>
<body class="layui-layout-body">
	<div id="LAY_app">
		<div class="layui-layout layui-layout-admin">
			<div class="layui-header">
				<!-- 头部区域 -->
				<ul class="layui-nav layui-layout-left">
					<li class="layui-nav-item layadmin-flexible" lay-unselect><a
						href="javascript:;" layadmin-event="flexible" title="侧边伸缩"> <i
							class="layui-icon layui-icon-shrink-right" id="LAY_app_flexible"></i>
					</a></li>
					<li class="layui-nav-item layui-hide-xs" lay-unselect><a
						href="/" target="_blank" title="前台"> <i
							class="layui-icon layui-icon-website"></i>
					</a></li>
					<li class="layui-nav-item" lay-unselect><a href="javascript:;"
						layadmin-event="refresh" title="刷新"> <i
							class="layui-icon layui-icon-refresh-3"></i>
					</a></li>

				</ul>
				<ul class="layui-nav layui-layout-right"
					lay-filter="layadmin-layout-right">
					<li class="layui-nav-item layui-hide-xs" lay-unselect><a
						href="javascript:;" layadmin-event="theme"> <i
							class="layui-icon layui-icon-theme"></i>
					</a></li>
					<li class="layui-nav-item layui-hide-xs" lay-unselect><a
						href="javascript:;" layadmin-event="note"> <i
							class="layui-icon layui-icon-note"></i>
					</a></li>
					<li class="layui-nav-item layui-hide-xs" lay-unselect><a
						href="javascript:;" layadmin-event="fullscreen"> <i
							class="layui-icon layui-icon-screen-full"></i>
					</a></li>
					<li class="layui-nav-item" lay-unselect><a href="javascript:;">
							<cite>管理员</cite>
					</a>
						<dl class="layui-nav-child">
							<dd>
								<a lay-href="#">基本资料</a>
							</dd>
							<dd>
								<a lay-href="#">修改密码</a>
							</dd>
							<hr />
							<dd style="text-align: center;">
								<a href="#">退出</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item layui-hide-xs" lay-unselect><a
						href="javascript:;" layadmin-event="about"><i
							class="layui-icon layui-icon-more-vertical"></i></a></li>
					<li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm"
						lay-unselect><a href="javascript:;" layadmin-event="more"><i
							class="layui-icon layui-icon-more-vertical"></i></a></li>
				</ul>
			</div>
			<!-- 侧边菜单 -->
			<div class="layui-side layui-side-menu">
				<div class="layui-side-scroll">
					<div class="layui-logo" lay-href="home/welcome.jsp">
						<span>一多软件</span>
					</div>
					<ul class="layui-nav layui-nav-tree" lay-shrink="all"
						id="LAY-system-side-menu" lay-filter="layadmin-system-side-menu">
						<li data-name="item1" class="layui-nav-item"><a
							href="javascript:;" lay-tips="主页" lay-direction="2"><i
								class="layui-icon layui-icon-home"></i><cite>主页</cite></a>
						<dl class="layui-nav-child">
								<dd class="layui-this">
									<a lay-href="home/welcome.jsp">控制台</a>
								</dd>
							</dl></li>
						<li data-name="item3" class="layui-nav-item"><a
							href="javascript:;" lay-tips="内容系统" lay-direction="2"><i
								class="layui-icon layui-icon-list"></i><cite>内容系统</cite></a>
						<dl class="layui-nav-child">
								<dd>
									<a lay-href="news/list.jsp">文章列表</a>
								</dd>
								<dd>
									<a lay-href="news/typeList.jsp">分类管理</a>
								</dd>
							</dl></li>
						<li data-name="item20" class="layui-nav-item"><a
							href="javascript:;" lay-tips="广告系统" lay-direction="2"><i
								class="layui-icon layui-icon-senior"></i><cite>广告系统</cite></a>
						<dl class="layui-nav-child">
								<dd>
									<a lay-href="adverts/advertTypeList.jsp">广告类型</a>
								</dd>
								<dd>
									<a lay-href="adverts/advertList.jsp">广告管理</a>
								</dd>
							</dl></li>
						<li data-name="item34" class="layui-nav-item"><a
							href="javascript:;" lay-tips="标签" lay-direction="2"><i
								class="layui-icon layui-icon-note"></i><cite>标签</cite></a>
						<dl class="layui-nav-child">
								<dd>
									<a lay-href="labels/list.jsp">标签管理</a>
								</dd>
							</dl></li>
						<li data-name="item45" class="layui-nav-item"><a
							href="javascript:;" lay-tips="单页" lay-direction="2"><i
								class="layui-icon layui-icon-file"></i><cite>单页</cite></a>
						<dl class="layui-nav-child">
								<dd>
									<a lay-href="singlepage/list.jsp">单页管理</a>
								</dd>
							</dl></li>
						<li data-name="item53" class="layui-nav-item"><a
							href="javascript:;" lay-tips="友情链接" lay-direction="2"><i
								class="layui-icon layui-icon-link"></i><cite>友情链接</cite></a>
						<dl class="layui-nav-child">
								<dd>
									<a lay-href="links/typeList.jsp">链接类型</a>
								</dd>
								<dd>
									<a lay-href="links/list.jsp">链接管理</a>
								</dd>
							</dl></li>
						<li data-name="item62" class="layui-nav-item"><a
							href="javascript:;" lay-tips="用户" lay-direction="2"><i
								class="layui-icon layui-icon-user"></i><cite>用户</cite></a>
						<dl class="layui-nav-child">
								<dd>
									<a lay-href="admin/list.jsp">后台管理员</a>
								</dd>
								<dd>
									<a lay-href="branch/list.jsp">部门管理</a>
								</dd>
								<dd>
									<a lay-href="admin/roleList.jsp">角色管理</a>
								</dd>
								<dd>
									<a lay-href="admin/logsAllList.jsp">操作记录</a>
								</dd>
							</dl></li>
						<li data-name="item83" class="layui-nav-item"><a
							href="javascript:;" lay-tips="设置" lay-direction="2"><i
								class="layui-icon layui-icon-set"></i><cite>设置</cite></a>
						<dl class="layui-nav-child">
								<dd class="layui-nav-itemed">
									<a href="javascript:;">系统设置</a>
									<dl class="layui-nav-child">
										<dd>
											<a lay-href="system/webSite.jsp">网站设置</a>
										</dd>
										<dd>
											<a lay-href="system/email.jsp">邮件服务</a>
										</dd>
										<dd>
											<a lay-href="system/roleActionList.jsp">权限管理</a>
										</dd>
									</dl>
								</dd>
								<dd class="layui-nav-itemed">
									<a href="javascript:;">我的设置</a>
									<dl class="layui-nav-child">
										<dd>
											<a lay-href="admin/editUserInfo.jsp">基本资料</a>
										</dd>
										<dd>
											<a lay-href="admin/editPwd.jsp">修改密码</a>
										</dd>
										<dd>
											<a lay-href="admin/logsList.jsp">操作记录</a>
										</dd>
									</dl>
								</dd>
							</dl>
							</li>
					</ul>
				</div>
			</div>
			<!-- 页面标签 -->
			<div class="layadmin-pagetabs" id="LAY_app_tabs">
				<div class="layui-icon layadmin-tabs-control layui-icon-prev"
					layadmin-event="leftPage"></div>
				<div class="layui-icon layadmin-tabs-control layui-icon-next"
					layadmin-event="rightPage"></div>
				<div class="layui-icon layadmin-tabs-control layui-icon-down">
					<ul class="layui-nav layadmin-tabs-select"
						lay-filter="layadmin-pagetabs-nav">
						<li class="layui-nav-item" lay-unselect><a
							href="javascript:;"></a>
							<dl class="layui-nav-child layui-anim-fadein">
								<dd layadmin-event="closeThisTabs">
									<a href="javascript:;">关闭当前标签页</a>
								</dd>
								<dd layadmin-event="closeOtherTabs">
									<a href="javascript:;">关闭其它标签页</a>
								</dd>
								<dd layadmin-event="closeAllTabs">
									<a href="javascript:;">关闭全部标签页</a>
								</dd>
							</dl></li>
					</ul>
				</div>
				<div class="layui-tab" lay-unauto lay-allowClose="true"
					lay-filter="layadmin-layout-tabs">
					<ul class="layui-tab-title" id="LAY_app_tabsheader">
						<li lay-id="home/welcome.jsp" lay-attr="home/welcome.jsp"
							class="layui-this"><i class="layui-icon layui-icon-home"></i></li>
					</ul>
				</div>
			</div>
			<div class="layui-body" id="LAY_app_body">
				<div class="layadmin-tabsbody-item layui-show">
					<iframe src="home/welcome.jsp" frameborder="0"
						class="layadmin-iframe"></iframe>
				</div>
			</div>
			<div class="layadmin-body-shade" layadmin-event="shade"></div>
		</div>
	</div>
	<script src="/assets/layuiadmin/layui/layui.js"></script>
	<script>
		layui.config({
			base : '/assets/layuiadmin/' //静态资源所在路径
		}).extend({
			index : 'lib/index' //主入口模块
		}).use('index');
	</script>
</body>
</html>
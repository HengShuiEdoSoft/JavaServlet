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
				<form action="/" method="post" id="form1">
					<div class="layui-form-item">
						<div class="layui-inline" style="width: 250px">
							<label class="layui-form-label">文章标题</label>
							<div class="layui-input-block">
								<input type="text" name="NewsTitle" placeholder="请输入" value=""
									autocomplete="off" class="layui-input" />
							</div>
						</div>
						<div class="layui-inline" style="width: 250px">
							<label class="layui-form-label">所属分类</label>
							<div class="layui-input-block">
								<select name="NewsTypeID">
									<option value="1">全部分类</option>
									<option value="">1</option>
								</select>
							</div>
						</div>
						<div class="layui-inline" style="width: 250px">
							<label class="layui-form-label">状态</label>
							<div class="layui-input-block">
								<select name="ArtState">
									<option value="-1">选择状态</option>
									<option value="0">未审核</option>
									<option value="1">审核通过</option>
									<option value="2">审核驳回</option>
								</select>
							</div>
						</div>
						<div class="layui-inline" style="width: 250px">
							<label class="layui-form-label">时间</label>
							<div class="layui-input-block">
								<input type="text" class="layui-input" name="txtDate"
									id="txtDate" placeholder=" ~ " value="" readonly="readonly">
								<input type="hidden" name="txtSDate" id="txtSDate" value="" />
								<input type="hidden" name="txtEDate" id="txtEDate" value="" />
							</div>
						</div>
						<div class="layui-inline">
							<button class="layui-btn layuiadmin-btn-admin" lay-submit>
								<i class="layui-icon layui-icon-search layuiadmin-button-btn"></i>
							</button>
						</div>
					</div>
				</form>
			</div>
			<div class="layui-card-body">
				<div style="padding-bottom: 10px;">
					<a class="layui-btn layuiadmin-btn-admin" href="add.jsp">添加</a> <span
						style="color: #FE0000;">注：文章只要经过顶层部门审核通过即可正常显示.</span>
				</div>
				<div class="layui-form">
					<table class="layui-table">
						<colgroup>
							<col width="50">
							<col width="80">
							<col>
							<col width="80">
							<col width="150">
							<col width="160">
							<col width="120">
							<col width="100">
							<col width="100">
							<col width="250">
						</colgroup>
						<thead>
							<tr>
								<th>
									<div
										class="layui-table-cell laytable-cell-1-0-1 laytable-cell-checkbox">
										<input type="checkbox" lay-skin="primary" class="parchk"
											lay-filter="c_all" />
									</div>
								</th>
								<th style="text-align: center">ID</th>
								<th>文章标题</th>
								<th style="text-align: center">点击量</th>
								<th style="text-align: center">文章类别</th>
								<th style="text-align: center">发布时间</th>
								<th style="text-align: center">发布人</th>
								<th style="text-align: center">状态</th>
								<th style="text-align: center">处理意见</th>
								<th style="text-align: center">操作</th>
							</tr>
						</thead>
						<tbody>

							<tr>
								<td><div
										class="layui-table-cell laytable-cell-1-0-1 laytable-cell-checkbox">
										<input type="checkbox" value="" class="item" name="tid"
											lay-skin="primary" />
									</div></td>
								<td style="text-align: center">1</td>
								<td>文章标题<a href="" target="_blank">[预览]</a>
								</td>
								<td style="text-align: center">14</td>
								<td style="text-align: center">名校风采</td>
								<td style="text-align: center">2019/11/22 17:10:53</td>
								<td style="text-align: center">edogaokao</td>
								<td style="text-align: center">管理员组 <span
									style="color: #ff0000">未审核</span> <br /> <span
									style="color: #165d26">审核通过</span> <br /> <span
									style="color: #0026ff">审核驳回</span>
								</td>
								<td style="text-align: center"><a
									class="layui-btn layui-btn-primary layui-btn-xs views"
									data-tips="" data-remark="">查看</a></td>
								<td>
									<div class="layui-btn-group">
										<a class="layui-btn layui-btn-primary layui-btn-sm"
											href="edit.jsp">编辑</a> <a
											class="layui-btn layui-btn-primary layui-btn-sm" href="">通过</a>
										<a class="layui-btn layui-btn-primary layui-btn-sm"
											href="javascript:void(0)" layadmin-event="editstate"
											data-id="">驳回</a>
										<button type="button"
											class="layui-btn layui-btn-primary layui-btn-sm"
											layadmin-event="del" data-id="1">删除</button>
									</div>
								</td>
							</tr>
						</tbody>
						<tfoot>
							<tr>
								<th>
									<div
										class="layui-table-cell laytable-cell-1-0-1 laytable-cell-checkbox">
										<input type="checkbox" class="parchk" lay-skin="primary"
											lay-filter="c_all" />
									</div>
								</th>
								<th colspan="9"><a class="layui-btn layuiadmin-btn-admin"
									data-url="" layadmin-event="delall" href="javascript:void(0)">批量删除</a>
									<a class="layui-btn layuiadmin-btn-admin" data-url=""
									layadmin-event="passall" href="javascript:void(0)">批量通过</a> <a
									class="layui-btn layuiadmin-btn-admin" data-url=""
									layadmin-event="nopassall" href="javascript:void(0)">批量驳回</a></th>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script src="/assets/layuiadmin/layui/layui.js"></script>
	<script>
	
</body>
</html>
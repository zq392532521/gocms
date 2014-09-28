<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="fs" uri="/fs-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@include file="../util/checkParentFrame.jsp" %>
<head>
<script type="text/javascript" charset="utf-8">
	function leftMenuFlush(fid){
		p =window.parent;
		p .flushMenu(fid);
	}
	
	function openIndex(){
		openWinAtMainTabs(sy.basePath+"/admin/admin_right.do",'系统首页');
	}
  	function updatePwd (){
  		url=sy.basePath + '/admin/user_goPwd.do';
		var dialog = parent.sy.modalDialog({
			title : '修改密码',
			url :url
		});
	};

	var logoutFun = function() {
	/* 	$.post(sy.contextPath + '/base/syuser!doNotNeedSessionAndSecurity_logout.sy', function(result) {
			location.replace(sy.contextPath + '/index.jsp');
		}, 'json'); */
		window.location.href=sy.basePath + '/login_out.do';
		
	};
	var showMyInfoFun = function() {
		url=sy.basePath + '/admin/user_profile.do';
		var dialog = parent.sy.modalDialog({
			title : '我的信息',
			url :url
		});
	};
	//打开预览站点窗口
	function openNewWindow(sourcepath){
		window.open('<%=basePath %>site/'+sourcepath+'/index.html');
	}
	
</script>
<style>
.clearfix:after { content:'\0020'; display:block; height:0; clear:both; }
.clearfix { *zoom:1;
}
.test { height:50px;  line-height:50px; font-size: 20px; font-weight: bold; margin:0px auto; padding:0 0px; }
.test img{ vertical-align:middle;}
	.test a{ text-decoration:none;}
	.test	a:hover{ text-decoration:none;}
	.test	a{color:#4F6B72
		}
</style>
</head>
<div id="sessionInfoDiv" style="position: absolute; right: 10px; top: 5px;">
<%
		if (session.getAttribute("loginAdmin") != null) {
			%>
			欢迎您， ${loginAdmin.name }
			<%
		}
%>
</div>
<div style="position: absolute; left: 10px; bottom: 0px;" class="test">
				<s:if test="#session.manageSite != null">
					<a  href="javascript:void(0);" style=" font-weight: bold;" id="managerName" title="点击选择管理站点" onclick="window.parent.managerSite();" >${manageSite.name }<img src="<%=basePath%>js/easyui/jslib/jquery-easyui-1.3.4/themes/bootstrap/images/combo_arrow.png" ></a>
					<img id='managerImg' style="cursor:hand" align="bottom" onclick="openNewWindow('${manageSite.sourcepath }');" title="点击预览站点" src="../../../img/www.gif">
				</s:if>
				<s:if test="#session.manageSite == null">
					<span  id="managerName" title="点击选择管理站点" onclick="window.parent.managerSite();"  >请选择管理站点</span> 
				</s:if>
</div>
<div style="position: absolute; left: 200px; bottom: 0px;">
<s:iterator value="funcList" status="status" id="bean">
	<a href="javascript:void(0);" onclick="leftMenuFlush('<s:property value="id"/>');" class="easyui-linkbutton" data-options="iconCls:''"><s:property value="name"/></a> 
</s:iterator>
</div>
<div style="position: absolute; right: 0px; bottom: 0px;">
	<a href="javascript:void(0);" data-options="iconCls:'ext-icon-cog'" class="easyui-linkbutton"  onclick="openIndex('open');">系统首页</a>
	<a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_pfMenu',iconCls:'ext-icon-rainbow'">更换皮肤</a> 
    <a href="javascript:void(0);"  data-options="iconCls:'ext-icon-user_edit'"  class="easyui-linkbutton" onclick="updatePwd();">修改密码</a>
    <a href="javascript:void(0);"  data-options="iconCls:'ext-icon-user'"  class="easyui-linkbutton" onclick="showMyInfoFun();">我的信息</a>
    <a href="javascript:void(0);"  data-options="iconCls:'ext-icon-door_out'"  class="easyui-linkbutton" onclick="logoutFun();">退出系统</a>
</div>
<div id="layout_north_pfMenu" style="width: 120px; display: none;">
	<div onclick="sy.changeTheme('default');" title="default">default</div>
	<div onclick="sy.changeTheme('gray');" title="gray">gray</div>
	<div onclick="sy.changeTheme('metro');" title="metro">metro</div>
	<div onclick="sy.changeTheme('bootstrap');" title="bootstrap">bootstrap</div>
	<div onclick="sy.changeTheme('black');" title="black">black</div>
	<div class="menu-sep"></div>
	<div onclick="sy.changeTheme('metro-blue');" title="metro-blue">metro-blue</div>
	<div onclick="sy.changeTheme('metro-gray');" title="metro-gray">metro-gray</div>
	<div onclick="sy.changeTheme('metro-green');" title="metro-green">metro-green</div>
	<div onclick="sy.changeTheme('metro-orange');" title="metro-orange">metro-orange</div>
	<div onclick="sy.changeTheme('metro-red');" title="metro-red">metro-red</div>
</div>

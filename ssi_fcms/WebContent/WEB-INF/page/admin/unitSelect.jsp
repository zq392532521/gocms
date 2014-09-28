<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.freeteam.model.Unit"%>
<%@page import="cn.freeteam.util.UnitTree"%>
<%@include file="../util/checkParentFrame.jsp" %>
	<link rel="stylesheet" href="../../../jqueryTools/jquery.treeview.css" />
	
	<script src="../../../jqueryTools/check.js" type="text/javascript"></script>
	<script src="../../../jqueryTools/jquery.cookie.js" type="text/javascript"></script>
	<script src="../../../jqueryTools/jquery.treeview.js" type="text/javascript"></script>
	<script src="../../../jqueryTools/jquery.treeview.edit.js" type="text/javascript"></script>
	<script src="../../../jqueryTools/jquery.treeview.async.js" type="text/javascript"></script>
	<ul id="tree" class="treeview filetree">
		
	<%
	if(request.getAttribute("unitList")!=null){
		List<Unit> unitList=(List<Unit>)request.getAttribute("unitList");
		UnitTree unitTree=new UnitTree();
		out.println(unitTree.create(unitList,request.getAttribute("selectUnitIds").toString(),request));
	}
	%>
	</ul>
	
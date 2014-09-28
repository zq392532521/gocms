<%@ page language="java"  pageEncoding="UTF-8"%>
<%
String checkParentPath = request.getContextPath();
String checkParentBasePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+checkParentPath+"/";
%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

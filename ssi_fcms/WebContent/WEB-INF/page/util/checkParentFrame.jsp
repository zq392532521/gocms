<%@ page language="java"  pageEncoding="UTF-8"%>
<%
String checkParentPath = request.getContextPath();
String checkParentBasePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+checkParentPath+"/";
%>
<%-- 正式使用后验证完整url --%>
<script type="text/javascript">
<%--   if (window.top.location.href.toLowerCase().indexOf("/inc/main.jsp") == -1 ){
window.top.location.href  = "<%=checkParentBasePath%>login.jsp";
 } --%>
 checkParentBasePath='<%=checkParentBasePath%>';
</script>

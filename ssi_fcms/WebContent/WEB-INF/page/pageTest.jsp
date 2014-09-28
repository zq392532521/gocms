<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="page" uri="/page"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

   
    <title>easyDemo1.jsp</title>
</head>
<body>
 <page:pages pageNo="pageInfo.pageNo" total="pageInfo.total" 
 pageSize="pageInfo.pageSize"
								count="pageInfo.count"
							/>
								
</body>
</html>
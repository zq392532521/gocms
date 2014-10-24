<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<jsp:include page="/common/inc.jsp"></jsp:include>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>文件上传</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

    <script type="text/javascript">
            
        $(function()
        {
            $("#button").click(function()
            {
                var html = $("<input type='file' name='file'>");
                var button = $("<input type='button' name='button' value='删除'><br>");
                
                $("#body div").append(html).append(button);
                
                button.click(function()
                {
                    html.remove();
                    button.remove();
                })
            })
        })
    
    </script>
  </head>
  
  <body id="body">

    <form action="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/doMultipleFileUpload.do" method="post" enctype="multipart/form-data">
    ${pageContext.request.contextPath}
        username: <input type="text" name="username"><br>
        file: <input type="file" name="file">
        <input type="button" value="添加" id="button"><br>
        <div></div>
        <input type="submit" value="submit"> 
        
    </form>

  </body>
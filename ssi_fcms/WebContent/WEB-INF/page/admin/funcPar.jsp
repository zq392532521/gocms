<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="../util/checkParentFrame.jsp" %>
<html>
	<head>
		<link rel="stylesheet" href="../../../img/common.css" type="text/css" />
		<link rel="stylesheet" href="../../../img/style.css" type="text/css" />

		<script src="../../../jqueryTools/check.js" type="text/javascript"></script>
		<script src="../../../jqueryTools/jquery-1.5.1.min.js" type="text/javascript"></script>
		<script src="../../../jqueryTools/jquery.cookie.js" type="text/javascript"></script>
		<script src="../../../jqueryTools/jquery.treeview.js" type="text/javascript"></script>
		<script src="../../../jqueryTools/jquery.treeview.edit.js" type="text/javascript"></script>
		<script src="../../../jqueryTools/jquery.treeview.async.js" type="text/javascript"></script>
		<script type="text/javascript" src="../../../jqueryTools/weebox0.4/bgiframe.js"></script>
		<script type="text/javascript" src="../../../jqueryTools/weebox0.4/weebox.js"></script>
		<link type="text/css" rel="stylesheet" href="../../../jqueryTools/weebox0.4/weebox.css" />
	<script type="text/javascript" src="../../../js/page/admin/func.js"></script>
	</head>
	<body >
<div id="man_zone" >
  <table width="99%" border="0" align="left"  cellpadding="3" cellspacing="1" >
    <tr>
      <td width="30%"  align="left">
      
	<ul id="mixedpar" >
		<li id="root" class="hasChildren">
			<span><font size="2"><b><a href="#" onclick="parButtonDo('','系统菜单')">系统菜单</a></b></font>
			</span>
			<ul>
				<li><span  >&nbsp;</span></li>
			</ul>
		</li>
	</ul>
      </td>
      
    </tr>
  </table>
</div>

	<script type="text/javascript">
		function initTrees() {
			$("#mixedpar").treeview({
				url: "func_son.do?pageContentNoFilter=1&noid=${param.id}&onclick=parButtonDo",
				ajax: {
					data: {
						"additional": function() {
							return "yeah: " + new Date;
						}
					},
					type: "post"
				}
			});
		}
		initTrees();
	</script>
	</body>
</html>

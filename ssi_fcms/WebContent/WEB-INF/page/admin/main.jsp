<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@taglib prefix="fs" uri="/fs-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<title>SSHE</title>
<jsp:include page="/common/inc.jsp"></jsp:include>
<script type="text/javascript">
	var mainMenu;
	var mainTabs;
	var treeSting;
	var site;
	$.ajax({
		   type: "POST",
		   async: false,
		   url:sy.basePath+"/admin/admin_left.do",
		   success: function(data){
			   treeSting=data.ptreeMenuList;
			 /*   treeSting= [{
					"id":1,
					"text":"My Documents",
					"children":[{
						"id":11,
						"text":"Photos",
						"state":"closed",
						
						"children":[{
							"id":111,
							"text":"Friend"
						},{
							"id":112,
							"text":"Wife"
						},{
							"id":113,
							"text":"Company"
						}]
					},{
						"id":12,
						"text":"Program Files",
						"children":[{
							"id":121,
							"text":"Intel"
						},{
							"id":122,
							"text":"Java",
							"attributes":{
								"p1":"Custom Attribute1",
								"p2":"Custom Attribute2"
							}
						},{
							"id":123,
							"text":"Microsoft Office"
						},{
							"id":124,
							"text":"Games",
							"checked":true
						}]
					},{
						"id":13,
						"text":"index.html"
					},{
						"id":14,
						"text":"about.html"
					},{
						"id":15,
						"text":"welcome.html"
					}]
				}]; */
		   },dataType:"json"
	});
	function ajaxLeftMenu(){
		 mainMenu = $('#mainMenu').tree({
			 lines:false,
			 data:treeSting, 
		 /* 	parentField : 'pid',   */
			onClick :function(node) {
				if (node.attributes.url) {
					linkUrl=node.attributes.url;
					 if(linkUrl.indexOf("?")>-1){
						linkUrl+="&pageFuncId="+node.id;
					}else{
						linkUrl+="?pageFuncId="+node.id;
					}
					var src =sy.basePath+"/admin/"+linkUrl; 
					
					if (node.attributes.target && node.attributes.target.length > 0) {
						window.open(src, node.attributes.target);
					} else {
						var iconClsCssLink=node.iconCls;
						if($('#mainMenu').tree('getParent',node.target)==null){
						    // o=$('#menuTree').tree('getParent',node.target);
							iconClsCssLink='play-blue';
						} 
						
						var tabs = $('#mainTabs');
						var opts = {
							title : node.text,
							closable : true,
							iconCls :iconClsCssLink ,
							content : sy.formatString('<iframe src="{0}" allowTransparency="true" style="border:0;width:100%;height:99%;" frameBorder="0"></iframe>', src),
							border : false,
							fit : true
						};
						//如果tabs中存在这个tab
						if (tabs.tabs('exists', opts.title)) {
							tabs.tabs('close', opts.title);
							tabs.tabs('add', opts);					
						} else {
							tabs.tabs('add', opts);
						}
					}
				}
			}  
			
		});    
 
	}
	$(function() {
		
		ajaxLeftMenu();
			
		$('#mainLayout').layout('panel', 'center').panel({
			onResize : function(width, height) {
				sy.setIframeHeight('centerIframe', $('#mainLayout').layout('panel', 'center').panel('options').height - 5);
			}
		});

		mainTabs = $('#mainTabs').tabs({
			fit : true,
			border : false,
			tools : [ {
				iconCls : 'ext-icon-arrow_up',
				handler : function() {
					mainTabs.tabs({
						tabPosition : 'top'
					});
				}
			}, {
				iconCls : 'ext-icon-arrow_left',
				handler : function() {
					mainTabs.tabs({
						tabPosition : 'left'
					});
				}
			}, {
				iconCls : 'ext-icon-arrow_right',
				handler : function() {
					mainTabs.tabs({
						tabPosition : 'right'
					});
				}
			}, {
				text : '',
				iconCls : 'ext-icon-arrow_refresh',
				handler : function() {
					var panel = mainTabs.tabs('getSelected').panel('panel');
					var frame = panel.find('iframe');
					try {
						if (frame.length > 0) {
							for (var i = 0; i < frame.length; i++) {
								frame[i].contentWindow.document.write('');
								frame[i].contentWindow.close();
								frame[i].src = frame[i].src;
							}
							if (navigator.userAgent.indexOf("MSIE") > 0) {// IE特有回收内存方法
								try {
									CollectGarbage();
								} catch (e) {
								}
							}
						}
					} catch (e) {
						alert(e.message);
					}
				}
			}, {
				text : '',
				iconCls : 'ext-icon-cross',
				handler : function() {
					var index = mainTabs.tabs('getTabIndex', mainTabs.tabs('getSelected'));
					var tab = mainTabs.tabs('getTab', index);
					if (tab.panel('options').closable) {
						mainTabs.tabs('close', index);
					} else {
						$.messager.alert('提示', '[' + tab.panel('options').title + ']不可以被关闭！', 'error');
					}
				}
			} ]
		});

	});
	
	/*根据一级菜单（站点，会员，系统等）刷新系统左侧菜单*/
	function flushMenu(fid){
	 	$.ajax({
			   type: "POST",
			   async: false,
			   url:sy.basePath+"/admin/admin_left.do?funcid="+fid,
			   success: function(data){
				   site=data.manageSite;
				   treeSting=data.ptreeMenuList;
				
			   },dataType:"json"
			});
	    changeSiteName(site);
		ajaxLeftMenu();
	 
		
	}
	
	/*根据选择的站点刷新系统左侧菜单*/
	function flushMenuBySite(siteId){
		   //window.location.reload();
		 $.ajax({
			   type: "POST",
			   async: false,
			   url:sy.basePath+"/admin/admin_left.do?siteid="+siteId,
			   success: function(data){
				   site=data.manageSite;
				   treeSting=data.ptreeMenuList;
			   },dataType:"json"
			});
		  changeSiteName(site);
		ajaxLeftMenu(); 
		$("#northDiv").panel({region:'north',href:'<%=basePath%>/admin/admin_top.do'});  
		$("#northDiv").panel('refresh'); 
	}

	function managerSite(){
		src='<%=basePath%>admin/cms/site_site.do?type=siteSelectPage'
			var tabs = $('#mainTabs');
		var opts = {
			title : '管理站点',
			closable : true,
			iconCls :'' ,
			content : sy.formatString('<iframe src="{0}" allowTransparency="true" style="border:0;width:100%;height:99%;" frameBorder="0"></iframe>', src),
			border : false,
			fit : true
		};
		if (tabs.tabs('exists', opts.title)) {
			tabs.tabs('select', opts.title);
		} else {
			tabs.tabs('add', opts);
		}
		
	}
	
	/*刷新左侧导航条的站点名*/
	function changeSiteName(manageSite){
		if(manageSite){
			text="<span  title=\"点击选择管理站点\" onclick=\"managerSite();\"  >"+manageSite.name+"</span>"+"&nbsp;&nbsp;<img style=\"cursor:hand\" onclick=\"window.open('<%=basePath %>site/"+manageSite.sourcepath+"/index.html');\" title=\"点击预览站点\" src=\"../../../img/www.gif\" >";
			$('#managerSite').html(text);
		}else{
			text="<span  id=\"managerName\" title=\"点击选择管理站点\" onclick=\"managerSite();\" >请选择管理站点</span>"; 
			$('#managerSite').html(text);
		}
	}
	
	function openWinAtMainTabs(src,title){
				var tabs = $('#mainTabs');
			var opts = {
				title : title,
				closable : true,
				iconCls :'' ,
				content : sy.formatString('<iframe src="{0}" allowTransparency="true" style="border:0;width:100%;height:99%;" frameBorder="0"></iframe>', src),
				border : false,
				fit : true
			};
			if (tabs.tabs('exists', opts.title)) {
				tabs.tabs('select', opts.title);
			} else {
				tabs.tabs('add', opts);
			}
			
		}
</script>
</head>
<body id="mainLayout" class="easyui-layout">

	<div id="northDiv" data-options="region:'north',href:'<%=basePath%>/admin/admin_top.do'" style="height:50px; overflow: hidden;" class="logo"></div>
	<div data-options="region:'west',href:'',split:true" title="菜单" style="width: 150px; padding: 10px;">
		
		<ul id="mainMenu"></ul>
	</div>
	<div data-options="region:'center'" style="">
		<div id="mainTabs">
			<div title="关于SSHE" data-options="iconCls:'ext-icon-heart'">
				<iframe src="<%=basePath%>admin/admin_right.do" allowTransparency="true" style="border: 0; width: 100%; height: 99%;" frameBorder="0"></iframe>
			</div>
		</div>
	</div>
	<div data-options="region:'south',href:'<%=basePath%>admin/admin_foot.do',border:false" style="height: 30px; overflow: hidden;"></div>
	
</body>
</html>
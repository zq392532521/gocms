package cn.freeteam.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.freeteam.base.BaseAction;
import cn.freeteam.cms.model.RoleSite;
import cn.freeteam.cms.model.Site;
import cn.freeteam.cms.service.RoleSiteService;
import cn.freeteam.cms.service.SiteService;
import cn.freeteam.model.Adminlink;
import cn.freeteam.model.Func;
import cn.freeteam.model.TreeMenu;
import cn.freeteam.service.AdminlinkService;
import cn.freeteam.service.FuncService;
import cn.freeteam.service.impl.AdminlinkServiceImpl;
import cn.freeteam.service.impl.FuncServiceImpl;
import cn.freeteam.util.JsonUtil;


/**
 * 
 * <p>Title: AdminAction.java</p>
 * 
 * <p>Description: 后台管理相关操作</p>
 * 
 * <p>Date: Dec 16, 2011</p>
 * 
 * <p>Time: 4:43:12 PM</p>
 * 
 * <p>Copyright: 2011</p>
 * 
 * <p>Company: freeteam</p>
 * 
 * @author freeteam
 * @version 1.0
 * 
 * <p>============================================</p>
 * <p>Modification History
 * <p>Mender: </p>
 * <p>Date: </p>
 * <p>Reason: </p>
 * <p>============================================</p>
 */


public class AdminAction extends BaseAction{

	private List<Func> funcList;
	private List<TreeMenu> treeMenuList;
	@Autowired
	private FuncService funcService;
	@Autowired
	private RoleSiteService roleSiteService;
	@Autowired
	private SiteService siteService;
	@Autowired
	private AdminlinkService adminlinkService;
	
	private List<Adminlink> syslink;
	private List<Adminlink> userlink;
	
	private String siteid;
	private String funcid;
	
	/**
	 * 后台首页左边页面
	 * @throws Exception 
	 */
	public void left() throws Exception{
		List<Func> funcTreeList=null;
		//先清除session变量
		Site manageSite=null;
		if (siteid!=null && siteid.trim().length()>0) {
			//指定管理站点
			manageSite=siteService.findById(siteid);
		}else {
			if (getHttpSession().getAttribute("manageSite")!=null) {
				manageSite=(Site)getHttpSession().getAttribute("manageSite");
			}else {
				//未指定管理站点
				if (isAdminLogin()) {
					//提取一级站点
					manageSite=siteService.selectFirstByParId( "");
				}else {
					//普通用户只提取有自己有权限的站点
					manageSite=siteService.selectFirstByRoles( getLoginRoleIdsSql());
				}
			}
		}
		getHttpSession().setAttribute("manageSite", manageSite);
		if (funcid==null || funcid.trim().length()==0) {
			if (getHttpSession().getAttribute("funcid")!=null && StringUtils.isNotEmpty(getHttpSession().getAttribute("funcid").toString())) {
				funcid=getHttpSession().getAttribute("funcid").toString();
			}else {
				//设置为第一个根菜单
				//提取一级菜单 
				if (isAdminLogin()) {
					funcTreeList=funcService.selectRoot();
					treeMenuList=funcService.func2FatherEasyUiMenu(funcTreeList);
				}else {
					funcTreeList=funcService.selectRootAuth(getLoginAdmin().getId());
					treeMenuList=funcService.func2FatherEasyUiMenu(funcTreeList);
				}
				if (funcTreeList!=null && funcTreeList.size()>0) {
					funcid=funcTreeList.get(0).getId();
				}
			}
		}
		getHttpSession().setAttribute("funcid", funcid);
		if (isAdminLogin()) {
			getHttpSession().setAttribute("siteAdmin", true);
		}else {
			if (manageSite!=null) {
				//判断是否是站点管理员
				RoleSite roleSite=roleSiteService.findBySiteRoles(manageSite.getId(), getLoginRoleIdsSql(),"1");
				if (roleSite!=null) {
					getHttpSession().setAttribute("siteAdmin", true);
				}
			}
		}
		//提取权限并放到session中
		if (getHttpSession().getAttribute("funcs")==null) {
			if (isAdminLogin()) {
				funcTreeList=funcService.selectAll();
				treeMenuList=funcService.func2ChildEasyUiMenu(funcTreeList);
			}else {
				funcTreeList=funcService.selectAllAuth(getLoginAdmin().getId());
				treeMenuList=funcService.func2ChildEasyUiMenu(funcTreeList);
			}
			if (funcTreeList!=null && funcTreeList.size()>0) {
				for (int i = 0; i < funcTreeList.size(); i++) {
					if (funcService.haveSon(funcTreeList.get(i).getId())) {
						funcTreeList.get(i).setHasChildren("1");
					}
				}
			}
			
			
		//	String jsonTreeMenu=JsonUtil.objectToJson(ptreeMenuList);
			//getHttpSession().setAttribute("funcs", funcTreeList);
			getHttpSession().setAttribute("funcs", treeMenuList);
		}
		List<TreeMenu> sessionFuncs=(List<TreeMenu>) getHttpSession().getAttribute("funcs");
		Set<TreeMenu> ptreeMenuList=new HashSet<TreeMenu>();
		List<TreeMenu> tempList=new ArrayList<TreeMenu>();
		if(sessionFuncs!=null||sessionFuncs.size()!=0){
			for(TreeMenu ptreeMenu:sessionFuncs){
				if(ptreeMenu.getPid().equals(funcid)){
					ptreeMenuList.add(ptreeMenu);
					tempList.add(ptreeMenu);
					for(TreeMenu cTreeMenu:sessionFuncs){
						if(tempList.contains(cTreeMenu)){
							continue;
						}
						if(ptreeMenu.getId().equals(cTreeMenu.getPid())){
							ptreeMenuList.add(cTreeMenu);
							tempList.add(ptreeMenu);
						}
					}
				}
				
			}
			manageSite=(Site)getHttpSession().getAttribute("manageSite");
				Map map=new HashMap();
				map.put("ptreeMenuList", ptreeMenuList);
				map.put("manageSite", manageSite);
				//String jsonTreeMenu=JsonUtil.objectToJson(map);
			//getHttpSession().setAttribute("jsonTreeMenu", funcTreeList);
				objectToJsonString(map);
		}
		
//		return "left";
	}
	/**
	 * 头部
	 * @return
	 */
	public String top(){
		//如果是admin则显示所有一级菜单
		if (isAdminLogin()) {
			funcList=funcService.selectRoot();
		}else {
			funcList=funcService.selectRootAuth(getLoginAdmin().getId());
		}
		if (funcList!=null && funcList.size()>0) {
			funcid=funcList.get(0).getId();
		}
		return "top";
	}
	public String foot(){
		return "foot";
	}
	/**
	 * 右侧
	 * @return
	 */
	public String  right(){
		//系统链接
		Adminlink adminlink=new Adminlink();
		adminlink.setType(Adminlink.TYPE_SYS);
		syslink=adminlinkService.find(adminlink, "ordernum", true);
		//个人链接
		adminlink.setType(Adminlink.TYPE_USER);
		adminlink.setUserid(getLoginAdmin().getId());
		userlink=adminlinkService.find(adminlink, "ordernum", true);
		return "right";
	}
	public String index(){
		return "index";
	}
	public List<Func> getFuncList() {
		return funcList;
	}
	public void setFuncList(List<Func> funcList) {
		this.funcList = funcList;
	}






	public String getSiteid() {
		return siteid;
	}
	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}
	public String getFuncid() {
		return funcid;
	}
	public void setFuncid(String funcid) {
		this.funcid = funcid;
	}
	public List<Adminlink> getSyslink() {
		return syslink;
	}
	public void setSyslink(List<Adminlink> syslink) {
		this.syslink = syslink;
	}
	public List<Adminlink> getUserlink() {
		return userlink;
	}
	public void setUserlink(List<Adminlink> userlink) {
		this.userlink = userlink;
	}
	
}

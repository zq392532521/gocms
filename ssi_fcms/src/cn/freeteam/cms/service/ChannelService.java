package cn.freeteam.cms.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.quartz.SchedulerException;

import cn.freeteam.cms.model.Channel;
import cn.freeteam.cms.model.Htmlquartz;
import cn.freeteam.cms.model.Site;
import freemarker.template.TemplateException;

/**
 * 
 * <p>Title: ChannelService.java</p>
 * 
 * <p>Description: 栏目相关服务</p>
 * 
 * <p>Date: Jan 23, 2012</p>
 * 
 * <p>Time: 11:49:58 AM</p>
 * 
 * <p>Copyright: 2012</p>
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
public interface ChannelService {
	String hasNextPage="<!--FreeCMS_channel_info_list_hasNextPage-->";
	
	/**
	 * 查询是否有子数据
	 * @param parId
	 * @return
	 */
	public boolean hasChildren(String parId);
	/**
	 * 判断是否已存在此页面标识
	 * @param pagemark
	 * @return
	 */
	public boolean hasPagemark(String siteid,String pagemark);
	/**
	 * 根据站点id,页面标识查询
	 * @param siteid
	 * @param pagemark
	 * @return
	 */
	public Channel findBySitePagemark(String siteid,String pagemark);
	/**
	 * 根据站点id,索引号查询
	 * @param siteid
	 * @param pagemark
	 * @return
	 */
	public Channel findBySiteIndexnum(String siteid,Integer indexnum);
	
	/**
	 * 根据站点和父id查询
	 * @param siteid
	 * @param parid
	 * @return
	 */
	public List<Channel> findByParWithBLOBs(String siteid,String parid);
	/**
	 * 根据站点和父id查询
	 * @param siteid
	 * @param parid
	 * @return
	 */
	public List<Channel> findByPar(String siteid,String parid);
	/**
	 * 根据站点和父id查询
	 * @param siteid
	 * @param parid
	 * @return
	 */
	public List<Channel> findByPar(String siteid,String parid,String state,String navigation);
	/**
	 * 根据站点和父id查询
	 * @param siteid
	 * @param parid
	 * @return
	 */
	public List<Channel> findByParWithBLOBs(String siteid,String parid,String state,String navigation);
	/**
	 * 根据站点查询
	 * @param siteid
	 * @param parid
	 * @return
	 */
	public List<Channel> findBySite(String siteid,String state,String navigation);
	/**
	 * 根据站点和角色查询
	 * @param siteid
	 * @param parid
	 * @return
	 */
	public List<Channel> findByRoles(String siteid,String roles);
	/**
	 * 根据站点和角色查询
	 * @param siteid
	 * @param parid
	 * @return
	 */
	public List<Channel> findByRolesWithBLOBs(String siteid,String roles);
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Channel findById(String id);
	/**
	 * 更新
	 * @param channel
	 */
	public void update(Channel channel);
	/**
	 * 添加
	 * @param channel
	 */
	public String insert(Channel channel);

	/**
	 * 删除
	 * @param siteId
	 * @throws TemplateException 
	 * @throws IOException 
	 */
	public void del(String id,HttpServletRequest request) throws IOException, TemplateException;
	/**
	 * 递归删除
	 * @param parId
	 * @throws TemplateException 
	 * @throws IOException 
	 */
	public void delPar(String parId,HttpServletRequest request) throws IOException, TemplateException;
	/**
	 * 删除栏目静态页
	 * @throws TemplateException 
	 * @throws IOException 
	 */
	public void delhtml(Channel channel,HttpServletRequest request) throws IOException, TemplateException;
	/**
	 * 栏目页静态化
	 * @throws TemplateException 
	 * @throws IOException 
	 */
	public void html(Site site,Channel channel,ServletContext context,HttpServletRequest request,String operuser,int pagenum) throws IOException, TemplateException;
	/**
	 * 栏目页静态化每一页
	 * @throws TemplateException 
	 * @throws IOException 
	 */
	public void htmlPage(Site site,Channel channel,ServletContext context,HttpServletRequest request,String templetPath,int page,String operuser,int pagenum) throws IOException, TemplateException;

	/**
	 * 栏目页静态化
	 * @throws TemplateException 
	 * @throws IOException 
	 */
	public void html(String siteid,String channelid,ServletContext context) throws IOException, TemplateException;
	/**
	 * 栏目页静态化每一页
	 * @throws TemplateException 
	 * @throws IOException 
	 */
	public void htmlPage(Site site,Channel channel,ServletContext context,String templetPath,int page) throws IOException, TemplateException;
	/**
	 * 递归生成静态树
	 * @param content
	 * @param siteid
	 * @param parid
	 * @param state
	 * @param navigation
	 */
	public void createTree(StringBuffer content,String adminRoles,String siteid,String roleid,String parid,String state,String navigation,String type);
	/**
	 * 更新栏目页静态化调度任务
	 * @param site
	 * @throws SchedulerException 
	 * @throws ParseException 
	 */
	public void updateHtmlChannelJob(ServletContext servletContext,Site site,Channel channel,Htmlquartz htmlquartz) throws SchedulerException, ParseException;
	/**
	 * 更新栏目页静态化调度任务
	 * @param site
	 * @throws SchedulerException 
	 * @throws ParseException 
	 */
	public void delHtmlChannelJob(String channelid) throws SchedulerException, ParseException;
	/**
	 * 查询栏目路径
	 * @return
	 */
	public List<Channel> findPath(String id);
	/**
	 * 查询栏目路径(递归方法)
	 * @return
	 */
	public List<Channel> findParPath(String id,List<Channel> channelList);
	/**
	 * 查询所有子栏目(pagemark)
	 * @param siteid
	 * @param parid
	 * @param state
	 * @param navigation
	 * @return
	 */
	public List<Channel> findSonByPagemark(String siteid,String pagemark,String state,String navigation);
	/**
	 * 查询所有子栏目
	 * @param siteid
	 * @param parid
	 * @param state
	 * @param navigation
	 * @return
	 */
	public List<Channel> findSon(String siteid,String parid,String state,String navigation);
	/**
	 * 查询所有子栏目（递归）
	 * @param siteid
	 * @param parid
	 * @param state
	 * @param navigation
	 * @return
	 */
	public List<Channel> findSonPro(List<Channel> list,String siteid,String parid,String state,String navigation);
	

	
}

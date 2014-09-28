package cn.freeteam.cms.service;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.Trigger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.freeteam.base.BaseService;
import cn.freeteam.cms.dao.SiteMapper;
import cn.freeteam.cms.model.Htmlquartz;
import cn.freeteam.cms.model.Site;
import cn.freeteam.cms.model.SiteExample;
import cn.freeteam.cms.model.SiteExample.Criteria;
import cn.freeteam.cms.util.FreeMarkerUtil;
import cn.freeteam.cms.util.HtmlChannelJob;
import cn.freeteam.cms.util.HtmlSiteJob;
import cn.freeteam.cms.util.QuartzUtil;
import cn.freeteam.util.FileUtil;



import freemarker.template.TemplateException;
import freemarker.template.TemplateModelException;

/**
 * 
 * <p>Title: SiteService.java</p>
 * 
 * <p>Description: 站点相关服务</p>
 * 
 * <p>Date: Jan 21, 2012</p>
 * 
 * <p>Time: 2:31:27 PM</p>
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

public interface SiteService {	public boolean hasChildren(String parId);
	public List<Site> selectByParId(String parid);
	public Site selectFirstByParId(String parid);
	public List<Site> selectByRoles(String roles);
	public Site selectFirstByRoles(String roles);
	public Site findById(String id);
	public Site findByDomain(String domain,boolean cache);
	public Site findBySourcepath(String sourcepath);
	public void html(String id,ServletContext context,String contextPath,HttpServletRequest request,String operuser) throws IOException, TemplateException;
	public void html(String id,ServletContext context) throws IOException, TemplateException;
	public void delhtml(String id,HttpServletRequest request) throws IOException, TemplateException;
	public boolean haveSourcePath(String path);
	public void update(Site site);
	public String insert(Site site);
	public void del(String siteId,HttpServletRequest request) throws IOException, TemplateException;
	public void delPar(String parId,HttpServletRequest request);
	public void updateHtmlSiteJob(ServletContext servletContext,Site site,Htmlquartz htmlquartz) throws SchedulerException, ParseException;
	public void delHtmlSiteJob(String siteid) throws SchedulerException, ParseException;
}
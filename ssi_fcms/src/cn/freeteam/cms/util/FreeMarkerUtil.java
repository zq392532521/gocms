package cn.freeteam.cms.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;

import cn.freeteam.cms.freemarker.directive.AjaxInfoClickDirective;
import cn.freeteam.cms.freemarker.directive.AjaxLoadDirective;
import cn.freeteam.cms.freemarker.directive.AjaxStoreDirective;
import cn.freeteam.cms.freemarker.directive.ApplyopenQueryDirective;
import cn.freeteam.cms.freemarker.directive.ChannelDirective;
import cn.freeteam.cms.freemarker.directive.ChannelListDirective;
import cn.freeteam.cms.freemarker.directive.ChannelPathDirective;
import cn.freeteam.cms.freemarker.directive.ChannelSonDirective;
import cn.freeteam.cms.freemarker.directive.CommentPageDirective;
import cn.freeteam.cms.freemarker.directive.ConfigDirective;
import cn.freeteam.cms.freemarker.directive.DemoDirective;
import cn.freeteam.cms.freemarker.directive.GuestbookDirective;
import cn.freeteam.cms.freemarker.directive.GuestbookListDirective;
import cn.freeteam.cms.freemarker.directive.GuestbookPageDirective;
import cn.freeteam.cms.freemarker.directive.HtmlDirective;
import cn.freeteam.cms.freemarker.directive.InfoAttchsDirective;
import cn.freeteam.cms.freemarker.directive.InfoDirective;
import cn.freeteam.cms.freemarker.directive.InfoImgDirective;
import cn.freeteam.cms.freemarker.directive.InfoListDirective;
import cn.freeteam.cms.freemarker.directive.InfoNextListDirective;
import cn.freeteam.cms.freemarker.directive.InfoPageDirective;
import cn.freeteam.cms.freemarker.directive.InfoPreListDirective;
import cn.freeteam.cms.freemarker.directive.InfoRelateDirective;
import cn.freeteam.cms.freemarker.directive.InfoSearchDirective;
import cn.freeteam.cms.freemarker.directive.InfoSignDirective;
import cn.freeteam.cms.freemarker.directive.JobDirective;
import cn.freeteam.cms.freemarker.directive.JobListDirective;
import cn.freeteam.cms.freemarker.directive.JobPageDirective;
import cn.freeteam.cms.freemarker.directive.LinkClassDirective;
import cn.freeteam.cms.freemarker.directive.LinkDirective;
import cn.freeteam.cms.freemarker.directive.MailListDirective;
import cn.freeteam.cms.freemarker.directive.MailPageDirective;
import cn.freeteam.cms.freemarker.directive.MailQueryDirective;
import cn.freeteam.cms.freemarker.directive.MailSaveDirective;
import cn.freeteam.cms.freemarker.directive.QuestionListDirective;
import cn.freeteam.cms.freemarker.directive.QuestionOneDirective;
import cn.freeteam.cms.freemarker.directive.QuestionPageDirective;
import cn.freeteam.cms.freemarker.directive.ReportQueryDirective;
import cn.freeteam.cms.freemarker.directive.URLDecoderDirective;
import cn.freeteam.cms.freemarker.directive.URLEncoderDirective;
import cn.freeteam.cms.freemarker.directive.UnitListDirective;
import cn.freeteam.cms.freemarker.directive.UserListDirective;
import cn.freeteam.cms.freemarker.directive.VideoDirective;
import cn.freeteam.cms.freemarker.directive.VisitDirective;


import cn.freeteam.util.SpringUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModelException;

/**
 * 
 * <p>Title: FreeMarkerUtil.java</p>
 * 
 * <p>Description: freemarker工具类</p>
 * 
 * <p>Date: Mar 9, 2012</p>
 * 
 * <p>Time: 4:00:48 PM</p>
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
public class FreeMarkerUtil {

	 /**     
	  * 生成静态页面主方法     默认编码为UTF-8
	  * @param context ServletContext     
	  * @param data 一个Map的数据结果集     
	  * @param templatePath ftl模版路径     
	  * @param htmlPath 生成静态页面的路径   
	 * @throws TemplateException 
	 * @throws IOException 
	  */    
	public static void createHTML(ServletContext context,Map<String,Object> data,String templatePath,String htmlPath) throws IOException, TemplateException{
		createHTML(context, data, "UTF-8", templatePath, "UTF-8", htmlPath);
	}
	 /**     
	  * 生成静态页面主方法     
	  * @param context ServletContext     
	  * @param data 一个Map的数据结果集     
	  * @param templatePath ftl模版路径     
	  * @param templateEncode ftl模版编码     
	  * @param htmlPath 生成静态页面的路径   
	  * @param htmlEncode 生成静态页面的编码     
	 * @throws IOException 
	 * @throws TemplateException 
	  */    
	public static void createHTML(ServletContext context,Map<String,Object> data,String templetEncode,String templatePath,String htmlEncode,String htmlPath) throws IOException, TemplateException{
		
		Configuration freemarkerCfg=initCfg(context, templetEncode);
		  
		//指定模版路径            
		Template template = freemarkerCfg.getTemplate(templatePath,templetEncode);            
		template.setEncoding(templetEncode);            
		//静态页面路径                      
		File htmlFile = new File(htmlPath);  
		if (!htmlFile.getParentFile().exists()) {
			htmlFile.getParentFile().mkdirs();
		}
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(htmlFile), htmlEncode));            
		//处理模版              
		template.process(data, writer);            
		writer.flush();            
		writer.close();        
	}
	/**
	 * 处理页面后，装处理结果放入指定Out
	 * @param context
	 * @param data
	 * @param templatePath
	 * @throws TemplateModelException 
	 */
	public static void createWriter(ServletContext context,Map<String,Object> data,String templatePath,Writer writer) throws TemplateModelException{
		createWriter(context, data, "UTF-8", templatePath, "UTF-8",writer);
	}
	public static void createWriter(ServletContext context,Map<String,Object> data,String templetEncode,String templatePath,String htmlEncode,Writer writer) throws TemplateModelException{

		Configuration freemarkerCfg=initCfg(context, templetEncode);
		
		try {            
			//指定模版路径            
			Template template = freemarkerCfg.getTemplate(templatePath,templetEncode);            
			template.setEncoding(templetEncode);            
			//处理模版              
			template.process(data, writer);        
		} catch (Exception e) {            
			e.printStackTrace();        
		}
	}
	/**
	 * 初始化freemarker配置
	 * @return
	 * @throws TemplateModelException 
	 */
	public static Configuration initCfg(ServletContext context,String templetEncode) throws TemplateModelException{

		Configuration freemarkerCfg=null;
		//判断context中是否有freemarkerCfg属性
		if (context.getAttribute("freemarkerCfg")!=null) {
			freemarkerCfg=(Configuration)context.getAttribute("freemarkerCfg");
		}else {
			freemarkerCfg = new Configuration();        
			//加载模版        
			freemarkerCfg.setServletContextForTemplateLoading(context, "/");        
			freemarkerCfg.setEncoding(Locale.getDefault(), templetEncode);    
			
			//加载自定义标签
			//栏目类
			freemarkerCfg.setSharedVariable("channel", SpringUtils.getBean("channelDirective"));
			freemarkerCfg.setSharedVariable("channelList",SpringUtils.getBean("channelListDirective") );
			freemarkerCfg.setSharedVariable("channelSon",SpringUtils.getBean("channelSonDirective"));
			freemarkerCfg.setSharedVariable("channelPath",SpringUtils.getBean("channelPathDirective") );
			//信息类
			freemarkerCfg.setSharedVariable("infoList", SpringUtils.getBean("infoListDirective"));
			freemarkerCfg.setSharedVariable("infoPreList",SpringUtils.getBean("infoPreListDirective") );
			freemarkerCfg.setSharedVariable("infoNextList",SpringUtils.getBean("infoNextListDirective") );
			freemarkerCfg.setSharedVariable("infoPage",SpringUtils.getBean("infoPageDirective") );
			freemarkerCfg.setSharedVariable("infoAttchs", SpringUtils.getBean("infoAttchsDirective"));
			freemarkerCfg.setSharedVariable("infoSearch", SpringUtils.getBean("infoSearchDirective"));
			freemarkerCfg.setSharedVariable("infoSign", SpringUtils.getBean("infoSignDirective"));
			freemarkerCfg.setSharedVariable("infoImg",SpringUtils.getBean("infoImgDirective") );
			freemarkerCfg.setSharedVariable("infoRelate", SpringUtils.getBean("infoRelateDirective"));
			freemarkerCfg.setSharedVariable("info",SpringUtils.getBean("infoDirective"));
			//访问
			freemarkerCfg.setSharedVariable("visit", SpringUtils.getBean("visitDirective"));
			//链接类
			freemarkerCfg.setSharedVariable("linkClass",  SpringUtils.getBean("linkClassDirective"));
			freemarkerCfg.setSharedVariable("link",SpringUtils.getBean("linkDirective") );
			//Ajax类
			freemarkerCfg.setSharedVariable("ajaxInfoClick", SpringUtils.getBean("ajaxInfoClickDirective"));
			freemarkerCfg.setSharedVariable("ajaxLoad", SpringUtils.getBean("ajaxLoadDirective"));
			freemarkerCfg.setSharedVariable("ajaxStore", SpringUtils.getBean("ajaxStoreDirective"));
			//单位类
			freemarkerCfg.setSharedVariable("unitList", SpringUtils.getBean("unitListDirective"));
			//用户类
			freemarkerCfg.setSharedVariable("userList", SpringUtils.getBean("userListDirective"));
			//系统配置
			freemarkerCfg.setSharedVariable("config",SpringUtils.getBean("configDirective"));
			//信件
			freemarkerCfg.setSharedVariable("mailSave", SpringUtils.getBean("mailSaveDirective"));
			freemarkerCfg.setSharedVariable("mailQuery", SpringUtils.getBean("mailQueryDirective"));
			freemarkerCfg.setSharedVariable("mailList",SpringUtils.getBean("mailListDirective"));
			
			freemarkerCfg.setSharedVariable("mailPage", SpringUtils.getBean("mailPageDirective"));
			//在线申报
			freemarkerCfg.setSharedVariable("reportQuery", SpringUtils.getBean("reportQueryDirective"));
			//依申请公开
			freemarkerCfg.setSharedVariable("applyopenQuery", SpringUtils.getBean("applyopenQueryDirective"));
			//网上调查
			freemarkerCfg.setSharedVariable("questionOne",  SpringUtils.getBean("questionOneDirective"));
			freemarkerCfg.setSharedVariable("questionList",SpringUtils.getBean("questionListDirective") );
			freemarkerCfg.setSharedVariable("questionPage", SpringUtils.getBean("questionPageDirective") );
			//评论
			freemarkerCfg.setSharedVariable("commentPage",SpringUtils.getBean("commentPageDirective") );
			//留言
			freemarkerCfg.setSharedVariable("guestbookList", SpringUtils.getBean("guestbookListDirective"));
			freemarkerCfg.setSharedVariable("guestbookPage", SpringUtils.getBean("guestbookPageDirective"));
			freemarkerCfg.setSharedVariable("guestbook", SpringUtils.getBean("guestbookDirective"));
			//职位
			freemarkerCfg.setSharedVariable("jobList", SpringUtils.getBean("jobListDirective"));
			freemarkerCfg.setSharedVariable("jobPage",SpringUtils.getBean("jobPageDirective"));
			freemarkerCfg.setSharedVariable("job", SpringUtils.getBean("jobDirective"));
			//其它
			freemarkerCfg.setSharedVariable("video",SpringUtils.getBean("videoDirective") );
			freemarkerCfg.setSharedVariable("URLEncoder",SpringUtils.getBean("urlEncoderDirective") );
			freemarkerCfg.setSharedVariable("URLDecoder",SpringUtils.getBean("urlDecoderDirective") );
			freemarkerCfg.setSharedVariable("html", SpringUtils.getBean("htmlDirective"));
			
			freemarkerCfg.setSharedVariable("demo",  SpringUtils.getBean("demoDirective"));
		}
		return freemarkerCfg;
	}
}
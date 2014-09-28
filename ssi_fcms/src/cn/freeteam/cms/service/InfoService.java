package cn.freeteam.cms.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import cn.freeteam.cms.model.Info;
import cn.freeteam.cms.model.InfoExample.Criteria;
import freemarker.template.TemplateException;

/**
 * 
 * <p>Title: InfoService.java</p>
 * 
 * <p>Description: 信息服务</p>
 * 
 * <p>Date: Feb 7, 2012</p>
 * 
 * <p>Time: 1:55:57 PM</p>
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
public interface InfoService {	public void html(String id,ServletContext context,String contextPath,HttpServletRequest request,String operuser) throws IOException, TemplateException;
	public void delhtml(String id,HttpServletRequest request) throws IOException, TemplateException;
	public List<Info> find(Info info,String order,int currPage,int pageSize);
	public List<Info> findAll(Info info,String order);
	public int count(Info info);
	public void proSearchParam(Info info,Criteria criteria);
	public String insert(Info info);
	public void update(Info info);
	public void click(Info info);
	public Info findById(String id);
	public Info findClickById(String id);
	public void del(String id);
	public List<Info> workload(Info info,int currPage,int pageSize);
	public List<Info> workload(Info info);
	public int workloadCount(Info info);
	public int workloadSum(Info info);
	public List<Info> siteStat(Info info,int currPage,int pageSize);
	public List<Info> siteStat(Info info);
	public int siteStatCount(Info info);
	public int siteStatSum(Info info);
	public List<Info> channelStat(Info info);
	public int channelStatCount(Info info);
	public int channelStatSum(Info info);
	public List<Info> infoUpdateYear(Info info);
	public List<Info> infoUpdateYear(Info info,int currPage,int pageSize);
	public int infoUpdateYearCount(Info info);
	public int infoUpdateYearSum(Info info);
	public List<Info> infoUpdateMonth(Info info);
	public List<Info> infoUpdateMonth(Info info,int currPage,int pageSize);
	public int infoUpdateMonthCount(Info info);
	public int infoUpdateMonthSum(Info info);
	public List<Info> infoUpdateDay(Info info);
	public List<Info> infoUpdateDay(Info info,int currPage,int pageSize);
	public int infoUpdateDayCount(Info info);
	public int infoUpdateDaySum(Info info);
	public int infoUpdateWeekSum(Info info);
	public List<Info> infoUpdateWeek(Info info);
}
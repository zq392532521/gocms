package cn.freeteam.cms.service;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.freeteam.base.BaseService;
import cn.freeteam.cms.dao.TempletLinkMapper;
import cn.freeteam.cms.model.Link;
import cn.freeteam.cms.model.Site;
import cn.freeteam.cms.model.Templet;
import cn.freeteam.cms.model.TempletChannel;
import cn.freeteam.cms.model.TempletLink;
import cn.freeteam.cms.model.TempletLinkExample;
import cn.freeteam.cms.model.TempletLinkExample.Criteria;
import cn.freeteam.util.XMLUtil;

/**
 * 
 * <p>Title: TempletLinkService.java</p>
 * 
 * <p>Description: 模板链接相关服务</p>
 * 
 * <p>Date: May 8, 2013</p>
 * 
 * <p>Time: 8:41:17 PM</p>
 * 
 * <p>Copyright: 2013</p>
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

public interface TempletLinkService {	public int count(String templetid);
	public void delClass(String id);
	public void update(TempletLink templetLink);
	public String add(TempletLink templetLink);
	public boolean hasPagemark(String templet,String type,boolean isClass,String pagemark);
	public TempletLink findById(String id);
	public List<TempletLink> findAll(TempletLink templetLink,String order);
	public void proSearchParam(TempletLink templetLink,Criteria criteria);
	public void createXML(Templet templet,HttpServletRequest request);
	public void importLinks(Templet templet,HttpServletRequest request) throws DocumentException;
	public void importSiteLinks(Templet templet,Site site);
	public void importSite(Templet templet,Site site);
}
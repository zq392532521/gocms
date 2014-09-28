package cn.freeteam.cms.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
import cn.freeteam.cms.dao.TempletChannelMapper;
import cn.freeteam.cms.model.Channel;
import cn.freeteam.cms.model.Site;
import cn.freeteam.cms.model.Templet;
import cn.freeteam.cms.model.TempletChannel;
import cn.freeteam.cms.model.TempletChannelExample;
import cn.freeteam.cms.model.TempletChannelExample.Criteria;
import cn.freeteam.util.FileUtil;
import cn.freeteam.util.XMLUtil;
import freemarker.template.TemplateException;

/**
 * 
 * <p>Title: TempletChannelService.java</p>
 * 
 * <p>Description: 模板栏目相关服务</p>
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

public interface TempletChannelService {	public int count(String templetid);
	public List<TempletChannel> findByPar(String templetid,String parid);
	public List<TempletChannel> findByPar(String templetid,String parid,String state,String navigation);
	public List<TempletChannel> findByParWithBLOBs(String templetid,String parid);
	public List<TempletChannel> findByParWithBLOBs(String templetid,String parid,String state,String navigation);
	public boolean hasChildren(String parId);
	public TempletChannel findById(String id);
	public void update(TempletChannel templetChannel);
	public String insert(TempletChannel templetChannel);
	public void del(String id,HttpServletRequest request) throws IOException, TemplateException;
	public void delPar(String parId,HttpServletRequest request) throws IOException, TemplateException;
	public boolean hasPagemark(String templetid,String pagemark);
	public void createXML(Templet templet,HttpServletRequest request);
	public void importChannels(Templet templet,HttpServletRequest request) throws DocumentException;
	public void importChannel(Map<String, TempletChannel> channelMap,Map<String, String> importedMap);
	public void importSiteChannels(Templet templet,Site site);
	public void importSiteChannel(Map<String, TempletChannel> channelMap,Map<String, String> importedMap,Site site);
	public void importSite(Templet templet,Site site,HttpServletRequest request);
	public void importSite(Map<String, Channel> channelMap,Map<String, String> importedMap,Templet templet,HttpServletRequest request);
}
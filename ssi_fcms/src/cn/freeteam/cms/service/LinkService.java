package cn.freeteam.cms.service;

import java.util.List;
import java.util.UUID;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.freeteam.base.BaseService;
import cn.freeteam.cms.dao.LinkMapper;
import cn.freeteam.cms.model.Link;
import cn.freeteam.cms.model.LinkExample;
import cn.freeteam.cms.model.Templet;
import cn.freeteam.cms.model.LinkExample.Criteria;


/**
 * 
 * <p>Title: LinkService.java</p>
 * 
 * <p>Description: 链接服务</p>
 * 
 * <p>Date: May 15, 2012</p>
 * 
 * <p>Time: 3:09:47 PM</p>
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

public interface LinkService {	public void update(Link link);
	public String add(Link link);
	public Link findById(String id);
	public boolean hasPagemark(String siteid,String type,boolean isClass,String pagemark);
	public List<Link> find(Link link,String order,int currPage,int pageSize);
	public List<Link> findAll(Link link,String order);
	public int count(Link link);
	public void proSearchParam(Link link,Criteria criteria);
	public void delClass(String id);
	public void del(String id);
}
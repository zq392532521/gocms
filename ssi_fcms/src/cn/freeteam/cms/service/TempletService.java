package cn.freeteam.cms.service;

import java.util.List;
import java.util.UUID;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.freeteam.base.BaseService;
import cn.freeteam.cms.dao.TempletMapper;
import cn.freeteam.cms.model.Templet;
import cn.freeteam.cms.model.TempletExample;
import cn.freeteam.cms.model.TempletExample.Criteria;


/**
 * 
 * <p>Title: TempletService.java</p>
 * 
 * <p>Description: 模板服务</p>
 * 
 * <p>Date: Feb 12, 2012</p>
 * 
 * <p>Time: 9:00:56 PM</p>
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

public interface TempletService {	public List<Templet> find(Templet templet,String order,int currPage,int pageSize);
	public List<Templet> findAll(Templet templet,String order);
	public int count(Templet templet);
	public void proSearchParam(Templet templet,Criteria criteria);
	public Templet findById(String id);
	public void update(Templet templet);
	public String add(Templet templet);
}
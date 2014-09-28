package cn.freeteam.cms.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.freeteam.base.BaseService;
import cn.freeteam.cms.dao.SensitiveMapper;
import cn.freeteam.cms.model.Sensitive;
import cn.freeteam.cms.model.SensitiveExample;
import cn.freeteam.cms.model.SensitiveExample.Criteria;
/**
 * 
 * <p>Title: SensitiveService.java</p>
 * 
 * <p>Description: 敏感词相关服务</p>
 * 
 * <p>Date: Feb 4, 2013</p>
 * 
 * <p>Time: 7:50:54 PM</p>
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

public interface SensitiveService {	public String replace(String content);
	public List<Sensitive> find(Sensitive sensitive,String order,int currPage,int pageSize);
	public List<Sensitive> find(Sensitive Sensitive,String order,boolean cache);
	public int count(Sensitive Sensitive);
	public void proSearchParam(Sensitive sensitive,Criteria criteria);
	public Sensitive findById(String id);
	public void update(Sensitive sensitive);
	public String add(Sensitive sensitive);
	public void del(String id);
}
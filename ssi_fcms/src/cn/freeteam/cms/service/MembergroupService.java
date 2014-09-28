package cn.freeteam.cms.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.freeteam.base.BaseService;
import cn.freeteam.cms.dao.MembergroupMapper;
import cn.freeteam.cms.model.Membergroup;
import cn.freeteam.cms.model.MembergroupExample;
import cn.freeteam.cms.model.Site;
import cn.freeteam.cms.model.MembergroupExample.Criteria;
/**
 * 
 * <p>Title: MembergroupService.java</p>
 * 
 * <p>Description: 会员组服务</p>
 * 
 * <p>Date: Jan 31, 2013</p>
 * 
 * <p>Time: 7:16:17 PM</p>
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

public interface MembergroupService {	public List<Membergroup> find(Membergroup Membergroup,String order);
	public void proSearchParam(Membergroup membergroup,Criteria criteria);
	public Membergroup findById(String id);
	public void update(Membergroup membergroup);
	public String insert(Membergroup membergroup);
	public void del(String id);
	public Membergroup findByExperience(int experience);
}
package cn.freeteam.cms.service;

import java.util.List;

import cn.freeteam.cms.model.Creditlog;
import cn.freeteam.cms.model.CreditlogExample.Criteria;

/**
 * 
 * <p>Title: CreditlogService.java</p>
 * 
 * <p>Description:积分日志相关服务 </p>
 * 
 * <p>Date: Feb 1, 2013</p>
 * 
 * <p>Time: 7:59:23 PM</p>
 * 
 * <p>Copyright: 2013</p>
 * 
 * <p>Company: freeteam</p>
 * 
 * @or freeteam
 * @version 1.0
 * 
 * <p>============================================</p>
 * <p>Modification History
 * <p>Mender: </p>
 * <p>Date: </p>
 * <p>Reason: </p>
 * <p>============================================</p>
 */

public interface CreditlogService {	public List<Creditlog> find(Creditlog Creditlog,String order,int currPage,int pageSize);
	public List<Creditlog> find(Creditlog Creditlog,String order);
	public int count(Creditlog creditlog);
	public void proSearchParam(Creditlog Creditlog,Criteria criteria);
	public Creditlog findById(String id);
	public void update(Creditlog Creditlog);
	public String add(Creditlog Creditlog);
	public void del(String id);
}
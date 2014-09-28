package cn.freeteam.cms.service;

import java.util.List;

import cn.freeteam.cms.model.Creditrule;
import cn.freeteam.cms.model.CreditruleExample.Criteria;
import cn.freeteam.cms.model.Member;
/**
 * 
 * <p>Title: CreditruleService.java</p>
 * 
 * <p>Description: 积分规则相关服务</p>
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

public interface CreditruleService {	public List<Creditrule> find(Creditrule Creditrule,String order,int currPage,int pageSize);
	public List<Creditrule> find(Creditrule Creditrule,String order,boolean cache);
	public int count(Creditrule Creditrule);
	public void proSearchParam(Creditrule Creditrule,Criteria criteria);
	public Creditrule findById(String id);
	public void update(Creditrule Creditrule);
	public String add(Creditrule Creditrule);
	public void del(String id);
	public Member credit(Member member,String rulecode);
	public Creditrule findByCode(String rulecode);
}
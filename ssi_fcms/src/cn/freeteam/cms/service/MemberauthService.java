package cn.freeteam.cms.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.freeteam.base.BaseService;
import cn.freeteam.cms.dao.MemberauthMapper;
import cn.freeteam.cms.model.Memberauth;
import cn.freeteam.cms.model.MemberauthExample;
import cn.freeteam.cms.model.MemberauthExample.Criteria;

/**
 * 
 * <p>Title: MemberauthService.java</p>
 * 
 * <p>Description: 会员权限服务</p>
 * 
 * <p>Date: Jan 30, 2013</p>
 * 
 * <p>Time: 8:53:38 PM</p>
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

public interface MemberauthService {	public List<Memberauth> find(Memberauth memberauth,String order,int currPage,int pageSize);
	public List<Memberauth> find(Memberauth memberauth,String order);
	public int count(Memberauth memberauth);
	public void proSearchParam(Memberauth Memberauth,Criteria criteria);
	public Memberauth findById(String id);
	public void update(Memberauth memberauth);
	public String add(Memberauth memberauth);
	public void del(String id);
}
package cn.freeteam.cms.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.freeteam.base.BaseService;
import cn.freeteam.cms.dao.MembergroupAuthMapper;
import cn.freeteam.cms.model.MembergroupAuth;
import cn.freeteam.cms.model.MembergroupAuthExample;
import cn.freeteam.cms.model.MembergroupAuthExample.Criteria;

/**
 * 
 * <p>Title: MembergroupAuthService.java</p>
 * 
 * <p>Description: 会员组权限服务</p>
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

public interface MembergroupAuthService {	public List<MembergroupAuth> findByGroup(String groupid);
	public void delByGroup(String groupid);
	public String add(MembergroupAuth membergroupAuth);
	public boolean hasAuth(String groupid,String authcode);
}
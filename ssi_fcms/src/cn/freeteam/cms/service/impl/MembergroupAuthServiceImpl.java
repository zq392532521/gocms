package cn.freeteam.cms.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.freeteam.cms.dao.MembergroupAuthMapper;
import cn.freeteam.cms.model.MembergroupAuth;
import cn.freeteam.cms.model.MembergroupAuthExample;
import cn.freeteam.cms.model.MembergroupAuthExample.Criteria;
import cn.freeteam.cms.service.MembergroupAuthService;

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
@Service
public class MembergroupAuthServiceImpl implements MembergroupAuthService{
@Autowired
	private MembergroupAuthMapper membergroupAuthMapper;
	
	

	/**
	 * 查询会员组下授权
	 * @param groupid
	 * @return
	 */
	public List<MembergroupAuth> findByGroup(String groupid){
		MembergroupAuthExample example=new MembergroupAuthExample();
		Criteria criteria=example.createCriteria();
		criteria.andGroupidEqualTo(groupid);
		return membergroupAuthMapper.selectByExample(example);
	}
	/**
	 * 删除会员组下授权
	 * @param groupid
	 * @return
	 */
	public void delByGroup(String groupid){
		MembergroupAuthExample example=new MembergroupAuthExample();
		Criteria criteria=example.createCriteria();
		criteria.andGroupidEqualTo(groupid);
		membergroupAuthMapper.deleteByExample(example);
		
	}
	/**
	 * 添加
	 * @param question
	 * @return
	 */
	public String add(MembergroupAuth membergroupAuth){
		membergroupAuth.setId(UUID.randomUUID().toString());
		membergroupAuthMapper.insert(membergroupAuth);
		
		return membergroupAuth.getId();
	}
	/**
	 * 判断会员组是否有权限
	 * @param groupid
	 * @param authcode
	 * @return
	 */
	public boolean hasAuth(String groupid,String authcode){
		MembergroupAuthExample example=new MembergroupAuthExample();
		Criteria criteria=example.createCriteria();
		criteria.andGroupidEqualTo(groupid);
		criteria.andSql(" authid in (select id from freecms_memberauth where code='"+authcode+"')");
		return membergroupAuthMapper.countByExample(example)>0;
	}
	public MembergroupAuthMapper getMembergroupAuthMapper() {
		return membergroupAuthMapper;
	}

	public void setMembergroupAuthMapper(MembergroupAuthMapper membergroupAuthMapper) {
		this.membergroupAuthMapper = membergroupAuthMapper;
	}
}

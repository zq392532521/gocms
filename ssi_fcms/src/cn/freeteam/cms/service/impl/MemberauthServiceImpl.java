package cn.freeteam.cms.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.freeteam.cms.dao.MemberauthMapper;
import cn.freeteam.cms.model.Memberauth;
import cn.freeteam.cms.model.MemberauthExample;
import cn.freeteam.cms.model.MemberauthExample.Criteria;
import cn.freeteam.cms.service.MemberauthService;

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
@Service
public class MemberauthServiceImpl implements MemberauthService{
@Autowired
	private MemberauthMapper memberauthMapper;
	

	/**
	 * 分页查询
	 */
	public List<Memberauth> find(Memberauth memberauth,String order,int currPage,int pageSize){
		MemberauthExample example=new MemberauthExample();
		Criteria criteria=example.createCriteria();
		proSearchParam(memberauth, criteria);
		if (order!=null && order.trim().length()>0) {
			example.setOrderByClause(order);
		}
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return memberauthMapper.selectPageByExample(example);
	}
	/**
	 * 查询
	 */
	public List<Memberauth> find(Memberauth memberauth,String order){
		MemberauthExample example=new MemberauthExample();
		Criteria criteria=example.createCriteria();
		proSearchParam(memberauth, criteria);
		if (order!=null && order.trim().length()>0) {
			example.setOrderByClause(order);
		}
		return memberauthMapper.selectByExample(example);
	}
	/**
	 * 统计
	 * @param info
	 * @return
	 */
	public int count(Memberauth memberauth){
		MemberauthExample example=new MemberauthExample();
		Criteria criteria=example.createCriteria();
		proSearchParam(memberauth, criteria);
		return memberauthMapper.countByExample(example);
	}

	/**
	 * 处理查询条件
	 * @param info
	 * @param criteria
	 */
	public void proSearchParam(Memberauth Memberauth,Criteria criteria){
		if (Memberauth!=null ) {
			if (Memberauth.getCode()!=null && Memberauth.getCode().trim().length()>0) {
				criteria.andCodeLike("%"+Memberauth.getCode().trim()+"%");
			}
			if (Memberauth.getName()!=null && Memberauth.getName().trim().length()>0) {
				criteria.andNameLike("%"+Memberauth.getName().trim()+"%");
			}
		}
	}

	/**
	 * 根据id查询
	 * @param id
	 * @param cache
	 * @return
	 */
	public Memberauth findById(String id){
		return memberauthMapper.selectByPrimaryKey(id);
	}
	/**
	 * 更新
	 * @param question
	 */
	public void update(Memberauth memberauth){
		memberauthMapper.updateByPrimaryKey(memberauth);
		
	}
	/**
	 * 添加
	 * @param question
	 * @return
	 */
	public String add(Memberauth memberauth){
		memberauth.setId(UUID.randomUUID().toString());
		memberauthMapper.insert(memberauth);
		
		return memberauth.getId();
	}
	/**
	 * 删除 
	 * @param id
	 */
	public void del(String id){
		memberauthMapper.deleteByPrimaryKey(id);
		
	}
	public MemberauthMapper getMemberauthMapper() {
		return memberauthMapper;
	}

	public void setMemberauthMapper(MemberauthMapper memberauthMapper) {
		this.memberauthMapper = memberauthMapper;
	}
}

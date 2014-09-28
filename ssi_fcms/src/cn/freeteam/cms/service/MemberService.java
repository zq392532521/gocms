package cn.freeteam.cms.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.freeteam.base.BaseService;
import cn.freeteam.cms.dao.MemberMapper;
import cn.freeteam.cms.model.Member;
import cn.freeteam.cms.model.MemberExample;
import cn.freeteam.cms.model.MemberExample.Criteria;
import cn.freeteam.cms.model.Membergroup;
import cn.freeteam.util.MD5;

/**
 * 
 * <p>Title: MemberService.java</p>
 * 
 * <p>Description:会员相关服务 </p>
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

public interface MemberService {	public List<Member> find(Member member,String order,int currPage,int pageSize);
	public List<Member> find(Member member,String order);
	public int count(Member member);
	public void proSearchParam(Member member,Criteria criteria);
	public Member findById(String id);
	public void update(Member member);
	public String add(Member member);
	public void del(String id);
	public boolean have(Member member);
	public Member findByLoginname(Member member);
	public Member findByLoginname(String loginname);
	public void isok(String id,String isok);
	public String checkLogin(HttpSession session,Member member);
}
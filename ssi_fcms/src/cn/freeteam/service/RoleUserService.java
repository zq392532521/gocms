package cn.freeteam.service;

import java.util.UUID;



import org.springframework.beans.factory.annotation.Autowired;

import cn.freeteam.dao.RoleUserMapper;
import cn.freeteam.model.RoleUser;
import cn.freeteam.model.RoleUserExample;
import cn.freeteam.model.RoleUserExample.Criteria;


public interface RoleUserService {
	/**
	 * 判断是用户是否有角色权限
	 * @return
	 */
	public boolean haveRoleUser(String role,String user);
	

	/**
	 * 添加关联
	 * @param role
	 * @param user
	 * @return
	 */
	public int add(String role,String user);
	/**
	 * 删除关联
	 * @param role
	 * @param user
	 * @return
	 */
	public void del(String role,String user);

}

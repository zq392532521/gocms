package cn.freeteam.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import cn.freeteam.dao.RoleFuncMapper;
import cn.freeteam.model.RoleFunc;
import cn.freeteam.model.RoleFuncExample;
import cn.freeteam.model.RoleFuncExample.Criteria;


/**
 * 关于菜单角色的相关服务
 * @author freeteam
 * 2011-4-8
 */
public interface RoleFuncService {
	/**
	 * 检查是否有此记录
	 * @param roleid
	 * @param funcid
	 * @return
	 */
	public boolean haveRoleFunc(String roleid,String funcid);
	/**
	 * 检查是否有此记录
	 * @param roleid
	 * @param funcid
	 * @return
	 */
	public RoleFunc findRoleFunc(String roleid,String funcid);
	/**
	 * 添加权限
	 * @param roleid
	 * @param funcid
	 * @return
	 */
	public int addRoleFunc(String roleid,String funcid,String dataLevel);
	/**
	 * 删除权限
	 * @param roleid
	 * @param funcid
	 * @return
	 */
	public int delRoleFunc(String roleid,String funcid);
	/**
	 * 更新
	 * @param roleFunc
	 * @return
	 */
	public int update(RoleFunc roleFunc);
}

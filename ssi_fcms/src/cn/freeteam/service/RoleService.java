package cn.freeteam.service;

import java.util.List;

import cn.freeteam.model.Roles;
import cn.freeteam.model.Users;


/**
 * 
 * <p>Title: RoleService.java</p>
 * 
 * <p>Description: 角色服务</p>
 * 
 * <p>Date: Jan 5, 2012</p>
 * 
 * <p>Time: 3:45:26 PM</p>
 * 
 * <p>Copyright: 2012</p>
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
public interface RoleService {

	/**
	 * 判断角色名称是否已存在
	 * @param roleName
	 * @return
	 */
	public boolean haveRoleName(String roleName);
	/**
	 * 添加
	 * @param roles
	 */
	public void insert(Roles roles);
	/**
	 * 更新
	 * @param role
	 */
	public void update(Roles role);
	/**
	 * 分页查询
	 * @param role
	 * @param order
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	public List<Roles> find(Roles role,String order,int currPage,int pageSize,Users loginAdmin);
	/**
	 * 查询所有
	 * @param role
	 * @param order
	 * @param loginAdmin
	 * @return
	 */
	public List<Roles> findAll(Roles role,String order,Users loginAdmin);
	/**
	 * 按id查询
	 * @param id
	 * @return
	 */
	public Roles findById(String id);
	/**
	 * 统计
	 * @param role
	 * @return
	 */
	public int count(Roles role);
	/**
	 * 删除
	 * @param id
	 */
	public void del(String id);
	/**
	 * 调用role_del存储过程
	 * @param roleId
	 */
	public void callRoleDelPro(String roleId);
	/**
	 * 调用role_update存储过程
	 * @param roleId
	 */
	public void callRoleUpdatePro(String roleId);
	/**
	 * 查询用户所属角色
	 * @return
	 */
	public List<Roles> findByUser(String userid);
}

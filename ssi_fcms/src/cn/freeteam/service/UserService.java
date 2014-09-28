package cn.freeteam.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import cn.freeteam.dao.UsersMapper;
import cn.freeteam.model.Users;


/**
 * 
 * <p>Title: UserService.java</p>
 * 
 * <p>Description: 用户服务</p>
 * 
 * <p>Date: Dec 16, 2011</p>
 * 
 * <p>Time: 4:49:39 PM</p>
 * 
 * <p>Copyright: 2011</p>
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
public interface UserService {

	
	/**
	 * 是否有此用户
	 * @param user
	 * @return
	 */
	public int have(Users user);
	
	/**
	 * 根据登录名查询用户对象
	 * freeteam 2011-12-16
	 * @param loginName
	 * @return
	 */
	public Users findByLoginName(String loginName);
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<Users> findAll();
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<Map<String,String>> findPage();
	/**
	 * 根据参数查询
	 * @return
	 */
	public List<Users> find(Users user,boolean cache);
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Users findById(String id);
	/**
	 * 保存
	 * freeteam 2011-12-17
	 * @param users
	 */
	public void save(Users users);
	/**
	 * 保存
	 * freeteam 2011-12-17
	 * @param users
	 */
	public void update(Users users);
	/**
	 * 检查登录信息是否正确
	 * @param loginname
	 * @param pwd
	 * @return
	 */
	public String checkLogin(HttpSession session,Users user);
	//setter and getter

	public UsersMapper getUsersMapper() ;

	public void setUsersMapper(UsersMapper usersMapper);
}

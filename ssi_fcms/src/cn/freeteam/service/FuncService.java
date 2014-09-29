package cn.freeteam.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import cn.freeteam.dao.FuncMapper;
import cn.freeteam.model.Func;
import cn.freeteam.model.FuncExample;
import cn.freeteam.model.FuncExample.Criteria;
import cn.freeteam.model.TreeMenu;


/**
 * 
 * <p>Title: FuncService.java</p>
 * 
 * <p>Description: 功能菜单相关服务</p>
 * 
 * <p>Date: Dec 16, 2011</p>
 * 
 * <p>Time: 4:46:30 PM</p>
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
public interface FuncService {
	
	/**
	 * 判断是否有子菜单
	 * @param parId
	 * @return
	 */
	public boolean haveSon(String parId);
	/**
	 * 查询根菜单
	 * @return
	 */
	public List<Func> selectRoot();
	/**
	 * 将根菜单转换为easyui识别的菜单
	 * @return
	 */
	public List<TreeMenu> func2FatherEasyUiMenu(List<Func> funcList);
	
	/**
	 * 将多级菜单转换为easyui识别的菜单
	 * @return
	 */
	public List<TreeMenu> func2ChildEasyUiMenu(List<Func> funcList);
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<Func> selectAll();
	/**
	 * 查询所有有权限的
	 * @return
	 */
	public List<Func> selectAllAuth(String userid);
	/**
	 * 根据用户查询根菜单
	 * @return
	 */
	public List<Func> selectRootAuth(String userid);
	/**
	 * 查询根菜单
	 * @return
	 */
	public List<Func> selectByParid(String par);
	/**
	 * 根据查询根菜单
	 * @return
	 */
	public List<Func> selectByParidAuth(String par,String userid);
	/**
	 * 根据id查询菜单
	 * @return
	 */
	public Func selectById(String id);
	/**
	 * 更新
	 * @param func
	 */
	public void update(Func func);
	/**
	 * 更新所属菜单
	 * @param func
	 */
	public void updatePar(Func func);
	/**
	 * 添加
	 * @param func
	 */
	public void insert(Func func);
	/**
	 * 递归删除
	 * @param id
	 */
	public void delete(String id);

	/**
	 * 根据菜单id获取所有父级菜单
	 * @param funcId
	 * @param funcList
	 * @return
	 */
	public List<Func> getPars(String funcId,List<Func> funcList);
	/**
	 * 根据菜单id获取所有子级菜单
	 * @param funcId
	 * @param funcList
	 * @return
	 */
	public List<Func> getSons(String funcId,List<Func> funcList);
	//setter and getter
	/**
	 * 菜单类转换为菜单tree
	 * @param func
	 * @return
	 */
	public List<TreeMenu> func2TreeMeu(List<Func> func);
	
	public List<Func> getfirstSons(String funcId);

}

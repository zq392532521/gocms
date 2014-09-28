package cn.freeteam.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.freeteam.model.Unit;



public interface UnitService {



	/**
	 * 查询是否有子数据
	 * @param parId
	 * @return
	 */
	public boolean hasChildren(String parId);
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Unit findById(String id);
	/**
	 * 根据用户查询用户所属有效单位
	 * @param user
	 * @return
	 */
	public List<Unit> findByUser(String user);
	/**
	 * 查询所有单位，顶级单位和下级单位
	 * @param parid 上级单位id
	 * @return list
	 */
	public List<Unit> selectUnit(@Param("parid")String parid);
	
	/**
	 * 根据查询
	 * @param isok
	 * @return
	 */
	public List<Unit> findByUser(String isok,String user);
	/**
	 * 调用unit_del存储过程
	 * @param roleId
	 */
	public void callUnitDelPro(String unitId);
	/**
	 * 调用unit_update存储过程
	 * @param roleId
	 */
	public void callUnitUpdatePro(String unitId);
	/**
	 * 根据父id查询
	 * @param parid
	 * @return
	 */
	public List<Unit> findByPar(String parid,String isok,String ismail,boolean cache);
}

package cn.freeteam.service.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.freeteam.dao.UnitMapper;
import cn.freeteam.model.Unit;
import cn.freeteam.model.UnitExample;
import cn.freeteam.model.UnitExample.Criteria;
import cn.freeteam.service.UnitService;


@Service()
public class UnitServiceImpl implements UnitService{

	@Autowired
	private UnitMapper unitMapper;


	/**
	 * 查询是否有子数据
	 * @param parId
	 * @return
	 */
	public boolean hasChildren(String parId){
		UnitExample example=new UnitExample();
		Criteria criteria=example.createCriteria();
		criteria.andParidEqualTo(parId);
		return unitMapper.countByExample(example)>0;
	}
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Unit findById(String id){
		if (id!=null && id.trim().length()>0) {
			return unitMapper.selectByPrimaryKey(id);
		}
		return null;
	}
	/**
	 * 根据用户查询用户所属有效单位
	 * @param user
	 * @return
	 */
	public List<Unit> findByUser(String user){
		if (user!=null && user.trim().length()>0) {
			UnitExample example=new UnitExample();
			example.setUserId(user);
			return unitMapper.findByUser(example);
		}
		return null;
	}
	/**
	 * 查询所有单位，顶级单位和下级单位
	 * @param parid 上级单位id
	 * @return list
	 */
	public List<Unit> selectUnit(@Param("parid")String parid)
	{
		return unitMapper.selectUnit(parid);
	}
	/**
	 * 根据查询
	 * @param isok
	 * @return
	 */
	public List<Unit> findByUser(String isok,String user){
		UnitExample example=new UnitExample();
		Criteria criteria=example.createCriteria();
		if (isok!=null && isok.trim().length()>0) {
			criteria.andIsokEqualTo(isok);
		}
		if (user!=null && user.trim().length()>0) {
			criteria.andSql(" id in (select unit from freecms_unit_user where users='"+user+"')");
		}
		return unitMapper.selectByExample(example);
	}
	/**
	 * 调用unit_del存储过程
	 * @param roleId
	 */
	public void callUnitDelPro(String unitId){
		try {
			Map<String,String> paramMap=new HashMap<String,String>();
			paramMap.put("unitId", unitId);
			unitMapper.delUnitById(paramMap);
		} catch (Exception e) {
			if (e.getMessage().indexOf("No data")<0) {
				System.out.println("调用unit_del存储过程时出错");
				e.printStackTrace();
			}
		}
	}
	/**
	 * 调用unit_update存储过程
	 * @param roleId
	 */
	public void callUnitUpdatePro(String unitId){
		try {
			Map<String,String> paramMap=new HashMap<String,String>();
			paramMap.put("unitId", unitId);
			unitMapper.updateUnitById(paramMap);
		} catch (Exception e) {
			if (e.getMessage().indexOf("No data")<0) {
				System.out.println("调用unit_update存储过程时出错");
				e.printStackTrace();
			}
		}
	}
	/**
	 * 根据父id查询
	 * @param parid
	 * @return
	 */
	public List<Unit> findByPar(String parid,String isok,String ismail,boolean cache){
		UnitExample example=new UnitExample();
		Criteria criteria=example.createCriteria();
		if (parid!=null && parid.trim().length()>0 && !"par".equals(parid)) {
			criteria.andParidEqualTo(parid.trim());
		}
		if ("par".equals(parid)) {
			criteria.andSql(" (parid is null or parid = '') ");
		}
		if (isok!=null && isok.trim().length()>0) {
			criteria.andIsokEqualTo(isok.trim());
		}
		if (ismail!=null && ismail.trim().length()>0) {
			criteria.andIsmailEqualTo(ismail.trim());
		}
		example.setOrderByClause(" orderNum ");
		if (cache) {
			return unitMapper.selectByExampleCache(example);
		}else {
			return unitMapper.selectByExample(example);
		}
	}
	public UnitMapper getMapper() {
		return unitMapper;
	}
	public void setMapper(UnitMapper mapper) {
		this.unitMapper = mapper;
	}
}

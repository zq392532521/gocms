package cn.freeteam.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import cn.freeteam.dao.UnitUserMapper;
import cn.freeteam.model.UnitUser;
import cn.freeteam.model.UnitUserExample;
import cn.freeteam.model.UnitUserExample.Criteria;



/**
 * 单位用户服务类
 * @author freeteam
 * 2011-4-16
 */
public interface UnitUserService {


	/**
	 * 判断一个用户与一个单位是否关联
	 * @param unit
	 * @param user
	 * @return
	 */
	public boolean haveUnitUser(String unit,String user);
	/**
	 * 添加关联
	 * @param role
	 * @param user
	 * @return
	 */
	public int add(String unit,String user);
}

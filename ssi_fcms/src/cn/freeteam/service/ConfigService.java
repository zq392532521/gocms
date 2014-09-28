package cn.freeteam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.freeteam.dao.ConfigMapper;
import cn.freeteam.model.Config;
import cn.freeteam.model.ConfigExample;
import cn.freeteam.model.ConfigExample.Criteria;
/**
 * 
 * <p>Title: ConfigService.java</p>
 * 
 * <p>Description: 系统配置服务类</p>
 * 
 * <p>Date: Jan 14, 2013</p>
 * 
 * <p>Time: 8:27:11 PM</p>
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

public interface ConfigService {
	
	/**
	 * 查询所有系统配置项目
	 * @return
	 */
	public List<Config> find();
	/**
	 * 查询指定编码配置
	 * @return
	 */
	public Config findByCode(String code);
	/**
	 * 查询指定编码配置并以分隔符处理数组
	 * @return
	 */
	public String[] findArrayByCode(String code,String split);

	/**
	 * 更新配置项
	 * @param code
	 * @param configvalue
	 */
	public void update(String code,String configvalue);

	
}

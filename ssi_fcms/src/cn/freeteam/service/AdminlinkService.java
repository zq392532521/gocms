package cn.freeteam.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import cn.freeteam.model.Adminlink;
import cn.freeteam.model.AdminlinkExample;
import cn.freeteam.model.AdminlinkExample.Criteria;
import cn.freeteam.dao.AdminlinkMapper;
/**
 * 
 * <p>Title: AdminlinkService.java</p>
 * 
 * <p>Description: 系统链接相关服务</p>
 * 
 * <p>Date: Jan 14, 2013</p>
 * 
 * <p>Time: 8:26:09 PM</p>
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

public interface AdminlinkService {

	/**
	 * 分页查询
	 */
	public List<Adminlink> find(Adminlink adminlink,String order,int currPage,int pageSize);
	
	

	/**
	 * 查询
	 */
	public List<Adminlink> find(Adminlink adminlink,String order,boolean cache);
	/**
	 * 统计
	 * @param info
	 * @return
	 */
	public int count(Adminlink adminlink);
	/**
	 * 处理查询条件
	 * @param info
	 * @param criteria
	 */
	public void proSearchParam(Adminlink adminlink,Criteria criteria);


	/**
	 * 根据id查询
	 * @param id
	 * @param cache
	 * @return
	 */
	public Adminlink findById(String id);
	/**
	 * 更新
	 * @param question
	 */
	public void update(Adminlink adminlink);
	/**
	 * 添加
	 * @param question
	 * @return
	 */
	public String add(Adminlink adminlink);
	/**
	 * 删除 
	 * @param id
	 */
	public void del(String id);

}

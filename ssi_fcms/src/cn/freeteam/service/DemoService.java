package cn.freeteam.service;

import java.util.List;

import cn.freeteam.model.Demo;
import cn.freeteam.model.DemoExample.Criteria;
/**
 * 
 * <p>Title: DemoService.java</p>
 * 
 * <p>Description: 演示功能服务</p>
 * 
 * <p>Date: Jun 19, 2013</p>
 * 
 * <p>Time: 1:42:25 PM</p>
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
public interface DemoService  {
	public List<Demo> find(Demo demo,String order,int currPage,int pageSize);
	public int count(Demo demo);
	public void proSearchParam(Demo demo,Criteria criteria);
	public Demo findById(String id);
	public void update(Demo demo);
	public String add(Demo demo);
	/**
	 * 删除 
	 * @param id
	 */
	public void del(String id);
}

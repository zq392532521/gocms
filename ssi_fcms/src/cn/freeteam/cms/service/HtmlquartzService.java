package cn.freeteam.cms.service;

import java.util.List;

import cn.freeteam.cms.model.Htmlquartz;

/**
 * 
 * <p>Title: HtmlquartzService.java</p>
 * 
 * <p>Description: 静态化调度服务类</p>
 * 
 * <p>Date: Jan 23, 2013</p>
 * 
 * <p>Time: 10:20:29 PM</p>
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

public interface HtmlquartzService {	public void update(Htmlquartz htmlquartz);
	public String insert(Htmlquartz htmlquartz);
	public Htmlquartz findById(String id);
	public Htmlquartz findBySiteid(String siteid);
	public void delBySiteid(String siteid);
	public Htmlquartz findByChannelid(String channelid);
	public void delByChannelid(String channelid);
	public List<Htmlquartz> findAll();
}
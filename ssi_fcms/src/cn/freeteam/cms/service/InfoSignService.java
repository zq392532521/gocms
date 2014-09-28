package cn.freeteam.cms.service;

import java.util.List;

import cn.freeteam.cms.dao.InfoSignMapper;
import cn.freeteam.cms.model.InfoSign;
/**
 * 
 * <p>Title: InfoSignService.java</p>
 * 
 * <p>Description: 信息签收服务</p>
 * 
 * <p>Date: Jan 15, 2013</p>
 * 
 * <p>Time: 7:13:12 PM</p>
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

public interface InfoSignService {	public void infoedit(String infoid,String[] signusers);
	public int countByInfoUser(String infoid,String userid);
	public String  save(InfoSign infoSign);
	public List<InfoSign> findByInfo(String infoid);
	public List<InfoSign> findSignByInfo(String infoid);
	public InfoSign findByUserInfo(String userid,String infoid);
	public void update(InfoSign infoSign);
	public InfoSignMapper getInfoSignMapper() ;
	public void setInfoSignMapper(InfoSignMapper infoSignMapper) ;
}
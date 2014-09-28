package cn.freeteam.cms.service;

import java.util.List;

import cn.freeteam.cms.dao.InfoImgMapper;
import cn.freeteam.cms.model.InfoImg;
import cn.freeteam.cms.model.InfoImgExample.Criteria;

public interface InfoImgService  {	public List<InfoImg> findByInfoid(String infoid);
	public List<InfoImg> find(InfoImg infoImg,String order);
	public int count(InfoImg infoImg);
	public void proSearchParam(InfoImg infoImg,Criteria criteria);
	public InfoImg findById(String id);
	public void update(InfoImg infoImg);
	public String add(InfoImg infoImg);
	public void del(String id);
	public InfoImgMapper getInfoImgMapper() ;
	public void setInfoImgMapper(InfoImgMapper infoImgMapper) ;
}
package cn.freeteam.cms.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.freeteam.cms.dao.InfoImgMapper;
import cn.freeteam.cms.model.InfoImg;
import cn.freeteam.cms.model.InfoImgExample;
import cn.freeteam.cms.model.InfoImgExample.Criteria;
import cn.freeteam.cms.service.InfoImgService;
@Service
public class InfoImgServiceImpl implements InfoImgService{
@Autowired
	private InfoImgMapper infoImgMapper;
	

	/**
	 * 查询
	 */
	public List<InfoImg> findByInfoid(String infoid){
		InfoImgExample example=new InfoImgExample();
		Criteria criteria=example.createCriteria();
		InfoImg infoImg=new InfoImg();
		infoImg.setInfoid(infoid);
		proSearchParam(infoImg, criteria);
		return infoImgMapper.selectByExample(example);
	}

	/**
	 * 查询
	 */
	public List<InfoImg> find(InfoImg infoImg,String order){
		InfoImgExample example=new InfoImgExample();
		Criteria criteria=example.createCriteria();
		proSearchParam(infoImg, criteria);
		if (order!=null && order.trim().length()>0) {
			example.setOrderByClause(order);
		}
		return infoImgMapper.selectByExample(example);
	}
	/**
	 * 统计
	 * @param InfoImg
	 * @return
	 */
	public int count(InfoImg infoImg){
		InfoImgExample example=new InfoImgExample();
		Criteria criteria=example.createCriteria();
		proSearchParam(infoImg, criteria);
		return infoImgMapper.countByExample(example);
	}

	/**
	 * 处理查询条件
	 * @param InfoImg
	 * @param criteria
	 */
	public void proSearchParam(InfoImg infoImg,Criteria criteria){
		if (infoImg!=null ) {
			if (StringUtils.isNotEmpty(infoImg.getInfoid())) {
				criteria.andInfoidEqualTo(infoImg.getInfoid());
			}
		}
	}

	/**
	 * 根据id查询
	 * @param id
	 * @param cache
	 * @return
	 */
	public InfoImg findById(String id){
		return infoImgMapper.selectByPrimaryKey(id);
	}
	/**
	 * 更新
	 * @param question
	 */
	public void update(InfoImg infoImg){
		infoImgMapper.updateByPrimaryKeySelective(infoImg);
		
	}
	/**
	 * 添加
	 * @param question
	 * @return
	 */
	public String add(InfoImg infoImg){
		infoImg.setId(UUID.randomUUID().toString());
		infoImgMapper.insert(infoImg);
		
		return infoImg.getId();
	}
	/**
	 * 删除 
	 * @param id
	 */
	public void del(String id){
		infoImgMapper.deleteByPrimaryKey(id);
		
	}

	public InfoImgMapper getInfoImgMapper() {
		return infoImgMapper;
	}

	public void setInfoImgMapper(InfoImgMapper infoImgMapper) {
		this.infoImgMapper = infoImgMapper;
	}
}

package cn.freeteam.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.freeteam.dao.DemoMapper;
import cn.freeteam.model.Demo;
import cn.freeteam.model.DemoExample;
import cn.freeteam.model.DemoExample.Criteria;
import cn.freeteam.service.DemoService;

/**
 * @author Administrator
 *
 */
@Service
public class DemoServiceImpl implements DemoService  {
	@Autowired
	private DemoMapper demoMapper;

	public DemoMapper getDemoMapper() {
		return demoMapper;
	}

	public void setDemoMapper(DemoMapper demoMapper) {
		this.demoMapper = demoMapper;
	}
	

	/**
	 * 分页查询
	 */
	@Override
	public List<Demo> find(Demo demo,String order,int currPage,int pageSize){
		DemoExample example=new DemoExample();
		Criteria criteria=example.createCriteria();
		proSearchParam(demo, criteria);
		if (order!=null && order.trim().length()>0) {
			example.setOrderByClause(order);
		}
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return demoMapper.selectPageByExample(example);
	}
	/**
	 * 统计
	 * @param info
	 * @return
	 */
	@Override
	public int count(Demo demo){
		DemoExample example=new DemoExample();
		Criteria criteria=example.createCriteria();
		proSearchParam(demo, criteria);
		return demoMapper.countByExample(example);
	}

	/**
	 * 处理查询条件
	 * @param info
	 * @param criteria
	 */
	@Override
	public void proSearchParam(Demo demo,Criteria criteria){
		if (demo!=null ) {
			if (demo.getTextdemo()!=null && demo.getTextdemo().trim().length()>0) {
				criteria.andTextdemoLike("%"+demo.getTextdemo().trim()+"%");
			}
		}
	}

	/**
	 * 根据id查询
	 * @param id
	 * @param cache
	 * @return
	 */
	@Override
	public Demo findById(String id){
		return demoMapper.selectByPrimaryKey(id);
	}
	/**
	 * 更新
	 * @param question
	 */
	@Override
	public void update(Demo demo){
		demoMapper.updateByPrimaryKeySelective(demo);
	}
	/**
	 * 添加
	 * @param question
	 * @return
	 */
	@Override
	public String add(Demo demo){
		demo.setId(UUID.randomUUID().toString());
		return demo.getId();
	}
	/**
	 * 删除 
	 * @param id
	 */
	@Override
	public void del(String id){
		demoMapper.deleteByPrimaryKey(id);
	}
}

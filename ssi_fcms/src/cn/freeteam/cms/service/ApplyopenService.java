package cn.freeteam.cms.service;

import java.util.List;

import cn.freeteam.cms.model.Applyopen;
import cn.freeteam.cms.model.ApplyopenExample.Criteria;

public interface ApplyopenService {

	
	

	/**
	 * 添加
	 * @param Applyopen
	 * @return
	 */
	public String insert(Applyopen applyopen);

	/**
	 * 分页查询
	 */
	public List<Applyopen> find(Applyopen applyopen,String order,int currPage,int pageSize,boolean cache);
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Applyopen findById(String id);
	/**
	 * 根据querycode查询
	 * @param id
	 * @return
	 */
	public Applyopen findByQuerycode(String querycode,boolean cache);
	/**
	 * 统计
	 * @param info
	 * @return
	 */
	public int count(Applyopen Applyopen,boolean cache);
	/**
	 * 处理查询条件
	 * @param info
	 * @param criteria
	 */
	public void proSearchParam(Applyopen Applyopen,Criteria criteria);
	/**
	 * 更新
	 * @param templet
	 */
	public void update(Applyopen Applyopen);
	/**
	 * 删除 
	 * @param id
	 */
	public void del(String id);



}

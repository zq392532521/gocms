package cn.freeteam.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.freeteam.model.Adminlink;
import cn.freeteam.model.AdminlinkExample;
import cn.freeteam.model.AdminlinkExample.Criteria;
import cn.freeteam.service.AdminlinkService;
import cn.freeteam.base.BaseService;
import cn.freeteam.dao.AdminlinkMapper;

/**
 * 
 * <p>
 * Title: AdminlinkService.java
 * </p>
 * 
 * <p>
 * Description: 系统链接相关服务
 * </p>
 * 
 * <p>
 * Date: Jan 14, 2013
 * </p>
 * 
 * <p>
 * Time: 8:26:09 PM
 * </p>
 * 
 * <p>
 * Copyright: 2013
 * </p>
 * 
 * <p>
 * Company: freeteam
 * </p>
 * 
 * @author freeteam
 * @version 1.0
 * 
 *          <p>=
 *          ===========================================
 *          </p>
 *          <p>
 *          Modification History
 *          <p>
 *          Mender:
 *          </p>
 *          <p>
 *          Date:
 *          </p>
 *          <p>
 *          Reason:
 *          </p>
 *          <p>=
 *          ===========================================
 *          </p>
 */
@Service
public class AdminlinkServiceImpl extends BaseService implements AdminlinkService {
	@Autowired
	private AdminlinkMapper adminlinkMapper;

	/**
	 * 分页查询
	 */
	@Override
	public List<Adminlink> find(Adminlink adminlink, String order,
			int currPage, int pageSize) {
		AdminlinkExample example = new AdminlinkExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(adminlink, criteria);
		if (order != null && order.trim().length() > 0) {
			example.setOrderByClause(order);
		}
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return adminlinkMapper.selectPageByExample(example);
	}

	/**
	 * 查询
	 */
	@Override
	public List<Adminlink> find(Adminlink adminlink, String order, boolean cache) {
		AdminlinkExample example = new AdminlinkExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(adminlink, criteria);
		if (order != null && order.trim().length() > 0) {
			example.setOrderByClause(order);
		}
		if (cache) {
			return adminlinkMapper.selectByExampleCache(example);
		}
		return adminlinkMapper.selectByExample(example);
	}

	/**
	 * 统计
	 * 
	 * @param info
	 * @return
	 */
	@Override
	public int count(Adminlink adminlink) {
		AdminlinkExample example = new AdminlinkExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(adminlink, criteria);
		return adminlinkMapper.countByExample(example);
	}

	/**
	 * 处理查询条件
	 * 
	 * @param info
	 * @param criteria
	 */
	@Override
	public void proSearchParam(Adminlink adminlink, Criteria criteria) {
		if (adminlink != null) {
			if (adminlink.getName() != null
					&& adminlink.getName().trim().length() > 0) {
				criteria.andNameLike("%" + adminlink.getName().trim() + "%");
			}
			if (adminlink.getType() != null
					&& adminlink.getType().trim().length() > 0) {
				criteria.andTypeEqualTo(adminlink.getType().trim());
			}
			if (adminlink.getUserid() != null
					&& adminlink.getUserid().trim().length() > 0) {
				criteria.andUseridEqualTo(adminlink.getUserid().trim());
			}
		}
	}

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @param cache
	 * @return
	 */
	@Override
	public Adminlink findById(String id) {
		return adminlinkMapper.selectByPrimaryKey(id);
	}

	/**
	 * 更新
	 * 
	 * @param question
	 */
	@Override
	public void update(Adminlink adminlink) {
		adminlinkMapper.updateByPrimaryKeySelective(adminlink);
	}

	/**
	 * 添加
	 * 
	 * @param question
	 * @return
	 */
	@Override
	public String add(Adminlink adminlink) {
		adminlink.setId(UUID.randomUUID().toString());
		adminlinkMapper.insert(adminlink);
		return adminlink.getId();
	}

	/**
	 * 删除
	 * 
	 * @param id
	 */
	@Override
	public void del(String id) {
		adminlinkMapper.deleteByPrimaryKey(id);
	}

}

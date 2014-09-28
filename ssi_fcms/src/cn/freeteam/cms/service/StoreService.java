package cn.freeteam.cms.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.freeteam.base.BaseService;
import cn.freeteam.cms.dao.StoreMapper;
import cn.freeteam.cms.model.Store;
import cn.freeteam.cms.model.StoreExample;
import cn.freeteam.cms.model.StoreExample.Criteria;

public interface StoreService {	public String insert(Store store);
	public void del(String id);
	public List<Store> find(Store guestbook,String order,int currPage,int pageSize);
	public int count(Store store);
	public void proSearchParam(Store store,Criteria criteria);
}
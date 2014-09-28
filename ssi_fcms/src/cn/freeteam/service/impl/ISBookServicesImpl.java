package cn.freeteam.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.freeteam.dao.ISBookMapper;

@Service
public class ISBookServicesImpl {
	@Autowired
	private ISBookMapper iSBookMapper;
	
	public List<Map> pageTest(Map map) {
		// TODO Auto-generated method stub
		return iSBookMapper.pageTest(map);
	}

	public int pageCount(Map map) {
		// TODO Auto-generated method stub
		return iSBookMapper.pageCount(map);
	}
	public ISBookMapper getiSBookMapper() {
		return iSBookMapper;
	}
	public void setiSBookMapper(ISBookMapper iSBookMapper) {
		this.iSBookMapper = iSBookMapper;
	}

}

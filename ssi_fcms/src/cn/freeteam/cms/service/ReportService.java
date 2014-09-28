package cn.freeteam.cms.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.freeteam.base.BaseService;
import cn.freeteam.cms.dao.ReportMapper;
import cn.freeteam.cms.model.Report;
import cn.freeteam.cms.model.ReportExample;
import cn.freeteam.cms.model.ReportExample.Criteria;

public interface ReportService {	public String insert(Report report);
	public List<Report> find(Report report,String order,int currPage,int pageSize,boolean cache);
	public Report findById(String id);
	public Report findByQuerycode(String querycode,boolean cache);
	public int count(Report report,boolean cache);
	public void proSearchParam(Report report,Criteria criteria);
	public void update(Report report);
	public void del(String id);
}
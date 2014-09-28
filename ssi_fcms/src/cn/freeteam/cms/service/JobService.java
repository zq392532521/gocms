package cn.freeteam.cms.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.freeteam.base.BaseService;
import cn.freeteam.cms.dao.JobMapper;
import cn.freeteam.cms.model.Job;
import cn.freeteam.cms.model.JobExample;
import cn.freeteam.cms.model.JobExample.Criteria;

public interface JobService {	public List<Job> find(Job job,String order,int currPage,int pageSize,boolean cache);
	public int count(Job job,boolean cache);
	public void proSearchParam(Job job,Criteria criteria);
	public Job findById(String id,boolean cache);
	public void update(Job Job);
	public String add(Job job);
	public void del(String id);
	public JobMapper getJobMapper() ;
	public void setJobMapper(JobMapper jobMapper) ;
}
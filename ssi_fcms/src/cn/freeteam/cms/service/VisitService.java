package cn.freeteam.cms.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.freeteam.base.BaseService;
import cn.freeteam.cms.dao.VisitMapper;
import cn.freeteam.cms.model.Info;
import cn.freeteam.cms.model.InfoExample;
import cn.freeteam.cms.model.Visit;
import cn.freeteam.cms.model.VisitExample;
import cn.freeteam.cms.model.VisitExample.Criteria;

public interface VisitService {	public String add(Visit visit);
	public List<Visit> channelVisit(Visit visit);
	public List<Visit> channelVisit(Visit visit,int currPage,int pageSize);
	public int channelVisitCount(Visit visit);
	public int channelVisitSum(Visit visit);
	public int siteVisitSum(Visit visit);
	public List<Visit> siteVisit(Visit visit);
	public List<Visit> siteVisit(Visit visit,int currPage,int pageSize);
	public int siteVisitCount(Visit visit);
	public List<Visit> infoVisit(Visit visit);
	public List<Visit> infoVisit(Visit visit,int currPage,int pageSize);
	public int infoVisitCount(Visit visit);
	public int infoVisitSum(Visit visit);
	public List<Visit> visitYear(Visit visit);
	public List<Visit> visitYear(Visit visit,int currPage,int pageSize);
	public int visitYearCount(Visit visit);
	public List<Visit> visitMonth(Visit visit);
	public List<Visit> visitMonth(Visit visit,int currPage,int pageSize);
	public int visitMonthCount(Visit visit);
	public List<Visit> visitDay(Visit visit);
	public List<Visit> visitDay(Visit visit,int currPage,int pageSize);
	public int visitDayCount(Visit visit);
	public List<Visit> visitWeek(Visit visit);
	public int visitSum(Visit visit);
	public void proSearchParam(Visit visit,Criteria criteria);
	public int count(Visit visit,boolean cache);
	public VisitMapper getVisitMapper() ;
	public void setVisitMapper(VisitMapper visitMapper) ;
}
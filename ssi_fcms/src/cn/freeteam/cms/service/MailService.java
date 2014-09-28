package cn.freeteam.cms.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.freeteam.base.BaseService;
import cn.freeteam.cms.dao.MailMapper;
import cn.freeteam.cms.model.Mail;
import cn.freeteam.cms.model.MailExample;
import cn.freeteam.cms.model.MailExample.Criteria;

public interface MailService {	public String insert(Mail mail);
	public List<Mail> find(Mail mail,String order,int currPage,int pageSize,boolean cache);
	public Mail findById(String id);
	public Mail findByQuerycode(String querycode,boolean cache);
	public int count(Mail mail,boolean cache);
	public void proSearchParam(Mail mail,Criteria criteria);
	public void update(Mail mail);
	public void del(String id);
}
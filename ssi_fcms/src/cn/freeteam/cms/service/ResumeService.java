package cn.freeteam.cms.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.freeteam.base.BaseService;
import cn.freeteam.cms.dao.ResumeMapper;
import cn.freeteam.cms.model.Resume;
import cn.freeteam.cms.model.ResumeExample;
import cn.freeteam.cms.model.ResumeExample.Criteria;
/**
 * 
 * <p>Title: ResumeService.java</p>
 * 
 * <p>Description: 简历相关服务</p>
 * 
 * <p>Date: Feb 4, 2013</p>
 * 
 * <p>Time: 7:50:54 PM</p>
 * 
 * <p>Copyright: 2013</p>
 * 
 * <p>Company: freeteam</p>
 * 
 * @author freeteam
 * @version 1.0
 * 
 * <p>============================================</p>
 * <p>Modification History
 * <p>Mender: </p>
 * <p>Date: </p>
 * <p>Reason: </p>
 * <p>============================================</p>
 */

public interface ResumeService {	public List<Resume> find(Resume resume,String order,int currPage,int pageSize);
	public int count(Resume resume);
	public void proSearchParam(Resume resume,Criteria criteria);
	public Resume findById(String id);
	public void update(Resume resume);
	public String add(Resume resume);
	public void del(String id);
}
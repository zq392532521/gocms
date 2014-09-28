package cn.freeteam.cms.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.freeteam.base.BaseService;
import cn.freeteam.cms.dao.QuestionMapper;
import cn.freeteam.cms.model.Question;
import cn.freeteam.cms.model.QuestionExample;
import cn.freeteam.cms.model.QuestionExample.Criteria;
/**
 * 
 * <p>Title: QuestionService.java</p>
 * 
 * <p>Description: 网上调查服务类</p>
 * 
 * <p>Date: Jan 22, 2013</p>
 * 
 * <p>Time: 8:58:23 PM</p>
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

public interface QuestionService {	public List<Question> find(Question question,String order,int currPage,int pageSize,boolean cache);
	public int count(Question question,boolean cache);
	public void proSearchParam(Question question,Criteria criteria);
	public Question findById(String id,boolean cache);
	public void update(Question question);
	public String add(Question question);
	public void del(String id);
}
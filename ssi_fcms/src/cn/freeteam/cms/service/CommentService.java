package cn.freeteam.cms.service;

import java.util.List;

import cn.freeteam.cms.model.Comment;
import cn.freeteam.cms.model.CommentExample.Criteria;

/**
 * 
 * <p>Title: CommentService.java</p>
 * 
 * <p>Description: 评论服务</p>
 * 
 * <p>Date: Feb 6, 2013</p>
 * 
 * <p>Time: 1:45:17 PM</p>
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

public interface CommentService {	public List<Comment> find(Comment Comment,String order,int currPage,int pageSize,boolean iscache);
	public List<Comment> find(Comment Comment,String order);
	public int count(Comment Comment,boolean iscache);
	public void proSearchParam(Comment Comment,Criteria criteria);
	public Comment findById(String id);
	public void update(Comment Comment);
	public String add(Comment Comment);
	public void del(String id);
	public void state(String id);
	public List<Comment> commentUpdateYear(Comment comment);
	public List<Comment> commentUpdateYear(Comment comment,int currPage,int pageSize);
	public int commentUpdateYearCount(Comment comment);
	public int commentUpdateYearSum(Comment comment);
	public List<Comment> commentUpdateMonth(Comment comment);
	public List<Comment> commentUpdateMonth(Comment comment,int currPage,int pageSize);
	public int commentUpdateMonthCount(Comment comment);
	public int commentUpdateMonthSum(Comment comment);
	public List<Comment> commentUpdateDay(Comment comment);
	public List<Comment> commentUpdateDay(Comment comment,int currPage,int pageSize);
	public int commentUpdateDayCount(Comment comment);
	public int commentUpdateDaySum(Comment comment);
	public int commentUpdateWeekSum(Comment comment);
	public List<Comment> commentUpdateWeek(Comment comment);
	public List<Comment> sysSiteComment(Comment comment,int currPage,int pageSize);
	public List<Comment> sysSiteComment(Comment comment);
	public int sysSiteCommentCount(Comment comment);
	public int sysSiteCommentSum(Comment comment);
}
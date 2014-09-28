package cn.freeteam.cms.service;

import java.util.List;

import cn.freeteam.cms.model.Guestbook;
import cn.freeteam.cms.model.GuestbookExample.Criteria;
/**
 * 
 * <p>Title: GuestbookService.java</p>
 * 
 * <p>Description: 留言本相关服务</p>
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

public interface GuestbookService {	public List<Guestbook> find(Guestbook guestbook,String order,int currPage,int pageSize,boolean cache);
	public int count(Guestbook Guestbook,boolean cache);
	public void proSearchParam(Guestbook guestbook,Criteria criteria);
	public Guestbook findById(String id);
	public void update(Guestbook Guestbook);
	public String add(Guestbook Guestbook);
	public void del(String id);
	public List<Guestbook> guestbookUpdateYear(Guestbook guestbook);
	public List<Guestbook> guestbookUpdateYear(Guestbook guestbook,int currPage,int pageSize);
	public int guestbookUpdateYearCount(Guestbook guestbook);
	public int guestbookUpdateYearSum(Guestbook guestbook);
	public List<Guestbook> guestbookUpdateMonth(Guestbook guestbook);
	public List<Guestbook> guestbookUpdateMonth(Guestbook guestbook,int currPage,int pageSize);
	public int guestbookUpdateMonthCount(Guestbook guestbook);
	public int guestbookUpdateMonthSum(Guestbook guestbook);
	public List<Guestbook> guestbookUpdateDay(Guestbook guestbook);
	public List<Guestbook> guestbookUpdateDay(Guestbook guestbook,int currPage,int pageSize);
	public int guestbookUpdateDayCount(Guestbook guestbook);
	public int guestbookUpdateDaySum(Guestbook guestbook);
	public int guestbookUpdateWeekSum(Guestbook guestbook);
	public List<Guestbook> guestbookUpdateWeek(Guestbook guestbook);
	public List<Guestbook> sysSiteGuestbook(Guestbook guestbook,int currPage,int pageSize);
	public List<Guestbook> sysSiteGuestbook(Guestbook guestbook);
	public int sysSiteGuestbookCount(Guestbook guestbook);
	public int sysSiteGuestbookSum(Guestbook guestbook);
}
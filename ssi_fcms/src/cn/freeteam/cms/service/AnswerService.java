package cn.freeteam.cms.service;

import java.util.List;

import cn.freeteam.cms.model.Answer;

/**
 * 
 * <p>Title: AnswerService.java</p>
 * 
 * <p>Description:网上调查选项 </p>
 * 
 * <p>Date: Jan 22, 2013</p>
 * 
 * <p>Time: 8:07:05 PM</p>
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

public interface AnswerService {
	/**
	 * 查询批定网上调查下选项
	 * @param questidid
	 * @return
	 */
	public List<Answer> findByQuestion(String questidid,String isok,boolean cache);
	/**
	 * 根据id查询
	 * @param id
	 * @param cache
	 * @return
	 */
	public Answer findById(String id,boolean cache);

	/**
	 * 更新
	 * @param answer
	 */
	public void update(Answer answer);
	/**
	 * 选择
	 * @param id
	 */
	public void selectnum(String id);
	/**
	 * 添加
	 * @param answer
	 * @return
	 */
	public String add(Answer answer);
	/**
	 * 删除 
	 * @param id
	 */
	public void del(String id);
	/**
	 * 统计选择次数
	 * @param questidid
	 * @param isok
	 * @param cache
	 * @return
	 */
	public int countSelectnum(String questidid,String isok,boolean cache);
}

package cn.freeteam.service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Administrator
 *
 */
public interface LogService {
	/**
	 * 记录操作人日志
	 * @param loginname
	 * 用户名
	 * @param content
	 * 内容
	 */
 void log(String loginname,String content,HttpServletRequest request);
}

package cn.freeteam.base;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import cn.freeteam.service.LogService;

/**
 * @author Administrator
 *
 */
public  class BaseService {
	
	@Resource 
	private LogService logService;
	public  void log(String loginname,String content,HttpServletRequest request) {
		logService.log(loginname, content, request);
	}
	public void init(String...str){
		
	}
}

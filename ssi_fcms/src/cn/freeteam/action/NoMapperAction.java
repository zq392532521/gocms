
package cn.freeteam.action;

import cn.freeteam.base.BaseAction;

/**
 * ActionMapping 没找到action
 * 
 * @author LiuTong
 * 
 */
public class NoMapperAction extends BaseAction {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String noMapperAction() {
		return "noMapperAction";
	}


}

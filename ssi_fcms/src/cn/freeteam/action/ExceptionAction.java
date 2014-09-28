
package cn.freeteam.action;

import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.freeteam.base.BaseAction;
import cn.freeteam.model.Users;

import com.opensymphony.xwork2.ActionContext;

/**
 * 处理Action异常
 * 
 * @author LiuTong
 * 
 */
public class ExceptionAction extends BaseAction {
	private Exception exception;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() {
		try {
			if(exception instanceof NoSuchMethodException){
				String str="cn.freeteam.action";
				String message=exception.getMessage();
				if(exception.getMessage().indexOf(str)>=0||exception.getMessage().indexOf("cn.freeteam.cms.action") >=0){
					return "noMapperAction";
				}
			}
			logger.error("********** 系统异常 **********{}{}",
					System.getProperty("line.separator"), getErrorMessage());
			logger.error(exception.getMessage(), exception);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return "error";
	}

	private String getErrorMessage() {
		ActionContext context = ActionContext.getContext();
		Map<String, Object> params = context.getParameters();
		StringBuffer paramsStr = new StringBuffer();

		try {
			for (String key : params.keySet()) {
				paramsStr.append(key).append("=")
						.append(ArrayUtils.toString(params.get(key)))
						.append(";");
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		StringBuffer message = new StringBuffer();
		Users admin = (Users) getHttpSession().getAttribute("loginAdmin");
		if (admin != null)
			message.append("登录用户：").append(admin.getName())
					.append(System.getProperty("line.separator"));
		message.append("客户端IP：")
				.append(ServletActionContext.getRequest().getRemoteAddr())
				.append(System.getProperty("line.separator"))
				.append("客户端User-Agent：")
				.append(ServletActionContext.getRequest().getHeader(
						"User-Agent"))
				.append(System.getProperty("line.separator")).append("请求URL：")
				.append(ServletActionContext.getRequest().getRequestURI())
				.append(System.getProperty("line.separator")).append("请求参数：")
				.append(paramsStr);

		return message.toString();
	}

	/**
	 * @return the exception
	 */
	public Exception getException() {
		return exception;
	}

	/**
	 * @param exception
	 *            the exception to set
	 */
	public void setException(Exception exception) {
		this.exception = exception;
	}

	final Logger logger = LoggerFactory.getLogger(ExceptionAction.class);
	private static final long serialVersionUID = 1461747420299280284L;
}

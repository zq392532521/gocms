package cn.freeteam.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import cn.freeteam.base.BaseAction;
import cn.freeteam.model.Users;
import cn.freeteam.service.UserService;
import cn.freeteam.util.EscapeUnescape;
import cn.freeteam.util.ResponseUtil;
import cn.freeteam.util.SpringUtils;




/**
 * 登录
 * @author freeteam
 *
 */

public class LoginAction extends BaseAction{
	private Users user;
	private String ValidateCode;
	private String RememberMe;
	private String msg;
	@Autowired
	private UserService userService;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String login(){
		return "login";
	}
	public String dologin(){
		try {
			//记住用户名
			if("on".equals(RememberMe)){
				Cookie cookie=new Cookie("FreeCMS_loginName",EscapeUnescape.escape(user.getLoginname()));
				cookie.setMaxAge(60*60*24*365);//有效时间为一年
				getHttpResponse().addCookie(cookie);
			}
		    HttpSession session =getHttpSession();
			/*if (ValidateCode!=null && ValidateCode.equals(session.getAttribute("rand"))) {
				msg=userService.checkLogin(getHttpSession(), user);
			}else {
				msg="验证码错误!";
			}*/
		    
		    
			msg=userService.checkLogin(getHttpSession(), user);
			if (msg==null || "".equals(msg)) {
				log(user.getLoginname(), "登录系统", getHttpRequest());
				return "admin";
			}else {
				ResponseUtil.writeGBK(getHttpResponse(), "<script>alert('"+msg+"');history.back();</script>");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			log(user.getLoginname(), "登录系统失败:"+e.toString(), getHttpRequest());
			ResponseUtil.writeGBK(getHttpResponse(), "<script>alert('出现错误:"+e.toString()+"');history.back();</script>");
			return null;
		}
	}
	//退出
	public String out(){
	    HttpSession session =getHttpSession();
	    user=(Users)session.getAttribute("loginAdmin");
	    if (user!=null) {
			log(user.getLoginname(), "退出系统", getHttpRequest());
		}
	    session.removeAttribute("loginAdmin");
	    session.removeAttribute("manageSite");
	    session.removeAttribute("siteAdmin");
	    session.removeAttribute("loginUnits");
	    session.removeAttribute("loginRoles");
	    session.removeAttribute("funcs");
		return "login";
	}
	//退出
	public String adminLogin(){
		return "login";
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public String getValidateCode() {
		return ValidateCode;
	}
	public void setValidateCode(String validateCode) {
		ValidateCode = validateCode;
	}
	public String getRememberMe() {
		return RememberMe;
	}
	public void setRememberMe(String rememberMe) {
		RememberMe = rememberMe;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}

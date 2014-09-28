package cn.freeteam.action;

import java.util.List;
import java.util.Map;

import cn.freeteam.base.BaseAction;
import cn.freeteam.model.Users;
import cn.freeteam.service.impl.UserServiceImpl;

public class TestPage extends BaseAction{
	private UserServiceImpl userService;
	public TestPage(){
		init("userService");
	}
public String test(){
	List<Map<String, String>> users=userService.findPage();
	return "test";
}
public String testCommon(){
	return "testCommon";
}

public String testOutCommon(){
	return "testOutCommon";
}
public UserServiceImpl getUserService() {
	return userService;
}
public void setUserService(UserServiceImpl userService) {
	this.userService = userService;
}

}

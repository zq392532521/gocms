package cn.freeteam.action.test.log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.freeteam.action.ExceptionAction;

import com.opensymphony.xwork2.ActionSupport;

public class TestLog extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2260097383418316644L;
	final Logger logger = LoggerFactory.getLogger(TestLog.class);
	@Override
	public String execute() {
		logger.debug("testLog............");
		return SUCCESS;
	}
}

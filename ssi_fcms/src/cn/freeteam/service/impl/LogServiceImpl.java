package cn.freeteam.service.impl;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.freeteam.dao.OperlogsMapper;
import cn.freeteam.model.Operlogs;
import cn.freeteam.service.LogService;


/**
 * @author Administrator
 *
 */
@Service
public class LogServiceImpl implements LogService {
	@Autowired
	 private OperlogsMapper operlogsMapper;
	@Override
	public  void log(String loginname,String content,HttpServletRequest request) {
			if (content!=null && content.trim().length()>0) {
				Operlogs log=new Operlogs();
				log.setId(UUID.randomUUID().toString());
				log.setContent(content);
				log.setIp(request.getRemoteAddr());
				log.setLoginname(loginname);
				log.setOpertime(new Date());
				operlogsMapper.insert(log);
			}
	}
}

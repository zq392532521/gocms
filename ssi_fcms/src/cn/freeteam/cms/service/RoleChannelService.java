package cn.freeteam.cms.service;

import java.util.UUID;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.freeteam.base.BaseService;
import cn.freeteam.cms.dao.RoleChannelMapper;
import cn.freeteam.cms.model.RoleChannel;
import cn.freeteam.cms.model.RoleChannelExample;
import cn.freeteam.cms.model.RoleChannelExample.Criteria;


public interface RoleChannelService {	public void delByRole(String roleid);
	public void save(String roleid,String channelid);
	public boolean have(String roleid,String channelid);
	public boolean haves(String roles,String channelid);
}
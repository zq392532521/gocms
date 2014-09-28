package cn.freeteam.cms.service;

import java.util.List;
import java.util.UUID;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.freeteam.base.BaseService;
import cn.freeteam.cms.dao.RoleSiteMapper;
import cn.freeteam.cms.model.RoleSite;
import cn.freeteam.cms.model.RoleSiteExample;
import cn.freeteam.cms.model.RoleSiteExample.Criteria;


public interface RoleSiteService {	public boolean have(String siteid,String roleid);
	public RoleSite findBySiteRole(String siteid,String roleid);
	public RoleSite findBySiteRoles(String siteid,String roles,String siteadmin);
	public void del(String siteid,String roleid);
	public void save(String siteid,String roleid,String siteadmin);
}
package cn.freeteam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.freeteam.dao.OperbuttonMapper;
import cn.freeteam.model.Operbutton;
import cn.freeteam.model.OperbuttonExample;
import cn.freeteam.model.OperbuttonExample.Criteria;


/**
 * 关于操作按钮的相关服务
 * @author freeteam
 * 2011-4-8
 */
public interface OperbuttonService {
	
	/**
	 * 查询所有
	 * @param funcid
	 * @return
	 */
	public List<Operbutton> findAll();
	/**
	 * 查询菜单下有效操作按钮
	 * @param funcid
	 * @return
	 */
	public List<Operbutton> findByFuncOk(String funcid);
	/**
	 * 查询菜单下有效操作按钮
	 * @param funcid
	 * @return
	 */
	public List<Operbutton> findByFunc(String funcid) ;
	/**
	 * 查询操作按钮
	 * @param funcid
	 * @return
	 */
	public Operbutton findById(String id) ;
	/**
	 * 判断操作按钮名是否存在
	 * @param name
	 * @return
	 */
	public boolean haveName(String funcId,String name);
	/**
	 * 添加
	 * @param operbutton
	 */
	public void insert(Operbutton operbutton);
	/**
	 * 更新
	 * @param operbutton
	 */
	public void update(Operbutton operbutton);
	/**
	 * 删除
	 * @param id
	 */
	public void delete(String id);
}

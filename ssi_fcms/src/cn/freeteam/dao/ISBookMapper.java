package cn.freeteam.dao;

import java.util.List;
import java.util.Map;


 
public interface ISBookMapper {
	public List<Map> pageTest(Map map);
	int pageCount(Map map);
}

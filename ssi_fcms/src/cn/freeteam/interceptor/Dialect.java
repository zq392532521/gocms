/**
 * 
 */
package cn.freeteam.interceptor;

/**
 * MyBatis实现物理分页
 * 
 * @author liutong01
 * 
 */
public abstract class Dialect {
	public static enum Type {
		MYSQL, ORACLE
	}

	public abstract String getLimitString(String sql, int skipResults,
			int maxResults);
}

package cn.freeteam.interceptor;

public class MysqlDialect extends Dialect{

	@Override
	public String getLimitString(String sql, int offset, int limit) {
		sql = sql.trim();
		StringBuffer buffer = new StringBuffer(sql.length() + 100);
		buffer.append(sql);
		buffer.append(" limit ");  
        buffer.append(offset);  
        buffer.append(",");  
        buffer.append(limit);  
		return buffer.toString();
	}

}

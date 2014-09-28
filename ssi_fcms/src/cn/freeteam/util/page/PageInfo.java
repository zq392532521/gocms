package cn.freeteam.util.page;



/**
 * 页面信息
 * @author 
 *
 */
public class PageInfo {
    // 默认当前页为第一页  
    private Integer pageNo = 1;
    // 总记录大小
    private Integer count = 0;
    // 分页大小
    private Integer pageSize=10 ;
    
    /**
     * 总共xx页
     * 
     * @return
     */
	public Integer getTotal() {
		int totalPage = count / pageSize;
        return count % pageSize == 0 ? totalPage : totalPage + 1;
	}
	
	/**
	 * 数据库从xx条开始查询
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public int getOffset() {
		return (pageNo - 1) * pageSize;
	}
	
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}

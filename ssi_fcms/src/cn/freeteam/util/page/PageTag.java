package cn.freeteam.util.page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ComponentTagSupport;

import com.opensymphony.xwork2.util.ValueStack;


/**
 * 分页标签
 * 
 */
public class PageTag extends ComponentTagSupport {
	// 这里传递的参数需要用字符串的形式
	private String pageNo;
	private String total;
	private String count;
	private String includes;
	private String pageSize;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.struts2.views.jsp.ComponentTagSupport#getBean(com.opensymphony
	 * .xwork2.util.ValueStack, javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public Component getBean(ValueStack arg0, HttpServletRequest arg1,
			HttpServletResponse arg2) {
		return new Pages(arg0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.struts2.views.jsp.ComponentTagSupport#populateParams()
	 */
	protected void populateParams() {
		super.populateParams();

		Pages pages = (Pages) component;
		pages.setPageNo(pageNo);
		pages.setTotal(total);
		pages.setCount(count);
		pages.setIncludes(includes);
		pages.setPageSize(pageSize);
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getIncludes() {
		return includes;
	}
	public void setIncludes(String includes) {
		this.includes = includes;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	private static final long serialVersionUID = 1L;
}
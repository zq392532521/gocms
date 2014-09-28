package cn.freeteam.util.page;


import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.StrutsStatics;
import org.apache.struts2.components.Component;
import org.apache.struts2.dispatcher.StrutsRequestWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * 分页逻辑Bean
 * 
 */
public class Pages extends Component {
	private String pageNo;
	private String total;
	private String count;
	private String includes;
	private String pageSize;//每页显示个数
	
	public Pages(ValueStack arg0) {
		super(arg0);
	}
	
	@Override
	public boolean start(Writer writer) {

		boolean result = super.start(writer);
		StringBuilder str = new StringBuilder();
		Map<String, Object> cont = stack.getContext();
		StrutsRequestWrapper req = (StrutsRequestWrapper) cont
				.get(StrutsStatics.HTTP_REQUEST);

		String url = (String) req
				.getAttribute("javax.servlet.forward.request_uri");

		// 从ValueStack中取出数值
		Object obj = stack.findValue(pageNo);
		String pageNo = String.valueOf(obj);
		obj = stack.findValue(total);
		String total = String.valueOf(obj);
		obj = stack.findValue(pageSize);     
		String pageSize = String.valueOf(obj);
		Integer pagesizeInt = Integer.valueOf(pageSize); 
		
		StringBuilder perUrl = new StringBuilder("");
		if (includes != null && includes.trim().length() > 0) {
			String[] perm = includes.split(",");
			for (int i = 0; i < perm.length; i++) {
				String permName = perm[i];
			
				String obje = null;
				if (stack.findValue(permName) != null)
					obje = stack.findValue(permName).toString();
				
				if (!StringUtils.isBlank(obje)) {
					perUrl.append("&");
					perUrl.append(permName);
					perUrl.append("=");
					perUrl.append(obje);
				}
			}
		}

		//用于计算的当前页整数形式
		int cpageInt = Integer.valueOf(pageNo);
		str.append("<div class='pagination'>");
		Integer totalInt = Integer.valueOf(total);

		str.append("<select name='pageInfo.pageSize' style='width: 50px' onchange=\"window.location.href='" + url + "?pageInfo.pageNo=" + (cpageInt > totalInt ? totalInt : cpageInt)+ "&pageInfo.pageSize=' + this.options[this.selectedIndex].value + '" + perUrl + "'\">" +
				"<option value='10' " + (pagesizeInt == 10 ? "selected='selected'" : "") + ">10</option>" +
				"<option value='20' " + (pagesizeInt == 20 ? "selected='selected'" : "") + ">20</option>" +				
				"<option value='50' " + (pagesizeInt == 50 ? "selected='selected'" : "") + ">50</option>" +
				"<option value='100' " + (pagesizeInt == 100 ? "selected='selected'" : "") + ">100</option>" +
				"<option value='200' " + (pagesizeInt == 200 ? "selected='selected'" : "") + ">200</option>" +
				"<option value='500' " + (pagesizeInt == 500 ? "selected='selected'" : "") + ">500</option>" +
			    "</select>    ");
		// 如果只有一页，则无需分页

		if (totalInt == 1) {
			str.append("<span class='current'>1</span>");
		} else {

			// 显示上一页与第一页
			if (cpageInt == 1) {
				str.append("<span class='disabled'><< 上一页</span>");
				str.append("<span class='current'>1</span>");
			} else {
				str.append("<a href='");
				str.append(url);
				str.append("?pageInfo.pageNo=");
				str.append(cpageInt - 1);
				str.append("&pageInfo.pageSize=");
				str.append(pageSize);
				str.append(perUrl);
				str.append("'><< 上一页</a>");
				
				str.append("<a href='");
				str.append(url);
				str.append("?pageInfo.pageNo=1");
				str.append("&pageInfo.pageSize=");
				str.append(pageSize);
				str.append(perUrl);
				str.append("'>1</a>");
			}

			// 当前页超过5时第一页后面加点，因为中间相隔了第二页
			if (cpageInt - 4 > 1)
				str.append("<span class='gap'>...</span>");

			// v,v1分别代表中间页数的最小值和最大值,3表示显示当前页的前后三页
			int v = (cpageInt - 3) > 1 ? (cpageInt - 3) : 2;
			int v1 = (cpageInt + 3) < totalInt ? (cpageInt + 3) : totalInt - 1;
			if (v1 == totalInt) {
				v = totalInt - 10;
			} else if (v == 1 && v1 < totalInt) {
				v1 = totalInt > 10 ? 10 : totalInt;
			}

			// 
			for (int i = v; i <= v1; i++) {
				if (cpageInt == i) { // 当前页要加粗显示
					str.append("<span class='current'>");
					str.append(i);
					str.append("</span>");
				} else {
					str.append("<a href='");
					str.append(url);
					str.append("?pageInfo.pageNo=");
					str.append(i);
					str.append("&pageInfo.pageSize=");
					str.append(pageSize);
					str.append(perUrl);
					str.append("'>");
					str.append(i);
					str.append("</a>");
				}
			}

			if (cpageInt < totalInt - 4)
				str.append("<span class='gap'>...</span>");
			// 显示最后一页

			if (cpageInt != totalInt) {
				str.append("<a href='");
				str.append(url);
				str.append("?pageInfo.pageNo=");
				str.append(totalInt);
				str.append("&pageInfo.pageSize=");
				str.append(pageSize);
				str.append(perUrl);
				str.append("'>");
				str.append(totalInt);
				str.append("</a>");
			} else {
				str.append("<span class='current'>" + cpageInt + "</span>");
			}
			
			
			if (cpageInt == totalInt) {
				str.append("<span class='disabled'>下一页 >></span>");
			} else {
				str.append("<a href='");
				str.append(url);
				str.append("?pageInfo.pageNo=");
				str.append(cpageInt + 1);
				str.append("&pageInfo.pageSize=");
				str.append(pageSize);
				str.append(perUrl);
				str.append("'>下一页 >></a>");
			}
		}

		//总记录数
		obj = stack.findValue(count);
		String count = String.valueOf(obj);
		Integer totalCount = Integer.valueOf(count);
		
		//b1:当前页开始数  b2:当前页结束数
		Integer b1 = 0;
		Integer b2 = 0;
		if (totalInt == 1){//如果只有一页
			b1 = 1;
			b2 = totalCount;
		} else {
			if(cpageInt == totalInt){//最后一页
				b1 = (cpageInt - 1) * pagesizeInt + 1;
				b2 = totalCount;
			}else{
				b1 = (cpageInt - 1) * pagesizeInt + 1;
				b2 = cpageInt  * pagesizeInt;
			}
		}
		
		str.append("    显示"+b1 + "到" + b2 + "，共" + totalCount +"条记录");
		
		str.append("</div>");

		// logger.debug("=============================\n{}", str.toString());
		try {
			writer.write(str.toString());
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}
	
	public String getIncludes() {
		return includes;
	}
	public void setIncludes(String includes) {
		this.includes = includes;
	}
	public String getPageNo() {
		return pageNo;
	}
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
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

	final Logger logger = LoggerFactory.getLogger(Pages.class);
}

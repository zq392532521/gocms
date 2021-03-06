package cn.freeteam.cms.util;

import javax.servlet.ServletContext;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 
 * <p>Title: HtmlChannelJob.java</p>
 * 
 * <p>Description: 栏目页面静态化任务</p>
 * 
 * <p>Date: Jan 24, 2013</p>
 * 
 * <p>Time: 7:32:54 PM</p>
 * 
 * <p>Copyright: 2013</p>
 * 
 * <p>Company: freeteam</p>
 * 
 * @author freeteam
 * @version 1.0
 * 
 * <p>============================================</p>
 * <p>Modification History
 * <p>Mender: </p>
 * <p>Date: </p>
 * <p>Reason: </p>
 * <p>============================================</p>
 */
public class HtmlChannelJob implements Job{

	
	public HtmlChannelJob() {
	}

    public   void  execute(JobExecutionContext cntxt)  throws  JobExecutionException   {
    	if (cntxt.getJobDetail().getJobDataMap().get("siteid")!=null 
    			&& cntxt.getJobDetail().getJobDataMap().get("channelid")!=null 
    			&& cntxt.getJobDetail().getJobDataMap().get("servletContext")!=null) {
    		try {
    			ServletContext servletContext=(ServletContext)cntxt.getJobDetail().getJobDataMap().get("servletContext");
    			if (servletContext!=null && 
    					servletContext.getAttribute("basePath")!=null && 
    					servletContext.getAttribute("basePath").toString().trim().length()>0) {
        			HttpClient httpClient=new DefaultHttpClient();
        			HttpGet httpget = new HttpGet(servletContext.getAttribute("basePath")
        					+"html_channel.do?siteid="+cntxt.getJobDetail().getJobDataMap().get("siteid")
        					+"&channelid="+cntxt.getJobDetail().getJobDataMap().get("channelid")
        					+"&htmlQuartaKey="+cntxt.getJobDetail().getJobDataMap().get("htmlQuartaKey"));
                    httpClient.execute(httpget);
        			//System.out.println("站点首页静态化调度任务成功"+cntxt.getJobDetail().getJobDataMap().get("siteid"));
				}
    		} catch (Exception e) {
    			System.out.println("站点栏目页静态化调度任务失败"+cntxt.getJobDetail().getJobDataMap().get("channelid"));
    			e.printStackTrace();
    		}
		}
    }
}

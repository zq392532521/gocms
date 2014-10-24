package cn.freeteam.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.opensymphony.xwork2.Action;

public class FileDownloadAction implements Action {   
	  
    public InputStream getInputStream() throws Exception {   
  
        return new ByteArrayInputStream("Struts 2 下载示例".getBytes());   
  
    }   
  
    public String execute() throws Exception {   
  
        return SUCCESS;   
  
    }   
  
}
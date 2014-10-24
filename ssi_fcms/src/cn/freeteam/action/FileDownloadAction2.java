package cn.freeteam.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import com.opensymphony.xwork2.Action;

public class FileDownloadAction2 implements Action {   
	  
	  private String fileName;// 初始的通过param指定的文件名属性   
	  
	    public InputStream getInputStream() throws Exception {   
	  
	        return new ByteArrayInputStream("Struts 2 下载示例".getBytes());   
	  
	    }   
	  
	    public String execute() throws Exception {   
	  
	        return SUCCESS;   
	  
	    }   
	  
	    public void setFileName(String fileName) {   
	  
	        this.fileName = fileName;   
	  
	    }   
	  
	    /** 提供转换编码后的供下载用的文件名 */   
	  
	    public String getDownloadFileName() {   
	  
	        String downFileName = fileName;   
	  
	        try {   
	  
	            downFileName = new String(downFileName.getBytes(), "ISO8859-1");   
	  
	        } catch (UnsupportedEncodingException e) {   
	  
	            e.printStackTrace();   
	  
	        }   
	  
	        return downFileName;   
	  
	    }   
	  
  
}
package cn.freeteam.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport {
	private String msg="文件上传成功";
	private String username;

	// 注意，file并不是指前端jsp上传过来的文件本身，而是文件上传过来存放在临时文件夹下面的文件
	private File file;

	// 提交过来的file的名字
	private String fileFileName;

	// 提交过来的file的MIME类型
	private String fileContentType;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String fileUpload() {
		return "fileUpload";
	}
	@Override
	public String execute() {
		String root = ServletActionContext.getServletContext().getRealPath(
				"/upload");

		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(file);

			os = new FileOutputStream(new File(root, fileFileName));

			System.out.println("fileFileName: " + fileFileName);

			// 因为file是存放在临时文件夹的文件，我们可以将其文件名和文件路径打印出来，看和之前的fileFileName是否相同
			System.out.println("file: " + file.getName());
			System.out.println("file: " + file.getPath());
			System.out.println();
			System.out.println("file: out " + fileFileName+"   "+fileContentType);
			byte[] buffer = new byte[500];
			while (-1 != (is.read(buffer, 0, buffer.length))) {
				os.write(buffer);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			msg="文件上传失败请重新上传!";
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			msg="文件上传失败请重新上传!";
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			msg="文件上传失败请重新上传!";
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return SUCCESS;
	}
}

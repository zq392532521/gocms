package cn.freeteam.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class MultipleFileUploadAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3834498956889291087L;

	private String username;

	// 这里用List来存放上传过来的文件，file同样指的是临时文件夹中的临时文件，而不是真正上传过来的文件
	private List<File> file;

	// 这个List存放的是文件的名字，和List<File>中的文件相对应
	private List<String> fileFileName;

	private List<String> fileContentType;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<File> getFile() {
		return file;
	}

	public void setFile(List<File> file) {
		this.file = file;
	}

	public List<String> getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(List<String> fileFileName) {
		this.fileFileName = fileFileName;
	}

	public List<String> getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(List<String> fileContentType) {
		this.fileContentType = fileContentType;
	}
	public String multipleFileUpload() {
		return "multipleFileUpload";
	}
	@Override
	public String execute() throws Exception {
		String root = ServletActionContext.getServletContext().getRealPath(
				"/upload");

		for (int i = 0; i < file.size(); i++) {
			InputStream is = new FileInputStream(file.get(i));

			OutputStream os = new FileOutputStream(new File(root,
					fileFileName.get(i)));

			byte[] buffer = new byte[500];

			@SuppressWarnings("unused")
			int length = 0;

			while (-1 != (length = is.read(buffer, 0, buffer.length))) {
				os.write(buffer);
			}

			os.close();
			is.close();
		}

		return SUCCESS;
	}
}
package com.codeFactory;

import java.io.File;
import java.sql.DriverManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.opensymphony.xwork2.ActionSupport;

public class uploadProfilePic extends ActionSupport{

	private File userImage;  
    private String userImageContentType;  
    private String userImageFileName;
	
    Connection con = null;
    PreparedStatement ps = null;
	ResultSet rs = null;
	String query;
    
	public String execute()
	{
		try
		{
			String filePath = ServletActionContext.getServletContext().getRealPath("/").concat("userImages/");  
	        System.out.println("Image Location:" + filePath);//see the server console for actual location  
	        File fileToCreate = new File(filePath,userImageFileName);
	        FileUtils.copyFile(userImage, fileToCreate);//copying source file to new file
	        
	        String URL = "jdbc:mysql://localhost/test";
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(URL, "root", "");
	        
	        String loc = "userImages/"+userImageFileName;
	        query = "update image set file_path='"+loc+"' where id="+1;
	        System.out.println(query);
	        ps = (PreparedStatement) con.prepareStatement(query);
	        ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("uploadPicAction" + e);
		}
		return SUCCESS;
	}

	public File getUserImage() {
		return userImage;
	}

	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}

	public String getUserImageContentType() {
		return userImageContentType;
	}

	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}

	public String getUserImageFileName() {
		return userImageFileName;
	}

	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}

}

package com.codeFactory;

import java.sql.DriverManager;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.opensymphony.xwork2.ActionSupport;

public class getData extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String query;
	
	public String execute()
	{
		
		try {
			String URL = "jdbc:mysql://localhost/test";
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(URL, "root", "");
			
			query = "select * from image where id="+1;
			ps = (PreparedStatement) con.prepareStatement(query);
			rs = (ResultSet) ps.executeQuery();
			
			while(rs.next())
			{
				System.out.println(rs.getInt("id"));
				session.put("id", rs.getInt("id"));
				
				System.out.println(rs.getString("file_path"));
				session.put("userProfile", rs.getString("file_path"));
			}
			
		} catch (Exception e) {
			System.out.println("getdata : " + e);
			e.getMessage();
		}
		
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
}

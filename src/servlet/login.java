package servlet;

import com.opensymphony.xwork2.ActionSupport;

import hibernate.BlogOperate;

import java.sql.*;
import java.util.List;

import model.Blog;
import model.Register;

public class login extends ActionSupport {

	/*
    private String account;
	private String password;
    
    public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}*/
    
    private Register register;
    private List<Blog> list;
    private int sumpage;
	private int currentPage;
    private int pageSize = 3;
    private List latestcontent;
    
    public List getLatestcontent() {
		return latestcontent;
	}

	public void setLatestcontent(List latestcontent) {
		this.latestcontent = latestcontent;
	}

	public int getSumpage() {
		return sumpage;
	}

	public void setSumpage(int sumpage) {
		this.sumpage = sumpage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<Blog> getList() {
		return list;
	}

	public void setList(List<Blog> list) {
		this.list = list;
	}
	public Register getRegister() {
		return register;
	}
	public void setRegister(Register register) {
		this.register = register;
	}
	
	public String Check(){
		DataBase DB = new DataBase();
		try{
		DB.getConn();
		//System.out.println(account);
		System.out.println(register.getAccount());
		String sql = "select * from register where account = '" + register.getAccount() + "' and password = '" + register.getPassword() + "'";
		//String sql = "select * from register where account = '" + account + "' and password = '" + password + "'";
		ResultSet rs = DB.executeQuery(sql);
		if(rs.next()){//��ʾ���д��󣬣�
			try{
	        	if(currentPage == 0){
	        		currentPage = 1;
	        	}
		    	BlogOperate bo = new BlogOperate();//ȡҳ��
		    	sumpage = bo.CountPage();  
		    	System.out.println("��ҳ����"+sumpage);
		    	if(currentPage > sumpage){
		    		currentPage = sumpage;
		    	}
		    	else if(currentPage < 1){
		    		currentPage = 1;
		    	}
		    	System.out.println("action"+currentPage + " "+sumpage);
		    	BlogOperate b = new BlogOperate();//ȡ��������
		    	list = b.queryAll(currentPage,pageSize);
		    	
		    	BlogOperate b1 = new BlogOperate();//ȡ�������
		    	latestcontent = b1.LatestContent();
		    	}catch(Exception e){
		    		System.out.println(e.getMessage());
		    	}
		    	DB.close();  
             return SUCCESS;
		}
		else{                        //û��ע�������Ϣ������
            DB.close();  
			return ERROR;
		}

		}catch(SQLException sql){
			System.out.println(sql.toString());
		} 
		return SUCCESS;
	}  /*
   public String execute(){
  /*
		//String name = getName();//request.getParameter("Name") ;
		//String password = request.getParameter("password");
		
		DataBase DB = new DataBase();
		try{
		DB.getConn();
		//System.out.println(account);
		System.out.println(register.getAccount());
		String sql = "select * from register where account = '" + register.getAccount() + "' and password = '" + register.getPassword() + "'";
		//String sql = "select * from register where account = '" + account + "' and password = '" + password + "'";
		ResultSet rs = DB.executeQuery(sql);
		if(rs.next()){//��ʾ���д��󣬣�
             return SUCCESS;
		}
		else{                        //û��ע�������Ϣ������
              return ERROR;
		}

		}catch(SQLException sql){
			System.out.println(sql.toString());
		} 
		
		return SUCCESS;
		
	}*/
}

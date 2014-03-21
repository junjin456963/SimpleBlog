package servlet;

import java.sql.*;

public class DataBase {

	  private final static String DRIVER = "com.mysql.jdbc.Driver"; // 数据库驱动
      private final static String URL = "jdbc:mysql://localhost/jjblog"; //url
	  private final static String DBNAME = "root"; // 数据库用户名
	  private final static String DBPASS = "456963"; // 数据库密码
	  public Statement s;
	  public Connection conn;
	  public ResultSet rs = null;

	  public void getConn(){
		  try{
			  Class.forName(DRIVER); //注册驱动
			  conn = DriverManager.getConnection(URL,DBNAME,DBPASS); //获得数据库连接
			  conn.setAutoCommit(false);
			   s = conn.createStatement();//数据库的连接
			   
		  }catch(ClassNotFoundException SQLException){
			  System.err.println(SQLException.getMessage()); 
		  }catch(SQLException sql){
			  System.err.println(sql.getMessage()); 
		  }

	  return; //返回连接
	  }

		//执行查询语句的方法
		public ResultSet executeQuery(String sql) {
			//this.setConnection();
			try {
				rs = s.executeQuery(sql);
			} 
			catch(SQLException ex) { 
				 System.err.println(ex.getMessage()); 
			}
			return rs;
		}
	    //执行增、删改语句的方法
		public int executeUpdate(String sql){
			int a = -1;
			//this.setConnection();
			try{
			 s.executeUpdate(sql);
	         conn.commit();
			}catch(SQLException e){
				 System.err.println(e.getMessage()); 
			}
			return a;
		}
		
		public void close(){
			if(conn!=null){
				try{
					conn.close();	
	                                System.out.println("数据库已断开");
				}catch(SQLException ex) { 
					ex.printStackTrace();
				}
			}	
			if(rs!=null){
				try{
					rs.close();
				}catch(SQLException ex) { 
					ex.printStackTrace();
				}
			}	
		}
}

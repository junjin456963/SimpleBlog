package servlet;

import java.sql.*;

public class DataBase {

	  private final static String DRIVER = "com.mysql.jdbc.Driver"; // ���ݿ�����
      private final static String URL = "jdbc:mysql://localhost/jjblog"; //url
	  private final static String DBNAME = "root"; // ���ݿ��û���
	  private final static String DBPASS = "456963"; // ���ݿ�����
	  public Statement s;
	  public Connection conn;
	  public ResultSet rs = null;

	  public void getConn(){
		  try{
			  Class.forName(DRIVER); //ע������
			  conn = DriverManager.getConnection(URL,DBNAME,DBPASS); //������ݿ�����
			  conn.setAutoCommit(false);
			   s = conn.createStatement();//���ݿ������
			   
		  }catch(ClassNotFoundException SQLException){
			  System.err.println(SQLException.getMessage()); 
		  }catch(SQLException sql){
			  System.err.println(sql.getMessage()); 
		  }

	  return; //��������
	  }

		//ִ�в�ѯ���ķ���
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
	    //ִ������ɾ�����ķ���
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
	                                System.out.println("���ݿ��ѶϿ�");
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

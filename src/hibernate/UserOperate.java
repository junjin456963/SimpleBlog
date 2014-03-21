package hibernate;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import model.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class UserOperate {


	/*  
	*具体操作hibernate的类  
	*增加,删除,修改,按ID查询,模糊查询,查询全部  
	**/ 
	//在hibernate中所有操作都是由Session完成  
	public Session session = null;  
    public SessionFactory sf = null;
	//在构造方法中实例化Session对象  
	public UserOperate(){  
	    //找出hibernate的配置  
	    //Configuration config = new Configuration().configure();  
		try{
	    Configuration config = new AnnotationConfiguration();    //使用Annotation来配置，方便
	    //从配置中取出SessionFactory  
	     sf = config.configure().buildSessionFactory();  
	    //从SessionFactory中取出Session  
	    this.session = sf.openSession();  
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}  
	 
	//操作Hibernate类的所有操作都是通过Session完成的  
	 
	//增加数据库中数据  
	public void insert(User user){  
	    //开始事务  
	    Transaction tran =    session.beginTransaction();  
	    //执行语句  
	    session.save(user);  
	    //提交事务  
	    tran.commit();  
	    session.close();
	    sf.close();
	}  
	 
	//操作Hibernate类更改数据库中的数据  
	public void update(User user){  
	    //开始事务  
	    Transaction tran =    session.beginTransaction();  
	    //执行语句  
	    session.update(user);  
	    //提交事务  
	    tran.commit();
	    session.close();
	    sf.close();
	}  
	 
	/*操作Hibernate类：按ID查询  
	    *我们插入,修改都是对对象进行操作  
	    *那么我们查询的时候也应该是返回一个对象  
	    **/ 
	public List queryById(int blogid){  
	    System.out.println(blogid);  
	    User user = null;  
	    //hibernate查询语句  
	    String hql = "FROM User as p WHERE p.blogid = "+blogid;  
	    Query q = session.createQuery(hql);  
	    //q.setString(0, id);  
	    List list = q.list();  
	    //Iterator iteator = list.iterator();  
	    //if(iteator.hasNext()){  
	    //	user = (User)iteator.next();  
	    //}  
	    session.close();  
	    sf.close();
	    
	    return list;  
	}  
	 
	/*操作Hibernate类：删除数据库中数据  
	    *hiberante2,hibernate3中通用的删除方法  
	    *缺点:删除数据之前要先查询一次数据,找出删除的数据对象  
	    *性能低下  
	    **/ 
	public void delete(User user){  
	    //开始事务  
	    Transaction tran =    session.beginTransaction();  
	    //执行语句  
	    session.delete(user);  
	    //提交事务  
	    tran.commit();   
	    session.close();  
	    sf.close();
	}  
	 
	//hibernate3的用法  
	public void delete(int id){  
	    //开始事务  
	    Transaction tran =    session.beginTransaction();  
	    String hql = "DELETE User WHERE blogid = "+id;  
	 
	    Query q = session.createQuery(hql);  
	    //q.setString(0, id);  
	    //执行更新语句  
	    q.executeUpdate();  
	    //提交事务  
	    tran.commit();
	    session.close();
	    sf.close();
	}  
	 
	//操作Hibernate类：查询全部数据  
	public List queryAll(){  
	    List list = null;  
	    String hql = "FROM User as p ";  
	    Query q = session.createQuery(hql);  
	    list = q.list();  
	    session.close();  
	    sf.close();
	    
	    return list;  
	}  
	 
	//操作Hibernate类：模糊查询  
	public List queryByLike(String colnum,String value){  
	    List list = null;  
	    String hql = "FROM User as p WHERE p."+ colnum +" like ?";  
	    Query q = session.createQuery(hql);  
	    q.setString(0, "%"+ value +"%");  
	    list = q.list();  
	    session.close();
	    sf.close();
	    
	    return list;
	}
	
}

package hibernate;

import java.util.Iterator;
import java.util.List;

import model.Blog;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class BlogOperate {

	/*  
	*具体操作hibernate的类  
	*增加,删除,修改,按ID查询,模糊查询,查询全部  
	**/ 
	//在hibernate中所有操作都是由Session完成  
	public Session session = null; 
	public SessionFactory sf = null;
	 
	//******************************在构造方法中实例化Session对象  
	public BlogOperate(){  
	    //找出hibernate的配置  
	   // Configuration config = new Configuration().configure();  
	    Configuration config = new AnnotationConfiguration();    //使用Annotation来配置，方便
	    //从配置中取出SessionFactory  
	     sf = config.configure().buildSessionFactory();  
	    //从SessionFactory中取出Session  
	    session = sf.openSession();  
	}  
	 
	//操作Hibernate类的所有操作都是通过Session完成的  
	 
	//******************************增加数据库中数据  
	public void insert(Blog blog){  
	    //开始事务  
	    Transaction tran = session.beginTransaction();  
	    //执行语句  
	    session.save(blog);  
	    //提交事务  
	    tran.commit();  
	    session.close();  
	    sf.close();
	}  
	 
	//******************************操作Hibernate类更改数据库中的数据  
	public void update(String content,int id){  
	    //开始事务  
	    Transaction tran = session.beginTransaction();  
	    //执行语句  
	    String hql="update Blog set content='"+content+"' where id="+id;
	    Query query = session.createQuery(hql);  
	    query.executeUpdate();  
	    //session.update(blog);
	    //提交事务  
	    tran.commit();   
	    session.close();  
	    sf.close();
	}  
	 
	/*操作Hibernate类：按ID查询  
	    *我们插入,修改都是对对象进行操作  
	    *那么我们查询的时候也应该是返回一个对象  
	    **/ 
	public Blog queryById(int id){  
	    System.out.println(id);  
	    Blog blog = null;  
	    //hibernate查询语句  
	    String hql = "FROM Blog as p WHERE p.id = "+id;  
	    Query q = session.createQuery(hql);   
	    List list = q.list();  
	    Iterator iteator = list.iterator();  
	    if(iteator.hasNext()){  
	    	blog = (Blog)iteator.next();  
	    }  
	    session.close();
	    sf.close();
	    
	    return blog;  
	}  
	 
	/*操作Hibernate类：删除数据库中数据  
	    *hiberante2,hibernate3中通用的删除方法  
	    *缺点:删除数据之前要先查询一次数据,找出删除的数据对象  
	    *性能低下  
	    **/ 
	public void delete(Blog blog){  
	    //开始事务  
	    Transaction tran =    session.beginTransaction();  
	    //执行语句  
	    session.delete(blog);  
	    //提交事务  
	    tran.commit();   
	    session.close(); 
	    sf.close();
	}  
	 
	//******************************hibernate3的用法  
	public void delete(int id){  
	    //开始事务  
	    Transaction tran =    session.beginTransaction();  
	    String hql = "DELETE Blog WHERE id = "+id;  
	 
	    Query q = session.createQuery(hql);  
	    //q.setInteger(0,id);  
	    //执行更新语句  
	    q.executeUpdate();  
	    //提交事务  
	    tran.commit();  
	    session.close();  
	    sf.close();
	}  
	 
	//******************************操作Hibernate类：查询全部数据  (分页来取数据)
	public List<Blog> queryAll(int currentPage,int pageSize){  
		List list = null;  
	    String hql = "from Blog order by id desc"; 
	    
         try{
	    	if(currentPage == 0){
	    		currentPage = 1;
	    	}

		Query query = session.createQuery(hql);
		query.setFirstResult((currentPage-1)*pageSize);
		query.setMaxResults(pageSize);
		list = query.list();
		
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    session.close();  
	    sf.close();
	    
	    return list;  
	}
	
	//******************************操作Hibernate类：查询最近文章，
	public List<Blog> LatestContent(){  
		List list = null;  
	    String hql = "from Blog order by id desc"; 
	    
        try{
			Query query = session.createQuery(hql);
			query.setFirstResult(0);
			query.setMaxResults(3);
			list = query.list();
		
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    session.close();  
	    sf.close();
	    
	    return list;  
	}
	
	//******************************操作Hibernate类：模糊查询  
	public List queryByLike(String colnum,String value){  
	    List list = null;  
	    String hql = "FROM blog as p WHERE p."+ colnum +" like ?";  
	    Query q = session.createQuery(hql);  
	    q.setString(0, "%"+ value +"%");  
	    list = q.list();  
	    session.close();  
	    sf.close();
	    
	    return list;
	}
	public int CountPage(){
	    List list = null;  
	    String hql = "from Blog";  
	    list = session.createQuery(hql).list(); 
		
	    int sumpage;
	    if(list.size()%3!=0){
	    	sumpage = list.size()/3+1;
	    }
	    else{
	    	sumpage = list.size()/3;
	    }
	    session.close();  
	    sf.close();
	    
	    return sumpage;
	}
}

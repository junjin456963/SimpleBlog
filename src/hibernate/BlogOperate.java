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
	*�������hibernate����  
	*����,ɾ��,�޸�,��ID��ѯ,ģ����ѯ,��ѯȫ��  
	**/ 
	//��hibernate�����в���������Session���  
	public Session session = null; 
	public SessionFactory sf = null;
	 
	//******************************�ڹ��췽����ʵ����Session����  
	public BlogOperate(){  
	    //�ҳ�hibernate������  
	   // Configuration config = new Configuration().configure();  
	    Configuration config = new AnnotationConfiguration();    //ʹ��Annotation�����ã�����
	    //��������ȡ��SessionFactory  
	     sf = config.configure().buildSessionFactory();  
	    //��SessionFactory��ȡ��Session  
	    session = sf.openSession();  
	}  
	 
	//����Hibernate������в�������ͨ��Session��ɵ�  
	 
	//******************************�������ݿ�������  
	public void insert(Blog blog){  
	    //��ʼ����  
	    Transaction tran = session.beginTransaction();  
	    //ִ�����  
	    session.save(blog);  
	    //�ύ����  
	    tran.commit();  
	    session.close();  
	    sf.close();
	}  
	 
	//******************************����Hibernate��������ݿ��е�����  
	public void update(String content,int id){  
	    //��ʼ����  
	    Transaction tran = session.beginTransaction();  
	    //ִ�����  
	    String hql="update Blog set content='"+content+"' where id="+id;
	    Query query = session.createQuery(hql);  
	    query.executeUpdate();  
	    //session.update(blog);
	    //�ύ����  
	    tran.commit();   
	    session.close();  
	    sf.close();
	}  
	 
	/*����Hibernate�ࣺ��ID��ѯ  
	    *���ǲ���,�޸Ķ��ǶԶ�����в���  
	    *��ô���ǲ�ѯ��ʱ��ҲӦ���Ƿ���һ������  
	    **/ 
	public Blog queryById(int id){  
	    System.out.println(id);  
	    Blog blog = null;  
	    //hibernate��ѯ���  
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
	 
	/*����Hibernate�ࣺɾ�����ݿ�������  
	    *hiberante2,hibernate3��ͨ�õ�ɾ������  
	    *ȱ��:ɾ������֮ǰҪ�Ȳ�ѯһ������,�ҳ�ɾ�������ݶ���  
	    *���ܵ���  
	    **/ 
	public void delete(Blog blog){  
	    //��ʼ����  
	    Transaction tran =    session.beginTransaction();  
	    //ִ�����  
	    session.delete(blog);  
	    //�ύ����  
	    tran.commit();   
	    session.close(); 
	    sf.close();
	}  
	 
	//******************************hibernate3���÷�  
	public void delete(int id){  
	    //��ʼ����  
	    Transaction tran =    session.beginTransaction();  
	    String hql = "DELETE Blog WHERE id = "+id;  
	 
	    Query q = session.createQuery(hql);  
	    //q.setInteger(0,id);  
	    //ִ�и������  
	    q.executeUpdate();  
	    //�ύ����  
	    tran.commit();  
	    session.close();  
	    sf.close();
	}  
	 
	//******************************����Hibernate�ࣺ��ѯȫ������  (��ҳ��ȡ����)
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
	
	//******************************����Hibernate�ࣺ��ѯ������£�
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
	
	//******************************����Hibernate�ࣺģ����ѯ  
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

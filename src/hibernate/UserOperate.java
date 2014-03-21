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
	*�������hibernate����  
	*����,ɾ��,�޸�,��ID��ѯ,ģ����ѯ,��ѯȫ��  
	**/ 
	//��hibernate�����в���������Session���  
	public Session session = null;  
    public SessionFactory sf = null;
	//�ڹ��췽����ʵ����Session����  
	public UserOperate(){  
	    //�ҳ�hibernate������  
	    //Configuration config = new Configuration().configure();  
		try{
	    Configuration config = new AnnotationConfiguration();    //ʹ��Annotation�����ã�����
	    //��������ȡ��SessionFactory  
	     sf = config.configure().buildSessionFactory();  
	    //��SessionFactory��ȡ��Session  
	    this.session = sf.openSession();  
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}  
	 
	//����Hibernate������в�������ͨ��Session��ɵ�  
	 
	//�������ݿ�������  
	public void insert(User user){  
	    //��ʼ����  
	    Transaction tran =    session.beginTransaction();  
	    //ִ�����  
	    session.save(user);  
	    //�ύ����  
	    tran.commit();  
	    session.close();
	    sf.close();
	}  
	 
	//����Hibernate��������ݿ��е�����  
	public void update(User user){  
	    //��ʼ����  
	    Transaction tran =    session.beginTransaction();  
	    //ִ�����  
	    session.update(user);  
	    //�ύ����  
	    tran.commit();
	    session.close();
	    sf.close();
	}  
	 
	/*����Hibernate�ࣺ��ID��ѯ  
	    *���ǲ���,�޸Ķ��ǶԶ�����в���  
	    *��ô���ǲ�ѯ��ʱ��ҲӦ���Ƿ���һ������  
	    **/ 
	public List queryById(int blogid){  
	    System.out.println(blogid);  
	    User user = null;  
	    //hibernate��ѯ���  
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
	 
	/*����Hibernate�ࣺɾ�����ݿ�������  
	    *hiberante2,hibernate3��ͨ�õ�ɾ������  
	    *ȱ��:ɾ������֮ǰҪ�Ȳ�ѯһ������,�ҳ�ɾ�������ݶ���  
	    *���ܵ���  
	    **/ 
	public void delete(User user){  
	    //��ʼ����  
	    Transaction tran =    session.beginTransaction();  
	    //ִ�����  
	    session.delete(user);  
	    //�ύ����  
	    tran.commit();   
	    session.close();  
	    sf.close();
	}  
	 
	//hibernate3���÷�  
	public void delete(int id){  
	    //��ʼ����  
	    Transaction tran =    session.beginTransaction();  
	    String hql = "DELETE User WHERE blogid = "+id;  
	 
	    Query q = session.createQuery(hql);  
	    //q.setString(0, id);  
	    //ִ�и������  
	    q.executeUpdate();  
	    //�ύ����  
	    tran.commit();
	    session.close();
	    sf.close();
	}  
	 
	//����Hibernate�ࣺ��ѯȫ������  
	public List queryAll(){  
	    List list = null;  
	    String hql = "FROM User as p ";  
	    Query q = session.createQuery(hql);  
	    list = q.list();  
	    session.close();  
	    sf.close();
	    
	    return list;  
	}  
	 
	//����Hibernate�ࣺģ����ѯ  
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

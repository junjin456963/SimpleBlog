package hibernate;

import java.util.List;

import model.Blog;
import model.User;

import com.opensymphony.xwork2.ActionSupport;

public class SaveComment extends ActionSupport{
       private int id;
       private Blog blog;
   	   private List list;
   	   private User user;
       
    public int getId() {
	return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

    public String execute(){	
		try{
			System.out.println("look id:" + user.getBlogid());
			id = user.getBlogid();
			BlogOperate b = new BlogOperate();//取文章内容
			blog = b.queryById(user.getBlogid());
			
			UserOperate u = new UserOperate();//存评论内容
			u.insert(user);
			
			UserOperate uo = new UserOperate();//取评论内容
			list = uo.queryById(user.getBlogid());
	    	}catch(Exception e){
	    		System.out.println(e.getMessage());
	    	}
    	
        return SUCCESS;
      }
}
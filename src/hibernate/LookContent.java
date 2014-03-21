package hibernate;

import java.util.List;

import model.Blog;

import com.opensymphony.xwork2.ActionSupport;

public class LookContent extends ActionSupport{
       private int id;
	   private Blog blog;
	   private List list;
	   private List latestcontent;

	public List getLatestcontent() {
		return latestcontent;
	}

	public void setLatestcontent(List latestcontent) {
		this.latestcontent = latestcontent;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    public String execute(){	
		try{
			System.out.println("look id:" + id);
			BlogOperate b = new BlogOperate();//取文章内容
			blog = b.queryById(id);
			
			UserOperate uo = new UserOperate();//取评论内容
			list = uo.queryById(id);
			
	    	BlogOperate b1 = new BlogOperate();//取最近文章
	    	latestcontent = b1.LatestContent();
	    	
	    	}catch(Exception e){
	    		System.out.println(e.getMessage());
	    	}
    	
        return SUCCESS;
      }
}

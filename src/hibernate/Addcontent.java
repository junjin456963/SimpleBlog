package hibernate;

import java.util.List;

import model.Blog;

import com.opensymphony.xwork2.ActionSupport;

public class Addcontent extends ActionSupport {
    private Blog blog;
    private List list;
    private int sumpage;
	private int currentPage;
    private int pageSize = 3;
    
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
    	  System.out.println(blog.getContent());
    	  BlogOperate bo = new BlogOperate();//存放文章内容
    	  bo.insert(blog);
    	  
			try{
	        	if(currentPage == 0){
	        		currentPage = 1;
	        	}
		    	BlogOperate b = new BlogOperate();//取页数
		    	sumpage = b.CountPage();  
		    	BlogOperate boo = new BlogOperate();//取文章内容
		    	list = boo.queryAll(1,3);
		    	
	    	}catch(Exception e){
	    		System.out.println(e.getMessage());
	    	}
    	  
    	  return SUCCESS;
      }
}

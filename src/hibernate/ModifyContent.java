package hibernate;

import java.util.List;

import model.Blog;

import com.opensymphony.xwork2.ActionSupport;
//实现数据库内容的读取，分页页数的读取
public class ModifyContent extends ActionSupport{ 
	    private List list;
        private int sumpage;
        private int currentPage;
        private int pageSize = 3;
        private Blog blog;

		public Blog getBlog() {
			return blog;
		}

		public void setBlog(Blog blog) {
			this.blog = blog;
		}

		public int getCurrentPage() {
			return currentPage;
		}

		public void setCurrentPage(int currentPage) {
			this.currentPage = currentPage;
		}

		public int getSumpage() {
			return sumpage;
		}

		public void setSumpage(int sumpage) {
			this.sumpage = sumpage;
		}

		public List getList() {
			return list;
		}

		public void setList(List list) {
			this.list = list;
		}
	    public String execute(){	
			try{
				    System.out.println("modify content.java");
				    System.out.println("id="+blog.getId());
				    System.out.println("content="+blog.getContent());
				    
				    BlogOperate boo = new BlogOperate();
				    boo.update(blog.getContent(),blog.getId());//修改文章
				
		        	if(currentPage == 0){
		        		currentPage = 1;
		        	}
			    	BlogOperate bo = new BlogOperate();//取页数
			    	sumpage = bo.CountPage();  
			    	System.out.println("总页数："+sumpage);
			    	if(currentPage > sumpage){
			    		currentPage = sumpage;
			    	}
			    	else if(currentPage < 1){
			    		currentPage = 1;
			    	}
			    	System.out.println("action"+currentPage + " "+sumpage);
			    	BlogOperate b = new BlogOperate();//取文章内容
			    	list = b.queryAll(currentPage,pageSize);
			    	
		    	}catch(Exception e){
		    		System.out.println(e.getMessage());
		    	}
	    	
	        return SUCCESS;
	      }
}

package hibernate;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

//删除文章，也需要删除评论内容
public class DeleteContent extends ActionSupport{
    private List list;
    private int sumpage;
	private int currentPage=1;
    private int pageSize = 3;
    private int id;
    
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
	//隐藏Bug：删除的文章是最后一页的最后一个，到时会返回不到最后一页，
    public String execute(){	
		try{
			System.out.println("id"+id);

			    UserOperate uo = new UserOperate();//删除对应评论
			    uo.delete(id);
			    BlogOperate boo = new BlogOperate();//删除对应文章
			    boo.delete(id);
			    
		    	BlogOperate bo = new BlogOperate();//取页数
		    	sumpage = bo.CountPage();  
		    	
		    	BlogOperate b = new BlogOperate();//取文章内容
		    	list = b.queryAll(currentPage,3);
	    	}catch(Exception e){
	    		System.out.println(e.getMessage());
	    	}
    	
        return SUCCESS;
      }
}

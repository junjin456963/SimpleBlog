package hibernate;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

//ɾ�����£�Ҳ��Ҫɾ����������
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
	//����Bug��ɾ�������������һҳ�����һ������ʱ�᷵�ز������һҳ��
    public String execute(){	
		try{
			System.out.println("id"+id);

			    UserOperate uo = new UserOperate();//ɾ����Ӧ����
			    uo.delete(id);
			    BlogOperate boo = new BlogOperate();//ɾ����Ӧ����
			    boo.delete(id);
			    
		    	BlogOperate bo = new BlogOperate();//ȡҳ��
		    	sumpage = bo.CountPage();  
		    	
		    	BlogOperate b = new BlogOperate();//ȡ��������
		    	list = b.queryAll(currentPage,3);
	    	}catch(Exception e){
	    		System.out.println(e.getMessage());
	    	}
    	
        return SUCCESS;
      }
}

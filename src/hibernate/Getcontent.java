package hibernate;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
//ʵ�����ݿ����ݵĶ�ȡ����ҳҳ���Ķ�ȡ
public class Getcontent extends ActionSupport{ 
	    private List list;
	    private List latestcontent;
		private int sumpage;
        private int currentPage;
        private int pageSize = 3;

        public List getLatestcontent() {
			return latestcontent;
		}

		public void setLatestcontent(List latestcontent) {
			this.latestcontent = latestcontent;
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
		        	if(currentPage == 0){
		        		currentPage = 1;
		        	}
			    	BlogOperate bo = new BlogOperate();//ȡҳ��
			    	sumpage = bo.CountPage();  
			    	System.out.println("��ҳ����"+sumpage);
			    	if(currentPage > sumpage){
			    		currentPage = sumpage;
			    	}
			    	else if(currentPage < 1){
			    		currentPage = 1;
			    	}
			    	System.out.println("action"+currentPage + " "+sumpage);
			    	BlogOperate b = new BlogOperate();//ȡ��������
			    	list = b.queryAll(currentPage,pageSize);
			    	
			    	BlogOperate b1 = new BlogOperate();//ȡ�������
			    	latestcontent = b1.LatestContent();

		    	}catch(Exception e){
		    		System.out.println(e.getMessage());
		    	}
	    	
	        return SUCCESS;
	      }
}

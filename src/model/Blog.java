package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Blog {
    private int id;
    private String content;
    private String time;
    private String assortment;
    private String title;
	   
    public Blog(){
    }
    @Id
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAssortment() {
		return assortment;
	}
	public void setAssortment(String assortment) {
		this.assortment = assortment;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

}

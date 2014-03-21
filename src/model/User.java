package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    private int id;
    private int blogid;
	private String account;
    private String content;
    private String time;
    
    public User(){
    }
    @Id
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
 	public int getBlogid() {
		return blogid;
	}
	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
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
}

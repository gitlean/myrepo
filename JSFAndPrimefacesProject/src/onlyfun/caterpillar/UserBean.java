package onlyfun.caterpillar;

import java.util.Date;

/**
 * 注意 没有注解 description
 * 
 * @author john
 * @date 2017年10月9日
 */
public class UserBean {
	private String name;
	private String email;

	private Date date = new Date();

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String registerAction() {
		return "result";
	}

}
package onlyfun.caterpillar;

import java.util.Date;

/**
 * ע�� û��ע�� description
 * 
 * @author john
 * @date 2017��10��9��
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
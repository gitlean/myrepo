package cn.jxufe;

import java.io.Serializable;


public class Person implements Serializable {
	private String message;

	public void setMessage(String message) {
		this.message = message;
	}

	public void getMessage() {
		System.out.println("Your Message : " + message);
	}

}

package com.isoft.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
*@author john
*@createTime 2019年8月30日 下午5:06:41
*@describe 
*/



/**
 * 将配置文件中配置的每一个属性的值，映射到这个组件（Person）中
 *
 * @ConfigurationProperties：告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定
 *      prefix：配置文件中哪个下面的所有属性进行一一映射
 *
 * 只有这个组件是容器中的组件才能使用容器提供的功能(@ConfigurationProperties所提供的功能)，
 * 所以添加@Component注解，使之成为Spring容器中的组件。
 *
 * @author chentongwei@bshf360.com 2018-05-17 14:05
 */
@ConfigurationProperties(prefix = "person")
@Component
public class Person {
    // 这种驼峰写法在yml里可以用lastName或者last-name，都可以
    private String lastName;
    private Integer age;
    private boolean isBoss;
    private Date birth;

    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public boolean isBoss() {
		return isBoss;
	}
	public void setBoss(boolean isBoss) {
		this.isBoss = isBoss;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public Map<String, Object> getMaps() {
		return maps;
	}
	public void setMaps(Map<String, Object> maps) {
		this.maps = maps;
	}
	public List<Object> getLists() {
		return lists;
	}
	public void setLists(List<Object> lists) {
		this.lists = lists;
	}
	public Dog getDog() {
		return dog;
	}
	public void setDog(Dog dog) {
		this.dog = dog;
	}
	
	public String toString(){
		return "Person{lastName="+this.lastName+",age="+this.age+",isBoss="+this.isBoss+",birth="+this.birth+",maps="+this.maps+",lists="+this.lists+",dog="+this.dog+"}";
	}
	
}

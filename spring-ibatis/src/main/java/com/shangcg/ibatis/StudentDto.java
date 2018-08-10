package com.shangcg.ibatis;

import java.sql.Date;

public class StudentDto {
    // 注意这里需要保证有一个无参构造方法，因为包括Hibernate在内的映射都是使用反射的，如果没有无参构造可能会出现问题
     //学生ID   
    private int id = 0;  
    //学生姓名   
    private String name = "";  
    //学生性别   
    private String sex = "";  
    //学生年龄   
    private int age = 0;  
    //学生地址   
    private String address = "";
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }  

    
}
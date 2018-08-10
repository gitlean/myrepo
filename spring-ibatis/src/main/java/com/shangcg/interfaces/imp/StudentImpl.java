package com.shangcg.interfaces.imp;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.shangcg.ibatis.StudentDto;
import com.shangcg.interfaces.StudentDao;

public class StudentImpl implements StudentDao {

     //添加student表的数据   
    public void addStudent(SqlMapClient sqlMap, StudentDto studentdto) {  
  
        try {  
            sqlMap.insert("insert_student", studentdto);  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
        }  
    }  
      
    //删除student表的数据   
    public void delStudent(SqlMapClient sqlMap) {  
  
        try {  
            sqlMap.delete("delete_all_student", null);  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
        }  
    }  
  
    //删除student表的指定ID数据   
    public void delStudentByID(SqlMapClient sqlMap, StudentDto studentdto) {  
  
        try {  
            sqlMap.delete("deleteByID_student",studentdto );  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
        }  
    }  
  
    //更新student表的数据   
    public void updataStudent(SqlMapClient sqlMap, StudentDto studentdto) {  
  
        try {  
            sqlMap.update("updataStudent_test",studentdto );  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
        }  
    }  
      
    //查询student表的所有数据   
    public ArrayList selectStudent(SqlMapClient sqlMap) {  
  
        //保存查询结果   
        ArrayList rsList = new ArrayList();  
  
        try {  
            rsList = (ArrayList)sqlMap.queryForList("select_all_student","");  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
        }  
        return rsList;  
    }  
  
    //查询student表的指定ID数据   
    public StudentDto selectStudentByID(SqlMapClient sqlMap, StudentDto studentdto) {  
  
        //返回后保存在info中   
        StudentDto info = new StudentDto();  
        try {  
            info = (StudentDto)sqlMap.queryForObject("selectByID_student", studentdto);  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
        }  
        return info;  
    }  
  

}
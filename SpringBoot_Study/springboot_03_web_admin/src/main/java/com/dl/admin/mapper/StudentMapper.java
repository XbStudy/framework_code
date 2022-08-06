package com.dl.admin.mapper;

import com.dl.admin.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentMapper {

    public Student getStudentById(@Param("id") Integer id);

    // 可以注解和Mapper配置文件混用：
    @Insert("insert into student(username,password) value(#{username},#{password})")
    @Options(useGeneratedKeys = true,keyProperty = "id") //主键值回填
    void  insertStudent(Student student);


}


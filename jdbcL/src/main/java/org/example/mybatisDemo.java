package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class mybatisDemo {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        Student zhaoming = new Student();
//        zhaoming.initStudent("zhaoming", "male", 32, "chengdu", 178);
//        sqlSession.insert("studentMapper.insertStudent",zhaoming);
        Student student = sqlSession.selectOne("studentMapper.selectStudent", 4);
        System.out.println(
                student.getName()
        );
        Student updateStudent = new Student();
        updateStudent.setAge(11);
        updateStudent.setId(11);
        sqlSession.update("studentMapper.updateStudent", updateStudent);
        sqlSession.commit();
        sqlSession.close();
    }
}

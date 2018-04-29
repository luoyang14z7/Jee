package com.yang;

import java.util.List;

import com.yang.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.yang.StudentJDBCTemplate;
import org.springframework.ui.ModelMap;
import org.springframework.stereotype.Controller;
public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");
        System.out.println("-------------------Records Creation---------");
        studentJDBCTemplate.create("zrar", 11);
        studentJDBCTemplate.create("haha", 144);
        studentJDBCTemplate.create("yang", 11);
        System.out.println("-------------Listing Multiple Records----------");
        List<Student> students = studentJDBCTemplate.listStudents();
        for (Student record : students) {
            System.out.print("ID:" + record.getId());
            System.out.print(",Name:" + record.getName());
            System.out.println(",Age:" + record.getAge());
        }
        System.out.println("------------Updating Record with ID=2 -----------");
        studentJDBCTemplate.update(2, 20);
        System.out.println("----------Listing Record with ID=2------------");
        Student student = studentJDBCTemplate.getStudent(2);
        System.out.print("ID:" + student.getId());
        System.out.print(",NAMe:" + student.getName());
        System.out.println(",AGe:" + student.getAge());
    }
}

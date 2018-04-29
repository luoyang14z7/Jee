package com;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class manApp {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("F:/Github/Java/demo1/web/WEB-INF/classes/Beans.xml");
        hello objA = (hello)context.getBean("hello");
        objA.getMessage1();
        objA.getMessage2();
        HelloChina objB = (HelloChina)context.getBean("HelloChina");
        objB.getMessage1();
        objB.getMessage2();
        objB.getMessage3();
        ((FileSystemXmlApplicationContext) context).registerShutdownHook();
    }

}

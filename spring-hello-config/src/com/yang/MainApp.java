package com.yang;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

public class MainApp {
    public static void main(String[] agrs){
        ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
        HelloWorld helloWorld = context.getBean(HelloWorld.class);
        helloWorld.setMessage("11111111");
        helloWorld.getMessage();
    }
}

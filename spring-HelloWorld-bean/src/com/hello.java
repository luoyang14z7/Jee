package com;

public class hello {

    private String message1;
    private String message2;
    public void setMessage1(String message){
        this.message1 = message;

    }

    public void setMessage2(String message) {
        this.message2 = message;
    }

    public void getMessage1(){
        System.out.println("message11111111111111" + message1);
    }
    public void getMessage2(){
        System.out.println("message222222222222" + message2);
    }
    public void init(){
        System.out.println("bean start");
    }
    public void destroy(){
        System.out.println("bean end");
    }
}

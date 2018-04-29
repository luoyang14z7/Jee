package com.yang;

import org.omg.CORBA.OBJ_ADAPTER;

public class Logging {
    public void beforeAdvice() {
        System.out.println("Going to setup student profile.");
        System.out.println("--------------------------------");

    }
    public void afterAdvice() {
        System.out.println("Student profile has been setup");
        System.out.println("--------------------------------");

    }
    public void afterRuturningAdvice(Object retVal) {
        System.out.println("Returning:" + retVal.toString());
        System.out.println("--------------------------------");

    }
    public void AfterThrowingAdvice(IllegalAccessException ex) {
        System.out.println("There has been an exception:" + ex.toString());
    }
}

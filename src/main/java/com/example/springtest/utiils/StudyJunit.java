package com.example.springtest.utiils;


public class StudyJunit {

    public int add(int a, int b){
        return  a+b*2;
    }

    public int devision(int a, int b){
        return a/b;
    }

    public void checkTimeOut() throws  InterruptedException{
        Thread.sleep(2000);
    }



}

package com.company;

public class MyTestingClass{
    private final String data;

    public MyTestingClass(String data) {
        this.data = data;
    }

    @Override
    public int hashCode(){
        return data.hashCode();
    }

    @Override
    public String toString(){
        return data;
    }

}

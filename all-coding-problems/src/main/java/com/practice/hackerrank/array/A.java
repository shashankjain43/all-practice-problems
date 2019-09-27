package com.practice.hackerrank.array;

public class A {

    public static void main(String[] args) {
        //C c = (C) new B();
        B b =  new C();
        //c.m1();
        b.m1();
        //b.m2();
    }
}
class B{
    void m1(){
        System.out.println("in B m1");
    }
}

class C extends B{
    void m1(){
        System.out.println("in C m1");
    }

    void m2(){
        System.out.println("in C m2");
    }
}


package com.practice.multithread;

public class FooBar {

    private boolean foo = true;

    public void foo() throws InterruptedException {
        int i = 0;

        while (i++ < 5) {
            synchronized (this) {
                while (!foo) {
                    wait();
                }
                System.out.println("Foo");
                foo = false;
                notify();
            }
        }
    }

    public void bar() throws InterruptedException {
        int i = 0;
        while (i++ < 5) {
            synchronized (this) {
                while (foo) {
                    wait();
                }
                System.out.println("Bar");
                foo = true;
                notify();
            }
        }
    }

    public static void main(String[] args) {
        final FooBar a = new FooBar();
        Thread t1 = new Thread(() -> {
            try {
                a.foo();
            } catch (InterruptedException ignored) {

            }
        });

        Thread t2 = new Thread(() -> {
            try {
                a.bar();
            } catch (InterruptedException ignored) {

            }
        });
        t1.start();
        t2.start();
    }

}

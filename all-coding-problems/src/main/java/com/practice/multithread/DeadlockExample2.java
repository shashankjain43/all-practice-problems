package com.practice.multithread;

public class DeadlockExample2 {
	
	public static void main(String[] args) {
		
		A a = new A();
		B b = new B();
		
		Thread t1 = new Thread(() -> {
			
			a.m1(b);
			
		}, "Thread1");
		
		Thread t2 = new Thread(() -> {
			b.m1(a);
		}, "Thread2");
		
		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Commencing Main thread");
	}

}

class A {
	
	public synchronized void m1(B b) {
		System.out.println(Thread.currentThread().getName()+" is in method1 begin");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		b.m2();
		System.out.println(Thread.currentThread().getName()+" is in method1 end");

	}
	
	public synchronized void m2() {
		System.out.println(Thread.currentThread().getName()+" is in method2");
	}
	
}

class B {
	
	public synchronized void m1(A a) {
		System.out.println(Thread.currentThread().getName()+" is in method3 begin");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		a.m2();
		System.out.println(Thread.currentThread().getName()+" is in method3 end");
	}
	
	public synchronized void m2() {
		System.out.println(Thread.currentThread().getName()+" is in method4");
	}
}
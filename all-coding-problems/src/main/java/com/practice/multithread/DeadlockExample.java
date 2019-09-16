package com.practice.multithread;


public class DeadlockExample {
	
	public static void main(String[] args) {
		
		Resource1 res1 = new Resource1();
		Resource2 res2 = new Resource2();
		
		Thread1 t11 = new Thread1(res1, res2);
		Thread t1 = new Thread(t11, "Thread1");
		
		Thread2 t22 = new Thread2(res1, res2);
		Thread t2 = new Thread(t22, "Thread2");
		
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

class Resource1 {
	
	public synchronized void method1(Resource2 r2) {
		System.out.println(Thread.currentThread().getName()+" is in method1 begin");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		r2.method4();
		System.out.println(Thread.currentThread().getName()+" is in method1 end");

	}
	
	public synchronized void method2() {
		System.out.println(Thread.currentThread().getName()+" is in method2");
	}
	
}

class Resource2 {
	
	public synchronized void method3(Resource1 r1) {
		System.out.println(Thread.currentThread().getName()+" is in method3 begin");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		r1.method2();
		System.out.println(Thread.currentThread().getName()+" is in method3 end");
	}
	
	public synchronized void method4() {
		System.out.println(Thread.currentThread().getName()+" is in method4");
	}
}

class Thread1 implements Runnable{
	
	Resource1 r1;
	Resource2 r2;
	
	public Thread1(Resource1 r1, Resource2 r2) {
		super();
		this.r1 = r1;
		this.r2 = r2;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		r1.method1(r2);
	}
	
}

class Thread2 implements Runnable{
	
	Resource1 r1;
	Resource2 r2;
	
	public Thread2(Resource1 r1, Resource2 r2) {
		super();
		this.r1 = r1;
		this.r2 = r2;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		r2.method3(r1);
	}
	
}
package com.practice.multithread;

public class FooBar {

	boolean foo = true;

	public void foo() throws InterruptedException {
		int i = 0;

		while (i++ < 5) {
			synchronized (this) {
				while (foo == false) {
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
				while (foo == true) {
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
		Thread t1 = new Thread(new Runnable() {

			public void run() {
				try {
					a.foo();
				} catch (InterruptedException e) {

				}

			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					a.bar();
				} catch (InterruptedException e) {

				}
			}
		});

		t1.start();
		t2.start();
	}

}

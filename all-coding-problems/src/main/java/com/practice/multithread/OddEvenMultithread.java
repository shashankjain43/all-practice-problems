package com.practice.multithread;

public class OddEvenMultithread {

	public static void main(String[] args) {
		
		Printer printer = new Printer(true);
		
		Thread odd = new Thread(() ->   {
			for(int i=1;i<10;i=i+2) {
				printer.printOdd(i);
			}
		}, "OddThread"); 

		Thread even = new Thread(() ->   {
			for(int i=2;i<=10;i=i+2) {
				printer.printEven(i);
			}
		}, "EvenThread");
		
		odd.start();
		even.start();
	}

}

class Printer {
	
	boolean isOdd;
	
	public Printer(boolean isOdd) {
		super();
		this.isOdd = isOdd;
	}

	public synchronized void printOdd(int i) {
		
		while(!isOdd) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+ ": "+ i);
		isOdd = false;
		notify();
	}
	
	public synchronized void printEven(int i) {
		while(isOdd) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+ ": "+ i);
		isOdd = true;
		notify();
	}
}

package com.practice.gfg.multithread;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

	Queue<Integer> queue = new LinkedList<Integer>();
	int capacity = 3;

	public static void main(String[] args) {

		ProducerConsumer pc = new ProducerConsumer();

		Thread t1 = new Thread(() -> {
			try {
				pc.produce();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}, "Producer");

		Thread t2 = new Thread(() -> {
			try {
				pc.consume();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}, "Consumer");

		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}

	}

	private void consume() throws InterruptedException {
		// TODO Auto-generated method stub
		while (true) {
			synchronized (this) {
				while (queue.isEmpty()) {
					wait();
				}
				System.out.println("Item: " + queue.remove() + " consumed by " + Thread.currentThread().getName());
				notify();
			}
			Thread.sleep(1000);
		}

	}

	private void produce() throws InterruptedException {
		int i = 1;
		while (true) {
			synchronized (this) {
				while (queue.size() == capacity) {
					wait();
				}
				System.out.println("Item: " + i + " produced by " + Thread.currentThread().getName());
				queue.add(i++);
				notify();
			}
			Thread.sleep(1000);
		}
	}

}

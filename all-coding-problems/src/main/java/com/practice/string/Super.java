package com.practice.string;

public class Super {
	int i =100;
	public Super(String d) {
		i=1;
	}
	
	public static void main(String[] args) {
		
		int i =200;
		
		Super s = new Super(null);
		System.out.println(i);
		
	}

}

/*class Sub extends Super{

	public Sub(String d) {
		//super(d);
		// TODO Auto-generated constructor stub
	}

	public Sub(String d) {
		
		i = 2;
		//super(d);
		// TODO Auto-generated constructor stub
	}
	
}*/

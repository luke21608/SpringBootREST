package com.demo;

public class TestFun {

	public static void main(String[] args) {
		System.out.println("*** Game start ***");
		Team team = new Team();
		
		PlayerThread p1 = new PlayerThread(team, 2);
		p1.setName("Kobe");
		p1.start();

		PlayerThread p2 = new PlayerThread(team, 2);
		p2.setName("LBJ");
		p2.start();

		PlayerThread p3 = new PlayerThread(team, 3);
		p3.setName("Curry");
		p3.start();
		
		try {
			p1.join();
			p2.join();
			p3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\r\n*** Game over ***");
	}

}

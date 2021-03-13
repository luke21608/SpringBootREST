package com.demo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class TestFun {

	public static void main(String[] args) {
		//testing extend thread
		System.out.println("*** Game1 \"Thread\" start ***");
		Team team = new Team();
		
		PlayerThread t1 = new PlayerThread(team, 2);
		t1.setName("Kobe");
		t1.start();

		PlayerThread t2 = new PlayerThread(team, 2);
		t2.setName("LBJ");
		t2.start();

		PlayerThread t3 = new PlayerThread(team, 3);
		t3.setName("KD");
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\r\n*** Game1 over ***");
		
		//testing implements runnable
		System.out.println("\r\n*** Game2 \"Runnable\" start ***");
		
		PlayerRunnable p1 = new PlayerRunnable(team, 3);
		Thread t4 = new Thread(p1);
		t4.setName("Curry");
		t4.start();

		PlayerRunnable p2 = new PlayerRunnable(team, 3);
		Thread t5 = new Thread(p2);
		t5.setName("KT");
		t5.start();
		
		try {
			t4.join();
			t5.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\r\n*** Game2 over ***");
		
		System.out.println("\r\n*** Game3 \"Callable\" start ***");
		
		PlayerCallable c1 = new PlayerCallable(team, 2, "Irving");
		PlayerCallable c2 = new PlayerCallable(team, 3, "Harden");

		FutureTask<String> futureTask1 = new FutureTask<String>(c1);
		FutureTask<String> futureTask2 = new FutureTask<String>(c2);

		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(futureTask1);
		executor.execute(futureTask2);

		try {
			System.out.println("\r\nTeam Scored " + futureTask1.get() + " points.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("\r\n*** Game3 over ***");
	}

}

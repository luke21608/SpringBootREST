package com.demo;

import java.util.concurrent.Semaphore;

public class Team {
	
	private int score = 0;
	
	private Semaphore s = new Semaphore(1);
	
	public synchronized int fieldGoal(int bucket) {
		System.out.println("----------------------------------");
		System.out.println("Current Team Score:" + score);
		
		if(score >= 30) {
			System.out.println("Team Score MAX!!");
		}else {
			score += bucket;
			System.out.println(Thread.currentThread().getName() + " made " + bucket +" point!");
			System.out.println("Latest Team Score:" + score);
			System.out.println("----------------------------------");
		}

		return score;
	}
	
	public int fieldGoal_2(int bucket) {
		try {
			s.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("----------------------------------");
		System.out.println("Current Team Score:" + score);
		
		if(score >= 30) {
			System.out.println("Team Score MAX!!");
		}else {
			score += bucket;
			System.out.println(Thread.currentThread().getName() + " made " + bucket +" point!");
			System.out.println("Latest Team Score:" + score);
			System.out.println("----------------------------------");
		}

		s.release();
		
		return score;
	}
}

package com.demo;

import java.util.concurrent.Semaphore;

public class Team {
	
	private int score = 0;
	
	private Semaphore s = new Semaphore(1);
	
	//testing synchronized
	public synchronized int fieldGoal(int bucket) {
		System.out.println("----------------------------------");
		System.out.println("Current Team Score:" + score);
		
		if(score >= 30) {
			System.out.println("Team Score MAX!!");
			System.out.println(Thread.currentThread().getName() + " stop shooting.");
		}else {
			score += bucket;
			System.out.println(Thread.currentThread().getName() + " made " + bucket +" point!");
			System.out.println("Latest Team Score:" + score);
			System.out.println("----------------------------------");
		}

		return score;
	}
	
	//testing Semaphore
	public int fieldGoal_2(int bucket) {
		try {
			s.acquire();
		} catch (InterruptedException e) {
			 //TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("----------------------------------");
		System.out.println("Current Team Score:" + score);
		int tmp = score;
		
		if(score <= 0) {
			System.out.println("Team Score reset to 0!!");
		}else {
			score -= bucket;
			
			if(score <= 0) {
				score = 0;
			}
			
			System.out.println(Thread.currentThread().getName() + " made " + bucket +" point!");
			System.out.println("Latest Team Score:" + tmp + " - " + bucket + " = " + score);
			System.out.println("----------------------------------");
		}

		s.release();
		
		return score;
	}

}

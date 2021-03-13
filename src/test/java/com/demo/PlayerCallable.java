package com.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class PlayerCallable implements Callable<String> {
	
	private Team team;
	
	private int point;
	private AtomicInteger score = new AtomicInteger(0);

	private String name;
	
	private boolean goal = true;
	
	public PlayerCallable(Team team, int point, String name) {
		this.team = team;
		this.point = point;
		this.name = name;
	}

	@Override
	public String call() throws Exception {
		
		Thread.currentThread().setName(name);

		while(goal && Thread.currentThread().isAlive()) {			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(score.get() >= 30) {
				goal = false;
			}else {
				score.set(team.fieldGoal(point));
			}
		}
		
		return String.valueOf(score);
	}
}

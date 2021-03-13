package com.demo;

public class PlayerRunnable implements Runnable {
	
	private Team team;
	
	private int point;
	private int score;

	private boolean goal = true;
	
	public PlayerRunnable(Team team, int point) {
		this.team = team;
		this.point = point;
	}
	
	@Override
	public void run() {
		while(goal) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			score = team.fieldGoal_2(point);
			
			if(score <= 0) {
				goal = false;
			}
		}
	}
}

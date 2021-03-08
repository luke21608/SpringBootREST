package com.demo;

public class PlayerThread extends Thread {
	
	private Team team;
	
	private int point;
	private int score;

	private boolean goal = true;
	
	public PlayerThread(Team team, int point) {
		this.team = team;
		this.point = point;
	}
	
	@Override
	public void run() {
		while(goal) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			score = team.fieldGoal(point);
			
			if(score >= 30) {
				goal = false;
			}
		}
	}
}

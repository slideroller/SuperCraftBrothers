package me.God_Tenshi.scb;

public class Game {

	Main plugin;
	GameStatus status = GameStatus.WAITING;

	public void setStatus(GameStatus s) {
		status = s;
	}

	public GameStatus getStatus() {
		return status;
	}
	
	public void startMatch() {
		setStatus(GameStatus.INGAME);
	}
}

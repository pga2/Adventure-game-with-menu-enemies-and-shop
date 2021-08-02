package com.myfirstgame.main;


public class OptimalScreen {
	protected static int screenHeight;
	protected static int screenWidth;
	protected static int groundHeight;
	protected static int playerStartingHeight;
	protected static int playerJumpRange;
	protected static int enemyStartingHeight;
	public OptimalScreen() {
		screenWidth = 1920;
		screenHeight = 1080;
		
		groundHeight = screenHeight/4*3;
		playerStartingHeight = groundHeight-BasicEnemy.enemyYSize;
		enemyStartingHeight = groundHeight-BasicEnemy.enemyYSize;
		playerJumpRange = playerStartingHeight-OptimalScreen.playerStartingHeight/5;
	}

}

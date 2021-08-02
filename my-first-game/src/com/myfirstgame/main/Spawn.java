package com.myfirstgame.main;


import java.util.Random;

public class Spawn {

	private Handler handler;
	private HUD hud;
	private int scoreKeep = 0;
	private Random random;

	public Spawn(Handler handler, HUD hud) {
		super();
		this.handler = handler;
		this.hud = hud;
		random = new Random();
	}
	
	public void tick() {
		scoreKeep++;
		
		if(scoreKeep >= 250) {
			scoreKeep = 0;
			hud.setLevel(hud.getLevel()+1);
			
			
			handler.addObject(new CoinResp(random.nextInt(OptimalScreen.screenWidth-CoinResp.enemyXSize-15)
						, random.nextInt(OptimalScreen.screenHeight-CoinResp.enemyYSize-37), ID.Coin));
			
			if(hud.getLevel() == 10) {
				
				handler.addObject(new EnemyBoss(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize*3-30)
						, random.nextInt(OptimalScreen.screenHeight-BasicEnemy.enemyYSize*3-100), handler, ID.EnemyBoss));
				
			
			
			} else if(hud.getLevel() == 20) {
				
				handler.addObject(new EnemyBoss2(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize*3-30)
						, random.nextInt(OptimalScreen.screenHeight-BasicEnemy.enemyYSize*3-100), handler, ID.EnemyBoss));
				TheGame.game_background_image = TheGame.game_background2_image;
			
			} else if(hud.getLevel() == 30) {
				
				handler.addObject(new EnemyBoss3(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize*3-30)
						, random.nextInt(OptimalScreen.screenHeight-BasicEnemy.enemyYSize*3-100), handler, ID.EnemyBoss));
			
				
			
				
			}  else if(hud.getLevel() == 40) {
				
				handler.addObject(new EnemyBoss4(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize*3-30)
						, 0, handler, ID.EnemyBoss));
			
			
			} else if(hud.getLevel() == 50) {
				
				handler.addObject(new EnemyBoss(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize*3-30)
						, random.nextInt(OptimalScreen.screenHeight-BasicEnemy.enemyYSize*3-100), handler, ID.EnemyBoss));
				handler.addObject(new EnemyBoss2(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize*3-30)
						, random.nextInt(OptimalScreen.screenHeight-BasicEnemy.enemyYSize*3-100), handler, ID.EnemyBoss));
			
			
			} else if(hud.getLevel() == 60) {
			
				handler.addObject(new EnemyBoss(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize*3-30)
						, random.nextInt(OptimalScreen.screenHeight-BasicEnemy.enemyYSize*3-100), handler, ID.EnemyBoss));
				handler.addObject(new EnemyBoss3(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize*3-30)
						, random.nextInt(OptimalScreen.screenHeight-BasicEnemy.enemyYSize*3-100), handler, ID.EnemyBoss));
				TheGame.game_background_image = TheGame.game_background3_image;
			
			} else if(hud.getLevel() == 70) {
				
				handler.addObject(new EnemyBoss2(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize*3-30)
						, random.nextInt(OptimalScreen.screenHeight-BasicEnemy.enemyYSize*3-100), handler, ID.EnemyBoss));
				handler.addObject(new EnemyBoss3(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize*3-30)
						, random.nextInt(OptimalScreen.screenHeight-BasicEnemy.enemyYSize*3-100), handler, ID.EnemyBoss));
			
			
			} else if(hud.getLevel() == 80) {
				
				handler.addObject(new EnemyBoss4(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize*3-30)
						, 0, handler, ID.EnemyBoss));
				handler.addObject(new EnemyBoss(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize*3-30)
						, random.nextInt(OptimalScreen.screenHeight-BasicEnemy.enemyYSize*3-100), handler, ID.EnemyBoss));
			
			
			} else if(hud.getLevel() == 90) {
				
				handler.addObject(new EnemyBoss4(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize*3-30)
						, 0, handler, ID.EnemyBoss));
				handler.addObject(new EnemyBoss2(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize*3-30)
						, random.nextInt(OptimalScreen.screenHeight-BasicEnemy.enemyYSize*3-100), handler, ID.EnemyBoss));
			
			
			} else if(hud.getLevel() == 100) {
				
				handler.addObject(new EnemyBoss3(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize*3-30)
						, random.nextInt(OptimalScreen.screenHeight-BasicEnemy.enemyYSize*3-100), handler, ID.EnemyBoss));
				handler.addObject(new EnemyBoss4(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize*3-30)
						, 0, handler, ID.EnemyBoss));
				TheGame.game_background_image = TheGame.game_background4_image;
			
			} else if(hud.getLevel() == 110) {
				
				handler.addObject(new EnemyBoss3(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize*3-30)
						, random.nextInt(OptimalScreen.screenHeight-BasicEnemy.enemyYSize*3-100), handler, ID.EnemyBoss));
				handler.addObject(new EnemyBoss2(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize*3-30)
						, random.nextInt(OptimalScreen.screenHeight-BasicEnemy.enemyYSize*3-100), handler, ID.EnemyBoss));
			} else if(hud.getLevel() == 115) {
				handler.addObject(new EnemyBoss4(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize*3-30)
						, 0, handler, ID.EnemyBoss));
			} else if(hud.getLevel() == 200) {
				TheGame.game_background_image = TheGame.game_background5_image;
			}
			if(TheGame.getDifficulty() == "easy") {
				if(hud.getLevel()%4 == 2) {
					handler.addObject(new BasicEnemy(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize-20)
							, random.nextInt(OptimalScreen.screenHeight-BasicEnemy.enemyYSize-40), handler, ID.Enemy));
				} else if(hud.getLevel()%4 == 0) {
					handler.addObject(new FastEnemy(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize-20)
							, random.nextInt(OptimalScreen.screenHeight-BasicEnemy.enemyYSize-40), handler, ID.FastEnemy));
				} else if(hud.getLevel()%4 == 3) {
					handler.addObject(new MagikEnemy(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize-20)
							, 0, handler, ID.magikEnemy));
				}
			} else if(TheGame.getDifficulty() == "medium") {
				if(hud.getLevel()%3 == 1) {
					handler.addObject(new BasicEnemy(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize-20)
							, random.nextInt(OptimalScreen.screenHeight-BasicEnemy.enemyYSize-40), handler, ID.Enemy));
				} else if(hud.getLevel()%3 == 0) {
					handler.addObject(new FastEnemy(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize-20)
							, random.nextInt(OptimalScreen.screenHeight-BasicEnemy.enemyYSize-40), handler, ID.FastEnemy));
				} else if(hud.getLevel()%3 == 2) {
					handler.addObject(new MagikEnemy(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize-20)
							, 0, handler, ID.magikEnemy));
				}
			} else if(TheGame.getDifficulty() == "hard") {
				if(hud.getLevel()%2 == 1) {
					handler.addObject(new BasicEnemy(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize-20)
							, random.nextInt(OptimalScreen.screenHeight-BasicEnemy.enemyYSize-40), handler, ID.Enemy));
				} else if(hud.getLevel()%2 == 0) {
					handler.addObject(new FastEnemy(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize-20)
							, random.nextInt(OptimalScreen.screenHeight-BasicEnemy.enemyYSize-40), handler, ID.FastEnemy));
					handler.addObject(new MagikEnemy(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize-20)
							, 0, handler, ID.magikEnemy));
				}
			}
			if(hud.getLevel() > 110) {
				if(hud.getLevel()%10 == 0) {
					handler.addObject(new EnemyBoss3(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize*3-30)
							, random.nextInt(OptimalScreen.screenHeight-BasicEnemy.enemyYSize*3-100), handler, ID.EnemyBoss));
					handler.addObject(new EnemyBoss2(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize*3-30)
							, random.nextInt(OptimalScreen.screenHeight-BasicEnemy.enemyYSize*3-100), handler, ID.EnemyBoss));
					handler.addObject(new EnemyBoss(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize*3-30)
							, random.nextInt(OptimalScreen.screenHeight-BasicEnemy.enemyYSize*3-100), handler, ID.EnemyBoss));
				}
				if(hud.getLevel()%50 == 0) {
					handler.addObject(new EnemyBoss4(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize*3-30)
							, 0, handler, ID.EnemyBoss));
				}
			}
		}
	}

	
	//Enemys
	/*
	 * 
	 * basic enemy
	 * handler.addObject(new BasicEnemy(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize-20)
						, random.nextInt(OptimalScreen.screenHeight-BasicEnemy.enemyYSize-40), handler, ID.Enemy, game));
	 * 
	 * fast enemy
	 * handler.addObject(new FastEnemy(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize-20)
						, random.nextInt(OptimalScreen.screenHeight-BasicEnemy.enemyYSize-40), handler, ID.FastEnemy, game));
	 * 
	 * magik enemy
	 * handler.addObject(new MagikEnemy(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize-20)
					, 0, handler, ID.magikEnemy, game));
	 * 
	 * enemy boss
	 * handler.addObject(new EnemyBoss(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize*3-30)
						, random.nextInt(OptimalScreen.screenHeight-BasicEnemy.enemyYSize*3-100), handler, ID.EnemyBoss, game));
	 * 
	 * enemy boss 2
	 * handler.addObject(new EnemyBoss2(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize*3-30)
						, random.nextInt(OptimalScreen.screenHeight-BasicEnemy.enemyYSize*3-100), handler, ID.EnemyBoss, game));
	 * 
	 * enemy boss 3
	 * handler.addObject(new EnemyBoss3(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize*3-30)
					, random.nextInt(OptimalScreen.screenHeight-BasicEnemy.enemyYSize*3-100), handler, ID.EnemyBoss, game));
	 *
	 *enemy boss 4
	 *handler.addObject(new EnemyBoss4(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize*3-30)
					, 0, handler, ID.EnemyBoss, game));
	*/

}

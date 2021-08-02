package com.myfirstgame.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class EnemyBoss3 extends GameObject {
	protected static int enemyXSize = 32;
	protected static int enemyYSize = 32;
	private Handler handler;
	private int timer = 80;
	private Random random;
	private int bossDirection;
	private BufferedImage enemyBoss3_image;
	private static float enemyVel = 10/2*2;

	
	public EnemyBoss3(int x, int y, Handler handler, ID id) {
		super(x, y, id);
		if(TheGame.getDifficulty()== "easy" || TheGame.getDifficulty()== "medium") {
			velY = enemyVel;
		} else {
			velY = enemyVel+enemyVel/2;
		}
		velX = 0;
		this.handler = handler;
		random = new Random();
		SpriteSheet ss = new SpriteSheet(TheGame.enemyBoss3_image);
		enemyBoss3_image = ss.grabImage(1, 1, 128, 128);
		if(TheGame.getDifficulty() == "easy") {
			health = 10;
		} else if(TheGame.getDifficulty() == "medium") {
			health = 15;
		} else {
			health = 20;
		}

	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= OptimalScreen.screenHeight-enemyYSize*22/4) {
			velY *= -1;
		}
		
		if(x <= 0 || x >= OptimalScreen.screenWidth-enemyXSize*7/3*2) {
			velX *= -1;
		}
		
		if(timer == 0) {
			velY = 0;
			velX = 0;
		}
		timer--;
		
		if(timer > 15 && timer >= 80) {
			
			
			bossDirection = random.nextInt(4);
			if(TheGame.getDifficulty()== "easy" || TheGame.getDifficulty()== "medium") {
				if(bossDirection == 0) {
					velX = enemyVel/2;
				} else if(bossDirection == 1) {
					velY = enemyVel/2;
				} else if(bossDirection == 2) {
					velX = -enemyVel/2;
				} else if(bossDirection == 3) {
					velY = -enemyVel/2;
				}
			} else {
				if(bossDirection == 0) {
					velX = enemyVel;
				} else if(bossDirection == 1) {
					velY = (int) enemyVel;
				} else if(bossDirection == 2) {
					velX = -enemyVel;
				} else if(bossDirection == 3) {
					velY = -enemyVel;
				}
			}
			
			
		}
		if(timer <= 15) {
			velX = 0;
			velY = 0;
			if(timer == 0) {
				timer = 81;
			}
		}
		
		if(Shop.speedAfterAdjustments <0.4) {
			if(timer == 1 || timer == 2 || timer == 3 || timer == 4 || timer == 5
					|| timer == 6 || timer == 7 || timer == 8) {
				if(TheGame.getDifficulty() == "easy") {
					for(int i=-8; i<=8; i = i+16) {
						for(int j=-8; j<=8; j = j+16) {
							if(i != 0 || j !=0) {
								handler.addObject(new Bullet( (int) x+enemyXSize+12, (int) y+enemyYSize+12, handler, ID.Bullet, i, j));
								
							}
						}
					}
				} else {
					for(int i=-8; i<=8; i = i+8) {
						for(int j=-8; j<=8; j = j+8) {
							if(i != 0 || j !=0) {
								handler.addObject(new Bullet( (int) x+enemyXSize+12, (int) y+enemyYSize+12, handler, ID.Bullet, i, j));
							}
						}
					}
				}
				AudioPlayer.getSound("boss shot").play();
			}
		} else if(Shop.speedAfterAdjustments <0.7) {
			if(timer == 1 || timer == 2 || timer == 3 || timer == 4 || timer == 5
					|| timer == 6 || timer == 7 || timer == 8 || timer == 9 || timer == 10
					 || timer == 11) {
				if(TheGame.getDifficulty() == "easy") {
					for(int i=-8; i<=8; i = i+16) {
						for(int j=-8; j<=8; j = j+16) {
							if(i != 0 || j !=0) {
								handler.addObject(new Bullet( (int) x+enemyXSize+12, (int) y+enemyYSize+12, handler, ID.Bullet, i, j));
								
							}
						}
					}
				} else {
					for(int i=-8; i<=8; i = i+8) {
						for(int j=-8; j<=8; j = j+8) {
							if(i != 0 || j !=0) {
								handler.addObject(new Bullet( (int) x+enemyXSize+12, (int) y+enemyYSize+12, handler, ID.Bullet, i, j));
							}
						}
					}
				}
				AudioPlayer.getSound("boss shot").play();
			}
		} else {
			if(timer == 1 || timer == 2 || timer == 3 || timer == 4 || timer == 5
					|| timer == 6 || timer == 7 || timer == 8 || timer == 9 || timer == 10
					 || timer == 11 || timer == 12 || timer == 13 || timer == 14 || timer == 15) {
				if(TheGame.getDifficulty() == "easy") {
					for(int i=-8; i<=8; i = i+16) {
						for(int j=-8; j<=8; j = j+16) {
							if(i != 0 || j !=0) {
								handler.addObject(new Bullet( (int) x+enemyXSize+12, (int) y+enemyYSize+12, handler, ID.Bullet, i, j));
								
							}
						}
					}
				} else {
					for(int i=-8; i<=8; i = i+8) {
						for(int j=-8; j<=8; j = j+8) {
							if(i != 0 || j !=0) {
								handler.addObject(new Bullet( (int) x+enemyXSize+12, (int) y+enemyYSize+12, handler, ID.Bullet, i, j));
							}
						}
					}
				}
				AudioPlayer.getSound("boss shot").play();
			}
		}

		
		//handler.addObject(new Trail((int) x, (int) y, ID.Trail, Color.BLACK, enemyXSize*3, enemyYSize*3, 0.01f, handler));
	}

	public void render(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect((int) x + 34, (int) y + 132, 60, 5);
		g.drawRect((int) x + 34, (int) y + 132, 60, 5);
		g.setColor(Color.green);
		if(TheGame.getDifficulty() == "easy") {
			g.fillRect((int) x + 34, (int) y + 132, health*6, 5);
		} else if(TheGame.getDifficulty() == "medium") {
			g.fillRect((int) x + 34, (int) y + 132, health*4, 5);
		} else if(TheGame.getDifficulty() == "hard") {
			g.fillRect((int) x + 34, (int) y + 132, health*3, 5);
		}
		g.drawImage(enemyBoss3_image, (int) x, (int) y, null);
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, enemyXSize*4, enemyYSize*4);

	}

}
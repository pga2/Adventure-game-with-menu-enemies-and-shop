package com.myfirstgame.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class EnemyBoss extends GameObject {
	protected static int enemyXSize = 32;
	protected static int enemyYSize = 32;
	private Handler handler;
	
	private int timer = 80;
	private Random random;
	private int bossDirection;
	private BufferedImage enemyBoss_image;
	private static float enemyVel = 10/3*2;

	
	public EnemyBoss(int x, int y, Handler handler, ID id) {
		super(x, y, id);
		velY = enemyVel + enemyVel/2;
		velX = 0;
		this.handler = handler;
		random = new Random();
		SpriteSheet ss = new SpriteSheet(TheGame.enemyBoss_image);
		enemyBoss_image = ss.grabImage(1, 1, 96, 96);
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
		
		if(y <= 0 || y >= OptimalScreen.screenHeight-enemyYSize*2*2) {
			velY *= -1;
		}
		
		if(x <= 0 || x >= OptimalScreen.screenWidth-enemyXSize*5/3*2) {
			velX *= -1;
		}
		
		if(timer == 0) {
			velY = 0;
			velX = 0;
		}
		timer--;
		
		if(timer <= -80 || timer == 0 || timer >= 80) {
			if(timer <=-80) {
				timer = 80;
			}
			if(TheGame.getDifficulty() == "hard" || TheGame.getDifficulty() == "medium") {
				for(int i=-8; i<=8; i = i+8) {
					for(int j=-8; j<=8; j = j+8) {
						if(i != 0 || j !=0) {
							handler.addObject(new Bullet( (int) x+enemyXSize, (int) y+enemyYSize, handler, ID.Bullet, i, j));
						}
					}
				}
			} else {
				for(int i=-8; i<=8; i = i+16) {
					for(int j=-8; j<=8; j = j+16) {
						if(i != 0 || j !=0) {
							handler.addObject(new Bullet( (int) x+enemyXSize, (int) y+enemyYSize, handler, ID.Bullet, i, j));
						}
					}
				}
			}
			bossDirection = random.nextInt(4);
			if(bossDirection == 0) {
				velX = enemyVel+enemyVel*2;
			} else if(bossDirection == 1) {
				velY = enemyVel+enemyVel*2;
			} else if(bossDirection == 2) {
				velX = -(enemyVel+enemyVel*2);
			} else if(bossDirection == 3) {
				velY = -(enemyVel+enemyVel*2);
			}
			AudioPlayer.getSound("boss shot").play();
		}


		
		//handler.addObject(new Trail((int) x, (int) y, ID.Trail, Color.BLACK, enemyXSize*3, enemyYSize*3, 0.01f, handler));
	}

	public void render(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect((int) x + 18, (int) y + 100, 60, 5);
		g.drawRect((int) x + 18, (int) y + 100, 60, 5);
		g.setColor(Color.green);
		if(TheGame.getDifficulty() == "easy") {
			g.fillRect((int) x + 18, (int) y + 100, health*6, 5);
		} else if(TheGame.getDifficulty() == "medium") {
			g.fillRect((int) x + 18, (int) y + 100, health*4, 5);
		} else if(TheGame.getDifficulty() == "hard") {
			g.fillRect((int) x + 18, (int) y + 100, health*3, 5);
		}
		g.drawImage(enemyBoss_image, (int) x, (int) y, null);
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, enemyXSize*3, enemyYSize*3);

	}

}
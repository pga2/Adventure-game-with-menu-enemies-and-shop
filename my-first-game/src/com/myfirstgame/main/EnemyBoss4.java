package com.myfirstgame.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class EnemyBoss4 extends GameObject {
	protected static int enemyXSize = 32;
	protected static int enemyYSize = 32;
	private Handler handler;
	private int timer = 80;
	private Random random;
	private BufferedImage enemyBoss2_image;
	private static float enemyVel = 10;
	private int divident;

	
	public EnemyBoss4(int x, int y, Handler handler, ID id) {
		super(x, y, id);
		if(TheGame.getDifficulty()== "easy" || TheGame.getDifficulty()== "medium") {
			velX = enemyVel/2;
		} else {
			velX = enemyVel+enemyVel/2;
		}
		velY = 0;
		this.handler = handler;
		random = new Random();
		SpriteSheet ss = new SpriteSheet(TheGame.enemyBoss4_image);
		enemyBoss2_image = ss.grabImage(1, 1, 96, 96);
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
		
		
		if(x <= 0 || x >= OptimalScreen.screenWidth-enemyXSize*3-10) {
			velX *= -1;
		}
		
		if(timer == 0) {
			velY = 0;
			velX = 0;
		}
		timer--;
		
		if(timer == 0) {
			timer = 80;
		}
		
		if(Shop.speedAfterAdjustments <0.4) {
			if(TheGame.getDifficulty() == "easy") {
				divident = 65;
			} else if(TheGame.getDifficulty() == "medium") {
				divident = 40;
			} else {
				divident = 20;
			}
		} else if(Shop.speedAfterAdjustments <0.7) {
			if(TheGame.getDifficulty() == "easy") {
				divident = 50;
			} else if(TheGame.getDifficulty() == "medium") {
				divident = 30;
			} else {
				divident = 15;
			}
		} else {
			if(TheGame.getDifficulty() == "easy") {
				divident = 40;
			} else if(TheGame.getDifficulty() == "medium") {
				divident = 20;
			} else {
				divident = 10;
			}
		}
		
		if(timer%divident==0) {
			float direction = (random.nextFloat() - 0.5f);
			handler.addObject(new TNT( (int) x+enemyXSize, (int) y+enemyYSize*2, handler, ID.Bullet, direction*5, 8));
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
		
		//g.setColor(new Color(0, 255, 0));
		
		
		g.drawImage(enemyBoss2_image, (int) x, (int) y, null);
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, enemyXSize*3, enemyYSize*3);

	}

}
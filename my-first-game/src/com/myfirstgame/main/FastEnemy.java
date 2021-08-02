package com.myfirstgame.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class FastEnemy extends GameObject {
	protected static int enemyXSize = 32;
	protected static int enemyYSize = 32;
	private Handler handler;
	BufferedImage fastEnemy_image;
	private static float enemyVel = 10/3;

	
	public FastEnemy(int x, int y, Handler handler, ID id) {
		super(x, y, id);
		velY = enemyVel*3;
		velX = enemyVel*3;
		this.handler = handler;
		SpriteSheet ss = new SpriteSheet(TheGame.fastEnemy_image);
		fastEnemy_image = ss.grabImage(1, 1, 32, 32);
		health = 3;
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= OptimalScreen.screenHeight-enemyYSize*2) {
			velY *= -1;
		}
		
		if(x <= 0 || x >= OptimalScreen.screenWidth-enemyXSize*5/3) {
			velX *= -1;
		}
		handler.addObject(new Trail((int) x, (int) y, ID.Trail, new Color(255, 120, 0), enemyXSize, enemyYSize, 0.1f, handler, fastEnemy_image));
	}

	public void render(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect((int) x + 7, (int) y + 36, 18, 5);
		g.drawRect((int) x + 7, (int) y + 36, 18, 5);
		g.setColor(Color.green);
		
		g.fillRect((int) x + 7, (int) y + 36, health*6, 5);
		g.drawImage(fastEnemy_image, (int) x, (int) y, null);
	}


	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, enemyXSize, enemyYSize);

	}

}

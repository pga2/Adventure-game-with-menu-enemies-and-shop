package com.myfirstgame.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class BasicEnemy extends GameObject {
	protected static int enemyXSize = 32;
	protected static int enemyYSize = 32;
	private Handler handler;
	private BufferedImage basicEnemy_image;
	private static float enemyVel = 3;

	
	public BasicEnemy(int x, int y, Handler handler, ID id) {
		super(x, y, id);
		velY = enemyVel;
		velX = enemyVel;
		this.handler = handler;
		SpriteSheet ss = new SpriteSheet(TheGame.basicEnemy_image);
		basicEnemy_image = ss.grabImage(1, 1, 32, 32);
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
		handler.addObject(new Trail((int) x, (int) y, ID.Trail, Color.red, enemyXSize, enemyYSize, 0.08f, handler, basicEnemy_image));
		enemyVel = 10/3;
		enemyVel = 10/3;
	}

	public void render(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect((int) x + 7, (int) y + 36, 18, 5);
		g.drawRect((int) x + 7, (int) y + 36, 18, 5);
		g.setColor(Color.green);
		
		g.fillRect((int) x + 7, (int) y + 36, health*6, 5);
		g.drawImage(basicEnemy_image, (int) x, (int) y, null);
	}


	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, enemyXSize, enemyYSize);

	}

}

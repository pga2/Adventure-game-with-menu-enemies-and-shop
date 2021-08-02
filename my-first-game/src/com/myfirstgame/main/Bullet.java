package com.myfirstgame.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Bullet extends GameObject {
	protected static int enemyXSize = 32;
	protected static int enemyYSize = 32;
	private Handler handler;
	private BufferedImage bullet_image;
	private float velX;
	private float velY;
	public BufferedImage coin_image;
	public BufferedImage leftBullet_image;
	public BufferedImage upLeftBullet_image;
	public BufferedImage upBullet_image;
	public BufferedImage upRightBullet_image;
	public BufferedImage rightBullet_image;
	public BufferedImage downRightBullet_image;
	public BufferedImage downBullet_image;
	public BufferedImage downLeftBullet_image;
	
	public Bullet(int x, int y, Handler handler, ID id, int velX, int velY) {
		super(x, y, id);
		this.velY = (float) Shop.speedAfterAdjustments*velY;
		this.velX = (float) Shop.speedAfterAdjustments*velX;
		this.handler = handler;
		if(velX == 0 && velY < 0) {
			SpriteSheet ss = new SpriteSheet(TheGame.upBullet_image);
			bullet_image = ss.grabImage(1, 1, 32, 32);
		} else if(velX == 0 && velY > 0) {
			SpriteSheet ss = new SpriteSheet(TheGame.downBullet_image);
			bullet_image = ss.grabImage(1, 1, 32, 32);
		} else if(velX < 0 && velY < 0) {
			SpriteSheet ss = new SpriteSheet(TheGame.upLeftBullet_image);
			bullet_image = ss.grabImage(1, 1, 32, 32);
		} else if(velX > 0 && velY < 0) {
			SpriteSheet ss = new SpriteSheet(TheGame.upRightBullet_image);
			bullet_image = ss.grabImage(1, 1, 32, 32);
		} else if(velX > 0 && velY > 0) {
			SpriteSheet ss = new SpriteSheet(TheGame.downRightBullet_image);
			bullet_image = ss.grabImage(1, 1, 32, 32);
		} else if(velX < 0 && velY > 0) {
			SpriteSheet ss = new SpriteSheet(TheGame.downLeftBullet_image);
			bullet_image = ss.grabImage(1, 1, 32, 32);
		} else if(velX > 0 && velY == 0) {
			SpriteSheet ss = new SpriteSheet(TheGame.rightBullet_image);
			bullet_image = ss.grabImage(1, 1, 32, 32);
		} else if(velX < 0 && velY == 0) {
			SpriteSheet ss = new SpriteSheet(TheGame.leftBullet_image);
			bullet_image = ss.grabImage(1, 1, 32, 32);
		}
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= -50 || y >= OptimalScreen.screenHeight-enemyYSize*2+50) {
			handler.removeObject(this);;
		}
		
		if(x <= -50 || x >= OptimalScreen.screenWidth-enemyXSize*5/3+50) {
			handler.removeObject(this);;
		}
		//handler.addObject(new Trail((int) x, (int) y, ID.Trail, Color.red, enemyXSize, enemyYSize, 0.01f, handler));
	}

	public void render(Graphics g) {
		//g.setColor(Color.gray);
		//g.fillRect((int) x, (int) y, enemyXSize, enemyYSize);
		g.drawImage(bullet_image, (int) x, (int) y, null);
	}


	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, enemyXSize, enemyYSize);

	}

}

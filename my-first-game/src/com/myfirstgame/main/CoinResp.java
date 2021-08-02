package com.myfirstgame.main;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class CoinResp extends GameObject {
	protected static int enemyXSize = 32;
	protected static int enemyYSize = 32;
	private BufferedImage coin_image;

	
	public CoinResp(int x, int y, ID id) {
		super(x, y, id);
		velY = 0;
		velX = 0;
		SpriteSheet ss = new SpriteSheet(TheGame.coin_image);
		coin_image = ss.grabImage(1, 1, 32, 32);
	}
	public void tick() {
		x += velX;
		y += velY;
	}

	public void render(Graphics g) {
		g.drawImage(coin_image, (int) x, (int) y, null);
	}


	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, enemyXSize, enemyYSize);

	}

}
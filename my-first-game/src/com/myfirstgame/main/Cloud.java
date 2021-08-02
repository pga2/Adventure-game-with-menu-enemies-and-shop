package com.myfirstgame.main;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Cloud extends GameObject{
	
	private Random random;
	private BufferedImage kid_image;
	
	public Cloud(int x, int y, ID id) {
		super(x, y, id);
		velX = TheGame.backgroundVelocity;
		velY = 0;
		
		random = new Random();
		int i = random.nextInt(2);
		if(i == 0) {
			SpriteSheet ss = new SpriteSheet(TheGame.kid_image);
			kid_image = ss.grabImage(1, 1, 96, 128);
		} else {
			SpriteSheet ss = new SpriteSheet(TheGame.kid2_image);
			kid_image = ss.grabImage(1, 1, 96, 128);
		}
	}

	public void tick() {
		x -= velX;
		y -= velY;
		if(x <= -250 || y <= 0) {
			x = x + OptimalScreen.screenWidth+200;
			y =  random.nextInt(OptimalScreen.screenHeight)-100;
		}
	}

	public void render(Graphics g) {
		//g.setColor(Color.MAGENTA);
		//g.fillRoundRect((int) x, (int) y, 120, 90, 80, 60);
		g.drawImage(kid_image, (int) x, (int) y, null);
	}

	public Rectangle getBounds() {
		return null;
	}

}

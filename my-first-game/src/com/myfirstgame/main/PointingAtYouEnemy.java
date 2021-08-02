package com.myfirstgame.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class PointingAtYouEnemy extends GameObject {
	protected static int enemyXSize = 32;
	protected static int enemyYSize = 32;
	private Handler handler;
	private GameObject player;
	private BufferedImage pointingAtYouEnemy_image;
	private static float enemyVel = 10/3;
	
	public PointingAtYouEnemy(int x, int y, Handler handler, ID id) {
		super(x, y, id);
		velY = enemyVel + enemyVel/2;
		velX = enemyVel + enemyVel/2;
		this.handler = handler;
		for(int i = 0; i < handler.objects.size(); i++) {
			if(handler.objects.get(i).getId() == ID.Player) {
				this.player = handler.objects.get(i);
			}
		}
		SpriteSheet ss = new SpriteSheet(TheGame.pointingAtYouEnemy_image);
		pointingAtYouEnemy_image = ss.grabImage(1, 1, 32, 32);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		float diffX = x-player.getX();
		float diffY = y-player.getY();
		float distance = (float) Math.sqrt((x-player.getX())*(x-player.getX()) + (y-player.getY())*(y-player.getY()));
		
		velX = ((-1/distance)*diffX);
		velY = ((-1/distance)*diffY);
		
		handler.addObject(new Trail((int) x, (int) y, ID.Trail, Color.cyan, enemyXSize, enemyYSize, 0.03f, handler, pointingAtYouEnemy_image));
	}

	public void render(Graphics g) {
		//g.setColor(Color.cyan);
		//g.fillRect((int) x, (int) y, enemyXSize, enemyYSize);
		g.drawImage(pointingAtYouEnemy_image, (int) x, (int) y, null);
	}


	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, enemyXSize, enemyYSize);

	}

}

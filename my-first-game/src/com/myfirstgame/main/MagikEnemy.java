
package com.myfirstgame.main;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class MagikEnemy extends GameObject {
	protected static int enemyXSize = 32;
	protected static int enemyYSize = 32;
	private Handler handler;
	private BufferedImage magik_image;

	
	public MagikEnemy(int x, int y, Handler handler, ID id) {
		super(x, y, id);
		velY = 1.6f;
		velX = 0;
		this.handler = handler;
		SpriteSheet ss = new SpriteSheet(TheGame.magik_image);
		magik_image = ss.grabImage(1, 1, 32, 32);
		health = 1;
		AudioPlayer.getSound("falling").play();
		
	}
	public void tick() {
		x += velX;
		y += velY;
		
		if( y >= OptimalScreen.screenHeight-50) {
			AudioPlayer.getSound("fall").play();
			System.out.println("dziala");
			handler.removeObject(this);
		}
		
		handler.addObject(new Trail((int) x, (int) y, ID.Trail, Color.red, enemyXSize, enemyYSize, 0.08f, handler, magik_image));
	}

	public void render(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect((int) x + 7, (int) y + 36, 18, 5);
		g.drawRect((int) x + 7, (int) y + 36, 18, 5);
		g.setColor(Color.green);
		
		g.fillRect((int) x + 7, (int) y + 36, health*18, 5);
		g.drawImage(magik_image, (int) x, (int) y, null);
	}


	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, enemyXSize, enemyYSize);

	}

}

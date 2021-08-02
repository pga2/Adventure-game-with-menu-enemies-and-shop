package com.myfirstgame.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Player extends GameObject {
	
	protected static int playerXSize = 32;
	protected static int playerYSize = 32;
	private float x;
	private float y;
	private int timer = 0;
	private int damageTimer = 0;
	
	Handler handler;
	
	private BufferedImage player_image;
	private Window window;
	private BulletMouseAdapter bulletMouseAdapter;
	
	public Player(int x, int y, ID id, Handler handler, Window window, BulletMouseAdapter bulletMouseAdapter) {
		
		super(x, y, id);
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.window = window;
		this.bulletMouseAdapter = bulletMouseAdapter;
		SpriteSheet ss = new SpriteSheet(TheGame.player_image);
		player_image = ss.grabImage(1, 1, 32, 32);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		x = TheGame.clamp((int) x, 0, OptimalScreen.screenWidth-49);
		y = TheGame.clamp((int) y, 0, OptimalScreen.screenHeight-72);
		collision();
		if(bulletMouseAdapter.ismPressed()) {
			if(timer == 0) {
				float diffX = x-window.getMouseX();
				float diffY = y-window.getMouseY();
				float distance = (float) Math.sqrt((x-window.getMouseX())*(x-window.getMouseX()) + (y-window.getMouseY())*(y-window.getMouseY()));
					
				float i = ((-1/distance)*diffX);
				float j = ((-1/distance)*diffY);
				handler.addObject(new PlayerBullet( (int) x, (int) y, handler, ID.PlayerBullet, i*10, j*10));
				AudioPlayer.getSound("throw").play();
				timer = 20;
			}
		}
		timer--;
		if(timer < 0) {
			timer = 0;
		}
		damageTimer--;
		if(damageTimer < 0) {
			damageTimer = 0;
		}
		
		
		handler.addObject(new Trail((int) x, (int) y, ID.Trail, Color.yellow, playerXSize, playerYSize, 0.01f, handler, player_image));
		
		
		
		
	}

	private void collision() {
		for(GameObject object:handler.objects) {
			if(object.getId() == ID.Enemy || object.getId() == ID.FastEnemy 
					|| object.getId() == ID.PointingAtYouEnemy || object.getId() == ID.EnemyBoss  || object.getId() == ID.Bullet || object.getId() == ID.Coin || object.getId() == ID.magikEnemy) {
				if(object.getId() == ID.Coin) {
					if(getBounds().intersects(object.getBounds())) {
						HUD.setGold(HUD.getGold()+1);
						AudioPlayer.getSound("eating").play();
						handler.removeObject(object);
					}
				} else {
					if(getBounds().intersects(object.getBounds())) {
						if(HUD.getADDITIONALHEALTH()>0) {
							HUD.setADDITIONALHEALTH(HUD.getADDITIONALHEALTH()-2);
							if(damageTimer ==0) {
								AudioPlayer.getSound("taking damage").play();
								damageTimer = 20;
							}
						} else {
							HUD.HEALTH -= 2;
							if(damageTimer ==0) {
								AudioPlayer.getSound("taking damage").play();
								damageTimer = 20;
							}
						}
					}
				}
			}
		}
		
	}

	public void render(Graphics g) {
		//g.setColor(Color.yellow);
		//g.fillRect((int)x, (int)y, playerXSize, playerYSize);
		g.drawImage(player_image, (int) x, (int) y, null);
		
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, playerXSize, playerYSize);
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}
	

}

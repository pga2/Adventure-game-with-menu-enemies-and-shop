package com.myfirstgame.main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Trail extends GameObject{
	
	private float alpha = 1;
	private Handler handler;

	private float life;
	private BufferedImage image;
	
	public Trail(int x, int y, ID id,Color color, int width, int height, float life, Handler handler, BufferedImage image) {
		super(x, y, id);
		this.handler = handler;
		this.life = life;
		this.image = image;
	}

	public void tick() {
		if(alpha > life) {
			alpha -= (life - 0.0001f);
		} else {
			handler.removeObject(this);
		}
		
	}

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));
		//g.setColor(color);
		//g.fillRect((int) x, (int) y, width, height);
		g.drawImage(image, (int) x, (int) y, null);
		g2d.setComposite(makeTransparent(1));

	}
	
	private AlphaComposite makeTransparent(float alpha) {
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type, alpha));
	}

	public Rectangle getBounds() {
		return null;
	}

}

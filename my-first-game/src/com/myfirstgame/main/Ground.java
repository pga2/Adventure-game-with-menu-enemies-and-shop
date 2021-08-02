package com.myfirstgame.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ground extends GameObject {
	private Color color;
	public Ground(int x, int y, ID id) {
		super(x, y, id);
		color = new Color(97, 51, 24);
	}

	public void tick() {
	}

	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect((int) x, (int) y, OptimalScreen.screenWidth*3, OptimalScreen.screenHeight);
	}

	public Rectangle getBounds() {
		return null;
	}


}

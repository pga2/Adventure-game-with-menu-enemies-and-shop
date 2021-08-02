package com.myfirstgame.main;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BulletMouseAdapter extends MouseAdapter {
	private boolean mPressed = false;
	
	public BulletMouseAdapter() {
		
	}
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		if(TheGame.mouseOver(mx, my, 0, 0, 1920, 1080)) {
			mPressed = true;
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		mPressed = false;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		
	}
	
	public boolean ismPressed() {
		return mPressed;
	}
	
}

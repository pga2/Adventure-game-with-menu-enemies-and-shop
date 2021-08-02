package com.myfirstgame.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import com.myfirstgame.main.TheGame.FIRSTTIMEOPEN;
import com.myfirstgame.main.TheGame.STATE;

public class Lost extends MouseAdapter {
	private TheGame game;
	
	
	public Lost(TheGame game) {
		this.game = game;
		
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		//Play Again
		if(TheGame.mouseOver(mx, my, 530, 250, 800, 150)) {
			game.gameState = STATE.LoadingScreen;
			game.firsttimeopen = FIRSTTIMEOPEN.LoadingScreen;
			AudioPlayer.getSound("mouse click").play();
		}
		
		//Menu
		if(TheGame.mouseOver(mx, my, 530, 450, 800, 150)) {
			game.gameState = STATE.Menu;
			game.firsttimeopen = FIRSTTIMEOPEN.Menu;
			AudioPlayer.getSound("mouse click").play();
		}
		
		//Quit
		if(TheGame.mouseOver(mx, my, 530, 650, 800, 150)) {
			AudioPlayer.getSound("mouse click").play();
			System.exit(1);
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	public void tick() {
	}
	
	public void render(Graphics g) {
		Font fnt = new Font("arial", 1, 100);
		g.setFont(fnt);
		g.drawString("You Lost", 700, 150);
		g.setColor(Color.white);
		g.drawRect(530, 250, 800, 150);
		g.drawString("Play again", 680, 360);
		g.drawRect(530, 450, 800, 150);
		g.drawString("Menu", 790, 560);
		g.drawRect(530, 650, 800, 150);
		g.drawString("Quit", 815, 760);
		

		
	}
	
}
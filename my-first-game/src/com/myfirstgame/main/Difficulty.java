package com.myfirstgame.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import com.myfirstgame.main.TheGame.FIRSTTIMEOPEN;
import com.myfirstgame.main.TheGame.STATE;

public class Difficulty extends MouseAdapter {
	private TheGame game;
	
	public Difficulty(TheGame game) {
		this.game = game;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		//difficulty easy
		if(TheGame.mouseOver(mx, my, 530, 250, 800, 150)) {
			TheGame.setDifficultyLevel("easy");
			game.gameState = STATE.Menu;
			game.firsttimeopen = FIRSTTIMEOPEN.Menu;
			AudioPlayer.getSound("mouse click").play();
		}
		
		//Difficulty medium
		if (TheGame.mouseOver(mx, my, 530, 450, 800, 150)) {
			TheGame.setDifficultyLevel("medium");
			game.gameState = STATE.Menu;
			game.firsttimeopen = FIRSTTIMEOPEN.Menu;
			AudioPlayer.getSound("mouse click").play();
		}
		
		//Difficulty hard
		if(TheGame.mouseOver(mx, my, 530, 650, 800, 150)) {
			TheGame.setDifficultyLevel("hard");
			game.gameState = STATE.Menu;
			game.firsttimeopen = FIRSTTIMEOPEN.Menu;
			AudioPlayer.getSound("mouse click").play();
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	public void tick() {
	}
	
	public void render(Graphics g) {
		Font fnt = new Font("arial", 1, 100);
		g.setFont(fnt);
		g.drawString("Menu", 790, 150);
		g.setColor(Color.white);
		g.drawRect(530, 250, 800, 150);
		g.drawString("Easy", 810, 360);
		g.drawRect(530, 450, 800, 150);
		g.drawString("Medium", 740, 560);
		g.drawRect(530, 650, 800, 150);
		g.drawString("Hard", 820, 760);
		

		
	}
	
}

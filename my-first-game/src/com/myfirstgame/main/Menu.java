package com.myfirstgame.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import com.myfirstgame.main.TheGame.FIRSTTIMEOPEN;
import com.myfirstgame.main.TheGame.STATE;

public class Menu extends MouseAdapter {
	private TheGame game;
	
	
	public Menu(TheGame game) {
		this.game = game;
		
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		//Starting game
		if(TheGame.mouseOver(mx, my, 530, 250, 800, 150)) {
			game.gameState = STATE.LoadingScreen;
			game.firsttimeopen = FIRSTTIMEOPEN.LoadingScreen;
			AudioPlayer.getSound("mouse click").play();
			
			
			
		}
		
		//High score
		if(TheGame.mouseOver(mx, my, 530, 450, 800, 150)) {
			game.gameState = STATE.HighScores;
			game.firsttimeopen = FIRSTTIMEOPEN.HighScores;
			AudioPlayer.getSound("mouse click").play();
			
			
		}
		
		//difficulty
		
		if(TheGame.mouseOver(mx, my, 1670, 912, 200, 100)) {
			game.gameState = STATE.Difficulty;
			game.firsttimeopen = FIRSTTIMEOPEN.Difficulty;
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
		g.setColor(Color.white);
		g.drawString("Menu", 790, 150);
		g.drawRect(530, 250, 800, 150);
		g.drawString("Play", 820, 360);
		g.drawRect(530, 450, 800, 150);
		g.drawString("High scores", 640, 560);
		g.drawRect(530, 650, 800, 150);
		g.drawString("Quit", 820, 760);
		g.drawRect(1670, 912, 200, 100);
		Font diffFnt = new Font("arial", 1, 40);
		g.setFont(diffFnt);
		g.drawString("Difficulty", 1685, 955);
		if(TheGame.getDifficulty() == "medium") {
			g.drawString(TheGame.getDifficulty(), 1697, 995);
		} else {
			g.drawString(TheGame.getDifficulty(), 1724, 995);
		}
		
	}
	
}

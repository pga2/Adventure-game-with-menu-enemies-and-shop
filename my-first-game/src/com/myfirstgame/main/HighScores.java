package com.myfirstgame.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import com.myfirstgame.main.TheGame.FIRSTTIMEOPEN;
import com.myfirstgame.main.TheGame.STATE;

public class HighScores extends MouseAdapter {
	private TheGame game;
	private FileOpener fileOpener;
	private ArrayList<String> scoresList;
	
	public HighScores(TheGame game, FileOpener fileOpener) {
		this.game = game;
		this.fileOpener = fileOpener;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		//Starting game
		
		//menu
		if(TheGame.mouseOver(mx, my, 530, 800, 800, 150)) {
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
		scoresList = fileOpener.open("res/scores.txt");
		g.setColor(Color.white);
		Font fnt = new Font("arial", 1, 100);
		g.setFont(fnt);
		g.drawString("High Scores", 620, 200);
		//high scores
		fnt = new Font("arial", 1, 40);
		g.setFont(fnt);
		FontMetrics metric = g.getFontMetrics(g.getFont());
		g.drawRect(790, 300, 250, 60);
		try {
		g.drawString("" + scoresList.get(0), 1035 - metric.stringWidth("" + scoresList.get(0)), 345);
		} catch(Exception e) {
			
		}
		g.drawRect(790, 400, 250, 60);
		try {
		g.drawString("" + scoresList.get(1), 1035 - metric.stringWidth("" + scoresList.get(1)), 445);
		} catch(Exception e) {
		
		}
		g.drawRect(790, 500, 250, 60);
		try {
		g.drawString("" + scoresList.get(2), 1035 - metric.stringWidth("" + scoresList.get(2)), 545);
		} catch(Exception e) {
	
		}
		g.drawRect(790, 600, 250, 60);
		try {
		g.drawString("" + scoresList.get(3), 1035 - metric.stringWidth("" + scoresList.get(3)), 645);
		} catch(Exception e) {
		
		}
		g.drawRect(790, 700, 250, 60);
		try {
		g.drawString("" + scoresList.get(4), 1035 - metric.stringWidth("" + scoresList.get(4)), 745);
		} catch(Exception e) {
		
		}
		//menu
		fnt = new Font("arial", 1, 100);
		g.setFont(fnt);
		g.drawRect(530, 800, 800, 150);
		g.drawString("Menu", 790, 910);
	}
	
}

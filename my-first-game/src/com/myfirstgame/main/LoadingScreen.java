package com.myfirstgame.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import java.util.Random;
import java.awt.event.MouseAdapter;

import com.myfirstgame.main.TheGame.FIRSTTIMEOPEN;
import com.myfirstgame.main.TheGame.STATE;

public class LoadingScreen extends MouseAdapter {
	private TheGame game;
	private Handler handler;
	private Random random;
	private Window window;
	private BulletMouseAdapter bulletMouseAdapter;
	private int timer = 0;
	
	public LoadingScreen(TheGame game, Handler handler, Window window, BulletMouseAdapter bulletMouseAdapter) {
		this.game = game;
		this.handler = handler;
		this.window = window;
		this.bulletMouseAdapter = bulletMouseAdapter;
		random = new Random();
		
	}
	
	
	public void tick() {
		if(timer == 150) {
			game.gameState = STATE.Game;
			game.firsttimeopen = FIRSTTIMEOPEN.Game;
			handler.addObject(new Player(100, OptimalScreen.playerStartingHeight, ID.Player, handler, window, bulletMouseAdapter));
			handler.addObject(new PointingAtYouEnemy(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize)
					, random.nextInt(OptimalScreen.screenHeight-BasicEnemy.enemyYSize), handler, ID.PointingAtYouEnemy));
			TheGame.game_background_image = TheGame.game_background1_image;
			timer = 0;
		}
		
		timer ++;
	}
	
	public void render(Graphics g) {
		Font fnt = new Font("arial", 1, 100);
		g.setColor(Color.black);
		g.setFont(fnt);
		g.drawString("Papaj has kidnapped a kid,", 290, 480);
		g.drawString(" help him escape.", 480, 600);
	}
	
}

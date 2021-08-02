package com.myfirstgame.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.myfirstgame.main.TheGame.FIRSTTIMEOPEN;
import com.myfirstgame.main.TheGame.STATE;

public class KeyInput extends KeyAdapter{
	private Handler handler;
	private boolean[] keyDown = new boolean[4];
	private TheGame game;
	
	
	public KeyInput(Handler handler, TheGame game) {
		this.handler = handler;
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;
		this.game = game;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for(GameObject object:handler.objects) {
			if(object.getId() == ID.Player) {
				if(key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
					object.setVelY(-6); keyDown[0] = true;
				}
				if(key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
					object.setVelY(6); keyDown[1] = true;
				}
				if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
					object.setVelX(-6); keyDown[2] = true;
				}
				if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
					object.setVelX(6); keyDown[3] = true;
				}
				
			}	
		}
		if(key == KeyEvent.VK_ESCAPE) {
			/*if(game.gameState == STATE.Game) {
				if(game.pause) {
					game.pause = false;
				} else {
					game.pause = true;
				}
			}
			*/
			System.exit(1);
		}
		if(key == KeyEvent.VK_SPACE) {
			if(game.gameState == STATE.Game) {
				game.gameState = STATE.Shop;
				game.firsttimeopen = FIRSTTIMEOPEN.Shop;
			} else if(game.gameState == STATE.Shop) {
				game.gameState = STATE.Game;
				game.firsttimeopen = FIRSTTIMEOPEN.Game;
			}
		}
	}
	
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for(GameObject object:handler.objects) {
			if(object.getId() == ID.Player) {
				if(key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
					keyDown[0] = false;
				}

				if(key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
					keyDown[1] = false;
				}

				if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
					keyDown[2] = false;
				}

				if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
					keyDown[3] = false;
				}
				if(!keyDown[0] && !keyDown[1]) {
					object.setVelY(0);
				}
				if(!keyDown[2] && !keyDown[3]) {
					object.setVelX(0);
				}
			}
		}
	}
}

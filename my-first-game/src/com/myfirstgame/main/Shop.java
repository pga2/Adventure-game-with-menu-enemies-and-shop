package com.myfirstgame.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Shop extends MouseAdapter{
	
	public static float speedAfterAdjustments = 1;
	public static boolean incrBulletSpeed = true;
	public static boolean incrHEALTH = true;
	public static boolean hugeIncrHEALTH = true;
	private int timer;
	
	public Shop() {

		
	}
	
	public void render(Graphics g) {
		g.setFont(new Font("Arial", 1, 100));
		g.setColor(Color.white);
		g.drawString("PAUSED", 700, 550);
		g.drawString("Shop", 1530, 250);
		g.setFont(new Font("Atial", 1, 25));
		//hp boost
		g.drawRect(1507, 300, 300, 90);
		if(incrHEALTH) {
			g.drawString("Increase Max HP", 1558, 335);
			g.drawString("Cost 4g", 1606, 375);
		}
		//slow bullets
		g.drawRect(1507, 400, 300, 90);
		if(incrBulletSpeed) {
			g.drawString("Slow bullets", 1575, 435);
			g.drawString("Cost 4g", 1606, 475);
		}
		//refill hp
		g.drawRect(1507, 500, 300, 90);
		if(HUD.getMaxHealth() != HUD.HEALTH) {
			g.drawString("Refill HP", 1601, 535);
			g.drawString("Cost 4g", 1606, 575);
		}
		//huge hp boost
		g.drawRect(1507, 600, 300, 90);
		if(hugeIncrHEALTH) {
			g.drawString("Huge Increase Max HP", 1523, 635);
			g.drawString("Cost 20g", 1602, 675);
		}
		//second life
		g.drawRect(1507, 700, 300, 90);
		if(HUD.getADDITIONALHEALTH() < HUD.getMaxHealth()) {
			g.drawString("Additional life", 1573, 735);
			g.drawString("Cost 20g", 1602, 775);
		}
		if(timer > 0) {
			timer--;
			g.drawString("Not enought gold", 1560, 870);
		}
		
	}


	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		if(TheGame.mouseOver(mx, my, 1507, 300, 300, 90)) { 		//increase hp limit
			if(HUD.getGold() >= 4) {
				if(HUD.getMaxHealth() <= 935) {
					HUD.setMaxHealth(HUD.getMaxHealth()+5);
					HUD.setGold(HUD.getGold()-4);
					AudioPlayer.getSound("mouse click").play();
				} else {
					incrHEALTH = false;
				}
			} else {
				timer = 200;
			}
			
		} else if(TheGame.mouseOver(mx, my, 1507, 400, 300, 90)) {		//slow bullets
			if(HUD.getGold() >= 4) {
				if(incrBulletSpeed) {
					if(speedAfterAdjustments > 0.7f) {
						speedAfterAdjustments = speedAfterAdjustments-speedAfterAdjustments * 0.05f;
						HUD.setGold(HUD.getGold()-4);
						AudioPlayer.getSound("mouse click").play();
					} else if(speedAfterAdjustments > 0.5f) {
						speedAfterAdjustments = speedAfterAdjustments-speedAfterAdjustments * 0.03f;
						HUD.setGold(HUD.getGold()-4);
						AudioPlayer.getSound("mouse click").play();
					} else if(speedAfterAdjustments > 0.2f) {
						speedAfterAdjustments = speedAfterAdjustments-speedAfterAdjustments * 0.01f;
						HUD.setGold(HUD.getGold()-4);
						AudioPlayer.getSound("mouse click").play();
					} else {
						incrBulletSpeed = false;
					}
				}
			} else {
				timer = 200;
			}
			
			
		} else if(TheGame.mouseOver(mx, my, 1507, 500, 300, 90)) {		//refill hp
			if(HUD.getGold() >= 4) {
				if(HUD.getMaxHealth() != HUD.HEALTH) {
					HUD.HEALTH = HUD.getMaxHealth();
					HUD.setGreenValue(255);
					HUD.setRedValue(0);
					HUD.setGold(HUD.getGold()-4);
					AudioPlayer.getSound("mouse click").play();
				}
			} else {
				timer = 200;
			}
			
		} else if(TheGame.mouseOver(mx, my, 1507, 600, 300, 90)) {		//huge increase hp limit
			if(HUD.getGold() >= 20) {
				if(HUD.getMaxHealth() <= 910) {
					HUD.setMaxHealth(HUD.getMaxHealth()+30);
					HUD.setGold(HUD.getGold()-20);
					AudioPlayer.getSound("mouse click").play();
				} else {
					hugeIncrHEALTH = false;
				}
			} else {
				timer = 200;
			}
		} else if(TheGame.mouseOver(mx, my, 1507, 700, 300, 90)) {		//second life
			if(HUD.getGold() >= 20) {
				if(HUD.getADDITIONALHEALTH() < HUD.getMaxHealth()) {
					HUD.setADDITIONALHEALTH(HUD.getMaxHealth());
					HUD.setGold(HUD.getGold()-20);
					AudioPlayer.getSound("mouse click").play();
				}
			} else {
				timer = 200;
			}
		}
	}
	public void setIncrBulletSpeed(boolean dcrBulletSpeed) {
		incrBulletSpeed = dcrBulletSpeed;
	}

	public void setIncrHEALTH(boolean incrHEALTH) {
		Shop.incrHEALTH = incrHEALTH;
	}

	public void setHugeIncrHEALTH(boolean hugeIncrHEALTH) {
		Shop.hugeIncrHEALTH = hugeIncrHEALTH;
	}
}

package com.myfirstgame.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class HUD {
	public static float HEALTH = 100;
	private static float ADDITIONALHEALTH;
	private static float maxHealth = 100;
	private static int redValue = 75;
	private static int greenValue = 255;
	private int blueValue = 0;
	private int score = 0;
	private int level = 1;
	private static int gold = 0;
	
	
	private BufferedImage coin_image;
	
	
	public HUD() {
		SpriteSheet ss = new SpriteSheet(TheGame.coin_image);
		coin_image = ss.grabImage(1, 1, 32, 32);
	}


	public void tick() {
		HEALTH = (int) TheGame.clamp(HEALTH, 0, maxHealth);
		if(HEALTH/maxHealth < 0.25f) {
			greenValue = 0;
			redValue = 255;
		} else if (HEALTH/maxHealth < 0.5f) {
			greenValue = 100;
			redValue = 255;
		} else {
			greenValue = 255;
			redValue = 0;
		}
		score += 1;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(15, 15, (int) maxHealth*2, 32);
		g.setColor(new Color(redValue, (int) greenValue, blueValue));
		g.fillRect( 15, 15, (int) HEALTH*2, 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, (int) maxHealth*2 , 32);
		if(ADDITIONALHEALTH > 0) {
			g.setColor(new Color(255, 215, 0));
			g.fillRect(15, 15, (int) ADDITIONALHEALTH*2, 32);
		}
		Font fnt = new Font("arial", 1, 15);
		g.setFont(fnt);
		g.drawString("Score: " + getScore(), 15, 64);
		g.drawString("Level: " + level, 15, 78);
		g.drawString("Press space for shop and pause", 15, 92);
		g.drawString("Press esc to quit", 15, 106);
		g.drawString("Gold: " + gold, 15, 132);
		g.drawImage(coin_image, 80, 110, null);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public static int getGold() {
		return gold;
	}


	public static void setGold(int gold) {
		HUD.gold = gold;
	}
	
	public static float getMaxHealth() {
		return maxHealth;
	}


	public static void setMaxHealth(float maxHealth) {
		HUD.maxHealth = maxHealth;
	}


	public static void setRedValue(int redValue) {
		HUD.redValue = redValue;
	}


	public static void setGreenValue(int greenValue) {
		HUD.greenValue = greenValue;
	}
	
	public static float getADDITIONALHEALTH() {
		return ADDITIONALHEALTH;
	}


	public static void setADDITIONALHEALTH(float aDDITIONALHEALTH) {
		ADDITIONALHEALTH = aDDITIONALHEALTH;
	}
	
}

package com.myfirstgame.main;

import java.awt.Canvas;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;


public class Window extends Canvas{

	private static final long serialVersionUID = 6440969597587803962L;
	
	private JFrame frame;
	
	public Window(int width, int height, String title, TheGame game) {
		frame = new JFrame(title);
		Toolkit kit = Toolkit.getDefaultToolkit();
		
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		
	    Cursor cursor = kit.createCustomCursor(TheGame.cursor_image, new Point(17, 17), "myCursor");;
	    frame.setCursor(cursor);
	    
		
		game.start();
	}

	public int getMouseX() {
		try {
			if(frame.getMousePosition() == null) {
				return 1920/2;
			} else {
				return frame.getMousePosition().x;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 1920/2;
	}

	public int getMouseY() {
		try {
			if(frame.getMousePosition() == null) {
				return 1080/2;
			} else {
				return frame.getMousePosition().y;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 1080/2;
	}

	
	
	
}

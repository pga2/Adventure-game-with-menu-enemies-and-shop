package com.myfirstgame.main;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;


public class AudioPlayer {
	
	public static Map<String, Sound> soundMap = new HashMap<String, Sound>();
	public static Map<String, Music> musicMap = new HashMap<String, Music>();

	public static void load() {
		try {
			musicMap.put("background music", new Music("res/background-music.wav"));
			
			
			soundMap.put("mouse click", new Sound("res/mouse-click.wav"));
			
			soundMap.put("death", new Sound("res/death.wav"));
			
			soundMap.put("boss shot", new Sound("res/boss-shot.wav"));
			
			soundMap.put("getting points", new Sound("res/getting-points.wav"));
			
			soundMap.put("throw", new Sound("res/throw.wav"));
			
			soundMap.put("taking damage", new Sound("res/taking-damage.wav"));
			
			soundMap.put("eating", new Sound("res/eating.wav"));
			
			soundMap.put("falling", new Sound("res/falling.wav"));
			
			soundMap.put("fall", new Sound("res/fall.wav"));
			
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public static Music getMusic(String key) {
		return musicMap.get(key);
	}
	
	public static Sound getSound(String key) {
		return soundMap.get(key);
	}
	
}

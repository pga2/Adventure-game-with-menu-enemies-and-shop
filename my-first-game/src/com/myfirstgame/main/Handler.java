package com.myfirstgame.main;

import java.awt.Graphics;
import java.util.concurrent.CopyOnWriteArrayList;

public class Handler {
	protected CopyOnWriteArrayList<GameObject> objects = new CopyOnWriteArrayList<GameObject>();

	public void tick() {
		for(GameObject object:objects) {
			object.tick();
		}

	}
	
	public void render(Graphics g) {
		for(GameObject object:objects) {
			object.render(g);
		}
	}
	
	public void addObject(GameObject object) {
		this.objects.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.objects.remove(object);

	}

	public void clearEnemys() {
		for(int i = 0; i<objects.size(); i++) {
			GameObject tempObject = this.objects.get(i);
			if(tempObject.getId() != ID.Player && tempObject.getId() != ID.Terrain) {
				this.removeObject(tempObject);
				i--;
			}
		}
		
	}
	public void clearStupidEnemys() {
		for(int i = 0; i<objects.size(); i++) {
			GameObject tempObject = this.objects.get(i);
			if(tempObject.getId() != ID.Player && tempObject.getId() != ID.Terrain && tempObject.getId() != ID.PointingAtYouEnemy) {
				this.removeObject(tempObject);
				i--;
			}
		}
		
	}
	
	public void clear() {
		for(int i = 0; i<objects.size(); i++) {
			GameObject tempObject = this.objects.get(i);
			this.removeObject(tempObject);
			i--;
		}
		
	}
	
	public void clearMenuBackground() {
		for(int i = 0; i<objects.size(); i++) {
			GameObject tempObject = this.objects.get(i);
			if(tempObject.getId() == ID.Terrain) {
				this.removeObject(tempObject);
				i--;
			}
		}
		
	}
}

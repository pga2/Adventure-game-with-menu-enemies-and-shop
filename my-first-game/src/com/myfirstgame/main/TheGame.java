package com.myfirstgame.main;


import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;



public class TheGame extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 2579893974893765909L;
	private Thread thread;
	private boolean running = false;
	
	protected static OptimalScreen OptimalScreen;
	private BulletMouseAdapter bulletMouseAdapter;
	private Handler handler;
	private HUD hud;
	private Spawn spawner;
	private Random random;
	
	private Menu menu;
	private Lost lost;
	private Difficulty difficulty;
	private Shop shop;
	private FileOpener fileOpener;
	private HighScores highScores;
	private Window window;
	private LoadingScreen loadingScreen;
	
	

	protected static int backgroundVelocity = 5;
	public static int groundHeight;
	public static boolean pause = false;
	private static String difficultyLevel = "easy";

	public enum FIRSTTIMEOPEN {
		Menu,
		Lost,
		Game,
		Difficulty,
		Shop,
		HighScores,
		LoadingScreen,
		NOT;
	}
	
	public enum STATE {
		Menu,
		Lost,
		Game,
		Shop,
		HighScores,
		Difficulty,
		LoadingScreen;
	}
	
	public STATE gameState = STATE.Menu;
	public FIRSTTIMEOPEN firsttimeopen = FIRSTTIMEOPEN.Game;
	
	public static BufferedImage sprite_sheet;
	public static BufferedImage cloud_image;
	public static BufferedImage game_background_image;
	public static BufferedImage coin_image;
	public static BufferedImage leftBullet_image;
	public static BufferedImage upLeftBullet_image;
	public static BufferedImage upBullet_image;
	public static BufferedImage upRightBullet_image;
	public static BufferedImage rightBullet_image;
	public static BufferedImage downRightBullet_image;
	public static BufferedImage downBullet_image;
	public static BufferedImage downLeftBullet_image;
	public static BufferedImage rock_image;
	public static BufferedImage player_image;
	public static BufferedImage basicEnemy_image;
	public static BufferedImage fastEnemy_image;
	public static BufferedImage pointingAtYouEnemy_image;
	public static BufferedImage enemyBoss_image;
	public static BufferedImage enemyBoss2_image;
	public static BufferedImage enemyBoss3_image;
	public static BufferedImage enemyBoss4_image;
	public static BufferedImage kid_image;
	public static BufferedImage kid2_image;
	public static BufferedImage game_background0_image;
	public static BufferedImage game_background1_image;
	public static BufferedImage game_background2_image;
	public static BufferedImage game_background3_image;
	public static BufferedImage game_background4_image;
	public static BufferedImage game_background5_image;
	public static BufferedImage cursor_image;
	public static BufferedImage magik_image;
	
	public TheGame() {
		OptimalScreen = new OptimalScreen();
		
		BufferedImageLoader loader = new BufferedImageLoader();
		sprite_sheet = loader.loadImage("res/sprite-sheet.png");
		cloud_image = loader.loadImage("res/bullet.png");
		game_background0_image = loader.loadImage("res/game-background.png");
		coin_image = loader.loadImage("res/coin.png");
		cursor_image = loader.loadImage("res/cursor.png");
		
		leftBullet_image = loader.loadImage("res/leftBullet_image.png");
		upLeftBullet_image = loader.loadImage("res/upLeftBullet_image.png");
		upBullet_image = loader.loadImage("res/upBullet_image.png");
		upRightBullet_image = loader.loadImage("res/upRightBullet_image.png");
		rightBullet_image = loader.loadImage("res/rightBullet_image.png");
		downRightBullet_image = loader.loadImage("res/downRightBullet_image.png");
		downBullet_image = loader.loadImage("res/downBullet_image.png");
		downLeftBullet_image = loader.loadImage("res/downLeftBullet_image.png");
		rock_image = loader.loadImage("res/rock.png");
		player_image = loader.loadImage("res/player.png");
		basicEnemy_image = loader.loadImage("res/basic-enemy.png");
		fastEnemy_image = loader.loadImage("res/fast-enemy.png");
		magik_image = loader.loadImage("res/magik.png");
		pointingAtYouEnemy_image = loader.loadImage("res/pointing-at-you-enemy.png");
		enemyBoss_image = loader.loadImage("res/enemy-boss.png");
		enemyBoss2_image = loader.loadImage("res/enemy-boss-2.png");
		enemyBoss3_image = loader.loadImage("res/enemy-boss-3.png");
		enemyBoss4_image = loader.loadImage("res/enemy-boss-4.png");
		kid_image = loader.loadImage("res/kid.png");
		kid2_image = loader.loadImage("res/kid2.png");
		game_background1_image = loader.loadImage("res/game-background1.png");
		game_background2_image = loader.loadImage("res/game-background2.png");
		game_background3_image = loader.loadImage("res/game-background3.png");
		game_background4_image = loader.loadImage("res/game-background4.png");
		game_background5_image = loader.loadImage("res/game-background5.png");
		game_background_image = game_background0_image;
		
		SpriteSheet ss = new SpriteSheet(game_background_image);
		game_background_image = ss.grabImage(1, 1, OptimalScreen.screenWidth, OptimalScreen.screenHeight);
		
		window = new Window(OptimalScreen.screenWidth, OptimalScreen.screenHeight
				, "The papaj game", this);
		
		handler = new Handler();
		random = new Random();
		fileOpener = new FileOpener();
		bulletMouseAdapter = new BulletMouseAdapter();
		menu = new Menu(this);
		highScores = new HighScores(this, fileOpener);
		lost = new Lost(this);
		difficulty = new Difficulty(this);
		shop = new Shop();
		loadingScreen = new LoadingScreen(this, handler, window, bulletMouseAdapter);
		
		
		
		

		
		this.addKeyListener(new KeyInput(handler, this));
		this.addMouseListener(menu);
		
		
		
		
		AudioPlayer.load();
		AudioPlayer.getMusic("background music").loop();
		hud = new HUD();
		spawner = new Spawn( handler, hud);
		firsttimeopen = FIRSTTIMEOPEN.NOT;
		
		for(int i=0; i<=100; i++) {
			handler.addObject(new Cloud(random.nextInt(OptimalScreen.screenWidth+140)
			, random.nextInt(OptimalScreen.screenHeight-130), ID.Terrain));
		}
		/*handler.addObject(new BasicEnemy(random.nextInt(OptimalScreen.screenWidth-BasicEnemy.enemyXSize)
			, random.nextInt(OptimalScreen.screenHeight-BasicEnemy.enemyYSize), handler, ID.Enemy));*/


	}


	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(running) {
				render();
			}
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
			
		}
	}
	
	private void tick() {
		if(gameState == STATE.Game) {
			if(firsttimeopen == FIRSTTIMEOPEN.Game) {
				
				this.removeMouseListener(shop);
				this.addMouseListener(bulletMouseAdapter);
				firsttimeopen = FIRSTTIMEOPEN.NOT;
				
			}
			//if(!pause) {
			
			hud.tick();
			spawner.tick();
			handler.clearMenuBackground();
				
			if(HUD.HEALTH == 0) {
				HUD.HEALTH = 100;
				HUD.setMaxHealth(100);
				fileOpener.sortAndSave("res/scores.txt", hud.getScore());
				hud.setScore(0);
				hud.setLevel(1);
				HUD.setGold(0);
				Shop.speedAfterAdjustments = 1;
				Shop.incrBulletSpeed = true;
				Shop.hugeIncrHEALTH = true;
				Shop.incrHEALTH = true;
				handler.clear();
				game_background_image = game_background0_image;
				for(int i=0; i<=100; i++) {
					handler.addObject(new Cloud(random.nextInt(OptimalScreen.screenWidth+140)
					, random.nextInt(OptimalScreen.screenHeight-130), ID.Terrain));
				}
				this.removeMouseListener(menu);
				this.removeMouseListener(bulletMouseAdapter);
				this.addMouseListener(lost);
				gameState = STATE.Lost;
			}
			handler.tick();
			//}
		} else if(gameState == STATE.Menu) {
			handler.tick();
			if(firsttimeopen == FIRSTTIMEOPEN.Menu) {
				this.removeMouseListener(lost);
				this.removeMouseListener(difficulty);
				this.removeMouseListener(highScores);
				this.addMouseListener(menu);
				firsttimeopen = FIRSTTIMEOPEN.NOT;
			}
			menu.tick();
		} else if(gameState == STATE.Lost) {
			handler.tick();
			if(firsttimeopen == FIRSTTIMEOPEN.Lost) {
				shop.setIncrBulletSpeed(true);
				shop.setIncrHEALTH(true);
				shop.setHugeIncrHEALTH(true);
				handler.tick();
				firsttimeopen = FIRSTTIMEOPEN.NOT;
			}
			lost.tick();
		} else if(gameState == STATE.Difficulty) {
			handler.tick();
			if(firsttimeopen == FIRSTTIMEOPEN.Difficulty) {
				this.removeMouseListener(menu);
				this.addMouseListener(difficulty);
				firsttimeopen = FIRSTTIMEOPEN.NOT;
			} else {
			difficulty.tick();
			}
			
		} else if(gameState == STATE.Shop) {
			if(firsttimeopen == FIRSTTIMEOPEN.Shop) {
				this.addMouseListener(shop);
				firsttimeopen = FIRSTTIMEOPEN.NOT;
			}
			
		} else if(gameState == STATE.HighScores) {
			handler.tick();
			if(firsttimeopen == FIRSTTIMEOPEN.HighScores) {
				this.removeMouseListener(menu);
				this.addMouseListener(highScores);
				firsttimeopen = FIRSTTIMEOPEN.NOT;
			}
			highScores.tick();
		} else if(gameState == STATE.LoadingScreen) {
			if(firsttimeopen == FIRSTTIMEOPEN.LoadingScreen) {
				this.removeMouseListener(menu);
				this.removeMouseListener(lost);
			}
			loadingScreen.tick();
			handler.tick();
		}
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		//g.setColor(new Color(backgroundRed, 0, backgroundBlue));
		//g.fillRect(x, y, OptimalScreen.screenWidth, OptimalScreen.screenHeight);
		g.drawImage(game_background_image, 0, 0, null);
		handler.render(g);
		if(gameState == STATE.Game) {
			hud.render(g);
		} else if(gameState == STATE.Menu){
			menu.render(g);
		} else if(gameState == STATE.Lost) {
			lost.render(g);
		} else if(gameState == STATE.Difficulty) {
			difficulty.render(g);
		} else if(gameState == STATE.Shop) {
			shop.render(g);
			hud.render(g);
		} else if(gameState == STATE.HighScores) {
			highScores.render(g);
		} else if(gameState == STATE.LoadingScreen) {
			loadingScreen.render(g);
		}
		/*if(pause) {
			Font fnt = new Font("Arial", 1, 100);
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("PAUSED", 700, 550);
		}*/
		
		g.dispose();
		bs.show();
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static float clamp(float var, float min, float max) {
		if(var <= min) {
			return var = min;
		}
		else if(var>=max) {
			return var = max;
		}
		else {
			return var;
		}
	}
	
	public static boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx>x && mx<x+width) {
			if(my>y && my<y+height) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
		
	}
	public static String getDifficulty() {
		return difficultyLevel;
	}
	
	public static void setDifficultyLevel(String difficultyLevel) {
		TheGame.difficultyLevel = difficultyLevel;
	}
	
	
	
	public static void main(String[] args) {
		new TheGame();
	}

	
	
}

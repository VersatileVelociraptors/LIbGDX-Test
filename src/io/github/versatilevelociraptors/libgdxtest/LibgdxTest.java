package io.github.versatilevelociraptors.libgdxtest;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.backends.lwjgl.audio.Mp3.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LibgdxTest implements ApplicationListener{
	
	public static final String TITLE = "LibGDX-Test";
	public static final int WIDTH = 640;
	public static final int HEIGHT = 360;
	public static final double SCALE = 1.5;
	public static final boolean COPS = true;
	
	private SpriteBatch batch;
	private BitmapFont font;
	private Texture texture;
	private FPSLogger fps;
	
	private float r,g,b;
	private double text_x, text_y;
	
	private int timer;
	
	private Sound coco;

	public static void main(String[] agrs){
		
		LwjglApplicationConfiguration configuration = new LwjglApplicationConfiguration();
		
		//disable frame limiter
		configuration.vSyncEnabled = true;
		configuration.foregroundFPS = 0;
		configuration.backgroundFPS = 0;
		
		//set window options
		configuration.title = TITLE;
		configuration.width = getWidth();
		configuration.height = getHeight();
		
		new LwjglApplication(new LibgdxTest() , configuration);
	}
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		texture = new Texture("assets/images/VersatileVelociraptors.png");
		fps = new FPSLogger();
		timer = 30;
		font = new BitmapFont();
		coco = (Sound) Gdx.audio.newSound(Gdx.files.internal("assets/music/coco.mp3"));
		coco.play();
	}
	
	@Override
	public void render() {
		if(timer == 0){
			r = (float)Math.random();
			g = (float)Math.random();
			b = (float)Math.random();
			
			text_x = Math.random() * getHeight();
			text_y = Math.random() * getWidth();
			
			timer = 30;
		}
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl20.glClearColor(r, g, b, 1);
		batch.begin();
		batch.draw(texture , Gdx.input.getX() - texture.getWidth()/2, getHeight() - Gdx.input.getY() - texture.getHeight()/2/*had to subtract from height to invert the y axis*/);
		font.setColor(new Color(1.0f - r, 1.0f - g, 1.0f - b, 1.0f));
		font.draw(batch, "SMOKE WEED EVERYDAY", (int)text_x, (int)text_y);
		batch.end();
		fps.log();
		timer--;
	}
	
	public static int getHeight(){
		return (int)(HEIGHT*SCALE);
	}

	public static int getWidth(){
		return (int)(WIDTH*SCALE);
	}

	@Override
	public void dispose() {
		if(COPS)
			coco.dispose();
		batch.dispose();
		texture.dispose();
		font.dispose();
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resize(int arg0, int arg1) {
	}

	@Override
	public void resume() {
	}

}

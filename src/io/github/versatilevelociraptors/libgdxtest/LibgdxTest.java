package io.github.versatilevelociraptors.libgdxtest;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.backends.lwjgl.audio.Mp3.Sound;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LibgdxTest implements ApplicationListener{
	
	public static final String TITLE = "LibGDX-Test";
	public static final int WIDTH = 640;
	public static final int HEIGHT = 360;
	public static final double SCALE = 1.5;
	
	private SpriteBatch batch;
	private Texture texture;
	private FPSLogger fps;
	
	private float r,g,b;
	
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
		coco = (Sound) Gdx.audio.newSound(Gdx.files.internal("assets/music/coco.mp3"));
		coco.play();
	}
	
	@Override
	public void render() {
		if(timer == 0){
			r = (float)Math.random();
			g = (float)Math.random();
			b = (float)Math.random();
			timer = 30;
		}
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl20.glClearColor(r, g, b, 1);
		batch.begin();
		batch.draw(texture , Gdx.input.getX() , getHeight() - Gdx.input.getY()/*had to subtract from height to invert the y axis*/);
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
		coco.dispose();
		batch.dispose();
		texture.dispose();
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

package io.github.versatilevelociraptors.libgdxtest;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LibgdxTest implements ApplicationListener{
	
	public static final String TITLE = "LibGDX-Test";
	public static final int WIDTH = 640;
	public static final int HEIGHT = 360;
	public static final int SCALE = 2;
	
	private SpriteBatch batch;
	private Texture texture;
	private FPSLogger fps;
	
	private float r,g,b;
	
	private int timer;

	public static void main(String[] agrs){
		
		LwjglApplicationConfiguration configuration = new LwjglApplicationConfiguration();
		
		//disable frame limiter
		configuration.vSyncEnabled = true;
		configuration.foregroundFPS = 0;
		configuration.backgroundFPS = 0;
		
		//set window options
		configuration.title = TITLE;
		configuration.width = WIDTH * SCALE;
		configuration.height = HEIGHT * SCALE;
		
		new LwjglApplication(new LibgdxTest() , configuration);
	}
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		texture = new Texture("assets/images/VersatileVelociraptors.png");
		fps = new FPSLogger();
		timer = 30;
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
		batch.draw(texture , 0 , 0);
		batch.end();
		fps.log();
		timer--;
	}

	@Override
	public void dispose() {
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

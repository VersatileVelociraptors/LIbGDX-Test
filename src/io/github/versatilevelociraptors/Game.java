package io.github.versatilevelociraptors;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game implements ApplicationListener {
	
	public static final String TITLE = "LibGDX-Test";
	public static final int WIDTH = 640;
	public static final int HEIGHT = 360;
	public static final int SCALE = 2;
	
	private SpriteBatch batch;
	private Texture texture;
	private FPSLogger fps;
	

	@Override
	public void create() {
		batch = new SpriteBatch();
		texture = new Texture("assets/images/VersatileVelociraptors.png");
		fps = new FPSLogger();
	}
	
	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(texture , 0 , 0);
		batch.end();
		fps.log();
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

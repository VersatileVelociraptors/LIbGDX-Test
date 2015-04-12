package io.github.versatilevelociraptors.libgdxtest.States;

import io.github.versatilevelociraptors.libgdxtest.LibgdxTest;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class State {
	
	protected GameStateManager manager;
	protected SpriteBatch batch;
	protected OrthographicCamera cam;
	
	protected State(GameStateManager manager) {
		this.manager = manager;
		cam = new OrthographicCamera();
		cam.setToOrtho(false, LibgdxTest.getWidth(), LibgdxTest.getHeight());
		batch = manager.getSpriteBatch();
	}
	
	protected abstract void render();
	protected abstract void dispose();

}

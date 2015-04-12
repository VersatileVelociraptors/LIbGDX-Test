package io.github.versatilevelociraptors.libgdxtest;

import io.github.versatilevelociraptors.libgdxtest.States.CocoState;
import io.github.versatilevelociraptors.libgdxtest.States.GameStateManager;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class LibgdxTest implements ApplicationListener{

	public static final String TITLE = "LibGDX-Test";
	public static final int WIDTH = 640;
	public static final int HEIGHT = 360;
	public static final double SCALE = 1.5;

	private GameStateManager manager;

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
		manager = new GameStateManager();
		manager.push(new CocoState(manager));
		
	}

	@Override
	public void render() {
		manager.render();
	}

	public static int getHeight(){
		return (int)(HEIGHT*SCALE);
	}

	public static int getWidth(){
		return (int)(WIDTH*SCALE);
	}

	@Override
	public void dispose() {
		manager.dispose();
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

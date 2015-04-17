package io.github.versatilevelociraptors.libgdxtest;

import io.github.versatilevelociraptors.libgdxtest.states.CocoState;
import io.github.versatilevelociraptors.libgdxtest.states.GameStateManager;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class LibgdxTest implements ApplicationListener{

	public static final String TITLE = "LibGDX-Test";
	private static final int WIDTH = 640;
	private static final int HEIGHT = 360;
	public static final double SCALE = 1.5;

	public static final float STEP = 1/60f;
	private static float frameTime;

	private GameStateManager manager;

	public static void main(String[] agrs){

		LwjglApplicationConfiguration configuration = new LwjglApplicationConfiguration();

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
		frameTime +=  Gdx.graphics.getDeltaTime();
		while(frameTime >= STEP){
			frameTime -= STEP;
			manager.render();
		}
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
	public void resize(int width, int height) {
	}

	@Override
	public void resume() {
	}

}

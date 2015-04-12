package io.github.versatilevelociraptors;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class LibgdxTest {

	public static void main(String[] agrs){
		
		LwjglApplicationConfiguration configuration = new LwjglApplicationConfiguration();
		
		//disable frame limiter
		configuration.vSyncEnabled = false;
		configuration.foregroundFPS = 0;
		configuration.backgroundFPS = 0;
		
		//set window options
		configuration.title = Game.TITLE;
		configuration.width = Game.WIDTH * Game.SCALE;
		configuration.height = Game.HEIGHT * Game.SCALE;
		
		new LwjglApplication(new Game() , configuration);
	}
}

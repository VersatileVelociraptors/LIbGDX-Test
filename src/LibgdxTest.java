import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class LibgdxTest {

	public static void main(String[] agrs){
		
		LwjglApplicationConfiguration configuration = new LwjglApplicationConfiguration();
		
		configuration.title = Game.TITLE;
		configuration.width = Game.WIDTH * Game.SCALE;
		configuration.height = Game.HEIGHT * Game.SCALE;
		
		new LwjglApplication(new Game() , configuration);
	}
}

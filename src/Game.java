import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game implements ApplicationListener {
	
	public static final String TITLE = "LibGDX-Test";
	public static final int WIDTH = 360;
	public static final int HEIGHT = 200;
	public static final int SCALE = 3;
	
	private SpriteBatch batch;
	private Texture texture;
	

	@Override
	public void create() {
		batch = new SpriteBatch();
		texture = new Texture("sprite/VersatileVelociraptors.png");
	}
	
	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(texture , 0 , 0);
		batch.end();
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

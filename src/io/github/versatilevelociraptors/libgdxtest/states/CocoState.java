package io.github.versatilevelociraptors.libgdxtest.states;

import io.github.versatilevelociraptors.libgdxtest.LibgdxTest;
import io.github.versatilevelociraptors.libgdxtest.entities.CocoGuy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.backends.lwjgl.audio.Mp3.Sound;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CocoState extends State {

	public static final boolean COPS = true;

	private SpriteBatch batch;
	private BitmapFont font , textFont;
	private Texture versatileVelociraptors;
	private FPSLogger fps;

	private float red,green,blue;
	private double textX, textY;

	private int timer;

	private Sound coco;

	private boolean CocoStopped;

	private CocoGuy cocoGuy;

	public CocoState(GameStateManager manager){
		super(manager);

		batch = new SpriteBatch();
		versatileVelociraptors = new Texture("assets/images/VersatileVelociraptors.png");
		fps = new FPSLogger();
		timer = 30;
		font = new BitmapFont();
		textFont = new BitmapFont();
		coco = (Sound) Gdx.audio.newSound(Gdx.files.internal("assets/music/coco.mp3"));
		coco.loop(.4f);
		cocoGuy = new CocoGuy(10,10);
	}

	@Override
	protected void render() {
		if(timer == 0){
			red = (float)Math.random();
			green = (float)Math.random();
			blue = (float)Math.random();

			textX = Math.random() * LibgdxTest.getWidth();
			textY = Math.random() * LibgdxTest.getHeight();

			timer = 30;
		}

		// the s key start/stops music
		if(Gdx.input.isKeyJustPressed(Input.Keys.S)){
			if(CocoStopped)
				coco.loop(.4f);
			else
				coco.stop();
			CocoStopped = !CocoStopped;
		}

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl20.glClearColor(red, green, blue, 1);
		batch.begin();

		// had to subtract from height to invert the y axis
		batch.draw(versatileVelociraptors , Gdx.input.getX() - versatileVelociraptors.getWidth()/2, LibgdxTest.getHeight() - Gdx.input.getY() - versatileVelociraptors.getHeight()/2);
		cocoGuy.render(batch);		
		font.setColor(1.0f - red, 1.0f - green, 1.0f - blue, 1.0f);
		textFont.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		font.draw(batch, "SMOKE WEED EVERYDAY", (int)textX , (int)textY);
		if(CocoStopped){
			textFont.draw(batch, "Press 's' to start coco", 5, 18);
		}else{
			textFont.draw(batch, "Press 's' to stop coco", 5, 18);
		}
		textFont.draw(batch, Gdx.graphics.getFramesPerSecond() + " FPS", 0, LibgdxTest.getHeight());

		batch.end();
		fps.log();
		timer--;

	}

	@Override
	protected void dispose() {
		if(COPS)
			coco.dispose();
		batch.dispose();
		versatileVelociraptors.dispose();
		cocoGuy.dispose();
		font.dispose();
	}
}

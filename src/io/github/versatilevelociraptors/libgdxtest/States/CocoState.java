package io.github.versatilevelociraptors.libgdxtest.States;

import io.github.versatilevelociraptors.libgdxtest.LibgdxTest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.backends.lwjgl.audio.Mp3.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CocoState extends State {

	public static final boolean COPS = true;

	private SpriteBatch batch;
	private BitmapFont font;
	private Texture texture;
	private FPSLogger fps;

	private float r,g,b;
	private double text_x, text_y;

	private int timer;

	private Sound coco;

	public CocoState(GameStateManager manager){
		super(manager);

		batch = new SpriteBatch();
		texture = new Texture("assets/images/VersatileVelociraptors.png");
		fps = new FPSLogger();
		timer = 30;
		font = new BitmapFont();
		coco = (Sound) Gdx.audio.newSound(Gdx.files.internal("assets/music/coco.mp3"));
		coco.play(.4f);
	}

	@Override
	protected void render() {
		if(timer == 0){
			r = (float)Math.random();
			g = (float)Math.random();
			b = (float)Math.random();

			text_x = Math.random() * LibgdxTest.getWidth();
			text_y = Math.random() * LibgdxTest.getHeight();

			timer = 30;
		}

		if(Gdx.input.isKeyPressed(Input.Keys.S))
			coco.stop();

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl20.glClearColor(r, g, b, 1);
		batch.begin();
		batch.draw(texture , Gdx.input.getX() - texture.getWidth()/2, LibgdxTest.getHeight() - Gdx.input.getY() - texture.getHeight()/2/*had to subtract from height to invert the y axis*/);
		font.setColor(new Color(1.0f - r, 1.0f - g, 1.0f - b, 1.0f));
		font.draw(batch, "SMOKE WEED EVERYDAY", (int)text_x, (int)text_y);
		font.draw(batch, "Press 's' to stop coco", 20, 20);
		batch.end();
		fps.log();
		timer--;

	}

	@Override
	protected void dispose() {
		if(COPS)
			coco.dispose();
		batch.dispose();
		texture.dispose();
		font.dispose();
	}
}

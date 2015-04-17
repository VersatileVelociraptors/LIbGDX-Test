package io.github.versatilevelociraptors.libgdxtest.entities;

import io.github.versatilevelociraptors.libgdxtest.LibgdxTest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CocoGuy {

	private final Texture COCO_GUY;

	private int speedX, speedY;
	private int locationX, locationY;

	public CocoGuy(){
		COCO_GUY = new Texture("assets/images/cocoGuy.png");
		speedX = 3;
		speedY = 3;
		locationX = 60;
		locationY = 60;
	}

	public CocoGuy(int speedX , int speedY){
		COCO_GUY = new Texture("assets/images/cocoGuy.png");
		this.speedX = speedX;
		this.speedY = speedY;
		locationX = 60;
		locationY = 60;
	}

	public CocoGuy(int speedX , int speedY , int locationX , int locationY){
		COCO_GUY = new Texture("assets/images/cocoGuy.png");
		this.speedX = speedX;
		this.speedY = speedY;
		//TODO throw an error if not bound in the area
		this.locationX = locationX;
		this.locationY = locationY;
	}


	public int getSpeedX(){
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && Gdx.input.isKeyPressed(Input.Keys.LEFT))
			return 0;
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
			return speedX;
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
			return -speedX;
		return 0;
	}

	public int getSpeedY(){
		if(Gdx.input.isKeyPressed(Input.Keys.UP) && Gdx.input.isKeyPressed(Input.Keys.DOWN))
			return 0;
		if(Gdx.input.isKeyPressed(Input.Keys.UP))
			return speedY;
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
			return -speedY;
		return 0;
	}

	public int getLocationX(){
		boolean leftCondition = locationX >= 0 || getSpeedX() >= 0;
		boolean rightCondition = locationX+getTexture().getWidth() <= LibgdxTest.getWidth() || getSpeedX() <= 0;
		if(leftCondition &&  rightCondition)
			locationX += getSpeedX();
		locationX = locationX < 0 ? 0 : locationX;
		locationX = locationX+getTexture().getWidth() > LibgdxTest.getWidth() ? LibgdxTest.getWidth()-getTexture().getWidth() : locationX ;
		return locationX;
	}

	public int getLocationY(){
		boolean botomCondition = locationY >= 0 || getSpeedY() >= 0;
		boolean topCondition = locationY+getTexture().getHeight() <= LibgdxTest.getHeight() || getSpeedY() <= 0;
		if(botomCondition && topCondition)
			locationY += getSpeedY();
		locationY = locationY < 0 ? 0 : locationY;
		locationY = locationY+getTexture().getHeight() > LibgdxTest.getHeight() ? LibgdxTest.getHeight()-getTexture().getHeight() : locationY ;
		return locationY;
	}

	public void render(SpriteBatch batch){
		batch.draw(getTexture() , getLocationX() , getLocationY());
	}

	public Texture getTexture(){
		return COCO_GUY;
	}

	public void dispose(){
		COCO_GUY.dispose();
	}

}

package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;




public class MyGdxGame implements Screen {


	private Camera cam;
	private GameCore game;
	private Texture mapa;
	private Sprite auto;
	float autoX = 400;
	float autoY = 240;
	float ruchX=0;
	float ruchY=0;
	int vMax = 30;
	float speed=0;
	float acceleration=2;
	float clock=0;
	float acc=Gdx.input.getAccelerometerY();
			//2m/s2
	float breakForce=5;
	short win=0;
	private Pixmap pixmap;
	BitmapFont font = new BitmapFont();

	public MyGdxGame(GameCore game) {


		this.game = game;
		pixmap= new Pixmap(Gdx.files.internal("collisionMap.png"));
		cam = new OrthographicCamera(800,480);
		mapa = new Texture("mapa.png");
		auto = new Sprite(new Texture(Gdx.files.internal("Audi.png")));
		auto.setPosition(400,240);
		cam.position.set(400,240,0);
		autoX=120;
		autoY=580;
		speed=0;
		auto.setRotation(180);

	}
	private void ruch(){

		if(acc>10){acc=10;}
		auto.rotate(acc);
		cam.rotate(acc, 0, 0, 1);

		cam.position.set(autoX,autoY,0);
		if(speed<0){speed=0;}
	}
	private void gaz(){
		speed+=acceleration;
		if(speed>vMax){speed=vMax;}
		ruchX=speed*Gdx.graphics.getDeltaTime() * MathUtils.cos((float)((Math.PI / 180) * ( auto.getRotation() + 90 )));
		ruchY=speed*Gdx.graphics.getDeltaTime() * MathUtils.sin((float)((Math.PI / 180) * ( auto.getRotation() + 90 )));
		auto.setPosition(autoX+=ruchX,autoY+=ruchY);
		cam.position.set(autoX,autoY,0);
	}


	@Override
	public void show() {

	}

	@Override
	public void render(float delta) {
	if (speed>0) {
		ruch();
		}
		if(true) {
			gaz();
		}
		else{speed-=breakForce;}
		acc=Gdx.input.getAccelerometerY();
		//Gdx.app.log("ACC","DZIALAM"+ acc);
		clock+=1*Gdx.graphics.getDeltaTime();
		Gdx.app.log("CLOCK","DZIALAM"+ clock);
		cam.update();
		game.batch.setProjectionMatrix(cam.combined);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		pixmap.drawPixmap(pixmap,0,0);

		game.batch.begin();
		game.batch.draw(mapa,0,0);
		font.draw(game.batch,"Gratulacje, twoj cza to:"+clock,10,10);
		auto.draw(game.batch);
		game.batch.end();

		int kodKoloru=pixmap.getPixel((int)autoX,(int)autoY);
		Color color = new Color(kodKoloru);
		int blue=(int)(color.b*255);
		int green=(int)(color.g*255);
		int red=(int)(color.r*255);
		//Gdx.app.log("KOLOR","DZIALAM"+ blue);
		if(blue==255){
			autoX=120;
			autoY=580;
			speed=0;
			auto.setRotation(180);
		}
		if(green==255){
			win=1;
		}
		if(green==0&&red==0&&win==1){win=2;}
		if(red==255&&win==2){win=3;}

		if(win==3){
			this.dispose();
			game.setScreen(new Winner(game,clock));
		}
	}


	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose() {

	}
}

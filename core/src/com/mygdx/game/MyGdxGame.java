package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture audi;
	Texture siatka;
	Texture mapa;
	OrthographicCamera camera;
	float auto_x, auto_y;
	@Override
	public void create () {
		batch = new SpriteBatch();
		audi = new Texture("Audi.png");
		mapa = new Texture("mapa.png");
		siatka = new Texture("siatka.png");
		camera= new OrthographicCamera(800,480);
		auto_x=0;
		auto_y=0;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if(auto_y<800){++auto_y;
		++auto_x;}
		else{
			--auto_y;
			--auto_x;

		}
		batch.begin();
		{
			camera.setToOrtho(false, 800,480);
			camera.update();
			batch.setProjectionMatrix(camera.combined);
			batch.draw(mapa, 0-auto_x, 0-auto_y);
			batch.draw(siatka, 0, 0);
			camera.setToOrtho(false, 800,480);
			camera.update();
			batch.draw(audi, 10, 10);

		}
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}

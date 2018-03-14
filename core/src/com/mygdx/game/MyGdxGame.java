package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;



public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture audi;
	Texture siatka;
	Texture mapa;
	Texture a;
	Texture c;
	Texture r;
	Texture g;
	Texture m;
	Texture e;
	Music music;


	Sprite auto;
	OrthographicCamera camera;
	float auto_x, auto_y;
	boolean menu=true;





	@Override
	public void create () {
		Music music = Gdx.audio.newMusic(Gdx.files.internal("menuMusic.wav"));
		batch = new SpriteBatch();
		audi = new Texture("Audi.png");
		mapa = new Texture("mapa.png");
		siatka = new Texture("siatka.png");
		a = new Texture("a.png");
		c = new Texture("c.png");
		r = new Texture("r.png");
		g = new Texture("g.png");
		m = new Texture("m.png");
		e = new Texture("e.png");
		camera= new OrthographicCamera(800,480);
		auto= new Sprite(audi);
		camera.position.set(camera.viewportWidth/2,camera.viewportHeight/2,0);
		auto_x=375;
		auto_y=215;
		music.play();
		music.setLooping(true);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		{
			if(menu) {

				Gdx.gl.glClearColor(0, 0, 0, 1);
				Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
				if (Gdx.input.isTouched()) {
				menu=false;
				music.stop();
				}
				batch.draw(c, 440, 250);
				batch.draw(a, 470, 250);
				batch.draw(r, 500, 250);
				batch.draw(g, 430, 210);
				batch.draw(a, 460, 210);
				batch.draw(m, 490, 210);
				batch.draw(e, 520, 210);
			}
			else {

				batch.draw(mapa, 0, 0);
				batch.draw(siatka, 0, 0);
				auto.draw(batch);
			}
		}
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}

package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;


/**
 * Created by Wqawer on 2018-03-22.
 */

public class Winner implements Screen {
private float clock;
float height,width;
private BitmapFont font= new BitmapFont();
private GameCore game;
    public Winner(GameCore game,float clock) {
        this.game=game;
        this.clock=clock;
        height=Gdx.graphics.getHeight();
        width=Gdx.graphics.getWidth();

    }



    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        font.getData().setScale(3);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        font.draw(game.batch, "Gratulacje, twoj czas to:" + clock, width/2, height/2);
        game.batch.end();
        if (Gdx.input.isTouched()) {
            this.dispose();
            game.setScreen(new MyGdxGame(game));
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

    }}

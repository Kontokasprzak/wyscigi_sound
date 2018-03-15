package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Administrator on 2018-03-15.
 */

public class MenuScreen implements Screen {
    Texture a;
    Texture c;
    Texture r;
    Texture g;
    Texture m;
    Texture e;
    Music music;
    private GameCore game;
    public MenuScreen(GameCore game) {

        Music music = Gdx.audio.newMusic(Gdx.files.internal("menuMusic.wav"));
        this.game=game;
        a = new Texture("a.png");
        c = new Texture("c.png");
        r = new Texture("r.png");
        g = new Texture("g.png");
        m = new Texture("m.png");
        e = new Texture("e.png");
        music.play();
        music.setLooping(true);




    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(c, 440, 250);
        game.batch.draw(a, 470, 250);
        game.batch.draw(r, 500, 250);
        game.batch.draw(g, 430, 210);
        game.batch.draw(a, 460, 210);
        game.batch.draw(m, 490, 210);
        game.batch.draw(e, 520, 210);
        game.batch.end();
        if(Gdx.input.isTouched()){this.dispose();
            game.setScreen(new MyGdxGame());


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

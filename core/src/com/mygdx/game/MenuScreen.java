package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
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
   int height, width;
    Camera camera;
    private GameCore game;
    public MenuScreen(GameCore game) {

        camera=new OrthographicCamera(800,480);
        this.game=game;
        music = Gdx.audio.newMusic(Gdx.files.internal("menuMusic.wav"));
        a = new Texture("a.png");
        c = new Texture("c.png");
        r = new Texture("r.png");
        g = new Texture("g.png");
        m = new Texture("m.png");
        e = new Texture("e.png");
        music.play();
        music.setLooping(true);
        camera.position.set(0,0,0);
        height=Gdx.graphics.getHeight();
        width=Gdx.graphics.getWidth();



    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        game.batch.begin();
        game.batch.draw(c, width/2, height/2);
        game.batch.draw(a, 30+width/2, height/2);
        game.batch.draw(r, 60+width/2, height/2);
        game.batch.draw(g, (width/2)-30, (height/2)-30);
        game.batch.draw(a, width/2, (height/2)-30);
        game.batch.draw(m, 30+width/2, (height/2)-30);
        game.batch.draw(e, 60+width/2, (height/2)-30);
        game.batch.end();
        if(Gdx.input.isTouched()){this.dispose();
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
        music.dispose();
    }
}

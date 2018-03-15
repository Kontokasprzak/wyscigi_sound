package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Administrator on 2018-03-15.
 */

public class GameCore extends Game
{
    SpriteBatch batch;

    public GameCore() {
        super();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void create() {
        batch = new SpriteBatch();
        this.setScreen(new MenuScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }
}

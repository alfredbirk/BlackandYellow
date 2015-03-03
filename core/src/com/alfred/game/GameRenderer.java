package com.alfred.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;


/**
 * Created by Alfred on 03.03.2015.
 */
public class GameRenderer {

    private GameWorld myWorld;


    public GameRenderer(GameWorld world) {
        myWorld = world;
    }

    public void render() {
        Gdx.gl.glClearColor(0, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);




    }

}

package com.alfred.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.List;


/**
 * Created by Alfred on 03.03.2015.
 */
public class GameRenderer {

    private GameWorld myWorld;
    private SpriteBatch batch;

    public GameRenderer(GameWorld world) {
        myWorld = world;
        batch = new SpriteBatch();
    }

    public void render() {
        Gdx.gl.glClearColor(0, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        List<Line> lines = myWorld.getLines();

        batch.begin();
        batch.disableBlending();

        for(int i = 0; i < lines.size(); i++) {
            //Putt noe utenfor rending-metoden
            Line line = lines.get(i);
            Sprite lineSprite = new Sprite(AssetLoader.lineTexture);
            lineSprite.setRotation(line.getAngle());
            lineSprite.setX(line.getX());
            lineSprite.setY(line.getY());
            lineSprite.setOrigin(-10, lineSprite.getHeight()/2); //hardkoding
            lineSprite.draw(batch);
        }

        batch.end();


    }

}

package com.alfred.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Alfred on 03.03.2015.
 */

public class GameRenderer {

    private GameWorld myWorld;
    private SpriteBatch batch;

    List<Line> lines;
    List<Sprite> lineSprites;

    public GameRenderer(GameWorld world) {
        myWorld = world;
        batch = new SpriteBatch();
        lineSprites = new ArrayList<Sprite>();

        initGameObjects();
        initAssets();
    }

    private void initGameObjects() {
        lines = myWorld.getLines();
    }

    private void initAssets() {
        for(int i = 0; i < lines.size(); i++) {
            Line line = lines.get(i);
            Sprite lineSprite;
            if(line.getBlack()) {
                lineSprite = new Sprite(AssetLoader.blackLineTexture);
            }
            else {
                lineSprite = new Sprite(AssetLoader.yellowLineTexture);
            }

            lineSprite.setOrigin(-10, lineSprite.getHeight()/2); //hardkoding
            lineSprites.add(lineSprite);
        }
    }

    public void render() {
        Gdx.gl.glClearColor(0.3f, 0.3f, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        //batch.disableBlending();

        for(int i = 0; i < lines.size(); i++) {
            Line line = lines.get(i);
            Sprite lineSprite = lineSprites.get(i);
            lineSprite.setRotation(line.getAngle());
            lineSprite.setX(line.getX());
            lineSprite.setY(line.getY());
            lineSprite.draw(batch);
        }
        //batch.enableBlending();
        batch.end();


    }

}

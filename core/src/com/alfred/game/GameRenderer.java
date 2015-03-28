package com.alfred.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Alfred on 03.03.2015.
 */

public class GameRenderer {

    private GameWorld myWorld;
    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;
    private int lineOrigin = 15;

    List<Line> lines;
    List<Sprite> lineSprites;

    Dot dot;


    public GameRenderer(GameWorld world) {
        myWorld = world;
        batch = new SpriteBatch();
        lineSprites = new ArrayList<Sprite>();
        shapeRenderer = new ShapeRenderer();

        initGameObjects();
        initAssets();
    }

    private void initGameObjects() {

        lines = myWorld.getLines();
        dot = myWorld.getDot();

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

            lineSprite.setOrigin(-lineOrigin, lineSprite.getHeight()/2);
            lineSprites.add(lineSprite);
        }
    }

    public void render() {
        Gdx.gl.glClearColor(0.3f, 0.3f, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        //batch.disableBlending();
/*
        for(int i = 0; i < lines.size(); i++) {
            Line line = lines.get(i);
            Sprite lineSprite = lineSprites.get(i);
            lineSprite.setRotation(line.getAngle());
            lineSprite.setX(line.getX());
            lineSprite.setY(line.getY());
            lineSprite.draw(batch);


        }*/
        //batch.enableBlending();
        batch.end();

        for(int i = 0; i < lines.size(); i++) {
            Line line = lines.get(i);
            shapeRenderer.begin(ShapeType.Filled);
            shapeRenderer.setColor(Color.RED);
            shapeRenderer.rect(line.getBoundingLine().getX(), line.getBoundingLine().getY(), -lineOrigin, line.getBoundingLine().getHeight()/2, line.getBoundingLine().width, line.getBoundingLine().height, 1, 1, line.getAngle());
            shapeRenderer.end();
        }

        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.circle(dot.getBoundingDot().x, dot.getBoundingDot().y, 12);
        shapeRenderer.end();
    }

}

package com.alfred.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;


public class MyGdxGame implements InputProcessor, GestureDetector.GestureListener {

    private SpriteBatch batch;
    private Texture lineTexture;
    private Sprite line;
    private List<Line> lines;
    private float linePadding = -25;
    private float centerX = 400;
    private float centerY = 600;
    GestureDetector gestureDetector;

    public MyGdxGame() {
        lines = new ArrayList<Line>();
    }

    private void generateLevel() {
        Line line1 = new Line(centerX, centerY, 0);
        Line line2 = new Line(centerX, centerY, 90);
        Line line3 = new Line(centerX, centerY, 180);
        Line line4 = new Line(centerX, centerY, 270);

        lines.add(line1);
        lines.add(line2);
        lines.add(line3);
        lines.add(line4);
    }

    /*
    @Override
    public void create () {
        batch = new SpriteBatch();
        generateLevel();

        gestureDetector = new GestureDetector(this);
        Gdx.input.setInputProcessor(gestureDetector);
    }

    @Override
    public void dispose() {
        batch.dispose();
        lineTexture.dispose();
    }
    */



    public void renderLines() {
        int len = lines.size();
        for(int i = 0; i < len; i++) {
            Line line = lines.get(i);

            line.rotateLine();
            line.getSprite().setRotation(line.getAngle());
            line.getSprite().setX(line.getX());
            line.getSprite().setY(line.getY());
            line.getSprite().setOrigin(linePadding, line.getSprite().getHeight()/2);
            line.getSprite().draw(batch);
        }
    }

    /*
    @Override
    public void render () {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        batch.begin();
        renderLines();
        batch.end();
    }
    */


    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        int len = lines.size();
        for(int i = 0; i < len; i++) {
            Line line = lines.get(i);
            line.setSpeed(velocityX/500);
        }
        return true;
    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        return false;
    }



    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }







    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }


    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }



    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }


}

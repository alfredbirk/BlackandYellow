package com.alfred.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by Alfred on 02.03.2015
 */
public class Line {

    private float x;
    private float y;
    private float angle;
    private Texture img = new Texture("line.png");
    private Sprite sprite = new Sprite(img);

    public Line(float x, float y, float angle) {
        this.x = x;
        this.y = y;
        this.angle = angle;
    }

    public void rotateLine() {
        angle++;
    }

    public float getAngle() {
        return angle;
    }

    public float getX() {
        return x;
    }

    public float getY()
    {
        return y;
    }

    public Sprite getSprite() {
        return sprite;
    }
}

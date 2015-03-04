package com.alfred.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by Alfred on 02.03.2015..
 */
public class Line {

    private float x;
    private float y;
    private float angle;
    private float speed = 0;

    public Line(float x, float y, float angle) {
        this.x = x;
        this.y = y;
        this.angle = angle;
    }

    public void update(float delta) {
        rotateLine(speed);
        if(speed < 0) {
            speed = 0;
        }
    }

    public void onClick() {
        speed += 0.1;
    }

    public void rotateLine(float degrees) {
        angle += degrees;
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


    public void setSpeed(float speed) {
        this.speed += speed;
    }
}

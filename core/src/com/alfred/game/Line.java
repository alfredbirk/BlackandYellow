package com.alfred.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alfred on 02.03.2015..
 */
public class Line {

    private float x;
    private float y;
    private float angle;
    private float speed = 1;
    private int oldScreenX;
    private int oldScreenY;
    private float oldAngle;
    private float angleDiff;
    private List<Integer> xValues = new ArrayList<Integer>();
    private List<Integer> yValues = new ArrayList<Integer>();
    private int numStore = 3;
    private float friction = 0.99f;
    private boolean black;

    public Line(float x, float y, float angle, boolean black) {
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.black = black;
    }

    public void update(float delta) {

        if(speed > 0) {
            speed = speed * friction;
        }

        if(speed < 0) {
            speed = speed * friction;
        }

        rotateLine(speed);
    }

    public void onClick(int screenX, int screenY) {
        speed = 0;
        oldScreenX  = screenX;
        oldScreenY = screenY;
        xValues.clear();
        yValues.clear();

        for(int i = 0; i < numStore; i++) {
            xValues.add(oldScreenX);
            yValues.add(oldScreenY);
        }

        oldAngle = (float) Math.atan2(screenY - y, screenX - x);

    }

    public void onDrag(int screenX, int screenY) {

        float newAngle  = (float) Math.atan2(y - screenY, x - screenX);

        angleDiff = (float) Math.toDegrees(oldAngle - newAngle);
        rotateLine(angleDiff);


        oldAngle = newAngle;

        xValues.remove(0);
        yValues.remove(0);
        xValues.add(screenX);
        yValues.add(screenY);

    }

    public void onRelease(int screenX, int screenY) {

        float oldAngle2 = (float) Math.atan2(y - yValues.get(0), x - xValues.get(0));
        float newAngle2 = (float) Math.atan2(y - yValues.get(numStore - 1), x - xValues.get(numStore - 1));

        float angleDiff2 = (float) Math.toDegrees(oldAngle2 - newAngle2);

        setSpeed(angleDiff2 / numStore);
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

    public boolean getBlack() {
        return black;
    }


    public void setSpeed(float speed) {
        this.speed += speed;
    }
}

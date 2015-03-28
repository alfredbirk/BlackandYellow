package com.alfred.game;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;

/**
 * Created by Alfred on 28.03.2015.
 */
public class Dot {

    private float x;
    private float y;
    private float speed;
    private Circle boundingDot;

    public Dot(float x, float y, float speed){
        this.x = x;
        this.y = y;
        this.speed = speed;

        boundingDot = new Circle();
    }

    public void update(float delta) {

        x += speed;

        boundingDot.set(x, y, 12);

    }

    public void collides(Line line) {/*
        if(Intersector.overlaps(boundingDot, line.getBoundingLine())) {
            stop();
        }*/
    }

    public void stop() {
        setSpeed(0);
    }

    public float getX() {
        return x;
    }

    public float getY()
    {
        return y;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public Circle getBoundingDot() {
        return boundingDot;
    }

}

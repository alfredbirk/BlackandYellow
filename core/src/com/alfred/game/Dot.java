package com.alfred.game;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Alfred on 28.03.2015.
 */
public class Dot {

    private float x;
    private float y;
    private float speed;
    private Circle boundingDot;
    private boolean black;
    private float dir;

    public Dot(float x, float y, float speed, boolean black){
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.black = black;

        boundingDot = new Circle();

        float xDiff = x - GameWorld.centerX;
        float yDiff = y - GameWorld.centerY;
        dir = (float)Math.atan2(yDiff, xDiff);

    }

    public void update(float delta) {

        x -= speed * Math.cos(dir);
        y -= speed * Math.sin(dir);
        //y += 1;

        boundingDot.set(x, y, 12);

    }

    public void collides(Line line) {
        if(overlaps(line.getBoundingLine(), boundingDot)) {
            stop();
        }
    }

    public boolean overlaps(Polygon polygon, Circle circle) {
        float []vertices=polygon.getTransformedVertices();
        Vector2 center=new Vector2(circle.x, circle.y);
        float squareRadius=circle.radius*circle.radius;
        for (int i=0;i<vertices.length;i+=2){
            if (i==0){
                if (Intersector.intersectSegmentCircle(new Vector2(vertices[vertices.length-2], vertices[vertices.length-1]), new Vector2(vertices[i], vertices[i+1]), center, squareRadius))
                    return true;
            } else {
                if (Intersector.intersectSegmentCircle(new Vector2(vertices[i-2], vertices[i-1]), new Vector2(vertices[i], vertices[i+1]), center, squareRadius))
                    return true;
            }
        }
        return false;
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

    public boolean getBlack() {
        return black;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public Circle getBoundingDot() {
        return boundingDot;
    }

}

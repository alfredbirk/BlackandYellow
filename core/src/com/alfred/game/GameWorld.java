package com.alfred.game;


import com.badlogic.gdx.Gdx;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Alfred on 03.03.2015.
 */
public class GameWorld {

    private List<Line> lines;
    private Line line1;
    private Line line2;
    private Line line3;
    private Line line4;

    private List<Dot>  dots;
    private Dot dot;

    public static float centerX = Gdx.graphics.getWidth()/2;
    public static float centerY = Gdx.graphics.getHeight()/2;

    public GameWorld() {
        lines = new ArrayList();
        dots = new ArrayList();

        line1 = new Line(centerX, centerY, 0, true);
        line2 = new Line(centerX, centerY, 90, false);
        line3 = new Line(centerX, centerY, 180, true);
        line4 = new Line(centerX, centerY, 270, false);

        lines.add(line1);
        lines.add(line2);
        lines.add(line3);
        lines.add(line4);

    }

    public void update(float delta) {
        line1.update(delta);
        line2.update(delta);
        line3.update(delta);
        line4.update(delta);

        spawnDots();


        for(int i = 0; i < lines.size(); i++) {
            for(int j = 0; j < dots.size(); j++) {
                dots.get(j).collides(lines.get(i));
            }
        }

        for(Dot dot: dots) {
            dot.update(delta);
        }
    }

    public void spawnDots() {
        int x = randInt(0,100);
        if(x < 5) {
            spawnDot();
        }
    }

    public void spawnDot() {
        int x = 0;
        int y = 0;
        int speed = 3;

        boolean black = randInt(0, 1) == 0;

        int side = randInt(0, 3);
        switch(side) {
            case 0:
                x = randInt(0, (int)centerX * 2);
                y = 0;
                break;
            case 1:
                x = (int)centerX * 2;
                y = randInt(0, (int)centerY * 2);
                break;
            case 2:
                x = randInt(0, (int)centerX * 2);
                y = (int)centerY * 2;
                break;
            case 3:
                x = 0;
                y = randInt(0, (int)centerY * 2);
                break;
        }

        //x = 200;
        //y = 200;

        Dot dot = new Dot(x, y, speed, black);
        dots.add(dot);
    }

    public List<Line> getLines() {
        return lines;
    }


    public List<Dot> getDots() {
        return dots;
    }


    public static int randInt(int min, int max) {

        Random rand = new Random();

        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
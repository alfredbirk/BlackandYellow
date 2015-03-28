package com.alfred.game;


import com.badlogic.gdx.Gdx;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alfred on 03.03.2015.
 */
public class GameWorld {

    private List<Line> lines;
    private Line line1;
    private Line line2;
    private Line line3;
    private Line line4;

    private Dot dot;

    private float centerX = Gdx.graphics.getWidth()/2;
    private float centerY = Gdx.graphics.getHeight()/2;

    public GameWorld() {
        lines = new ArrayList();

        line1 = new Line(centerX, centerY, 0, true);
        line2 = new Line(centerX, centerY, 90, false);
        line3 = new Line(centerX, centerY, 180, true);
        line4 = new Line(centerX, centerY, 270, false);

        lines.add(line1);
        lines.add(line2);
        lines.add(line3);
        lines.add(line4);

        dot = new Dot(0, centerY, 2);
    }

    public void update(float delta) {
        line1.update(delta);
        line2.update(delta);
        line3.update(delta);
        line4.update(delta);

        dot.update(delta);

        for(int i = 0; i < lines.size(); i++) {
            dot.collides(lines.get(i));
        }
    }

    public List<Line> getLines() {
        return lines;
    }


    public Dot getDot() {
        return dot;
    }
}

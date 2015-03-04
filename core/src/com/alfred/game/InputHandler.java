package com.alfred.game;

import com.badlogic.gdx.InputProcessor;
import java.util.List;

/**
 * Created by Alfred on 03.03.2015.
 */
public class InputHandler implements InputProcessor {

    private List<Line> lines;

    public InputHandler(List<Line> lines) {
        this.lines = lines;
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
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        for(int i = 0; i < lines.size(); i++) {
            Line line = lines.get(i);
            line.onClick(screenX, screenY);
        }

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        for(int i = 0; i < lines.size(); i++) {
            Line line = lines.get(i);
            line.onRelease(screenX, screenY);
        }

        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {

        for(int i = 0; i < lines.size(); i++) {
            Line line = lines.get(i);
            line.onDrag(screenX, screenY);
        }
        return true;
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

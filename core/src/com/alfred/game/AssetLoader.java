package com.alfred.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Alfred on 03.03.2015.
 */
public class AssetLoader {

    public static Texture blackLineTexture;
    public static Texture yellowLineTexture;

    public static void load() {
        blackLineTexture  = new Texture(Gdx.files.internal("blackLine.png"));
        yellowLineTexture  = new Texture(Gdx.files.internal("yellowLine.png"));

    }

    public static void dispose() {

        blackLineTexture.dispose();
        yellowLineTexture.dispose();
    }

}

package com.alfred.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Alfred on 03.03.2015.
 */
public class AssetLoader {

    public static Texture lineTexture;

    public static void load() {
        lineTexture  = new Texture(Gdx.files.internal("line.png"));
    }

    public static void dispose() {
        lineTexture.dispose();
    }

}

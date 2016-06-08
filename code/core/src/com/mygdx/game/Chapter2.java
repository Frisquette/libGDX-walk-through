package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Chapter2 {
    private BitmapFont  font_;
    private GlyphLayout glyphLayout_;
    private float       textWidth_;
    private float       textHeight_;

    public void create () {
        font_ = new BitmapFont(Gdx.files.internal("chapter-2/my-font.fnt"));
        glyphLayout_ = new GlyphLayout();
        glyphLayout_.setText(font_, "Hello World!");
    }

    public void dispose() {
        font_.dispose();
    }

    public void render(SpriteBatch batch)
    {
        font_.draw(batch, "Hello World!", Gdx.graphics.getWidth() / 2 - glyphLayout_.width / 2,
                            Gdx.graphics.getHeight() / 2 - glyphLayout_.height / 2);
    }

}

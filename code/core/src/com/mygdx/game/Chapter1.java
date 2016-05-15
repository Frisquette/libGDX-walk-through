package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Chapter1 {
    private Texture logoTexture_;
    private Sprite  logoSprite_;

    public void create () {
        logoTexture_ = new Texture("chapter-1/github-logo.png");
        logoSprite_ = new Sprite(logoTexture_);
        logoSprite_.setOrigin(logoSprite_.getWidth() / 2, logoSprite_.getHeight() / 2);
        logoSprite_.setPosition(Gdx.graphics.getWidth() / 2 - logoSprite_.getOriginX(),
                                Gdx.graphics.getHeight() / 2 - logoSprite_.getOriginY());
    }

    public void render(SpriteBatch batch)
    {
        logoSprite_.draw(batch);
    }

}

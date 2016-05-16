package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Chapter1 {
    private Texture logoTexture_;
    private Sprite  logoSprite_;

    private final float velocity_ = 0.5f;

    public void create () {
        logoTexture_ = new Texture("chapter-1/github-logo.png");
        logoSprite_ = new Sprite(logoTexture_);
        //logoSprite_.setOrigin(logoSprite_.getWidth() / 2, logoSprite_.getHeight() / 2);
        // First attempt to center the image
        logoSprite_.setPosition(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        //logoSprite_.setPosition(Gdx.graphics.getWidth() / 2 - logoSprite_.getOriginX(),
          //                      Gdx.graphics.getHeight() / 2 - logoSprite_.getOriginY());
    }

    public void dispose() {
        logoTexture_.dispose();
        // Or
        logoSprite_.getTexture().dispose();
    }

    public void render(SpriteBatch batch)
    {
        // First render with Texture
        //batch.draw(logoTexture_, 0, 0);
        // Static Sprite drawing
        logoSprite_.draw(batch);
        //logoSprite_.setX(logoSprite_.getX() + velocity_);
        //logoSprite_.draw(batch);
    }

}

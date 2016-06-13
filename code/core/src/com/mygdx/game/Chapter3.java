package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Chapter3 {

    private Sprite logoSprite_;

    public void create () {
        logoSprite_ = new Sprite(new Texture("chapter-3/mario.png"));
    }

    public void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.D))
            logoSprite_.translateX(100f * Gdx.graphics.getDeltaTime());
        if (Gdx.input.isKeyPressed(Input.Keys.A))
            logoSprite_.translateX(-100f * Gdx.graphics.getDeltaTime());
        if (Gdx.input.isKeyPressed(Input.Keys.W))
            logoSprite_.translateY(100f * Gdx.graphics.getDeltaTime());
        if (Gdx.input.isKeyPressed(Input.Keys.S))
            logoSprite_.translateY(-100f * Gdx.graphics.getDeltaTime());

        moveToMouse();
    }

    public void moveToMouse() {
        logoSprite_.setPosition(Gdx.input.getX() - logoSprite_.getOriginX(),
                Gdx.graphics.getHeight() - Gdx.input.getY() - logoSprite_.getOriginY());

        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            logoSprite_.setPosition(0f, 0f);
        }
        else if(Gdx.input.isButtonPressed(Input.Buttons.RIGHT)) {
            float xPos = Gdx.graphics.getWidth() - logoSprite_.getWidth();
            float yPos = Gdx.graphics.getHeight() - logoSprite_.getHeight();
            logoSprite_.setPosition(xPos, yPos);
        }
    }

    public void render(SpriteBatch batch) {
        logoSprite_.draw(batch);
    }

}

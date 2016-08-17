package com.mygdx.pong;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Racket {

    private int     initX_;
    private int     initY_;

    private Sprite  sprite_;

    public Racket(int x, int y) {
        sprite_ = new Sprite(new Texture("pong/racket.png"));

        initX_ = x;
        initY_ = y;

        init();
    }

    public void moveUp(float deltaTime) {
        if (sprite_.getY() + sprite_.getHeight() < 580)
            sprite_.translateY(Const.RACKET_SPEED * deltaTime);
    }

    public void moveDown(float deltaTime) {
        if (sprite_.getY() > 20)
            sprite_.translateY(- Const.RACKET_SPEED * deltaTime);
    }

    public void init() {
        sprite_.setPosition(initX_, initY_ - sprite_.getHeight() / 2);
    }

    public Sprite getSprite() {
        return sprite_;
    }
}

package com.mygdx.pong;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Racket extends Sprite {

    int initX_;
    int initY_;

    public Racket(int x, int y) {
        super(new Texture("pong/racket.png"));

        initX_ = x;
        initY_ = y;
        this.setPosition(x, y  - this.getHeight() / 2);
    }

    public void moveUp(float deltaTime) {
        if (this.getY() + this.getHeight() < 580)
            this.translateY(Const.RACKET_SPEED * deltaTime);
    }

    public void moveDown(float deltaTime) {
        if (this.getY() > 20)
            this.translateY(- Const.RACKET_SPEED * deltaTime);
    }

    public void init() {
        this.setPosition(initX_, initY_ - this.getHeight() / 2);
    }
}

package com.mygdx.pong;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Racket extends Sprite {

    public Racket(int x, int y) {
        super(new Texture("pong/racket.png"));
        
        this.setPosition(x, y);
    }

    public void moveUp() {
        if (this.getY() + this.getHeight() < 580)
            this.translateY(7.0f);
    }

    public void moveDown() {
        if (this.getY() > 20)
            this.translateY(-7.0f);
    }
}

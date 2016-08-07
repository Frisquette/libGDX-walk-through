package com.mygdx.pong;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Ball extends Sprite {

    private final Vector2 normal = new Vector2(0, 1);
    private Vector2 direction_;

    public Ball(int x, int y) {
        super(new Texture("pong/ball.png"));

        this.setOrigin(10, 10);
        this.setPosition(x, y);
    }

    public void update() {
        this.translate(direction_.x * 8, direction_.y * 8);
    }

    public void setDirection(Vector2 direction) {
        direction.nor();
        direction_ = direction;
    }

    public Vector2 getDirection() {
        return direction_;
    }
}

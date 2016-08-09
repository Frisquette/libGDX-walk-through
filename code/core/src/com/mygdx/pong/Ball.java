package com.mygdx.pong;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Ball {

    private Sprite  sprite_;
    private Vector2 direction_;

    public Ball(int x, int y) {
        sprite_ = new Sprite(new Texture("pong/ball.png"));
        init(x, y);
    }

    public void update(float deltaTime) {
        sprite_.translate(direction_.x * Const.BALL_SPEED * deltaTime,
                          direction_.y * Const.BALL_SPEED * deltaTime);
    }

    public void init(int x, int y) {
        sprite_.setPosition(x, y);
        if (2 * (float)Math.random() - 1.0f <= 0.0f)
            setDirection(new Vector2(-1.0f, 0.0f));
        else
            setDirection(new Vector2(1.0f, 0.0f));
    }

    public void setDirection(Vector2 direction) {
        direction.nor();
        direction_ = direction;
    }

    public Vector2 getDirection() {
        return direction_;
    }

    public Sprite getSprite() {
        return sprite_;
    }
}

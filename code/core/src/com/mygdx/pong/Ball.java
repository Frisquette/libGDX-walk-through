package com.mygdx.pong;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Ball extends Sprite {

    private final Vector2 normal = new Vector2(0, 1);
    private Vector2 direction_;

    public Ball() {
        super(new Texture("pong/ball.png"));
    }

    public void update(float deltaTime) {
        this.translate(direction_.x * Const.BALL_SPEED * deltaTime,
                       direction_.y * Const.BALL_SPEED * deltaTime);
    }

    public void setDirection(Vector2 direction) {
        direction.nor();
        direction_ = direction;
    }

    public Vector2 getDirection() {
        return direction_;
    }

    public void init(int x, int y) {
        this.setPosition(x, y);
        if (2 * (float)Math.random() - 1.0f <= 0.0f)
            setDirection(new Vector2(-1.0f, 0.0f));
        else
            setDirection(new Vector2(1.0f, 0.0f));
    }
}

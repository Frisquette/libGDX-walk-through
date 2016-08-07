package com.mygdx.pong.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.pong.Ball;
import com.mygdx.pong.Racket;

public class PongScreen {

    private Texture terrainTexture_;

    private Racket  racketLeft_;
    private Racket  racketRight_;
    private Ball    ball_;

    private Vector2 normal_;

    private boolean paused_;
    private boolean gameOver_;

    public PongScreen() {
        terrainTexture_ = new Texture("pong/terrain.png");

        racketLeft_ = new Racket(0, 300);
        racketRight_ = new Racket(780, 300);

        ball_ = new Ball(390, 290);
        //Vector2 direction = new Vector2((float)Math.random(), (float)Math.random());
        Vector2 direction = new Vector2(-1, 0);
        ball_.setDirection(direction);

        normal_ = new Vector2(0, -1);
    }

    public void update() {

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE))
            paused_ = !paused_;

        if (paused_ || gameOver_)
            return;

        if (Gdx.input.isKeyPressed(Input.Keys.Z))
            racketLeft_.moveUp();
        else if (Gdx.input.isKeyPressed(Input.Keys.S))
            racketLeft_.moveDown();

        if (Gdx.input.isKeyPressed(Input.Keys.I))
            racketRight_.moveUp();
        else if (Gdx.input.isKeyPressed(Input.Keys.K))
            racketRight_.moveDown();

        // Updates the ball
        checkTerrainCollisions();
        checkRacketCollision();

        ball_.update();
        if (ball_.getX() <= 0 || ball_.getX() >= 800)
            gameOver_ = true;
    }

    public void render(SpriteBatch batch) {
        // Draws the background
        batch.draw(terrainTexture_, 0, 0);
        // Draws the two players rackets
        racketLeft_.draw(batch);
        racketRight_.draw(batch);
        // Draws the ball
        ball_.draw(batch);
    }

    private void checkTerrainCollisions() {

        Vector2 direction = ball_.getDirection();
        if (ball_.getY() >= 560) {
            float dot = 2 * direction.dot(normal_.scl(-1));
            ball_.setDirection(direction.sub(normal_.scl(dot)));
        }
        else if (ball_.getY() <= 20) {
            float dot = 2 * direction.dot(normal_);
            ball_.setDirection(direction.sub(normal_.scl(dot)));
        }
    }

    private void checkRacketCollision() {
        Rectangle rec1 = racketLeft_.getBoundingRectangle();
        Rectangle rec2 = racketRight_.getBoundingRectangle();

        if (rec1.overlaps(ball_.getBoundingRectangle())) {
            ball_.setDirection(new Vector2(1, 0));
                System.out.println("teeeesty");
        }
        if (rec2.overlaps(ball_.getBoundingRectangle()))
            ball_.setDirection(new Vector2(-1, 0));
    }
}

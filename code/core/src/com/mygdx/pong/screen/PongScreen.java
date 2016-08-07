package com.mygdx.pong.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.pong.Ball;
import com.mygdx.pong.Racket;

public class PongScreen {

    private Texture terrainTexture_;

    private Racket  racketLeft_;
    private Racket  racketRight_;
    private Ball    ball_;

    private boolean paused_;

    public PongScreen() {
        terrainTexture_ = new Texture("pong/terrain.png");

        racketLeft_ = new Racket(0, 300);
        racketRight_ = new Racket(780, 300);

        ball_ = new Ball(390, 290);
        Vector2 direction = new Vector2((float)Math.random(), (float)Math.random());
        ball_.setDirection(direction);
    }

    public void resize(int w, int h) {
    }

    public void update() {

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE))
            paused_ = !paused_;

        if (paused_)
            return;

        if (Gdx.input.isKeyPressed(Input.Keys.Z))
            racketLeft_.translateY(7.0f);
        else if (Gdx.input.isKeyPressed(Input.Keys.S))
            racketLeft_.translateY(-7.0f);

        if (Gdx.input.isKeyPressed(Input.Keys.I))
            racketRight_.translateY(7.0f);
        else if (Gdx.input.isKeyPressed(Input.Keys.K))
            racketRight_.translateY(-7.0f);

        // Updates the ball
        checkTerrainCollisions();
        checkRacketCollision();
        ball_.update();
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
        if (ball_.getY() >= 560) {
            Vector2 direction = ball_.getDirection();
            Vector2 normal = new Vector2(0, -1);
            float dot = 2 * direction.dot(normal.scl(-1));
            ball_.setDirection(direction.sub(normal.scl(dot)));
        }
        else if (ball_.getY() <= 20) {
            Vector2 direction = ball_.getDirection();
            Vector2 normal = new Vector2(0, -1);
            float dot = 2 * direction.dot(normal.scl(1));
            ball_.setDirection(direction.sub(normal.scl(dot)));
        }
    }

    private void checkRacketCollision() {
        
    }
}

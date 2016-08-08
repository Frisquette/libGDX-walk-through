package com.mygdx.pong.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.pong.Ball;
import com.mygdx.pong.Racket;

public class PongScreen {

    private Texture terrainTexture_;

    private Racket      racketLeft_;
    private Racket      racketRight_;
    private Ball        ball_;

    private BitmapFont  font_;

    private int         scoreLeft_;
    private int         scoreRight_;

    private boolean     paused_;
    private boolean     gameOver_;

    public PongScreen() {
        terrainTexture_ = new Texture("pong/terrain.png");

        font_ = new BitmapFont(Gdx.files.internal("pong/font.fnt"));

        racketLeft_ = new Racket(0, 300);
        racketRight_ = new Racket(780, 300);

        ball_ = new Ball();
        ball_.init(390, 290);
    }

    public void update() {

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE))
            paused_ = !paused_;
        else if (Gdx.input.isKeyPressed(Input.Keys.R) && gameOver_)
            reset();

        if (paused_ || gameOver_)
            return;

        // Updates rackets
        if (Gdx.input.isKeyPressed(Input.Keys.Z))
            racketLeft_.moveUp(Gdx.graphics.getDeltaTime());
        else if (Gdx.input.isKeyPressed(Input.Keys.S))
            racketLeft_.moveDown(Gdx.graphics.getDeltaTime());

        if (Gdx.input.isKeyPressed(Input.Keys.I))
            racketRight_.moveUp(Gdx.graphics.getDeltaTime());
        else if (Gdx.input.isKeyPressed(Input.Keys.K))
            racketRight_.moveDown(Gdx.graphics.getDeltaTime());

        // Updates the ball
        ball_.update(Gdx.graphics.getDeltaTime());

        checkTerrainCollisions();
        checkRacketCollision();
        gameOver_ = checkGameOver();
    }

    public void render(SpriteBatch batch) {
        // Draws the background
        batch.draw(terrainTexture_, 0, 0);
        // Draws the two players rackets
        racketLeft_.draw(batch);
        racketRight_.draw(batch);
        // Draws the ball
        ball_.draw(batch);
        // Draws the score
        font_.draw(batch, "" + scoreLeft_, 200, 540);
        font_.draw(batch, "" + scoreRight_, 600, 540);
    }

    private void checkTerrainCollisions() {
        Vector2 direction = ball_.getDirection();
        if (ball_.getY() >= 560 ||ball_.getY() <= 20)
            ball_.setDirection(new Vector2(direction.x, direction.y * -1));
    }

    private void checkRacketCollision() {
        Rectangle rec1 = racketLeft_.getBoundingRectangle();
        Rectangle rec2 = racketRight_.getBoundingRectangle();

        if (rec1.overlaps(ball_.getBoundingRectangle()))
            ball_.setDirection(getCollisionDirection(racketLeft_, ball_.getY() + ball_.getHeight() / 2));
        if (rec2.overlaps(ball_.getBoundingRectangle())) {
            Vector2 dir = getCollisionDirection(racketRight_, ball_.getY() + ball_.getHeight() / 2);
            dir.x *= -1;
            ball_.setDirection(dir);
        }
    }

    private Vector2 getCollisionDirection(Racket r, float collisionPointY) {

        Vector2 direction = new Vector2(1, 0);

        // Upper part of the racket
        direction.y = Math.abs((r.getY() + r.getHeight() / 2) - collisionPointY) / (r.getHeight() / 2) * 0.6f;
        if ((collisionPointY < r.getY() + r.getHeight() / 2))
            direction.y *= -1;

        return direction;
    }

    private boolean checkGameOver() {
        if (ball_.getX() <= -20) {
            ++scoreRight_;
            return true;
        }
        else if (ball_.getX() >= 800) {
            ++scoreLeft_;
            return true;
        }
        return false;
    }

    private void reset() {
        gameOver_ = false;
        ball_.init(390, 290);
        racketLeft_.init();
        racketRight_.init();
    }
}

package com.mygdx.pong.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.pong.Racket;

public class PongScreen {

    private Texture terrainTexture_;

    private Racket  racketLeft_;
    private Racket  racketRight_;

    public PongScreen() {
        terrainTexture_ = new Texture("pong/terrain.png");

        racketLeft_ = new Racket(0, 300);
        racketRight_ = new Racket(780, 300);
    }

    public void resize(int w, int h) {
    }

    public void update() {
    }

    public void render(SpriteBatch batch) {
        // Draws the background
        batch.draw(terrainTexture_, 0, 0);
        // Draws the two players rackets
        racketLeft_.draw(batch);
        racketRight_.draw(batch);
    }
}

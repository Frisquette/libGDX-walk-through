package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.pong.screen.PongScreen;

public class Main extends ApplicationAdapter {
	private SpriteBatch batch_;

	private PongScreen 	pongScreen_;

	@Override
	public void create () {
		batch_ = new SpriteBatch();
		pongScreen_ = new PongScreen();
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// Updates the scene
		pongScreen_.update();
		// Draws the scene
		batch_.begin();
		pongScreen_.render(batch_);
		batch_.end();
	}
}

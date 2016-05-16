package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main extends ApplicationAdapter {
	private SpriteBatch batch_;

    private Chapter1 chapter1_;
	
	@Override
	public void create () {
		batch_ = new SpriteBatch();
		chapter1_ = new Chapter1();
        chapter1_.create();
	}

	@Override
	public void dispose() {
		super.dispose();
		chapter1_.dispose();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch_.begin();
		chapter1_.render(batch_);
		batch_.end();
	}
}

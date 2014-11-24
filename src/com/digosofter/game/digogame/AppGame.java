package com.digosofter.game.digogame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class AppGame implements ApplicationListener {

  private SpriteBatch batch;
  private BitmapFont font;

  @Override
  public void create() {

    batch = new SpriteBatch();
    font = new BitmapFont();
    font.setColor(Color.RED);

  }

  @Override
  public void dispose() {

    batch.dispose();
    font.dispose();

  }

  @Override
  public void pause() {

    // TODO Auto-generated method stub

  }

  @Override
  public void render() {

    Gdx.gl.glClearColor(1, 1, 1, 1);
    // Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

    batch.begin();
    font.draw(batch, "Ol� mundo!", 200, 200);
    batch.end();

  }

  @Override
  public void resize(int arg0, int arg1) {

    // TODO Auto-generated method stub

  }

  @Override
  public void resume() {

    // TODO Auto-generated method stub

  }

}

package com.digosofter.game.digogame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.digosofter.digojava.App;
import com.digosofter.digojava.erro.Erro;

public abstract class AppGame extends App implements ApplicationListener {

  private static AppGame i;

  public static AppGame getI() {

    return i;
  }

  private static void setI(AppGame appGame) {

    try {

      if (i != null) {

        return;
      }

      i = appGame;
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private Color _corBkg;

  protected AppGame() {

    try {

      AppGame.setI(this);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  @Override
  public void create() {

    try {

      Gdx.input.setInputProcessor(this.getObjControle());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  @Override
  public void dispose() {

  }

  Color getCorBkg() {

    try {

      if (_corBkg != null) {

        return _corBkg;
      }

      _corBkg = new Color(1, 1, 1, 0);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _corBkg;
  }

  protected abstract InputProcessor getObjControle();

  @Override
  public void render() {

    try {

      Gdx.gl.glClearColor(this.getCorBkg().r, this.getCorBkg().g, this.getCorBkg().b, this.getCorBkg().a);
      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public void setCorBkg(Color corBkg) {

    _corBkg = corBkg;
  }
}
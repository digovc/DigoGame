package com.digosofter.game.digogame;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.digosofter.digojava.App;
import com.digosofter.digojava.Objeto;
import com.digosofter.digojava.erro.Erro;
import com.digosofter.game.digogame.elemento.Elemento;

public abstract class Mundo extends Objeto {

  public final static int INT_TAMANHO_BASICO = 25;
  public final static int INT_TELA_DEBUG_MARGEM = INT_TAMANHO_BASICO * 1;

  private List<Elemento> _lstElm;
  private ShapeRenderer _objShapeRendererDebug;
  private SpriteBatch _objSpriteBatch;

  public List<Elemento> getLstElm() {

    try {

      if (_lstElm != null) {

        return _lstElm;
      }

      _lstElm = new ArrayList<>();
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _lstElm;
  }

  private ShapeRenderer getObjShapeRendererDebug() {

    try {

      if (_objShapeRendererDebug != null) {

        return _objShapeRendererDebug;
      }

      _objShapeRendererDebug = new ShapeRenderer();
      this.getObjShapeRendererDebug().setColor(Color.LIGHT_GRAY);
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _objShapeRendererDebug;
  }

  public SpriteBatch getObjSpriteBatch() {

    try {

      if (_objSpriteBatch != null) {

        return _objSpriteBatch;
      }

      _objSpriteBatch = new SpriteBatch();

    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _objSpriteBatch;
  }

  public void inicializar() {

    try {

    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void montarLayoutDebug() {

    try {

      if (!App.getI().getBooDebug()) {

        return;
      }

      this.montarLayoutDebugLimiteTela();
      this.montarLayoutDebugFps();
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void montarLayoutDebugFps() {

    try {

      // TODO: Mostrar FPS na tela.

    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

  }

  private void montarLayoutDebugLimiteTela() {

    int x;
    int y;

    try {

      if (!App.getI().getBooDebug()) {

        return;
      }

      x = Gdx.graphics.getWidth() - INT_TELA_DEBUG_MARGEM;
      y = Gdx.graphics.getHeight() - INT_TELA_DEBUG_MARGEM;

      this.getObjShapeRendererDebug().begin(ShapeType.Line);
      this.getObjShapeRendererDebug().rect(INT_TELA_DEBUG_MARGEM / 2, INT_TELA_DEBUG_MARGEM / 2, x, y);
      this.getObjShapeRendererDebug().end();
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

  }

  public void update() {

    try {

      // TODO: Separar o processo de update dos elementos do print.
      this.getObjSpriteBatch().begin();

      for (Elemento elm : this.getLstElm()) {

        elm.update();
      }

      this.getObjSpriteBatch().end();
      this.montarLayoutDebug();
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {

    }
  }
}

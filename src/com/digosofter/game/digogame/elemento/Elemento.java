package com.digosofter.game.digogame.elemento;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Disposable;
import com.digosofter.digojava.Objeto;
import com.digosofter.digojava.erro.Erro;
import com.digosofter.game.digogame.Mundo;

public abstract class Elemento extends Objeto implements Disposable {

  private boolean _booDinamico;
  private int _intPosX;
  private int _intPosY;
  private Mundo _objMundo;
  private Texture _objTexture;

  public Elemento(Mundo objMundo, int intPosX, int intPosY) {

    try {

      this.setObjMundo(objMundo);

      this.getObjMundo().getLstElm().add(this);
      this.setIntPosX(intPosX);
      this.setIntPosY(intPosY);
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  @Override
  public void dispose() {

    try {

    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

  }

  public boolean getBooDinamico() {

    return _booDinamico;
  }

  protected abstract String getDirTexture();

  protected int getIntPosX() {

    return _intPosX;
  }

  protected int getIntPosY() {

    return _intPosY;
  }

  protected Mundo getObjMundo() {

    return _objMundo;
  }

  protected Texture getObjTexture() {

    try {

      if (_objTexture != null) {

        return _objTexture;
      }

      _objTexture = new Texture(this.getDirTexture());
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _objTexture;
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

  public void render() {

    try {

    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  protected void setBooDinamico(boolean booDinamico) {

    try {

      _booDinamico = booDinamico;

      if (_booDinamico) {

        this.getObjMundo().getLstElmDinamico().add(this);
      }
      else {

        this.getObjMundo().getLstElmDinamico().remove(this);
      }

    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void setIntPosX(int intPosX) {

    try {

      _intPosX = intPosX * Mundo.INT_TAMANHO_BASICO;
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void setIntPosY(int intPosY) {

    try {

      _intPosY = intPosY * Mundo.INT_TAMANHO_BASICO;
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void setObjMundo(Mundo objMundo) {

    _objMundo = objMundo;
  }

  public void update() {

    try {

    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

}

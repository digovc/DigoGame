package com.digosofter.game.digogame.elemento;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Disposable;
import com.digosofter.digojava.Objeto;
import com.digosofter.digojava.erro.Erro;
import com.digosofter.game.digogame.Mundo;

public abstract class Elemento extends Objeto implements Disposable {

  private Texture _objTexture;

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

  protected abstract String getDirTexture();

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

  private boolean _booDinamico;
  private Mundo _objMundo;

  public Elemento(Mundo objMundo) {

    try {

      this.setObjMundo(objMundo);
      this.getObjMundo().getLstElm().add(this);
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

  protected Mundo getObjMundo() {

    return _objMundo;
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

  public void print() {

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

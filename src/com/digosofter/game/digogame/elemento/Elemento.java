package com.digosofter.game.digogame.elemento;

import com.digosofter.digojava.Objeto;
import com.digosofter.digojava.erro.Erro;
import com.digosofter.game.digogame.Mundo;

public abstract class Elemento extends Objeto {

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

package com.digosofter.game.digogame;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.digosofter.digojava.Objeto;
import com.digosofter.digojava.erro.Erro;

public class Controle extends Objeto implements InputProcessor {

  private static Controle i;

  public static Controle getI() {

    try {

      if (i != null) {

        return i;
      }

      i = new Controle();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return i;
  }

  protected Controle() {

    try {

      this.setI(this);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  @Override
  public boolean keyDown(int intKeyCode) {

    return false;
  }

  @Override
  public boolean keyTyped(char chr) {

    return false;
  }

  @Override
  public boolean keyUp(int intKeyCode) {

    try {

      if (intKeyCode == Keys.ESCAPE) {

        AppGame.getI().setBooDebug(!AppGame.getI().getBooDebug());
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return false;
  }

  @Override
  public boolean mouseMoved(int intScreenX, int intScreenY) {

    return false;
  }

  @Override
  public boolean scrolled(int intAmount) {

    return false;
  }

  private void setI(Controle objControle) {

    try {

      if (i != null) {

        return;
      }

      i = objControle;
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  @Override
  public boolean touchDown(int intScreenX, int intScreenY, int intPointer, int intButton) {

    return false;
  }

  @Override
  public boolean touchDragged(int intScreenX, int intScreenY, int intPointer) {

    return false;
  }

  @Override
  public boolean touchUp(int intScreenX, int intScreenY, int intPointer, int intButton) {

    return false;
  }
}
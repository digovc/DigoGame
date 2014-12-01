package com.digosofter.game.digogame.elemento;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.digosofter.digojava.Utils;
import com.digosofter.digojava.erro.Erro;
import com.digosofter.game.digogame.Mundo;

public abstract class BackgroundElm extends Elemento {

  private boolean _booRepeteX;
  private boolean _booRepeteY;
  private String _dirImagem;
  private Image _img;

  public BackgroundElm(Mundo objMundo) {

    super(objMundo, 0, 0);
  }

  private boolean getBooRepeteX() {

    return _booRepeteX;
  }

  private boolean getBooRepeteY() {

    return _booRepeteY;
  }

  private String getDirImagem() {

    return _dirImagem;
  }

  private Image getImg() {

    try {
      if (_img != null) {

        return _img;
      }

      _img = new Image(this.getObjTexture());

      _img.setHeight(Gdx.graphics.getHeight());
      _img.setWidth(Gdx.graphics.getWidth());
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _img;
  }

  @Override
  public void inicializar() {

    super.inicializar();

    try {

    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public void setBooRepeteX(boolean booRepeteX) {

    _booRepeteX = booRepeteX;
  }

  private void setbooRepeteY(boolean booRepeteY) {

    _booRepeteY = booRepeteY;
  }

  public void setDirImagem(String dirImagem) {

    try {

      _dirImagem = dirImagem;

      if (Utils.getBooStrVazia(_dirImagem)) {

        return;
      }

      if (_dirImagem.toLowerCase().startsWith("assets/")) {

        return;
      }

      _dirImagem = "assets/" + _dirImagem;

    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  @Override
  public void update() {

    super.update();

    try {

      this.getImg().draw(this.getObjMundo().getObjSpriteBatch(), 1);
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

}

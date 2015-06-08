package com.digosofter.game.digogame.hud;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad.TouchpadStyle;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.digosofter.digojava.Objeto;
import com.digosofter.digojava.erro.Erro;
import com.digosofter.game.digogame.Mundo;

public class Hud extends Objeto {

  private Touchpad _imgBotao;
  private List<HudItem> _lstHudItem;
  private Mundo _objMundo;
  private Stage _stg;

  public Hud(Mundo objMundo) {

    try {

      this.setObjMundo(objMundo);
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private Touchpad getImgBotao() {

    TouchpadStyle tps;
    Skin skn;

    try {

      if (_imgBotao != null) {

        return _imgBotao;
      }

      skn = new Skin();
      skn.add("botao", new Texture("png/blocos/terra/blocos_terra_01_005.png"));

      tps = new TouchpadStyle();
      tps.knob = skn.getDrawable("botao");

      _imgBotao = new Touchpad(1, tps);
      _imgBotao.setBounds(0, 0, 10, 10);
      _imgBotao.setHeight(50);
      _imgBotao.setWidth(50);
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _imgBotao;
  }

  private List<HudItem> getLstHudItem() {

    try {

      if (_lstHudItem != null) {

        return _lstHudItem;
      }

      _lstHudItem = new ArrayList<HudItem>();
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
    return _lstHudItem;
  }

  private Mundo getObjMundo() {

    return _objMundo;
  }

  private Stage getStg() {

    try {

      if (_stg != null) {

        return _stg;
      }

      _stg = new Stage(new StretchViewport(this.getObjMundo().getVctTelaTamanho().x, this.getObjMundo().getVctTelaTamanho().y), this.getObjMundo().getObjSpriteBatch());
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
    return _stg;
  }

  public void inicializar() {

    try {

      this.getStg().addActor(this.getImgBotao());
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public void render() {

    try {

      this.getStg().draw();
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

  }
}

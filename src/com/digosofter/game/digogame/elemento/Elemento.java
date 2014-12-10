package com.digosofter.game.digogame.elemento;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;
import com.digosofter.digojava.Objeto;
import com.digosofter.digojava.erro.Erro;
import com.digosofter.game.digogame.Mundo;

public abstract class Elemento extends Objeto implements Disposable {

  private boolean _booDinamico;
  private List<Colisao> _lstObjColisao;
  private Mundo _objMundo;
  private Texture _objTexture;
  private Rectangle _rct;
  private Vector2 _vctPosicao;
  private Vector2 _vctTamanho;

  public Elemento(Mundo objMundo, Vector2 vctPosicao) {

    try {

      this.setObjMundo(objMundo);
      this.setVctPosicao(vctPosicao);
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private Vector2 calcularPosicao() {

    Vector2 vctResultado = null;

    try {

      vctResultado = new Vector2();
      vctResultado.x = this.calcularPosicaoX();
      vctResultado.y = this.calcularPosicaoY();
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return vctResultado;
  }

  private float calcularPosicaoX() {

    float fltResultado = 0;

    try {

      fltResultado = this.getVctPosicao().x;
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return fltResultado;
  }

  private float calcularPosicaoY() {

    float fltResultado = 0;

    try {

      fltResultado = this.getVctPosicao().y;
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return fltResultado;
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

  private List<Colisao> getLstObjColisao() {

    try {

      if (_lstObjColisao != null) {

        return _lstObjColisao;
      }

      _lstObjColisao = new ArrayList<Colisao>();
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _lstObjColisao;
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

  private Rectangle getRct() {

    try {

      if (_rct != null) {

        return _rct;
      }

      _rct = new Rectangle();
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {

      _rct.height = this.getVctTamanho().y;
      _rct.width = this.getVctTamanho().x;
      _rct.x = this.getVctPosicao().x;
      _rct.y = this.getVctPosicao().y;
    }

    return _rct;
  }

  protected Vector2 getVctPosicao() {

    try {

      if (_vctPosicao != null) {

        return _vctPosicao;
      }

      _vctPosicao = new Vector2();
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
    return _vctPosicao;
  }

  protected Vector2 getVctTamanho() {

    try {

      if (_vctTamanho != null) {

        return _vctTamanho;
      }

      _vctTamanho = new Vector2();
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _vctTamanho;
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

  public void render(SpriteBatch objSpriteBatch) {

    try {

    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public void renderDebug(ShapeRenderer objShapeRendererDebug) {

    // TODO Auto-generated method stub

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

    try {

      _objMundo = objMundo;

      if (_objMundo != null) {

        _objMundo.getLstElm().add(this);
      }
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void setVctPosicao(Vector2 vctPosicao) {

    _vctPosicao = vctPosicao;
  }

  protected void setVctTamanho(Vector2 vctTamanho) {

    _vctTamanho = vctTamanho;
  }

  public void update() {

    try {

      if (!this.getObjMundo().getBooAplicarFisica() || !this.getBooDinamico()) {

        return;
      }

      this.updateFisica();
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void updateFisica() {

    try {

      this.verificarColisao();
      this.setVctPosicao(this.calcularPosicao());
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void verificarColisao() {

    try {

      this.getLstObjColisao().clear();

      for (Elemento elm : this.getObjMundo().getLstElm()) {

        if (elm == this) {

          continue;
        }

        this.verificarColisao(elm);
      }
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void verificarColisao(Elemento elm) {

    Colisao objColisao;
    Rectangle rctIntercessao;

    try {

      rctIntercessao = new Rectangle();

      if (!Intersector.intersectRectangles(this.getRct(), elm.getRct(), rctIntercessao)) {

        return;
      }

      objColisao = new Colisao();

      objColisao.setElm1(this);
      objColisao.setElm2(elm);
      objColisao.setRctIntercessao(rctIntercessao);

      objColisao.getEnmTipo();

      this.getLstObjColisao().add(objColisao);
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }
}

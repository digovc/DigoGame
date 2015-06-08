package com.digosofter.game.digogame.elemento;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
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
import com.digosofter.game.digogame.elemento.Colisao.EnmTipo;

public abstract class Elemento extends Objeto implements Disposable {

  private boolean _booAplicarGravidadeX = true;
  private boolean _booAplicarGravidadeY = true;
  private boolean _booDinamico;
  private boolean _booNoChao;
  private List<Movimento> _lstMov;
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

  private void aplicarGravidadeX() {

    try {

      if (!this.getBooAplicarGravidadeX()) {

        this.setBooAplicarGravidadeX(true);
        return;
      }

      if (this.getObjMundo().getVctGravidade().x > 0 && this.getBooColidiuLateralDireita()) {

        return;
      }

      if (this.getObjMundo().getVctGravidade().x < 0 && this.getBooColidiuLateralEsquerda()) {

        return;
      }

      this.getVctPosicao().x = this.getVctPosicao().x + this.getObjMundo().getVctGravidade().x * Gdx.graphics.getDeltaTime();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void aplicarGravidadeY() {

    try {

      if (!this.getBooAplicarGravidadeY()) {

        this.setBooAplicarGravidadeY(true);
        return;
      }

      if (this.getObjMundo().getVctGravidade().y > 0 && this.getBooColidiuLateralTopo()) {

        return;
      }

      if (this.getObjMundo().getVctGravidade().y < 0 && this.getBooColidiuLateralFundo()) {

        return;
      }

      this.getVctPosicao().y = this.getVctPosicao().y + this.getObjMundo().getVctGravidade().y * Gdx.graphics.getDeltaTime();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  protected void aplicarMovimento(Movimento mov) {

    try {

      this.getLstMov().add(mov);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void aplicarMovimentoX() {

    List<Movimento> lstMovTemp;

    try {

      lstMovTemp = new ArrayList<Movimento>();

      for (Movimento mov : this.getLstMov()) {

        lstMovTemp.add(mov);
      }

      for (Movimento mov : lstMovTemp) {

        this.aplicarMovimentoX(mov);
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void aplicarMovimentoX(Movimento mov) {

    try {

      if (mov.getVctDistancia().x == 0) {

        return;
      }

      if (mov.getVctDistancia().x > 0 && this.getBooColidiuLateralDireita()) {

        this.getLstMov().remove(mov);
        return;
      }

      if (mov.getVctDistancia().x < 0 && this.getBooColidiuLateralEsquerda()) {

        this.getLstMov().remove(mov);
        return;
      }

      this.setBooAplicarGravidadeX(false);
      this.getVctPosicao().x = mov.calcularX(this.getVctPosicao().x);

      if (mov.getBooAcabou()) {

        this.getLstMov().remove(mov);
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void aplicarMovimentoY() {

    List<Movimento> lstMovTemp;

    try {

      lstMovTemp = new ArrayList<Movimento>();

      for (Movimento mov : this.getLstMov()) {

        lstMovTemp.add(mov);
      }

      for (Movimento mov : lstMovTemp) {

        this.aplicarMovimentoY(mov);
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void aplicarMovimentoY(Movimento mov) {

    try {

      if (mov.getVctDistancia().y > 0 && this.getBooColidiuLateralTopo()) {

        this.getLstMov().remove(mov);
        return;
      }

      if (mov.getVctDistancia().y < 0 && this.getBooColidiuLateralFundo()) {

        this.getLstMov().remove(mov);
        return;
      }

      this.setBooAplicarGravidadeY(false);
      this.getVctPosicao().y = mov.calcularY(this.getVctPosicao().y);

      if (mov.getBooAcabou()) {

        this.getLstMov().remove(mov);
      }
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

      this.getObjMundo().removeElemento(this);
      this.getObjMundo().getLstElmDinamico().remove(this);
      this.getObjTexture().dispose();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

  }

  private boolean getBooAplicarGravidadeX() {

    return _booAplicarGravidadeX;
  }

  private boolean getBooAplicarGravidadeY() {

    return _booAplicarGravidadeY;
  }

  private boolean getBooColidiu(Colisao.EnmTipo enmTipo) {

    try {

      for (Colisao objColisao : this.getLstObjColisao()) {

        if (objColisao.getEnmTipo().equals(enmTipo)) {

          return true;
        }
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return false;
  }

  private boolean getBooColidiuLateralDireita() {

    return this.getBooColidiu(EnmTipo.LATERAL_DIREITA);
  }

  private boolean getBooColidiuLateralEsquerda() {

    return this.getBooColidiu(EnmTipo.LATERAL_ESQUERDA);
  }

  private boolean getBooColidiuLateralFundo() {

    return this.getBooColidiu(EnmTipo.FUNDO);
  }

  private boolean getBooColidiuLateralTopo() {

    return this.getBooColidiu(EnmTipo.TOPO);
  }

  public boolean getBooDinamico() {

    return _booDinamico;
  }

  protected boolean getBooNoChao() {

    try {

      _booNoChao = this.getBooColidiu(EnmTipo.FUNDO);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _booNoChao;
  }

  protected abstract String getDirTexture();

  private List<Movimento> getLstMov() {

    try {

      if (_lstMov != null) {

        return _lstMov;
      }

      _lstMov = new ArrayList<Movimento>();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _lstMov;
  }

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

  }

  public void render(SpriteBatch objSpriteBatch) {

  }

  public void renderDebug(ShapeRenderer objShapeRendererDebug) {

  }

  private void setBooAplicarGravidadeX(boolean booAplicarGravidadeX) {

    _booAplicarGravidadeX = booAplicarGravidadeX;
  }

  private void setBooAplicarGravidadeY(boolean booAplicarGravidadeY) {

    _booAplicarGravidadeY = booAplicarGravidadeY;
  }

  protected void setBooDinamico(boolean booDinamico) {

    try {

      _booDinamico = booDinamico;

      if (_booDinamico) {

        this.getObjMundo().addElmentoDinamico(this);
        return;
      }

      this.getObjMundo().removeElementoDinamico(this);
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

      if (_objMundo == null) {

        return;
      }

      _objMundo.addElmento(this);
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

  protected void updadePosicao() {

    try {

      this.updatePosicaoX();
      this.updatePosicaoY();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
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

  private void updateColisao() {

    try {

      this.getLstObjColisao().clear();

      for (Elemento elm : this.getObjMundo().getLstElm()) {

        if (elm == this) {

          continue;
        }

        this.verificarColisao(elm);
      }

      this.updateColisaoAjustarPosicao();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void updateColisaoAjustarPosicao() {

    try {

      for (Colisao objColisao : this.getLstObjColisao()) {

        if (objColisao == null) {

          continue;
        }

        this.updateColisaoAjustarPosicao(objColisao);
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void updateColisaoAjustarPosicao(Colisao objColisao) {

    try {

      this.getVctPosicao().y = objColisao.ajustarY(this.getVctPosicao().y);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void updateFisica() {

    try {

      this.updadePosicao();
      this.updateColisao();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void updatePosicaoX() {

    try {

      this.aplicarMovimentoX();
      this.aplicarGravidadeX();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void updatePosicaoY() {

    try {

      this.aplicarMovimentoY();
      this.aplicarGravidadeY();
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

      this.getLstObjColisao().add(objColisao);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }
}
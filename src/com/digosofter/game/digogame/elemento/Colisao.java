package com.digosofter.game.digogame.elemento;

import com.badlogic.gdx.math.Rectangle;
import com.digosofter.digojava.Objeto;
import com.digosofter.digojava.erro.Erro;

public class Colisao extends Objeto {

  public enum EnmTipo {

    FUNDO,
    LATERAL_DIREITA,
    LATERAL_ESQUERDA,
    NONE,
    TOPO,
  }

  private Elemento _elm1;
  private Elemento _elm2;
  private EnmTipo _enmTipo = EnmTipo.NONE;
  private Rectangle _rctIntercessao;

  private EnmTipo calcularEnmTipo() {

    try {

      if (this.getRctIntercessao().height > this.getRctIntercessao().width && this.getRctIntercessao().x > this.getElm1().getVctPosicao().x) {
        return EnmTipo.LATERAL_DIREITA;
      }

      if (this.getRctIntercessao().height > this.getRctIntercessao().width && this.getRctIntercessao().x <= this.getElm1().getVctPosicao().x) {
        return EnmTipo.LATERAL_ESQUERDA;
      }

      if (this.getRctIntercessao().height < this.getRctIntercessao().width && this.getRctIntercessao().y > this.getElm1().getVctPosicao().y) {
        return EnmTipo.TOPO;
      }

      if (this.getRctIntercessao().height < this.getRctIntercessao().width && this.getRctIntercessao().y <= this.getElm1().getVctPosicao().y) {
        return EnmTipo.FUNDO;
      }
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  private Elemento getElm1() {

    return _elm1;
  }

  private Elemento getElm2() {

    return _elm2;
  }

  public EnmTipo getEnmTipo() {

    try {

      if (_enmTipo != EnmTipo.NONE) {

        return _enmTipo;
      }

      _enmTipo = this.calcularEnmTipo();
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
    return _enmTipo;
  }

  private Rectangle getRctIntercessao() {

    return _rctIntercessao;
  }

  public void setElm1(Elemento elm1) {

    _elm1 = elm1;
  }

  public void setElm2(Elemento elm2) {

    _elm2 = elm2;
  }

  public void setRctIntercessao(Rectangle rctIntercessao) {

    _rctIntercessao = rctIntercessao;
  }
}

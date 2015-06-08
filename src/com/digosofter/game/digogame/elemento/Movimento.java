package com.digosofter.game.digogame.elemento;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.digosofter.digojava.Objeto;
import com.digosofter.digojava.erro.Erro;

public class Movimento extends Objeto {

  private boolean _booAcabou;
  private float _fltDuracao;
  private Vector2 _vctDistancia;
  private Vector2 _vctDistanciaPercorrida;

  public Movimento(float fltDistanciaX, float fltDistanciaY, float fltDuracao) {

    try {

      this.setFltDuracao(fltDuracao);
      this.setVctDistancia(new Vector2(fltDistanciaX, fltDistanciaY));
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public float calcularX(float x) {

    float fltResultado = 0;

    try {

      fltResultado = x + this.getVctDistancia().x * (this.getFltDuracao() * Gdx.graphics.getDeltaTime());
      this.getVctDistanciaPercorrida().x = this.getVctDistanciaPercorrida().x + fltResultado - x;

      if (this.getVctDistancia().x > 0 && this.getVctDistanciaPercorrida().x > this.getVctDistancia().x) {

        return x;
      }

      if (this.getVctDistancia().x < 0 && this.getVctDistanciaPercorrida().x < this.getVctDistancia().x) {

        return x;
      }
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return fltResultado;
  }

  public float calcularY(float y) {

    float fltResultado = 0;

    try {

      fltResultado = y + (this.getVctDistancia().y / this.getFltDuracao()) * Gdx.graphics.getDeltaTime();
      this.getVctDistanciaPercorrida().y = this.getVctDistanciaPercorrida().y + fltResultado - y;

      if (this.getVctDistancia().y > 0 && this.getVctDistanciaPercorrida().y > this.getVctDistancia().y) {

        return y;
      }

      if (this.getVctDistancia().y < 0 && this.getVctDistanciaPercorrida().y < this.getVctDistancia().y) {

        return y;
      }
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return fltResultado;
  }

  public boolean getBooAcabou() {

    try {

      if (this.getVctDistancia().x > 0 && this.getVctDistanciaPercorrida().x < this.getVctDistancia().x) {

        return false;
      }

      if (this.getVctDistancia().x < 0 && this.getVctDistanciaPercorrida().x > this.getVctDistancia().x) {

        return false;
      }

      if (this.getVctDistancia().y > 0 && this.getVctDistanciaPercorrida().y < this.getVctDistancia().y) {

        return false;
      }

      if (this.getVctDistancia().y < 0 && this.getVctDistanciaPercorrida().y > this.getVctDistancia().y) {

        return false;
      }

      _booAcabou = true;
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _booAcabou;
  }

  private float getFltDuracao() {

    return _fltDuracao;
  }

  public Vector2 getVctDistancia() {

    return _vctDistancia;
  }

  private Vector2 getVctDistanciaPercorrida() {

    try {

      if (_vctDistanciaPercorrida != null) {

        return _vctDistanciaPercorrida;
      }

      _vctDistanciaPercorrida = new Vector2();
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
    return _vctDistanciaPercorrida;
  }

  private void setFltDuracao(float fltDuracao) {

    _fltDuracao = fltDuracao;
  }

  private void setVctDistancia(Vector2 vctDistancia) {

    _vctDistancia = vctDistancia;
  }

}

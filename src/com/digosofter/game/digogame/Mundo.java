package com.digosofter.game.digogame;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Disposable;
import com.digosofter.digojava.App;
import com.digosofter.digojava.Objeto;
import com.digosofter.digojava.erro.Erro;
import com.digosofter.game.digogame.elemento.Elemento;

public abstract class Mundo extends Objeto implements Disposable {

  public final static float FLT_PIXELS_TO_METERS = 100f;
  public final static int INT_TAMANHO_BASICO = 25;

  private float _fltGravidadeX;
  private float _fltGravidadeY = -98f;
  private List<Elemento> _lstElm;
  private List<Elemento> _lstElmDinamico;
  private Box2DDebugRenderer _objBox2dDebugRenderer;
  private OrthographicCamera _objCamera;
  private Matrix4 _objMatrix4;
  private SpriteBatch _objSpriteBatch;
  private World _objWorld;

  @Override
  public void dispose() {

    try {

      for (Elemento elm : this.getLstElm()) {

        elm.dispose();
      }

      this.getObjBox2dDebugRenderer().dispose();
      this.getObjSpriteBatch().dispose();
      this.getObjWorld().dispose();
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

  }

  private float getFltGravidadeX() {

    return _fltGravidadeX;
  }

  private float getFltGravidadeY() {

    return _fltGravidadeY;
  }

  public List<Elemento> getLstElm() {

    try {

      if (_lstElm != null) {

        return _lstElm;
      }

      _lstElm = new ArrayList<>();
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _lstElm;
  }

  public List<Elemento> getLstElmDinamico() {

    try {

      if (_lstElmDinamico != null) {

        return _lstElmDinamico;
      }

      _lstElmDinamico = new ArrayList<>();
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _lstElmDinamico;
  }

  private Box2DDebugRenderer getObjBox2dDebugRenderer() {

    try {

      if (_objBox2dDebugRenderer != null) {

        return _objBox2dDebugRenderer;
      }

      _objBox2dDebugRenderer = new Box2DDebugRenderer();
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _objBox2dDebugRenderer;
  }

  protected OrthographicCamera getObjCamera() {

    try {

      if (_objCamera != null) {

        return _objCamera;
      }

      _objCamera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
      // _objCamera.position.set(Gdx.graphics.getWidth() / 2,
      // Gdx.graphics.getHeight() / 2, 0);
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _objCamera;
  }

  private Matrix4 getObjMatrix4() {

    return _objMatrix4;
  }

  public SpriteBatch getObjSpriteBatch() {

    try {

      if (_objSpriteBatch != null) {

        return _objSpriteBatch;
      }

      _objSpriteBatch = new SpriteBatch();

    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _objSpriteBatch;
  }

  public World getObjWorld() {

    try {

      if (_objWorld != null) {

        return _objWorld;
      }

      Box2D.init();

      _objWorld = new World(new Vector2(this.getFltGravidadeX(), this.getFltGravidadeY()), true);

    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _objWorld;
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

  private void montarLayoutBox2d() {

    try {

      this.getObjBox2dDebugRenderer().render(this.getObjWorld(), this.getObjMatrix4());
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

  }

  private void montarLayoutDebug() {

    try {

      if (!App.getI().getBooDebug()) {

        return;
      }

      this.montarLayoutDebugFps();
      this.montarLayoutBox2d();
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void montarLayoutDebugFps() {

    try {

      // TODO: Mostrar FPS na tela.
      System.out.println("FPS: " + Gdx.graphics.getFramesPerSecond());

    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

  }

  public void print() {

    try {

      this.getObjSpriteBatch().begin();

      for (Elemento elm : this.getLstElm()) {

        elm.print();
      }

      this.getObjSpriteBatch().end();
      this.montarLayoutDebug();
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  protected void setFltGravidadeX(float fltGravidadeX) {

    _fltGravidadeX = fltGravidadeX;
  }

  protected void setFltGravidadeY(float fltGravidadeY) {

    _fltGravidadeY = fltGravidadeY;
  }

  private void setObjMatrix4(Matrix4 objMatrix4) {

    _objMatrix4 = objMatrix4;
  }

  public void update() {

    try {

      this.updateCamera();
      this.updateDiverso();

      for (Elemento elmDinamico : this.getLstElmDinamico()) {

        elmDinamico.update();
      }
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  protected void updateCamera() {

    try {

      this.getObjCamera().update();
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void updateDiverso() {

    try {

      this.getObjSpriteBatch().setProjectionMatrix(this.getObjCamera().combined);
      this.setObjMatrix4(this.getObjSpriteBatch().getProjectionMatrix().cpy().scale(Mundo.FLT_PIXELS_TO_METERS, Mundo.FLT_PIXELS_TO_METERS, 0));
      this.getObjWorld().step(Gdx.graphics.getDeltaTime(), 6, 2);
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

}

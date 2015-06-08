package com.digosofter.game.digogame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.digosofter.digojava.erro.Erro;

public abstract class MundoBox2d extends Mundo {

  public final static float FLT_PIXELS_TO_METERS = 100;

  private Box2DDebugRenderer _objBox2dDebugRenderer;
  private Matrix4 _objMatrix4;
  private World _objWorld;

  public MundoBox2d(Vector2 vctGravidade) {

    super(vctGravidade);
  }

  @Override
  public void dispose() {

    super.dispose();

    try {

      this.getObjBox2dDebugRenderer().dispose();
      this.getObjWorld().dispose();
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
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

  private Matrix4 getObjMatrix4() {

    return _objMatrix4;
  }

  public World getObjWorld() {

    try {

      if (_objWorld != null) {

        return _objWorld;
      }

      _objWorld = new World(this.getVctGravidade(), true);
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _objWorld;
  }

  @Override
  public void inicializar() {

    super.inicializar();

    try {

      Box2D.init();
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  @Override
  protected void renderDebug() {

    super.renderDebug();

    try {

      this.getObjBox2dDebugRenderer().render(this.getObjWorld(), this.getObjMatrix4());
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void setObjMatrix4(Matrix4 objMatrix4) {

    _objMatrix4 = objMatrix4;
  }

  @Override
  protected void updateDiverso() {

    super.updateDiverso();

    try {

      this.setObjMatrix4(this.getObjSpriteBatch().getProjectionMatrix().cpy().scale(MundoBox2d.FLT_PIXELS_TO_METERS, MundoBox2d.FLT_PIXELS_TO_METERS, 0));
      this.getObjWorld().step(Gdx.graphics.getDeltaTime(), 6, 2);
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

}

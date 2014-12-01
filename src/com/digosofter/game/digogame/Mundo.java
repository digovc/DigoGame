package com.digosofter.game.digogame;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.digosofter.digojava.App;
import com.digosofter.digojava.Objeto;
import com.digosofter.digojava.erro.Erro;
import com.digosofter.game.digogame.elemento.Elemento;

public abstract class Mundo extends Objeto implements Disposable {

  public final static float FLT_PIXELS_TO_METERS = 100;
  public final static int INT_TAMANHO_BASICO = 25;

  private float _fltGravidadeX;
  private float _fltGravidadeY = -9.8f;
  private List<Elemento> _lstElm;
  private List<Elemento> _lstElmDinamico;
  private Box2DDebugRenderer _objBox2dDebugRenderer;
  private OrthographicCamera _objCamera;
  private Matrix4 _objMatrix4;
  private SpriteBatch _objSpriteBatch;
  private TiledMap _objTiledMap;
  private TiledMapRenderer _objTiledMapRenderer;
  private TiledMapTileLayer _objTiledMapTileLayerDinamica;
  private TiledMapTileLayer _objTiledMapTileLayerFixa;
  private Viewport _objViewport;
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

  protected abstract String getDirTmxMap();

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
      _objCamera.position.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0);
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

  private TiledMap getObjTiledMap() {

    try {

      if (_objTiledMap != null) {

        return _objTiledMap;
      }

      _objTiledMap = new TmxMapLoader().load(this.getDirTmxMap());
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _objTiledMap;
  }

  private TiledMapRenderer getObjTiledMapRenderer() {

    try {

      if (_objTiledMapRenderer != null) {

        return _objTiledMapRenderer;
      }

      _objTiledMapRenderer = new OrthogonalTiledMapRenderer(this.getObjTiledMap());
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _objTiledMapRenderer;
  }

  private TiledMapTileLayer getObjTiledMapTileLayerDinamica() {

    try {

      if (_objTiledMapTileLayerDinamica != null) {

        return _objTiledMapTileLayerDinamica;
      }

      _objTiledMapTileLayerDinamica = (TiledMapTileLayer) this.getObjTiledMap().getLayers().get("cmdDinamica");
      _objTiledMapTileLayerDinamica.setVisible(false);
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _objTiledMapTileLayerDinamica;
  }

  private TiledMapTileLayer getObjTiledMapTileLayerFixa() {

    try {

      if (_objTiledMapTileLayerFixa != null) {

        return _objTiledMapTileLayerFixa;
      }

      _objTiledMapTileLayerFixa = (TiledMapTileLayer) this.getObjTiledMap().getLayers().get("cmdFixa");
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _objTiledMapTileLayerFixa;
  }

  private Viewport getObjViewport() {

    try {

      if (_objViewport != null) {

        return _objViewport;
      }

      _objViewport = new StretchViewport(400, 240, this.getObjCamera());
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _objViewport;
  }

  public World getObjWorld() {

    try {

      if (_objWorld != null) {

        return _objWorld;
      }

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

      Box2D.init();
      this.inicializarMap();
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  protected abstract void inicializarCellDinamica(Cell objCell, int x, int y);

  protected abstract void inicializarCellFixa(Cell objCell, int x, int y);

  private void inicializarMap() {

    try {

      this.inicializarMapCmdAmbiente();
      this.inicializarMapCmdFixa();
      this.inicializarMapCmdDinamica();
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

  }

  private void inicializarMapCmdAmbiente() {

  }

  private void inicializarMapCmdDinamica() {

    Cell objCell;

    try {

      for (int x = 0; x < this.getObjTiledMapTileLayerDinamica().getWidth(); x++) {

        for (int y = 0; y < this.getObjTiledMapTileLayerDinamica().getHeight(); y++) {

          objCell = this.getObjTiledMapTileLayerDinamica().getCell(x, y);

          if (objCell == null) {

            continue;
          }

          this.inicializarCellDinamica(objCell, x, y);
        }
      }

    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void inicializarMapCmdFixa() {

    Cell objCell;

    try {

      for (int x = 0; x < this.getObjTiledMapTileLayerFixa().getWidth(); x++) {

        for (int y = 0; y < this.getObjTiledMapTileLayerFixa().getHeight(); y++) {

          objCell = this.getObjTiledMapTileLayerFixa().getCell(x, y);

          if (objCell == null) {

            continue;
          }

          this.inicializarCellFixa(objCell, x, y);
        }
      }

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

      this.printMap();
      this.printElementos();
      this.montarLayoutDebug();
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void printElementos() {

    try {

      this.getObjSpriteBatch().begin();

      for (Elemento elm : this.getLstElm()) {

        elm.print();
      }

      this.getObjSpriteBatch().end();
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void printMap() {

    try {

      this.getObjTiledMapRenderer().setView(this.getObjCamera());
      this.getObjTiledMapRenderer().render();
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

  }

  public void resize(int intWidth, int intHeight) {

    try {

      this.getObjViewport().update(intWidth, intHeight);
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

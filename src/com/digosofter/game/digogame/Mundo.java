package com.digosofter.game.digogame;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.digosofter.digojava.App;
import com.digosofter.digojava.Objeto;
import com.digosofter.digojava.Utils;
import com.digosofter.digojava.erro.Erro;
import com.digosofter.game.digogame.elemento.Elemento;
import com.digosofter.game.digogame.hud.Hud;

public abstract class Mundo extends Objeto implements Disposable {

  public final static int INT_TAMANHO_BASICO = 32;

  private boolean _booAplicarFisica;
  private Hud _hud;
  private List<Elemento> _lstElm;
  private List<Elemento> _lstElmDinamico;
  private OrthographicCamera _objCamera;
  private ShapeRenderer _objShapeRenderDebug;
  private SpriteBatch _objSpriteBatch;
  private TiledMap _objTiledMap;
  private TiledMapRenderer _objTiledMapRenderer;
  private TiledMapTileLayer _objTiledMapTileLayerDinamica;
  private TiledMapTileLayer _objTiledMapTileLayerFixa;
  private Viewport _objViewport;
  private Vector2 _vctGravidade;
  private Vector2 _vctTelaTamanho;

  public Mundo(Vector2 vctGravidade) {

    try {

      this.setVctGravidade(vctGravidade);
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

      for (Elemento elm : this.getLstElm()) {

        elm.dispose();
      }

      this.getObjSpriteBatch().dispose();
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

  }

  public boolean getBooAplicarFisica() {

    return _booAplicarFisica;
  }

  protected abstract String getDirTmxMap();

  private Hud getHud() {

    try {

      if (_hud != null) {

        return _hud;
      }

      _hud = new Hud(this);
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
    return _hud;
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

  private ShapeRenderer getObjShapeRenderDebug() {

    try {

      if (_objShapeRenderDebug != null) {

        return _objShapeRenderDebug;
      }

      _objShapeRenderDebug = new ShapeRenderer();
      _objShapeRenderDebug.setColor(0, 0, 1, 0);
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
    return _objShapeRenderDebug;
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

  public Viewport getObjViewport() {

    try {

      if (_objViewport != null) {

        return _objViewport;
      }

      _objViewport = new StretchViewport(this.getVctTelaTamanho().x, this.getVctTelaTamanho().y, this.getObjCamera());
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _objViewport;
  }

  public Vector2 getVctGravidade() {

    try {

      if (_vctGravidade != null) {

        return _vctGravidade;
      }

      _vctGravidade = new Vector2(0, -10);
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _vctGravidade;
  }

  public Vector2 getVctTelaTamanho() {

    try {

      if (_vctTelaTamanho != null) {

        return _vctTelaTamanho;
      }

      _vctTelaTamanho = new Vector2(16 * Mundo.INT_TAMANHO_BASICO, 10 * Mundo.INT_TAMANHO_BASICO);
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
    return _vctTelaTamanho;
  }

  public void inicializar() {

    try {

      this.inicializarMap();

      // TODO: Terminar hub para sistema Android.
      // this.inicializarHud();
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  protected abstract void inicializarCellDinamica(Cell objCell, int x, int y);

  protected abstract void inicializarCellFixa(Cell objCell, int x, int y);

  private void inicializarHud() {

    try {

      this.getHud().inicializar();
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void inicializarMap() {

    try {

      // TODO: Inicializar os componentes a medida que forem sendo necessários.
      // Do jeito que está ele inicializa todos os blocos do mapa, fazendo uso
      // de muita memória.
      if (Utils.getBooStrVazia(this.getDirTmxMap())) {

        return;
      }

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

  private void montarLayoutDebugFps() {

    try {

      System.out.println("FPS: " + Gdx.graphics.getFramesPerSecond());

    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

  }

  public void render() {

    try {

      this.renderMap();
      this.renderElementos();
      this.renderDebug();
      this.renderHud();
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  protected void renderDebug() {

    try {

      if (!App.getI().getBooDebug()) {

        return;
      }

      this.montarLayoutDebugFps();
      this.renderElementosDebug();
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void renderElementos() {

    try {

      this.getObjSpriteBatch().begin();

      for (Elemento elm : this.getLstElm()) {

        elm.render(this.getObjSpriteBatch());
      }

      this.getObjSpriteBatch().end();
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void renderElementosDebug() {

    try {

      this.getObjShapeRenderDebug().begin(ShapeType.Line);

      for (Elemento elm : this.getLstElm()) {

        elm.renderDebug(this.getObjShapeRenderDebug());
      }

      this.getObjShapeRenderDebug().end();
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void renderHud() {

    try {

      this.getHud().render();
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void renderMap() {

    try {

      if (Utils.getBooStrVazia(this.getDirTmxMap())) {

        return;
      }

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

  protected void setBooAplicarFisica(boolean booAplicarFisica) {

    _booAplicarFisica = booAplicarFisica;
  }

  private void setVctGravidade(Vector2 vctGravidade) {

    _vctGravidade = vctGravidade;

  }

  protected void setVctTelaTamanho(Vector2 vctTelaTamanho) {

    _vctTelaTamanho = vctTelaTamanho;
  }

  public void update() {

    try {

      this.updateCamera();
      this.updateDiverso();
      this.updateHud();

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

      if (AppGame.getI().getBooDebug()) {

        this.getObjShapeRenderDebug().setProjectionMatrix(this.getObjCamera().combined);
      }
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  protected void updateDiverso() {

    try {

      this.getObjSpriteBatch().setProjectionMatrix(this.getObjCamera().combined);
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void updateHud() {

    try {

      this.getHud().update();
    }
    catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

}

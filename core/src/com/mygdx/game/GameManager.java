package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameManager extends ApplicationAdapter {

    private Square square;
    private OrthographicCamera camera = new OrthographicCamera();
    private SpriteBatch batch;


    private int positionX = 100;
    private int positionY = 100;

    private final float GAME_WORLD_WIDTH = 1200;
    private final float GAME_WORLD_HEIGHT = 1200;

    private Viewport viewport;


    public void create()
    {
        square = new Square();
        batch = new SpriteBatch();

        float aspectRatio = (float) Gdx.graphics.getHeight()/(float)Gdx.graphics.getWidth();
        camera = new OrthographicCamera();
        viewport = new FitViewport(aspectRatio * GAME_WORLD_WIDTH,  GAME_WORLD_HEIGHT, camera);
        viewport.apply();
        camera.position.set(GAME_WORLD_WIDTH/2, GAME_WORLD_WIDTH/2, 0);
    }

    @Override
    public void resize (int width, int height)
    {
        viewport.update(width,height);
        camera.position.set(GAME_WORLD_WIDTH/2, GAME_WORLD_WIDTH/2, 0);
    }

    public void render()
    {
        ScreenUtils.clear(0,0,0,1);
        camera.update();
        square.render( positionX, positionY, batch, camera);
    }

    public void dispose()
    {
        batch.dispose();
    }
}

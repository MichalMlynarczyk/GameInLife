package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Square extends ApplicationAdapter {

    //private Texture emptySquare = new Texture(Gdx.files.internal("square.png"));
    // public SpriteBatch batch;
    private Pixmap pixmap200 = new Pixmap(Gdx.files.internal("square_2.png"));
    private Pixmap pixmap100;
    private  Texture emptySquare;


    public Square() {
        this.prepare();
    }

    public void prepare() {
        pixmap100 = new Pixmap(100, 100, pixmap200.getFormat());
        pixmap100.drawPixmap(pixmap200,
                0, 0, pixmap200.getWidth(), pixmap200.getHeight(),
                0, 0, pixmap100.getWidth(), pixmap100.getHeight()
        );
         emptySquare = new Texture(pixmap100);
        emptySquare.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }


    public void render ( int x, int y, SpriteBatch batch, OrthographicCamera camera)
    {
        batch.begin();
        batch.setProjectionMatrix(camera.combined);
           batch.draw(emptySquare, x, y);
        batch.end();
    }

}

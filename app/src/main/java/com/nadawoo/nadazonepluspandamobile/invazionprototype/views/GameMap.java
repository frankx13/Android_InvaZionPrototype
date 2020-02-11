package com.nadawoo.nadazonepluspandamobile.invazionprototype.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import com.nadawoo.nadazonepluspandamobile.invazionprototype.activities.MapActivity;

import java.util.HashMap;

public class GameMap extends View {
    private int mapHeight;
    private int mapWidth;

    private Paint pLignes;
    private HashMap<int[], String> gameObjects;
    private MapActivity mapActivity;

    public GameMap(Context context, int mapHeight, int mapWidth) {
        super(context);

        this.mapHeight = mapHeight;
        this.mapWidth = mapWidth;

        mapActivity = new MapActivity();
        gameObjects = mapActivity.getMapObjects();

        pLignes = new Paint();
        pLignes.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int w = getWidth();
        int h = getHeight();

        // Quadrillage
        for(int i=1 ; i< mapWidth ; i++) {
            canvas.drawLine(i*w/mapWidth, 0, i*w/mapWidth, h, pLignes);
        }

        for(int j=1 ; j<= mapHeight ; j++) {
            canvas.drawLine(0,j*h/mapHeight, w, j*h/mapHeight, pLignes);
        }
    }
}

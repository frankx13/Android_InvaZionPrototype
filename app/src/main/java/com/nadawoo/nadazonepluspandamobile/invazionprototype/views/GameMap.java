package com.nadawoo.nadazonepluspandamobile.invazionprototype.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import com.nadawoo.nadazonepluspandamobile.invazionprototype.R;
import com.nadawoo.nadazonepluspandamobile.invazionprototype.activities.MapActivity;
import com.nadawoo.nadazonepluspandamobile.invazionprototype.models.InvazionMapZone;

import java.util.Map;

public class GameMap extends View {
    private int mapHeight;
    private int mapWidth;

    private Map<String, InvazionMapZone> gameObjects;
    private MapActivity mapActivity;

    private Bitmap bitmap;

    private Paint pTile;
    private Paint pLines;

    public GameMap(Context context, int mapHeight, int mapWidth) {
        super(context);

        this.mapHeight = mapHeight;
        this.mapWidth = mapWidth;

        bitmap = BitmapFactory.decodeResource(
                getResources(),
                R.drawable.tile_map_ready
        );

        mapActivity = new MapActivity();
        gameObjects = mapActivity.getMapObjects();

        pLines = new Paint();
        pLines.setColor(Color.BLACK);

        pTile = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int w = getWidth();
        int h = getHeight();

        // Quadrillage
        for (int i = 1; i < mapWidth; i++) {
            canvas.drawLine(i * w / mapWidth, 0, i * w / mapWidth, h, pLines);
            canvas.drawBitmap(bitmap, i * w / mapWidth, 0, pTile);
        }

        for (int j = 1; j < mapHeight; j++) {
            canvas.drawLine(0, j * h / mapHeight, w, j * h / mapHeight, pLines);
            canvas.drawBitmap(bitmap, 0, j * w / mapHeight, pTile);
        }
    }
}

package com.nadawoo.nadazonepluspandamobile.invazionprototype.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.View;

import com.nadawoo.nadazonepluspandamobile.invazionprototype.R;
import com.nadawoo.nadazonepluspandamobile.invazionprototype.activities.MapActivity;
import com.nadawoo.nadazonepluspandamobile.invazionprototype.models.InvazionMapZone;

import java.util.Map;

public class GameMap extends View {
    private int mapHeight;
    private int mapWidth;
    private int mapTotalTiles;
    private int counterBackLine;
    private int counterTiles;
    private int width;
    private int height;

    private Context context;

    private Map<String, InvazionMapZone> gameObjects;
    private MapActivity mapActivity;

    private Bitmap bitmapTileOriginal;
    private Bitmap bmp_Copy;

    private Paint pTile;
    private Paint pLines;

    public GameMap(Context context, int mapHeight, int mapWidth) {
        super(context);

        this.mapHeight = mapHeight;
        this.mapWidth = mapWidth;
        this.context = context;

        mapActivity = new MapActivity();

        DisplayMetrics display = getResources().getDisplayMetrics();
        int width = display.widthPixels;
        int height = display.heightPixels;

        mapTotalTiles = mapHeight * mapWidth;
        counterBackLine = 0;
        counterTiles = 0;

        gameObjects = mapActivity.getMapObjects();

        pTile = new Paint();

        bitmapTileOriginal = BitmapFactory
                .decodeResource(getResources(), R.drawable.tile_map_ready);
        bmp_Copy = bitmapTileOriginal.copy(Bitmap.Config.ARGB_8888, true);
//        bmp_Copy.setPixel(width/mapWidth, height/mapHeight/2, Color.RED);

        pLines = new Paint();
        pLines.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        width = getWidth();
//        height = getHeight();
        DisplayMetrics display = getResources().getDisplayMetrics();
        height = display.heightPixels;

        // Quadrillage
        for (int i = 0; i < mapTotalTiles; i++) {
            counterTiles++;
            if (i % 9 == 0) {
                counterBackLine++;
            }
            if (i % 9 == 0) {
                counterTiles = 0;
            }
            canvas.drawBitmap(bmp_Copy, counterTiles * width / mapWidth * 2, counterBackLine * height / mapHeight, pTile);
        }
    }
}

package com.nadawoo.nadazonepluspandamobile.invazionprototype.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nadawoo.nadazonepluspandamobile.invazionprototype.R;
import com.nadawoo.nadazonepluspandamobile.invazionprototype.api.Client;
import com.nadawoo.nadazonepluspandamobile.invazionprototype.api.InvaZionService;
import com.nadawoo.nadazonepluspandamobile.invazionprototype.models.InvazionMap;
import com.nadawoo.nadazonepluspandamobile.invazionprototype.models.InvazionMapData;
import com.nadawoo.nadazonepluspandamobile.invazionprototype.models.InvazionMapZone;
import com.nadawoo.nadazonepluspandamobile.invazionprototype.models.Pantheon;
import com.nadawoo.nadazonepluspandamobile.invazionprototype.models.PantheonData;
import com.nadawoo.nadazonepluspandamobile.invazionprototype.views.GameMap;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapActivity extends AppCompatActivity implements View.OnTouchListener {

    private GameMap map;

    private int mapWidth;
    private int mapHeight;

    private int xTouched;
    private int yTouched;

    private int zombies[];
    private int citizens[];

    private HashMap<int[], String> mapContainer = new HashMap<>();

    InvazionMapData mapData;
    InvazionMapZone firstMapZone;
    List<InvazionMapZone> mapZones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map2);

        initVars();
        loadMapObjects();
        initMapObjects();
        initMapContainer();
        map = new GameMap(this, mapHeight, mapWidth);
        setContentView(map);

        map.setOnTouchListener(this);
    }

    private void loadMapObjects() {
        Client client = Client.getINSTANCE();
        InvaZionService service = client.getService();
        Call<InvazionMap> call = service.getMap();

        call.enqueue(new Callback<InvazionMap>() {
            @Override
            public void onResponse(@NotNull Call<InvazionMap> call, @NotNull Response<InvazionMap> response) {
                InvazionMap map = response.body();
                if (map != null) {
                    mapData = map.getInvazionMapData();
                    Log.i("MAPDATA", "onResponse: " + mapData.getZone().getCitizensNumber());
                }
            }

            @Override
            public void onFailure(@NotNull Call<InvazionMap> call, @NotNull Throwable t) {
                Toast.makeText(MapActivity.this, "Couldn't load the map objects!", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }

    private void initMapObjects() {

    }

    private void initMapContainer() {
        if (zombies != null) {
            mapContainer.put(zombies, "zombies");
        }
        if (citizens != null) {
            mapContainer.put(citizens, "citizens");
        }
    }

    private void initVars() {
        mapWidth = 10;
        mapHeight = 24;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            xTouched = (int) (event.getX() * mapWidth / map.getWidth());
            yTouched = (int) (event.getY() * mapHeight / map.getHeight());
        }

        Log.i("TOUCHED", "xPos : " + xTouched + " yPos : " + yTouched);

        map.postInvalidate();
        return true;
    }

    public HashMap<int[], String> getMapObjects() {
        return mapContainer;
    }
}

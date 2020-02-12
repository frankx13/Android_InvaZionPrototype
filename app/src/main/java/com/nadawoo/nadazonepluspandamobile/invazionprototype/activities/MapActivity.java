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
import com.nadawoo.nadazonepluspandamobile.invazionprototype.views.GameMap;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private InvazionMap invazionMap;
    private InvazionMapData invazionMapData;
    private Map<String, InvazionMapZone> mapContainer = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map2);

        initVars();
        loadMapData();
        map = new GameMap(this, mapHeight, mapWidth);
        setContentView(map);

        map.setOnTouchListener(this);
    }

    private void loadMapData() {
        Client client = Client.getINSTANCE();
        InvaZionService service = client.getService();
        Call<InvazionMap> call = service.getMap();

        call.enqueue(new Callback<InvazionMap>() {
            @Override
            public void onResponse(@NotNull Call<InvazionMap> call, @NotNull Response<InvazionMap> response) {
                invazionMap = response.body();
                if (invazionMap != null) {
                    invazionMapData = invazionMap.getInvazionMapData();
                    Log.i("MAPDATA", "onResponse: " + invazionMapData.getInvazionMapZone().get("0_0").getNumberCitizens());
                }
                fillMapDataContainer();
            }

            @Override
            public void onFailure(@NotNull Call<InvazionMap> call, @NotNull Throwable t) {
                Toast.makeText(MapActivity.this, "Couldn't load the map objects!", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }

    private void fillMapDataContainer() {
        mapContainer = invazionMapData.getInvazionMapZone();
    }

    private void initVars() {
        mapWidth = 19;
        mapHeight = 24;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            xTouched = (int) (event.getX() * mapWidth / map.getWidth());
            yTouched = (int) (event.getY() * mapHeight / map.getHeight());

            Log.i("TOUCHED", "xPos : " + xTouched + " yPos : " + yTouched);

            //TODO fix blank screen when postInvalidate() is called
//            map.postInvalidate();
        }

        return true;
    }

    public Map<String, InvazionMapZone> getMapObjects() {
        return mapContainer;
    }
}

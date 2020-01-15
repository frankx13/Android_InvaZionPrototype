package com.nadawoo.nadazonepluspandamobile.invazionprototype.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.nadawoo.nadazonepluspandamobile.invazionprototype.R;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

//TODO Implement search options on citizens
//TODO Generate the map
//TODO FINAL: Fetch data from DB directly
public class MapActivity extends AppCompatActivity {

    //UI
    @BindView(R.id.exit_btn)
    Button exitMap;

    //DATA


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        ButterKnife.bind(this);
        closeMap();
        Log.i("CONTENT STORAGE", "writeRawData: " + (Arrays.toString(this.getExternalFilesDirs(null))));
    }

    private void closeMap() {
        exitMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

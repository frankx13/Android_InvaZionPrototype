package com.nadawoo.nadazonepluspandamobile.invazionprototype;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    private Button btnMap;
    private Button btnCitizens;
    private Button btnRankings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnMap = findViewById(R.id.btnCarte);
        btnCitizens = findViewById(R.id.btnCitoyens);
        btnRankings = findViewById(R.id.btnPanthéon);

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, MapActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnCitizens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, CitizensActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnRankings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuActivity.this, "Le Panthéon est en développement :)", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MenuActivity.this, RankingsActivity.class);
//                startActivity(intent);
//                finish();
            }
        });
    }
}

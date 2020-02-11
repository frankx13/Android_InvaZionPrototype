package com.nadawoo.nadazonepluspandamobile.invazionprototype.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nadawoo.nadazonepluspandamobile.invazionprototype.R;
import com.nadawoo.nadazonepluspandamobile.invazionprototype.adapters.PantheonAdapter;
import com.nadawoo.nadazonepluspandamobile.invazionprototype.api.Client;
import com.nadawoo.nadazonepluspandamobile.invazionprototype.api.InvaZionService;
import com.nadawoo.nadazonepluspandamobile.invazionprototype.models.Pantheon;
import com.nadawoo.nadazonepluspandamobile.invazionprototype.models.PantheonData;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RankingsActivity extends AppCompatActivity {

    @BindView(R.id.pantheon_recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.exit_pantheon_btn)
    Button exitPantheonBtn;

    List<PantheonData> bestTenCitizens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rankings);

        ButterKnife.bind(this);
        bestTenCitizens = new ArrayList<>();

        exitTopTenBtn();
        callTopTenAPI();
    }

    private void exitTopTenBtn() {
        exitPantheonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void callTopTenAPI() {
        Client client = Client.getINSTANCE();
        InvaZionService service = client.getService();
        Call<Pantheon> call = service.getPantheonTopTen();

        call.enqueue(new Callback<Pantheon>() {
            @Override
            public void onResponse(@NotNull Call<Pantheon> call, @NotNull Response<Pantheon> response) {
                Pantheon pantheon = response.body();
                if (pantheon != null){
                    bestTenCitizens = pantheon.getDatas();
                    generatePantheon();
                }
            }

            @Override
            public void onFailure(@NotNull Call<Pantheon> call, @NotNull Throwable t) {
                Toast.makeText(RankingsActivity.this, "Couldn't load the Pantheon!", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void generatePantheon() {
        PantheonAdapter recyclerAdapter = new PantheonAdapter(this, bestTenCitizens);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerAdapter);
    }
}

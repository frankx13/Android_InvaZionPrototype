package com.nadawoo.nadazonepluspandamobile.invazionprototype.activities;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.nadawoo.nadazonepluspandamobile.invazionprototype.R;
import com.nadawoo.nadazonepluspandamobile.invazionprototype.api.Client;
import com.nadawoo.nadazonepluspandamobile.invazionprototype.api.InvaZionService;
import com.nadawoo.nadazonepluspandamobile.invazionprototype.models.Citizen;
import com.nadawoo.nadazonepluspandamobile.invazionprototype.models.CitizenData;
import com.nadawoo.nadazonepluspandamobile.invazionprototype.utils.RandomNumberGenerator;
import com.nadawoo.nadazonepluspandamobile.invazionprototype.utils.UIUtils;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CitizensActivity extends AppCompatActivity {

    //---UI---///
    @BindView(R.id.citizens_recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.list_citizens_btn)
    Button listCitizensBtn;
    @BindView(R.id.search_one_citizen_btn)
    Button searchCitizenBtn;
    @BindView(R.id.search_found_container)
    LinearLayout containerSearchFoundCitizen;
    @BindView(R.id.citizen_name)
    TextView citizenName;
    @BindView(R.id.citizen_found_id)
    TextView citizenID;
    @BindView(R.id.citizen_map_id)
    TextView citizenMapID;
    @BindView(R.id.citizen_intown)
    TextView citizenInTown;
    @BindView(R.id.citizen_location)
    TextView citizenLocation;
    @BindView(R.id.citizen_last_death)
    TextView citizenLastDeath;
    @BindView(R.id.search_back_btn)
    Button exitSearchBtn;
    @BindView(R.id.container_search_selection)
    LinearLayout containerSearchInputCitizen;
    @BindView(R.id.user_search_input_et)
    EditText userSearchInput;
    @BindView(R.id.search_input_back_btn)
    Button searchInputBackBtn;
    @BindView(R.id.search_input_validate_btn)
    Button searchInputValidateBtn;
    @BindView(R.id.user_image)
    ImageView userImage;
    //---UI---///
    //---DATA---///
    private String searchCitizenInput = "0";
    private String searchCitizenInputTest = "0";
    private Citizen citizenSelection;
    private ArrayList citizens;
    private int citizen_id = 0;
    private String url;
    //---DATA---///

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citizens);

        ButterKnife.bind(this);
        citizens = new ArrayList();

        showAllCitizens();
        searchOneCitizen();
    }

    //TODO fixed the bug that forbid the call on players with pictos active
    private void searchOneCitizen() {
        searchCitizenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUserSelection();
            }
        });
    }

    private void displaySearchCitizen() {
        containerSearchFoundCitizen.setVisibility(View.VISIBLE);
        CitizenData mBaseCitStruc = citizenSelection.getCitizenData();
        Log.i("DATA", "citizendata: " + mBaseCitStruc);
        if (!mBaseCitStruc.getCitizenPseudo().isEmpty()) {
            citizenName.setText(mBaseCitStruc.getCitizenPseudo());
        } else {
            citizenName.setText(getResources().getString(R.string.username_problem_txt));
        }
        if (mBaseCitStruc.getCitizenId() > 0) {
            citizenID.setText(getResources().getString(R.string.citizen_selection, String.valueOf(mBaseCitStruc.getCitizenId())));
        } else {
            citizenID.setText(getResources().getString(R.string.citizenID_problem_txt));
        }
        if (mBaseCitStruc.getMapId() != (0)) {
            citizenMapID.setText(getResources().getString(R.string.citizen_mapid, String.valueOf(mBaseCitStruc.getMapId())));
        } else {
            citizenMapID.setText(getResources().getString(R.string.map_problem_txt));
        }
        if (mBaseCitStruc.getCityId() > 0) {
            citizenInTown.setText(getResources().getString(R.string.is_in_town));
        } else {
            citizenInTown.setText(getResources().getString(R.string.not_in_town));
        }
        if (!mBaseCitStruc.getLastDeath().isEmpty()) {
            citizenLastDeath.setText(getResources().getString(R.string.citizen_last_death_date, mBaseCitStruc.getLastDeath()));
        } else {
            citizenLastDeath.setText(getResources().getString(R.string.last_death_problem_txt));
        }
        citizenLocation.setText(getResources().getString(R.string.citizen_location, mBaseCitStruc.getCoordX(), mBaseCitStruc.getCoordY()));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            applyRandomColorOnFace();
        }

        exitSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listCitizensBtn.setVisibility(View.VISIBLE);
                searchCitizenBtn.setVisibility(View.VISIBLE);
                containerSearchFoundCitizen.setVisibility(View.GONE);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void applyRandomColorOnFace() {
        float r = RandomNumberGenerator.randomGenerator()*2;
        float g = RandomNumberGenerator.randomGenerator()*2;
        float b = RandomNumberGenerator.randomGenerator()*2;
        userImage.setBackgroundColor(Color.rgb(r,g,b));
    }

    private void getUserSelection() {
        listCitizensBtn.setVisibility(View.GONE);
        searchCitizenBtn.setVisibility(View.GONE);
        containerSearchInputCitizen.setVisibility(View.VISIBLE);

        searchInputValidateBtn.setOnClickListener(v -> {
            searchCitizenInputTest = (userSearchInput.getEditableText().toString());
            if (!searchCitizenInputTest.equals("0")) {
                getOneCitizen();
            }
        });
        searchInputBackBtn.setOnClickListener(v -> {
            listCitizensBtn.setVisibility(View.VISIBLE);
            searchCitizenBtn.setVisibility(View.VISIBLE);
            containerSearchInputCitizen.setVisibility(View.GONE);
            userSearchInput.clearComposingText();
        });
    }

    private void returnUserSelection() {
        userSearchInput.clearComposingText();
        searchCitizenInput = searchCitizenInputTest;
        hideUserInput();
        userSearchInput.clearComposingText();
        displaySearchCitizen();
        UIUtils.hideKeyboard(this);
    }

    private void hideUserInput() {
        containerSearchInputCitizen.setVisibility(View.GONE);
        containerSearchFoundCitizen.setVisibility(View.VISIBLE);
    }

    private void getOneCitizen() {
        Client client = Client.getINSTANCE();
        InvaZionService service = client.getService();
        urlBuilder();
        Call<Citizen> call = service.getOneCitizen(url);

        call.enqueue(new Callback<Citizen>() {
            @Override
            public void onResponse(@NotNull Call<Citizen> call, @NotNull Response<Citizen> response) {
                Citizen citizenTest = response.body();
                if (citizenTest != null) {
                    citizenSelection = citizenTest;
                    citizen_id = citizenSelection.getCitizenData().getCitizenId();
                    Toast.makeText(CitizensActivity.this, String.valueOf(citizen_id), Toast.LENGTH_SHORT).show();
                    returnUserSelection();
                } else {
                    Toast.makeText(CitizensActivity.this, "Null!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NotNull Call<Citizen> call, @NotNull Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void urlBuilder() {
        url = "api/citizens.php?action=get&citizen_id=" + searchCitizenInputTest;
    }

    private void showAllCitizens() {
        listCitizensBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO implement a RV to list the citizens list (15 max)
//                getAllCitizensRaw();
                Toast.makeText(CitizensActivity.this, "Disponible dans la prochaine MAJ!", Toast.LENGTH_SHORT).show();
            }
        });
    }

//    private void getAllCitizensRaw() {
//        //TODO Create a proper Singleton to contain the Retrofit instance
            //We use ScalarsFactory in order to automatically parse through the JSON response from
            //the API and convert it to a String Object
//        Retrofit retrofit = new Retrofit.Builder()
//                .addConverterFactory(ScalarsConverterFactory.create())
//                .baseUrl("https://invazion.nadazone.fr/")
//                .build();
//
//        InvaZionService scalarService = retrofit.create(InvaZionService.class);
//        Call<String> stringCall = scalarService.getCitizens("api/citizens.php?action=get&map_id=1");
//        stringCall.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(@NotNull Call<String> call, @NotNull Response<String> response) {
//                if (response.isSuccessful()) {
//                    String responseString = response.body();
//                    //TODO Extends limits to whole citizens when map is ready
//                    String[] splitJson = responseString.split(Pattern.quote("\"50\": {"));
//
//                    //---METADATA---//
//                    //Use this for the metadata when needed
//                    //String metasInit = splitJson[0];
//                    //---METADATA---//
//
//                    String datasInit = splitJson[1];
//
//                    matchingPattern(datasInit);
//                }
//            }
//
//            @Override
//            public void onFailure(@NotNull Call<String> call, @NotNull Throwable t) {
//
//            }
//        });
//    }

        //Parse String elements to fill the objects' list Citizens
//    private void matchingPattern(String data) {
//        String[] pattern = data.split(Pattern.quote("{,"), 2);
//        citizens.addAll(Arrays.asList(pattern));
            //TODO test the matcher and its pattern
//        if (!citizens.isEmpty())
//            Log.i("PATTERNMATCHER", "matchingPattern: " + citizens.toString());
//        else
//            Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show();
//    }
}

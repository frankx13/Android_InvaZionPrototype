package com.nadawoo.nadazonepluspandamobile.invazionprototype.api;

import com.nadawoo.nadazonepluspandamobile.invazionprototype.models.Citizen;
import com.nadawoo.nadazonepluspandamobile.invazionprototype.models.GameMap;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface InvaZionService {

    @GET("api/maps.php?action=get&map_id=1")
        // Map API
    Call<List<GameMap>> getMap();

    @GET("api/citizens.php?action=get&map_id=1")
        // Citizens API
    Call<String> getCitizens(@Query("append-url") String url);

    @GET
        // Citizen API
    Call<Citizen> getOneCitizen(@Url String url);

    //WORK OK
    @GET("api/citizens.php?action=get&citizen_id=86")
    // Citizen API
    Call<Citizen> getOneCitizenBru();
}
package com.nadawoo.nadazonepluspandamobile.invazionprototype.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
    private static Client INSTANCE = new Client();

    private Retrofit retrofit;

    private Client() { // we pass an URL and we create a new instance of Retrofit with its Builder


        String API_URL = "http://invazion.nadazone.fr/";
        retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Client getINSTANCE() {
        return INSTANCE;
    }

    public InvaZionService getService() {
        return retrofit.create(InvaZionService.class);
    }
}

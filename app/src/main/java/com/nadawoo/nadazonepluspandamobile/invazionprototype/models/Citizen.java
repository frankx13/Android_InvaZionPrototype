package com.nadawoo.nadazonepluspandamobile.invazionprototype.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Citizen {

    @SerializedName("datas")
    @Expose
    private CitizenData citizenData;

    public Citizen(CitizenData citizenData) {
        this.citizenData = citizenData;
    }

    public CitizenData getCitizenData() {
        return citizenData;
    }

    public void setCitizenData(CitizenData citizenData) {
        this.citizenData = citizenData;
    }
}
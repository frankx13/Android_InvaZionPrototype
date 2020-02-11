package com.nadawoo.nadazonepluspandamobile.invazionprototype.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InvazionMapZone {
    @SerializedName("zombies")
    @Expose
    private Integer zombiesNumber;
    @SerializedName("citizens")
    @Expose
    private Integer citizensNumber;

    public InvazionMapZone(Integer zombiesNumber, Integer citizensNumber) {
        this.zombiesNumber = zombiesNumber;
        this.citizensNumber = citizensNumber;
    }

    public Integer getZombiesNumber() {
        return zombiesNumber;
    }

    public void setZombiesNumber(Integer zombies) {
        this.zombiesNumber = zombies;
    }

    public Integer getCitizensNumber() {
        return citizensNumber;
    }

    public void setCitizensNumber(Integer citizensNumber) {
        this.citizensNumber = citizensNumber;
    }
}

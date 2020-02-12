package com.nadawoo.nadazonepluspandamobile.invazionprototype.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InvazionMapZone {
    @SerializedName("zombies")
    @Expose
    private Integer numberZombies;
    @SerializedName("citizens")
    @Expose
    private Integer numberCitizens;

    public InvazionMapZone(Integer numberZombies, Integer numberCitizens) {
        this.numberZombies = numberZombies;
        this.numberCitizens = numberCitizens;
    }

    public Integer getNumberZombies() {
        return numberZombies;
    }

    public void setNumberZombies(Integer numberZombies) {
        this.numberZombies = numberZombies;
    }

    public Integer getNumberCitizens() {
        return numberCitizens;
    }

    public void setNumberCitizens(Integer numberCitizens) {
        this.numberCitizens = numberCitizens;
    }
}

package com.nadawoo.nadazonepluspandamobile.invazionprototype.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PantheonData {
    @SerializedName("citizen_id")
    @Expose
    private Integer citizenId;
    @SerializedName("citizen_pseudo")
    @Expose
    private String citizenPseudo;
    @SerializedName("last_death")
    @Expose
    private String lastDeath;
    @SerializedName("survival_time")
    @Expose
    private int survivalTime;

    public Integer getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(Integer citizenId) {
        this.citizenId = citizenId;
    }

    public String getCitizenPseudo() {
        return citizenPseudo;
    }

    public void setCitizenPseudo(String citizenPseudo) {
        this.citizenPseudo = citizenPseudo;
    }

    public String getLastDeath() {
        return lastDeath;
    }

    public void setLastDeath(String lastDeath) {
        this.lastDeath = lastDeath;
    }

    public int getSurvivalTime() {
        return survivalTime;
    }

    public void setSurvivalTime(int survivalTime) {
        this.survivalTime = survivalTime;
    }
}

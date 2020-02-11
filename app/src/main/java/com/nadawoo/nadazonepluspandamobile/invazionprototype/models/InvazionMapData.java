package com.nadawoo.nadazonepluspandamobile.invazionprototype.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InvazionMapData {
    @SerializedName("zones")
    @Expose
    private InvazionMapZone zone;

    public InvazionMapData(InvazionMapZone zone) {
        this.zone = zone;
    }

    public InvazionMapZone getZone() {
        return zone;
    }

    public void setZone(InvazionMapZone zone) {
        this.zone = zone;
    }
}

package com.nadawoo.nadazonepluspandamobile.invazionprototype.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class InvazionMapData {
    @SerializedName("zones")
    @Expose
    public Map<String, InvazionMapZone> invazionMapZone;

    public InvazionMapData(Map<String, InvazionMapZone> invazionMapZone) {
        this.invazionMapZone = invazionMapZone;
    }

    public Map<String, InvazionMapZone> getInvazionMapZone() {
        return invazionMapZone;
    }

    public void setInvazionMapZone(Map<String, InvazionMapZone> invazionMapZone) {
        this.invazionMapZone = invazionMapZone;
    }
}

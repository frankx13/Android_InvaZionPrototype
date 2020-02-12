package com.nadawoo.nadazonepluspandamobile.invazionprototype.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InvazionMap {
    @SerializedName("datas")
    @Expose
    public InvazionMapData invazionMapData;

    public InvazionMap(InvazionMapData invazionMapData) {
        this.invazionMapData = invazionMapData;
    }

    public InvazionMapData getInvazionMapData() {
        return invazionMapData;
    }

    public void setInvazionMapData(InvazionMapData invazionMapData) {
        this.invazionMapData = invazionMapData;
    }
}

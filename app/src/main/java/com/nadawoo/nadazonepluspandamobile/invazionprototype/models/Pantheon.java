package com.nadawoo.nadazonepluspandamobile.invazionprototype.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pantheon {

    @SerializedName("datas")
    @Expose
    private List<PantheonData> datas = null;

    public List<PantheonData> getDatas() {
        return datas;
    }

    public void setDatas(List<PantheonData> datas) {
        this.datas = datas;
    }

}

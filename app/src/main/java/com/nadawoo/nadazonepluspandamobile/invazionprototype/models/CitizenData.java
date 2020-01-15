package com.nadawoo.nadazonepluspandamobile.invazionprototype.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CitizenData {

    @SerializedName("citizen_id")
    @Expose
    private Integer citizenId;
    @SerializedName("citizen_pseudo")
    @Expose
    private String citizenPseudo;
    @SerializedName("map_id")
    @Expose
    private Integer mapId;
    @SerializedName("city_id")
    @Expose
    private Integer cityId;
    @SerializedName("coord_y")
    @Expose
    private Integer coordY;
    @SerializedName("coord_x")
    @Expose
    private Integer coordX;
    @SerializedName("action_points")
    @Expose
    private Integer actionPoints;
    @SerializedName("last_death")
    @Expose
    private String lastDeath;
    @SerializedName("speciality")
    @Expose
    private String speciality;
    @SerializedName("item_amount")
    @Expose
    private Object itemAmount;
    @SerializedName("control_points")
    @Expose
    private Integer controlPoints;
    @SerializedName("can_change_speciality")
    @Expose
    private Integer canChangeSpeciality;
    @SerializedName("distance_to_city")
    @Expose
    private Integer distanceToCity;
    @SerializedName("bag_size")
    @Expose
    private Integer bagSize;
    @SerializedName("bag_items")
    @Expose
    private List<Object> bagItems = null;
    @SerializedName("pictos")
    @Expose
    private List<Object> pictos = null;

    public CitizenData(Integer citizenId, String citizenPseudo) {
        this.citizenId = citizenId;
        this.citizenPseudo = citizenPseudo;
    }

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

    public Integer getMapId() {
        return mapId;
    }

    public void setMapId(Integer mapId) {
        this.mapId = mapId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getCoordY() {
        return coordY;
    }

    public void setCoordY(Integer coordY) {
        this.coordY = coordY;
    }

    public Integer getCoordX() {
        return coordX;
    }

    public void setCoordX(Integer coordX) {
        this.coordX = coordX;
    }

    public Integer getActionPoints() {
        return actionPoints;
    }

    public void setActionPoints(Integer actionPoints) {
        this.actionPoints = actionPoints;
    }

    public String getLastDeath() {
        return lastDeath;
    }

    public void setLastDeath(String lastDeath) {
        this.lastDeath = lastDeath;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Object getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(Object itemAmount) {
        this.itemAmount = itemAmount;
    }

    public Integer getControlPoints() {
        return controlPoints;
    }

    public void setControlPoints(Integer controlPoints) {
        this.controlPoints = controlPoints;
    }

    public Integer getCanChangeSpeciality() {
        return canChangeSpeciality;
    }

    public void setCanChangeSpeciality(Integer canChangeSpeciality) {
        this.canChangeSpeciality = canChangeSpeciality;
    }

    public Integer getDistanceToCity() {
        return distanceToCity;
    }

    public void setDistanceToCity(Integer distanceToCity) {
        this.distanceToCity = distanceToCity;
    }

    public Integer getBagSize() {
        return bagSize;
    }

    public void setBagSize(Integer bagSize) {
        this.bagSize = bagSize;
    }

    public List<Object> getBagItems() {
        return bagItems;
    }

    public void setBagItems(List<Object> bagItems) {
        this.bagItems = bagItems;
    }

    public List<Object> getPictos() {
        return pictos;
    }

    public void setPictos(List<Object> pictos) {
        this.pictos = pictos;
    }
}

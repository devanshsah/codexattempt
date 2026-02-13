package com.nobrokerclone.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class PropertyRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String city;
    @NotBlank
    private String locality;
    @Min(1)
    private int rent;
    @Min(1)
    private int bhk;
    @NotBlank
    private String ownerEmail;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getLocality() { return locality; }
    public void setLocality(String locality) { this.locality = locality; }
    public int getRent() { return rent; }
    public void setRent(int rent) { this.rent = rent; }
    public int getBhk() { return bhk; }
    public void setBhk(int bhk) { this.bhk = bhk; }
    public String getOwnerEmail() { return ownerEmail; }
    public void setOwnerEmail(String ownerEmail) { this.ownerEmail = ownerEmail; }
}

package com.example.guessplayerbackend.entity.dto;

public class NatinalityWithURL {
    private String nationality;
    private String nationalityUrl;

    public NatinalityWithURL(String nationName, String natioUrl) {
        this.nationality = nationName;
        this.nationalityUrl = natioUrl;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNationalityUrl() {
        return nationalityUrl;
    }

    public void setNationalityUrl(String nationalityUrl) {
        this.nationalityUrl = nationalityUrl;
    }

    @Override
    public String toString() {
        return "NatinalityWithURL{" +
                "nationName='" + nationality + '\'' +
                ", natioUrl='" + nationalityUrl + '\'' +
                '}';
    }
}

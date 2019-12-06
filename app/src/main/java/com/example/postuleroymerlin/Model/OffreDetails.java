package com.example.postuleroymerlin.Model;

public class OffreDetails {

    private OffrePreface offrePreface;
    private String paragraphe1;
    private String paragraphe2;
    private String profil;
    private String uri;
    private String lien;

    public OffreDetails(OffrePreface offrePreface, String paragraphe1, String paragraphe2, String profil, String uri, String lien) {
        this.offrePreface = offrePreface;
        this.paragraphe1 = paragraphe1;
        this.paragraphe2 = paragraphe2;
        this.profil = profil;
        this.uri = uri;
        this.lien = lien;
    }
    public OffreDetails(){

    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien =  lien;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public OffrePreface getOffrePreface() {
        return offrePreface;
    }

    public void setOffrePreface(OffrePreface offrePreface) {
        this.offrePreface = offrePreface;
    }

    public String getParagraphe1() {
        return paragraphe1;
    }

    public void setParagraphe1(String paragraphe1) {
        this.paragraphe1 = paragraphe1;
    }

    public String getParagraphe2() {
        return paragraphe2;
    }

    public void setParagraphe2(String paragraphe2) {
        this.paragraphe2 = paragraphe2;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }
}

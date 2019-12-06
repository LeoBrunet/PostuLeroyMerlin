package com.example.postuleroymerlin.Model;

import java.util.ArrayList;
import java.util.List;

public class OffrePreface {

    private String titre;
    private String contrat;
    private String lieu;
    private String experience;
    private String filiere;
    private String publication;

    private List<OffrePreface> offres = new ArrayList<>();

    public OffrePreface(String titre, String contrat, String lieu, String experience, String filiere, String publication) {
        this.titre = titre;
        this.contrat = contrat;
        this.lieu = lieu;
        this.experience = experience;
        this.filiere = filiere;
        this.publication = publication;
        offres.add(this);
    }

    public List<OffrePreface> getOffres(){
        return this.offres;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContrat() {
        return contrat;
    }

    public void setContrat(String contrat) {
        this.contrat = contrat;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }
}

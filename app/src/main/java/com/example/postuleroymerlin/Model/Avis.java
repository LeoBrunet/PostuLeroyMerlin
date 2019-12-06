package com.example.postuleroymerlin.Model;

import java.util.ArrayList;
import java.util.List;

public class Avis {

    private String note;
    private String titre;
    private String create;
    private String Description;

    private List<Avis> avis = new ArrayList<>();


    public Avis(String titre, String create, String description, String note) {
        this.note = note;
        this.titre = titre;
        this.create = create;
        this.Description = description;
        avis.add(this);
    }


    public List<Avis> getAvis() {
        return avis;
    }

    public void setAvis(List<Avis> avis) {
        this.avis = avis;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getCreate() {
        return create;
    }

    public void setCreate(String create) {
        this.create = create;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}

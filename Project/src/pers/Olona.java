package pers;

import java.util.Date;

import annotation.Attribut;
import annotation.Table;

@Table(value = "Personne")
public class Olona {
    @Attribut(value = "nom", varchar = true)
    String name;
    @Attribut(varchar = true)
    String firstname;
    @Attribut(value = "dateins", varchar = true)
    Date date;
    @Attribut()
    int taille;
    @Attribut
    double quantite;

    public Olona(String name, String firstname, int taille, double quantite) {
        this.setName(name);
        this.setFirstname(firstname);
        this.setTaille(taille);
        this.setQuantite(quantite);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.List;

/**
 *
 * @author HASNA
 */
public class Pays {
    private String id;
    private String nom;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Pays{" + "id=" + id + ", nom=" + nom + '}';
    }

    public Pays() {
    }

    public Pays(String id, String nom) {
        this.id = id;
        this.nom = nom;
    }

   
     
    
}

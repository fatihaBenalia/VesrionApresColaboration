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
public class AgendaRDV {
    private String id;
    private List<RendezVous> rendezvouss;
    private boolean effectue;

    public AgendaRDV() {
    }

    public AgendaRDV(String id, List<RendezVous> rendezvouss, boolean effectue) {
        this.id = id;
        this.rendezvouss = rendezvouss;
        this.effectue = effectue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<RendezVous> getRendezvouss() {
        return rendezvouss;
    }

    public void setRendezvouss(List<RendezVous> rendezvouss) {
        this.rendezvouss = rendezvouss;
    }

    public boolean isEffectue() {
        return effectue;
    }

    public void setEffectue(boolean effectue) {
        this.effectue = effectue;
    }

    @Override
    public String toString() {
        return "AgendaRDV{" + "id=" + id + ", effectue=" + effectue + '}';
    }

   
    
}

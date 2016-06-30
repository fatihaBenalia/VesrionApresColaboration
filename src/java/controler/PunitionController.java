package controler;

import bean.Dossier;
import bean.Punition;
import controler.util.JsfUtil;
import controler.util.JsfUtil.PersistAction;
import service.PunitionFacade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import service.DossierFacade;

@ManagedBean(name = "punitionController")
@SessionScoped
public class PunitionController implements Serializable {

    @EJB
    private service.PunitionFacade ejbFacade;
    private List<Punition> items = null;
    private Punition selected;
     @EJB
     private DossierFacade dossierFacade;
    private int typeDossier;
    Date dateSytem = new Date();
    
    

    public PunitionController() {
    }

    public Date getDateSytem() {
        return dateSytem;
    }

    public void setDateSytem(Date dateSytem) {
        this.dateSytem = dateSytem;
    }

    public int getTypeDossier() {
        return typeDossier;
    }

    public void setTypeDossier(int typeDossier) {
        this.typeDossier = typeDossier;
    }
    
    public void punitionSelonDate(Dossier dossier ){
        if (selected.getDateFin().equals(new Date())) {
            dossier.setEtat(-1);
            typeDossier=2;
        } else {
            typeDossier=1;
        }
        
        
    }

    public void punition(Dossier dossier) {
        selected = new Punition();
        selected.setDossier(dossier);
    }
    public void createPunition() {
        
        int res = dossierFacade.createPunition(selected);
        if (res > 0) {
            JsfUtil.addSuccessMessage("Le Dossier Que Vous avez Choisi est Puni Avec Succes");
            selected.getDossier().getPunitions().add(selected);
            punitionSelonDate(selected.getDossier());
        } else {
            JsfUtil.addErrorMessage("Le Dossier est Non puni : Désolé ");

        }
    }

    public Punition getSelected() {
        if (selected == null) {
            selected = new Punition();
        }
        return selected;
    }

    public void setSelected(Punition selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private PunitionFacade getFacade() {
        return ejbFacade;
    }

    public Punition prepareCreate() {
        selected = new Punition();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("PunitionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("PunitionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("PunitionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Punition> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public List<Punition> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Punition> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Punition.class)
    public static class PunitionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PunitionController controller = (PunitionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "punitionController");
            return controller.getFacade().find(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Punition) {
                Punition o = (Punition) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Punition.class.getName()});
                return null;
            }
        }

    }

}

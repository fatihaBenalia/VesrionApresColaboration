package controler;

import bean.Dossier;
import bean.Parrinage;
import controler.util.JsfUtil;
import controler.util.JsfUtil.PersistAction;
import service.ParrinageFacade;

import java.io.Serializable;
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

@ManagedBean(name = "parrinageController")
@SessionScoped
public class ParrinageController implements Serializable {

    @EJB
    private service.ParrinageFacade ejbFacade;
    private List<Parrinage> items = null;
    private Parrinage selected;

    @EJB
    private DossierFacade dossierFacade;
    private String typeParrainage;

    ////////////////////////////Creation Parrainage ////////////////////
    public void ajouterParrainage(Dossier dossier) {
        selected = new Parrinage();
        selected.setDossier(dossier);
    }
    public void completerParrainage(Dossier dossier) {
        selected = new Parrinage();
        selected.setDossier(dossier);
       
    }

    public void createParrinage( List<Dossier> dossiers) {
        System.out.println("haaa  selected "+selected.getDossier());
        System.out.println("haaa  selected.getParrain() "+selected.getParrain());
        dossiers.remove(dossiers.indexOf(selected.getDossier()));
        int res = dossierFacade.ajouterParrinage(selected, selected.getParrain(),typeParrainage);
        if (res > 0) {
            JsfUtil.addSuccessMessage("Parrinage Ajouté Avec Succes");
            selected.getDossier().getParrinages().add(selected);
            
        } else {
            JsfUtil.addErrorMessage("Parrinage Non Ajouté : Désolé ");

        }
    }
    
    public void completerParrinage() {
        System.out.println("haaa  selected "+selected.getDossier());
        System.out.println("haaa  selected.getParrain() "+selected.getParrain());
        int res = dossierFacade.completerParrinage(selected, selected.getParrain());
        if (res > 0) {
            JsfUtil.addSuccessMessage("Parrinage Ajouté Avec Succes");
            selected.getDossier().getParrinages().add(selected);
        } else {
            JsfUtil.addErrorMessage("Parrinage Non Ajouté : Désolé ");

        }
    }
    
    public void MontantParrinageSelonType(Parrinage parrinage){
        
        if(typeParrainage.equalsIgnoreCase("Complet"))
        {
            selected.setMontant(600);
        } else if (typeParrainage.equalsIgnoreCase("Partiel")){
            selected.setMontant(300);
        }
    }
    //////////////////////////
    public ParrinageController() {
    }

    public String getTypeParrainage() {
        return typeParrainage;
    }

    public void setTypeParrainage(String typeParrainage) {
        this.typeParrainage = typeParrainage;
    }
    
    public Parrinage getSelected() {
        if (selected == null) {
            selected = new Parrinage();
        }
        return selected;
    }

    public void setSelected(Parrinage selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ParrinageFacade getFacade() {
        return ejbFacade;
    }

    public Parrinage prepareCreate() {
        selected = new Parrinage();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ParrinageCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ParrinageUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ParrinageDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Parrinage> getItems() {
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

    public List<Parrinage> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Parrinage> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Parrinage.class)
    public static class ParrinageControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ParrinageController controller = (ParrinageController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "parrinageController");
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
            if (object instanceof Parrinage) {
                Parrinage o = (Parrinage) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Parrinage.class.getName()});
                return null;
            }
        }

    }

}

package controler;

import bean.EtatPedagogiqueItem;
import bean.EtatSanteOrphelin;
import bean.Orphelin;
import controler.util.JsfUtil;
import controler.util.JsfUtil.PersistAction;
import service.OrphelinFacade;

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

@ManagedBean(name = "orphelinController")
@SessionScoped
public class OrphelinController implements Serializable {

    @EJB
    private service.OrphelinFacade ejbFacade;
    private List<Orphelin> items = null;
    private Orphelin selected;
    private int sswitch=0;
    
    @EJB
    private DossierFacade dossierFacade;
    
    public void allEtatSanteOrphe(Orphelin orphelin){
        sswitch=1;
        selected=orphelin;
        selected.setEtatSanteOrphelin((EtatSanteOrphelin) dossierFacade.allEtatSanteOrphelin(orphelin));
        
    }
    
    public void allEtatPeda(Orphelin orphelin){
        sswitch=2;
        selected=orphelin;
        selected.setEtatPedagogiqueItem((EtatPedagogiqueItem) dossierFacade.allEtatPedaParOrph(orphelin));
        
    }
    
    public OrphelinController() {
    }

    public int getSswitch() {
        return sswitch;
    }

    public void setSswitch(int sswitch) {
        this.sswitch = sswitch;
    }

    
    public Orphelin getSelected() {
        if(selected==null){
            selected=new Orphelin();
        }
        return selected;
    }

    public void setSelected(Orphelin selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private OrphelinFacade getFacade() {
        return ejbFacade;
    }

    public Orphelin prepareCreate() {
        selected = new Orphelin();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("OrphelinCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("OrphelinUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("OrphelinDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Orphelin> getItems() {
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

    public List<Orphelin> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Orphelin> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Orphelin.class)
    public static class OrphelinControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            OrphelinController controller = (OrphelinController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "orphelinController");
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
            if (object instanceof Orphelin) {
                Orphelin o = (Orphelin) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Orphelin.class.getName()});
                return null;
            }
        }

    }

}

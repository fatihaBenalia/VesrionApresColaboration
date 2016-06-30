package controler;

import bean.RemplissageItemPhilantrope;
import controler.util.JsfUtil;
import controler.util.JsfUtil.PersistAction;
import service.RemplissageItemPhilantropeFacade;

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

@ManagedBean(name = "remplissageItemPhilantropeController")
@SessionScoped
public class RemplissageItemPhilantropeController implements Serializable {

    @EJB
    private service.RemplissageItemPhilantropeFacade ejbFacade;
    private List<RemplissageItemPhilantrope> items = null;
    private RemplissageItemPhilantrope selected;

    public RemplissageItemPhilantropeController() {
    }

    public RemplissageItemPhilantrope getSelected() {
        return selected;
    }

    public void setSelected(RemplissageItemPhilantrope selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private RemplissageItemPhilantropeFacade getFacade() {
        return ejbFacade;
    }

    public RemplissageItemPhilantrope prepareCreate() {
        selected = new RemplissageItemPhilantrope();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("RemplissageItemPhilantropeCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("RemplissageItemPhilantropeUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("RemplissageItemPhilantropeDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<RemplissageItemPhilantrope> getItems() {
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

    public List<RemplissageItemPhilantrope> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<RemplissageItemPhilantrope> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = RemplissageItemPhilantrope.class)
    public static class RemplissageItemPhilantropeControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            RemplissageItemPhilantropeController controller = (RemplissageItemPhilantropeController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "remplissageItemPhilantropeController");
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
            if (object instanceof RemplissageItemPhilantrope) {
                RemplissageItemPhilantrope o = (RemplissageItemPhilantrope) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), RemplissageItemPhilantrope.class.getName()});
                return null;
            }
        }

    }

}

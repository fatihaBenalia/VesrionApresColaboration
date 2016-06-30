package controler.util;

import bean.Utilisateur;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class SessionUtil {
  
    private static final SessionUtil instance = new SessionUtil();
    
   
    private SessionUtil() {
        super();
    }

     public static void registerUser(Utilisateur user){
         setAttribute("user", user);
    }
     public static void removeUser(String cle) {
        removeAttribute(cle);
    }
     
     public static Utilisateur getConnectedUser(){
         return (Utilisateur) getAttribute("user");
    }
    public static SessionUtil getInstance() {
        return instance;
    }
    private static boolean isContextOk(FacesContext fc) {
        boolean res = (fc != null
                && fc.getExternalContext() != null
                && fc.getExternalContext().getSession(false) != null);
        return res;
    }

    private static HttpSession getSession(FacesContext fc) {
        return (HttpSession) fc.getExternalContext().getSession(false);
    }

    public static Object getAttribute(String cle) {
        FacesContext fc = FacesContext.getCurrentInstance();
        Object res = null;
        if (isContextOk(fc)) {
            res = getSession(fc).getAttribute(cle);
        }
        return res;
    }

   
    public static void setAttribute(String cle, Object valeur) {
        FacesContext fc = FacesContext.getCurrentInstance();
        if (fc != null && fc.getExternalContext() != null) {
            getSession(fc).setAttribute(cle, valeur);
        }
    }
    
    public static void removeAttribute(String cle) {
        FacesContext fc = FacesContext.getCurrentInstance();
        if (fc != null && fc.getExternalContext() != null) {
            if (getAttribute(cle) != null) {
                getSession(fc).removeAttribute(cle);
            }
        }
    }
    
    
    
    
    
    
}



package proxyHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.URLClassLoader;
import java.util.ArrayList;

import plateforme.Plateforme;

public class PanierProxy implements InvocationHandler {
	private Object objet;
	
	public Object getObjet() {
		return objet;
	}

	public void setObjet(Object objet) {
		this.objet = objet;
	}

	/*
	 * constructeur prenant en charge le changement d'extension en cas de non chargement vers une extension de secours
	 * 
	 */
	public PanierProxy(String nomClasse, URLClassLoader urlExtLoader) {
	  Object o = null;
    try {
      o = Plateforme.getPlateforme().creaInstance(nomClasse.split(";")[0]);
    } catch (Exception e) {
      try {
        o = Plateforme.getPlateforme().creaInstance((nomClasse.split(";")[4]));
      } catch (Exception e1) {
        e1.printStackTrace();
      }
    }
	    objet = o;
	}
	
	
	/*
	 * permet d'intercepter les appels de methodes pour modifier le comportement. Ici on interceptre les appels de la methode valider() pour hotswap la classe s'il s'agit d'un IPanierHandler et qu'il y a eu un probleme 
	 * 
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
	    Object res = null;
	    res = method.invoke(objet, args);
	    if(method.getName().equals("valider")) {
	    	boolean val = (boolean)res;
	    	if(val == false) {
	    		ArrayList<String> listeExtention = Plateforme.getPlateforme().getListe_extensions();
	    		int i;
	    		for (i = 0; i < listeExtention.size(); i++) {
	    			if(listeExtention.get(i).contains("IPanierHandler")) {
	    			  if(listeExtention.get(i).contains("proxy=" +objet.getClass().getName())) {
	    			    this.setObjet(Plateforme.getPlateforme().creaInstance(listeExtention.get(i)));
	                    return val;
	    			  }
	    			}
	    		}
	    		
	    	}
	    }
	    
	    return res;
	}
}

package proxyHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;

import afficheur.IAfficheur;

import plateforme.Plateforme;

public class PanierHandler implements InvocationHandler {
	private Object objet;
	
	public Object getObjet() {
		return objet;
	}

	public void setObjet(Object objet) {
		this.objet = objet;
	}

	public PanierHandler(Object o) {
	    objet = o;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
	    Object res = null;
	    res = method.invoke(objet, args);
	    if(method.getName().equals("valider")) {
	    	boolean val = (boolean)res;
	    	if(val == false) {
	    		ArrayList<String> listeExtention = Plateforme.getPlateforme().getExtensions();
//	    		System.out.println("erreur lors de la validation, veuillez choisir une extension de secours");
//	    		Scanner sc = new Scanner(System.in);
//	    		System.out.println("liste des gestionnaire de panier: ");
	    		int i;
	    		for (i = 0; i < listeExtention.size(); i++) {
	    			if(listeExtention.get(i).contains("IPanierHandler")) {
//	    			  System.out.println(objet.getClass().toString());
	    			  if(listeExtention.get(i).contains("proxy=" +objet.getClass().getName())) {
	    			    this.setObjet(Plateforme.getPlateforme().CreaInstance(listeExtention.get(i)));
	                    res = this.invoke(proxy, method, args);
	                    return res;
	    			  }
//	    				System.out.println(i + " - " + listeExtention.get(i));
	    			}
	    		}
//	    		System.out.println("Quel gestionnaire ? ");
//	    		i = sc.nextInt();
//	    		try {
//	    			this.setObjet(Plateforme.getPlateforme().CreaInstance(listeExtention.get(i)));
//	    			res = this.invoke(proxy, method, args);
//	    		} catch (Exception e) {
//	    			e.printStackTrace();
//	    		}
	    		
	    	}
	    }
	    
	    return res;
	}
}

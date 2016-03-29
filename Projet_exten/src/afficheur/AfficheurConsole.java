package afficheur;

import java.util.Scanner;

import donnees.IMagasin;
import donnees.IPanier;
import donnees.IProduit;

public class AfficheurConsole implements IAfficheur{

	public void afficheProduit(IProduit p) {
		System.out.println(p.toString());
	}
	
	public void afficheMagasin(IMagasin mag) {
		System.out.println(mag.toString());
	}
	
	public void affichePanier(IPanier pan) {
		System.out.println(pan.toString());
	}
	
	public String affichePhrase(String s , Scanner sc) {
	  System.out.println(s);
	  String obj = null;
	  if(sc != null){
	    obj = sc.next();
	  }
	  return obj;
	}
}

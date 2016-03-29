package afficheur;

import java.util.Scanner;

import donnees.IMagasin;
import donnees.IPanier;
import donnees.IProduit;

public interface IAfficheur {

	public void afficheProduit(IProduit p);
	
	public void afficheMagasin(IMagasin mag);
	
	public void affichePanier(IPanier pan);
	
	public String affichePhrase(String s, Scanner sc);
}

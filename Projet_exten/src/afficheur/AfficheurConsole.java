package afficheur;

import donnees.Magasin;
import donnees.Produit;

public class AfficheurConsole implements IAfficheur{

	public void afficheProduit(Produit p) {
		System.out.println(p.toString());
	}
	
	public void afficheMagasin(Magasin mag) {
		System.out.println(mag.toString());
	}
}

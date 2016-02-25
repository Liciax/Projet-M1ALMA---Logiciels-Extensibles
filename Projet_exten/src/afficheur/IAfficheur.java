package afficheur;

import donnees.Magasin;
import donnees.Produit;

public interface IAfficheur {

	public void afficheProduit(Produit p);
	
	public void afficheMagasin(Magasin mag);
}

package appli;

import donnees.Produit;
import donnees.Stock;

public class AfficheurStock implements Afficheur{
	
	public void afficher(Stock current) {
		for(Produit p: current.getStockProduit()) {
			p.toString();
		}
	}
	
	
}

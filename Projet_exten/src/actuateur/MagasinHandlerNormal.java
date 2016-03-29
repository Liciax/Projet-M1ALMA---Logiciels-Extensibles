package actuateur;

import donnees.IMagasin;
import donnees.IProduit;

public class MagasinHandlerNormal implements IMagasinHandler {

	public void ajouter(IProduit produit, IMagasin magasin, int quantite) {
		for (IProduit p : magasin.getProduits()) {
			p.getNom().equals(produit.getNom());
		}
	}
	
	
	public void modifier(IProduit p, IMagasin magasin, int quantite) {
		
	}

	
	public void supprimer(IProduit p, IMagasin magasin) {
		
	}

}

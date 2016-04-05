package actuateur;

import donnees.IMagasin;
import donnees.IProduit;

public class MagasinHandlerNormal implements IMagasinHandler {

	public void ajouter(IProduit produit, IMagasin magasin) {
		IProduit prod = null;
		try {
			prod = produit.getClass().newInstance();
			prod.setNom(produit.getNom());
			prod.setPrix(produit.getPrix());
			prod.setType(produit.getType());
			prod.setQuantites(produit.getQuantites());
			
			magasin.getProduits().add(prod);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}

	}
		
	
	public void modifier(IProduit produit, IMagasin magasin, IProduit p2) {
		produit.setNom(p2.getNom());
		produit.setType(p2.getType());
		produit.setPrix(p2.getPrix());
		if(p2.getQuantites() < 0) {
		  produit.setQuantites(0);
		} else {
		  produit.setQuantites(p2.getQuantites());
		}
	
	}

	
	public void supprimer(IProduit produit, IMagasin magasin) {
		if(magasin.getProduits().contains(produit)) {
			magasin.getProduits().remove(produit);
		}else {
			System.out.println("Erreur : ce produit n'est pas dans le magasin.");
		}
	}
}

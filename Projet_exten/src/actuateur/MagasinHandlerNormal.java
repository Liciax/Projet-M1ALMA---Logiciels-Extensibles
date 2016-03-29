package actuateur;

import donnees.IMagasin;
import donnees.IProduit;

public class MagasinHandlerNormal implements IMagasinHandler {

	public void ajouter(IProduit produit, IMagasin magasin, int quantite) {

		for(IProduit p: magasin.getProduits()){
			if(produit.getNom().equals(p.getNom())) {
				IProduit nouvProd = null;
				
				try {
					nouvProd = produit.getClass().newInstance();
					nouvProd.setNom(produit.getNom());
					nouvProd.setPrix(produit.getPrix());
					nouvProd.setType(produit.getType());
					nouvProd.setQuantites(quantite);
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
			
				if(!(magasin.getProduits().contains(produit))) {
					magasin.getProduits().add(nouvProd);
				}else {
					modifier(nouvProd, magasin, quantite);
				}
				
			}
		}
	}
		
	
	public void modifier(IProduit produit, IMagasin magasin, int quantite) {
		for(IProduit p: magasin.getProduits()){
			if(produit.getNom().equals(p.getNom())) {
				p.setQuantites(p.getQuantites() + quantite);
			}
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

package actuateur;

import donnees.IMagasin;
import donnees.IProduit;

public class MagasinHandlerNormal implements IMagasinHandler {

	public void ajouter(IProduit produit, IMagasin magasin, int quantite) {
		boolean existant = false;
		IProduit prod = null;
		try {
			prod = produit.getClass().newInstance();
			prod.setNom(produit.getNom());
			prod.setPrix(produit.getPrix());
			prod.setType(produit.getType());
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		for(IProduit p: magasin.getProduits()){
			if(produit.getNom().equals(p.getNom())) {
				modifier(prod, magasin, quantite);//existe deja dans panier
				existant = true;
			}
		}
		if(!existant){
			prod.setQuantites(quantite);
			magasin.getProduits().add(prod);
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

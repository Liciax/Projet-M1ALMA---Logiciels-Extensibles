package actuateur;

import donnees.IMagasin;
import donnees.IProduit;


public class PanierHandlerFavoris implements IPanierHandler {

	// ajoute au panier un nombre de produits disponible dans le magasin
	public void ajouter(IProduit produit, IMagasin magasin, int quantite) {
		for(IProduit p: magasin.getProduits()){
			if(produit.getNom().equals(p.getNom())) {

				IProduit prod = null;
				try {
					prod = produit.getClass().newInstance();
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
				if (!(magasin.getPanier().getContenu().contains(produit))) {	
				prod.setQuantites(quantite);
				magasin.getPanier().getContenu().add(prod);
				} else {
					modifier(prod, magasin, quantite);
				}
			}
		}
	}
	
	// modifie le nombre de produits ajoute dans un panier
	public void modifier(IProduit produit, IMagasin magasin, int quantite) {
		for(IProduit p: magasin.getPanier().getContenu()){
			if(produit.getNom().equals(p.getNom())) {
				p.setQuantites(produit.getQuantites() + quantite);
			}
		}        
	}
	
	//valide les favoris ajouté dans le panier
	public boolean valider(IMagasin magasin) {
		System.out.println("Voici la liste de vos favoris : ");
		for(IProduit p: magasin.getPanier().getContenu()){
			System.out.println(p.toString());
		}
		return true;
	}

}

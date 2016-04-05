package actuateur;

import afficheur.IAfficheur;
import donnees.IMagasin;
import donnees.IPanier;
import donnees.IProduit;

public interface IPanierHandler {

	/*
	* ajoute une quantite d'un produit dans un panier
	*/
	public void ajouter(IProduit p, IMagasin magasin, int quantite);

	/*
	* modifie la quantite d'un produit dans un panier
	*/
	public void modifier(IProduit p, IMagasin magasin, int quantite);
	
	/*
	* supprime un produit d'un panier
	*/
	public void supprimer(IProduit p, IPanier panier);
	
	/*
	* calcule le prix total des produits contenu dans un panier
	*/
	public String calcule(IMagasin magasin);
	
	/*
	* valide les choix contenu dans un panier
	*/
	public boolean valider(IMagasin magasin);
}

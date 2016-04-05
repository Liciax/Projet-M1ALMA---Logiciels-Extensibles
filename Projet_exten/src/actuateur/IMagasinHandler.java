package actuateur;

import donnees.IMagasin;
import donnees.IProduit;

public interface IMagasinHandler {

	/*
	* ajoute un produit dans un magasin
	*/
	public void ajouter(IProduit p, IMagasin magasin);

	/*
	* modifie le produit p d'un magasin en produit p2
	*/
	public void modifier(IProduit p, IMagasin magasin, IProduit p2);
	
	/*
	* supprime un produit dans un magasin
	*/
	public void supprimer(IProduit p, IMagasin magasin);
}

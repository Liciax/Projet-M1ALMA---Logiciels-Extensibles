package actuateur;

import afficheur.IAfficheur;
import donnees.IMagasin;
import donnees.IPanier;
import donnees.IProduit;

public interface IPanierHandler {

	public void ajouter(IProduit p, IMagasin magasin, int quantite);

	public void modifier(IProduit p, IMagasin magasin, int quantite);
	
	public void supprimer(IProduit p, IPanier panier);
	
	public String calcule(IMagasin magasin);
	
	public boolean valider(IMagasin magasin);
}

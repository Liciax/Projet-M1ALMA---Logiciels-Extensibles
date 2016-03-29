package actuateur;

import donnees.IMagasin;
import donnees.IProduit;

public interface IPanierHandler {

	public void ajouter(IProduit p, IMagasin magasin, int quantite);

	public void modifier(IProduit p, IMagasin magasin, int quantite);
	
	public boolean valider(IMagasin magasin);
}

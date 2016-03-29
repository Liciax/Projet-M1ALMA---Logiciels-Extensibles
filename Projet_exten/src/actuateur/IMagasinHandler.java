package actuateur;

import donnees.IMagasin;
import donnees.IProduit;

public interface IMagasinHandler {

	public void ajouter(IProduit p, IMagasin magasin, int quantite);

	public void modifier(IProduit p, IMagasin magasin, int quantite);
	
	public void supprimer(IProduit p, IMagasin magasin);
}

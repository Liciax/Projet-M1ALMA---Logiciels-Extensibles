package actuateur;

import donnees.IMagasin;
import donnees.IProduit;

public interface IMagasinHandler {

	public void ajouter(IProduit p, IMagasin magasin);

	public void modifier(IProduit p, IMagasin magasin, IProduit p2);
	
	public void supprimer(IProduit p, IMagasin magasin);
}

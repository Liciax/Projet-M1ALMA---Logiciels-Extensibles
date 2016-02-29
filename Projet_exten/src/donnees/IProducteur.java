package donnees;

import java.util.ArrayList;
import donnees.Magasin;
import donnees.Produit;

public interface IProducteur {

	public ArrayList<Produit> getProduit();
	
	public Magasin getMagasin();
}

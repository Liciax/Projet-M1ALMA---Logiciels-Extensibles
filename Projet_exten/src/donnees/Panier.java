package donnees;

import java.util.ArrayList;

public interface Panier {

	public ArrayList<Produit> getContenu();
	
	public void valider();
	
	public void vider();

}

package donnees;

import java.util.ArrayList;
import java.util.Arrays;

public class Magasin {

	private ArrayList<Produit> produits;
	
	public Magasin() {
		produits = new ArrayList<Produit>();
	}

	public ArrayList<Produit> getProduits() {
		return produits;
	}

	public void setProduits(ArrayList<Produit> produits) {
		this.produits = produits;
	}
	
	@Override
	public String toString() {
		return "Magasin = [" + Arrays.asList(produits).toString() + "]";
	}
}

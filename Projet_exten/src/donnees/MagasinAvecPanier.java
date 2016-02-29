package donnees;

import java.util.ArrayList;
import java.util.Arrays;

public class MagasinAvecPanier implements Magasin {
	
	private String nomMag;
	private ArrayList<Produit> produits;
	private Panier panier;
	
	public String getNomMag() {
		return nomMag;
	}
	public void setNomMag(String nomMag) {
		this.nomMag = nomMag;
	}
	public ArrayList<Produit> getProduits() {
		return produits;
	}
	public void setProduits(ArrayList<Produit> produits) {
		this.produits = produits;
	}
	public Panier getPanier() {
		return panier;
	}
	public void setPanier(Panier panier) {
		this.panier = panier;
	}
	
	public String toString() {
		return "Magasin " + nomMag + "=" + Arrays.asList(produits).toString() + "/n et Panier Actuel:" + Arrays.asList().toString();
	}

}

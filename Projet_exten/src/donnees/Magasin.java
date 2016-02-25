package donnees;

import java.util.ArrayList;
import java.util.Arrays;

public class Magasin {

	private String nomMag;
	private ArrayList<Produit> produits;
	
	public Magasin(String nom) {
		this.nomMag = nom;
		produits = new ArrayList<Produit>();
	}

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
	
	@Override
	public String toString() {
		return "Magasin " + nomMag + "= [" + Arrays.asList(produits).toString() + "]";
	}
}

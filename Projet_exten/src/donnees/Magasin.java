package donnees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class Magasin {

	private String nomMag;
	private Vector<Produit> produits;
	
	public Magasin() {
		super();
	}
	
	public String getNomMag() {
		return nomMag;
	}

	public void setNomMag(String nomMag) {
		this.nomMag = nomMag;
	}

	public Vector<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Vector<Produit> stock) {
		this.produits = stock;
	}
	
	@Override
	public String toString() {
		return "Magasin " + nomMag + "= [" + Arrays.asList(produits).toString() + "]";
	}
}

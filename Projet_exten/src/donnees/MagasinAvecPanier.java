package donnees;

import java.util.ArrayList;
import java.util.Arrays;

public class MagasinAvecPanier implements IMagasin {
	
	private String nomMag;
	private ArrayList<IProduit> produits;
	private IPanier panier;
	
	
	public String getNomMag() {
		return nomMag;
	}
	public void setNomMag(String nomMag) {
		this.nomMag = nomMag;
	}
	public ArrayList<IProduit> getProduits() {
		return produits;
	}
	public void setProduits(ArrayList<IProduit> produits) {
		this.produits = produits;
	}
	public IPanier getPanier() {
		return panier;
	}
	public void setPanier(IPanier panier) {
		this.panier = panier;
	}
	
	public void ajouter(IProduit p) {
		panier.getContenu().add(p);
	}
	
	public String toString() {
		return "Magasin " + nomMag + "=" + Arrays.asList(produits).toString() + "/n et Panier Actuel:" + Arrays.asList(panier.getContenu()).toString();
	}

}

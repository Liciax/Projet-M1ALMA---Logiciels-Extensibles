package donnees;

import java.util.ArrayList;

public class PanierSimple implements Panier {
	private ArrayList<Produit> contenu;
	
	public PanierSimple() {
		setContenu(new ArrayList<Produit>());
	}
	
	public void valider() {
		float i = 0;
		for(Produit p: contenu) {
			i += p.getPrix();
		}
		System.out.println("ce panier va vous couter " + i + "€");
	}
	
	public void vider() {
		contenu.clear();
	}

	public ArrayList<Produit> getContenu() {
		return contenu;
	}

	public void setContenu(ArrayList<Produit> contenu) {
		this.contenu = contenu;
	}

	
}

package donnees;

import java.util.ArrayList;

public class PanierSimple implements IPanier {
	private ArrayList<IProduit> contenu;
	
	public PanierSimple() {
		contenu = new ArrayList<IProduit>();
	}

	public ArrayList<IProduit> getContenu() {
		return contenu;
	}

	public void setContenu(ArrayList<IProduit> contenu) {
		this.contenu = contenu;
	}

	@Override
	public String toString() {
		return "PanierSimple [contenu=" + contenu + "]";
	}

	
}

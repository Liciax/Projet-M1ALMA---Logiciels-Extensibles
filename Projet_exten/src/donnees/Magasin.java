package donnees;

import java.util.ArrayList;

public interface Magasin {

	public abstract String getNomMag();

	public abstract void setNomMag(String nomMag);

	public abstract ArrayList<Produit> getProduits();

	public abstract void setProduits(ArrayList<Produit> stock);

}
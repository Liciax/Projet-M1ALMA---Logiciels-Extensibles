package donnees;

import java.util.ArrayList;

public interface IMagasin {

	public abstract String getNomMag();

	public abstract void setNomMag(String nomMag);

	public abstract ArrayList<IProduit> getProduits();

	public abstract void setProduits(ArrayList<IProduit> stock);

}

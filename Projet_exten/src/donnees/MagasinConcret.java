package donnees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class MagasinConcret implements Magasin {

	private String nomMag;
	private ArrayList<Produit> produits;
	
	public MagasinConcret() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see donnees.Magasin#getNomMag()
	 */
	@Override
	public String getNomMag() {
		return nomMag;
	}

	/* (non-Javadoc)
	 * @see donnees.Magasin#setNomMag(java.lang.String)
	 */
	@Override
	public void setNomMag(String nomMag) {
		this.nomMag = nomMag;
	}

	/* (non-Javadoc)
	 * @see donnees.Magasin#getProduits()
	 */
	@Override
	public ArrayList<Produit> getProduits() {
		return produits;
	}

	/* (non-Javadoc)
	 * @see donnees.Magasin#setProduits(java.util.Vector)
	 */
	@Override
	public void setProduits(ArrayList<Produit> stock) {
		this.produits = stock;
	}
	
	@Override
	public String toString() {
		return "Magasin " + nomMag + "=" + Arrays.asList(produits).toString();
	}
}

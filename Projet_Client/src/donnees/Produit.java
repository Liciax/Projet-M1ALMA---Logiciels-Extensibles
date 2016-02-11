package donnees;

public class Produit {

	private String nom;
	private String type;
	private float prix;
	private int quantité;
	
	/**
	 * @param nom
	 * @param type
	 * @param prix
	 * @param quantité
	 */
	public Produit(String nom, String type, float prix, int quantité) {
		super();
		this.nom = nom;
		this.type = type;
		this.prix = prix;
		this.quantité = quantité;
	}
	
	
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the prix
	 */
	public float getPrix() {
		return prix;
	}
	/**
	 * @param prix the prix to set
	 */
	public void setPrix(float prix) {
		this.prix = prix;
	}
	/**
	 * @return the quantité
	 */
	public int getQuantité() {
		return quantité;
	}
	/**
	 * @param quantité the quantité to set
	 */
	public void setQuantité(int quantité) {
		this.quantité = quantité;
	}
	
	
}

package donnees;

public interface IProduit {

	/**
	 * @return the nom
	 */
	public abstract String getNom();

	/**
	 * @param nom the nom to set
	 */
	public abstract void setNom(String nom);

	/**
	 * @return the type
	 */
	public abstract String getType();

	/**
	 * @param type the type to set
	 */
	public abstract void setType(String type);

	/**
	 * @return the prix
	 */
	public abstract float getPrix();

	/**
	 * @param prix the prix to set
	 */
	public abstract void setPrix(float prix);
	
	public abstract int getQuantites();
	
	public abstract void setQuantites(int quantites);

}
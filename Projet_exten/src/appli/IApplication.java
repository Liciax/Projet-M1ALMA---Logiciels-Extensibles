package appli;

import actuateur.IMagasinHandler;
import actuateur.IPanierHandler;
import afficheur.IAfficheur;
import donnees.IProducteur;



public interface IApplication {


	/* (non-Javadoc)
	 * @see appli.IApplication#getiProducteur()
	 */
	public abstract void doIt();
}

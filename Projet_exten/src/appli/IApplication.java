package appli;

import actuateur.IMagasinHandler;
import actuateur.IPanierHandler;
import afficheur.IAfficheur;
import donnees.IProducteur;



public interface IApplication {

  /* (non-Javadoc)
   * @see appli.IApplication#doIt()
   */
  public abstract void doIt();

}

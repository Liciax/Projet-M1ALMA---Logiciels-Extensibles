package appli;

import actuateur.IMagasinHandler;
import actuateur.IPanierHandler;
import afficheur.IAfficheur;
import donnees.IProducteur;



public interface IApplication {

  /* (non-Javadoc)
   * @see appli.IApplication#getiProducteur()
   */
  public abstract IProducteur getiProducteur();

  /* (non-Javadoc)
   * @see appli.IApplication#setiProducteur(donnees.IProducteur)
   */
  public abstract void setiProducteur(IProducteur iProducteur);

  /* (non-Javadoc)
   * @see appli.IApplication#getiMagHandler()
   */
  public abstract IMagasinHandler getiMagHandler();

  /* (non-Javadoc)
   * @see appli.IApplication#setiMagHandler(actuateur.IMagasinHandler)
   */
  public abstract void setiMagHandler(IMagasinHandler iMagHandler);

  /* (non-Javadoc)
   * @see appli.IApplication#getiPanHandler()
   */
  public abstract IPanierHandler getiPanHandler();

  /* (non-Javadoc)
   * @see appli.IApplication#setiPanHandler(actuateur.IPanierHandler)
   */
  public abstract void setiPanHandler(IPanierHandler iPanHandler);

  /* (non-Javadoc)
   * @see appli.IApplication#getiAffich()
   */
  public abstract IAfficheur getiAffich();

  /* (non-Javadoc)
   * @see appli.IApplication#setiAffich(afficheur.IAfficheur)
   */
  public abstract void setiAffich(IAfficheur iAffich);

  /* (non-Javadoc)
   * @see appli.IApplication#doIt()
   */
  public abstract void doIt();

}

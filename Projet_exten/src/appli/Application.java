package appli;

import java.util.ArrayList;
import java.util.Scanner;

import donnees.IProducteur;
import donnees.IProduit;
import actuateur.IMagasinHandler;
import actuateur.IPanierHandler;
import afficheur.IAfficheur;
import plateforme.Plateforme;

public class Application implements IApplication{
    
    private IProducteur iProduc;
    private IMagasinHandler iMagHandler;
    private IPanierHandler iPanHandler;
    private IAfficheur iAffich;
    
    private static IApplication INSTANCE = null;
    
    protected Application() {
        iProduc = null;
        iMagHandler = null;
        iPanHandler = null;
        iAffich = null;
    }
    
    public static IApplication getAppli() {         
        if (INSTANCE == null) {
            INSTANCE = new Application();   
        }
        return INSTANCE;
    }
    
    /* (non-Javadoc)
     * @see appli.IApplication#getiProducteur()
     */
    @Override
    public IProducteur getiProducteur() {
        return iProduc;
    }

    /* (non-Javadoc)
     * @see appli.IApplication#getiProducteur()
     */
    @Override
    public void setiProducteur(IProducteur iProducteur) {
        this.iProduc = iProducteur;
    }

    /* (non-Javadoc)
     * @see appli.IApplication#getiProducteur()
     */
    @Override
    public IMagasinHandler getiMagHandler() {
        return iMagHandler;
    }

    /* (non-Javadoc)
     * @see appli.IApplication#getiProducteur()
     */
    @Override
    public void setiMagHandler(IMagasinHandler iMagHandler) {
        this.iMagHandler = iMagHandler;
    }

    /* (non-Javadoc)
     * @see appli.IApplication#getiProducteur()
     */
    @Override
    public IPanierHandler getiPanHandler() {
        return iPanHandler;
    }

    /* (non-Javadoc)
     * @see appli.IApplication#getiProducteur()
     */
    @Override
    public void setiPanHandler(IPanierHandler iPanHandler) {
        this.iPanHandler = iPanHandler;
    }

    /* (non-Javadoc)
     * @see appli.IApplication#getiProducteur()
     */
    @Override
    public IAfficheur getiAffich() {
        return iAffich;
    }

    /* (non-Javadoc)
     * @see appli.IApplication#getiProducteur()
     */
    @Override
    public void setiAffich(IAfficheur iAffich) {
        this.iAffich = iAffich;
    }


    /* (non-Javadoc)
     * @see appli.IApplication#getiProducteur()
     */
    @Override
    public void doIt() {
        ArrayList<String> listeExtention = Plateforme.getPlateforme().getExtensions();
        int i;
        int j;
        boolean loadnow = false;
        System.out.println("Liste des extensions proposees :");
        System.out.println("--------------------------------");
        Scanner sc = new Scanner(System.in);
        IAfficheur aff = null;
        System.out.println("liste des affichages : ");
        for (i = 0; i < listeExtention.size(); i++) {
            if(listeExtention.get(i).contains("type=afficheur.IAfficheur")) {
                System.out.println(i + " - " + listeExtention.get(i));
                if(listeExtention.get(i).contains("load=now")){
                    System.out.println("Load immediat...");
                    try {
                        aff = (IAfficheur) Plateforme.getPlateforme().CreaInstance(listeExtention.get(i));
                        setiAffich(aff);
                        loadnow = true;
                        i = listeExtention.size();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                
            }
        }
        if(!loadnow){
            System.out.println("Quel affichage ? ");
            i = sc.nextInt();
            try {
                aff = (IAfficheur) Plateforme.getPlateforme().CreaInstance(listeExtention.get(i));
                setiAffich(aff);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////
        
        System.out.println("--------------------------------");
        IProducteur prod = null;
        System.out.println("liste des Producteurs : ");
        for (i = 0; i < listeExtention.size(); i++) {
            if(listeExtention.get(i).contains("type=donnees.IProducteur")) {
                System.out.println(i + " - " + listeExtention.get(i));
                if(listeExtention.get(i).contains("load=now")){
                    System.out.println("Load immediat...");
                    try {
                        prod = (IProducteur) Plateforme.getPlateforme().CreaInstance(listeExtention.get(i));
                        setiProducteur(prod);
                        loadnow = true;
                        i = listeExtention.size();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                
            }
        }
        if(!loadnow){
            System.out.println("Quel producteur ? ");
            i = sc.nextInt();
            try {
                prod = (IProducteur) Plateforme.getPlateforme().CreaInstance(listeExtention.get(i));
                setiProducteur(prod);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }   
        
        ////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("--------------------------------");
        IMagasinHandler maghand = null;
        System.out.println("liste des managers de Magasins : ");
        for (i = 0; i < listeExtention.size(); i++) {
            if(listeExtention.get(i).contains("type=actuateur.IMagasinHandler")) {
                System.out.println(i + " - " + listeExtention.get(i));
                if(listeExtention.get(i).contains("load=now")){
                    System.out.println("Load immediat...");
                    try {
                        maghand = (IMagasinHandler) Plateforme.getPlateforme().CreaInstance(listeExtention.get(i));
                        setiMagHandler(maghand);
                        loadnow = true;
                        i = listeExtention.size();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                
            }
        }
        if(!loadnow){
            System.out.println("Quel managers de Magasins ?");
            i = sc.nextInt();
            try {
                maghand = (IMagasinHandler) Plateforme.getPlateforme().CreaInstance(listeExtention.get(i));
                setiMagHandler(maghand);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        ////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("--------------------------------");
        IPanierHandler panhand = null;
        System.out.println("liste des managers de Panier : ");
        for (i = 0; i < listeExtention.size(); i++) {
            if(listeExtention.get(i).contains("type=actuateur.IPanierHandler")) {
                System.out.println(i + " - " + listeExtention.get(i));
                if(listeExtention.get(i).contains("load=now")){
                    System.out.println("Load immediat...");
                    try {
                        panhand = (IPanierHandler) Plateforme.getPlateforme().CreaInstance(listeExtention.get(i));
                        setiPanHandler(panhand);
                        loadnow = true;
                        i = listeExtention.size();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                
            }
        }
        if(!loadnow){
            System.out.println("Quel managers de Paniers ?");
            i = sc.nextInt();
            try {
                panhand = (IPanierHandler) Plateforme.getPlateforme().CreaInstance(listeExtention.get(i));
                setiPanHandler(panhand);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("--------------------------------");
        System.out.println("utilisation de l'actuateur sur les donnees...");
        iAffich.afficheMagasin(iProduc.getMagasin());
        iAffich.affichePanier(iProduc.getMagasin().getPanier());
        String nom;
        String type;
        float prix;
        int quantites;
        while(true) {
            
            i = Integer.parseInt(iAffich.affichePhrase("travailler avec quel donnees: 1-magasin, 2-panier :", sc));
            switch(i){
///////////////////////////////////////////////////////////////////////////
              case 1:
                iAffich.afficheMagasin(iProduc.getMagasin());
                i = Integer.parseInt(iAffich.affichePhrase("vous voulez 1- ajouter un produit, 2- modifier un produit, 3-supprimer un produit? :", sc));
                switch(i){
                  case 1:
                    nom = iAffich.affichePhrase("entrez un nom", sc);
                    type = iAffich.affichePhrase("entrez un type",sc);
                    prix = Float.parseFloat(iAffich.affichePhrase("entrez un prix",sc));
                    quantites = Integer.parseInt(iAffich.affichePhrase("entrez un quantites",sc));
                    IProduit p = null;
                    try {
                        p = iProduc.getMagasin().getProduits().get(0).getClass().newInstance();
                        p.setNom(nom);
                        p.setPrix(prix);
                        p.setType(type);
                    } catch (InstantiationException | IllegalAccessException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    iMagHandler.ajouter(p, iProduc.getMagasin(), quantites);
                    break;
                    
                  case 2:
                    j = Integer.parseInt(iAffich.affichePhrase("quel produit? :", sc));
                    IProduit q = iProduc.getMagasin().getProduits().get(j);
                    j = Integer.parseInt(iAffich.affichePhrase("quel quantite ajouter/retirer? (retirer en negatif :", sc));
                    iMagHandler.modifier(q, iProduc.getMagasin(), j);
                    break;
                    
                  case 3:
                    j = Integer.parseInt(iAffich.affichePhrase("quel produit? :", sc));
                    IProduit r = iProduc.getMagasin().getProduits().get(j);
                    iMagHandler.supprimer(r, iProduc.getMagasin());
                    break;
                }
                break;
////////////////////////////////////////////////////////////////////////////
              default:
              i = Integer.parseInt(iAffich.affichePhrase("vous voulez 1- ajouter un produit, 2- modifier un produit, 3-valider le panier? :", sc));
              switch(i){
                case 1:
                  j = Integer.parseInt(iAffich.affichePhrase("quel produit? :", sc));
                  i = Integer.parseInt(iAffich.affichePhrase("quel quantite ajouter?", sc));
                  iPanHandler.ajouter(iProduc.getMagasin().getProduits().get(j), iProduc.getMagasin(), i);
                  break;
                  
                case 2:
                  j = Integer.parseInt(iAffich.affichePhrase("quel produit? :", sc));
                  IProduit q = iProduc.getMagasin().getPanier().getContenu().get(j);
                  j = Integer.parseInt(iAffich.affichePhrase("quel quantite ajouter/retirer? (retirer en negatif :", sc));
                  iPanHandler.modifier(q, iProduc.getMagasin(), j);
                  break;
              
                case 3:
                    iPanHandler.valider(iProduc.getMagasin(), iAffich);
                  break;
                
            }
              break;
            }
            aff.afficheMagasin(iProduc.getMagasin());
            aff.affichePanier(iProduc.getMagasin().getPanier());
        }
    }

}

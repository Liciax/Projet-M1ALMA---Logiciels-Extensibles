package appli;

import java.util.ArrayList;
import java.util.Scanner;

import donnees.IProducteur;
import donnees.IProduit;
import actuateur.IActuateur;
import actuateur.IMagasinHandler;
import actuateur.IPanierHandler;
import afficheur.IAfficheur;
import plateforme.Plateforme;

public class Application {
	
	/**
	 * 
	 */
	public Application() {
		super();
	}

	public void doIt() {
		ArrayList<String> listeExtention = Plateforme.getPlateforme().getExtensions();
		int i;
		int j;
		boolean loadnow = false;
		System.out.println("Liste des extensions proposees :");
//		for (i = 0; i < listeExtention.size(); i++) {
//			System.out.println(i + " - " + listeExtention.get(i));
//		}
		
		////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("--------------------------------");
		Scanner sc = new Scanner(System.in);
		IAfficheur aff = null;
		System.out.println("liste des affichages : ");
		for (i = 0; i < listeExtention.size(); i++) {
			if(listeExtention.get(i).contains("type=IAfficheur")) {
				System.out.println(i + " - " + listeExtention.get(i));
				if(listeExtention.get(i).contains("load=now")){
					System.out.println("Load immediat...");
					try {
						aff = (IAfficheur) Plateforme.getPlateforme().CreaInstance(listeExtention.get(i));
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		////////////////////////////////////////////////////////////////////////////////////////////////////
		
		System.out.println("--------------------------------");
		IProducteur prod = null;
		System.out.println("liste des Producteurs : ");
		for (i = 0; i < listeExtention.size(); i++) {
			if(listeExtention.get(i).contains("type=IProducteur")) {
				System.out.println(i + " - " + listeExtention.get(i));
				if(listeExtention.get(i).contains("load=now")){
					System.out.println("Load immediat...");
					try {
						prod = (IProducteur) Plateforme.getPlateforme().CreaInstance(listeExtention.get(i));
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
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
		
		////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("--------------------------------");
		IMagasinHandler maghand = null;
		System.out.println("liste des managers de Magasins : ");
		for (i = 0; i < listeExtention.size(); i++) {
			if(listeExtention.get(i).contains("type=IMagasinHandler")) {
				System.out.println(i + " - " + listeExtention.get(i));
				if(listeExtention.get(i).contains("load=now")){
					System.out.println("Load immediat...");
					try {
						maghand = (IMagasinHandler) Plateforme.getPlateforme().CreaInstance(listeExtention.get(i));
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("--------------------------------");
		IPanierHandler panhand = null;
		System.out.println("liste des managers de Panier : ");
		for (i = 0; i < listeExtention.size(); i++) {
			if(listeExtention.get(i).contains("type=IPanierHandler")) {
				System.out.println(i + " - " + listeExtention.get(i));
				if(listeExtention.get(i).contains("load=now")){
					System.out.println("Load immediat...");
					try {
						panhand = (IPanierHandler) Plateforme.getPlateforme().CreaInstance(listeExtention.get(i));
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		/*
		System.out.println("liste des IActuateur : ");
		for (i = 0; i < listeExtention.size(); i++) {
			if(listeExtention.get(i).contains("type=IActuateur")) {
				System.out.println(i + " - " + listeExtention.get(i));
			}
		}
		System.out.println("Quel actuateur ?");
		i = sc.nextInt();
		IActuateur actu = null;
		try {
			actu = (IActuateur) Plateforme.getPlateforme().CreaInstance(listeExtention.get(i));
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		System.out.println("--------------------------------");
		System.out.println("utilisation de l'actuateur sur les donnees...");
		
		
        //actu.Modifier(prod);
        //actu.Modifier(prod);
		aff.afficheMagasin(prod.getMagasin());
		aff.affichePanier(prod.getMagasin().getPanier());
		String nom;
		String type;
		float prix;
		int quantites;
		aff.afficheMagasin(prod.getMagasin());
        aff.affichePanier(prod.getMagasin().getPanier());
		while(true) {
			
		  
		    i = Integer.parseInt(aff.affichePhrase("travailler avec quel données: 1-magasin, 2-panier :", sc));
		    switch(i){
///////////////////////////////////////////////////////////////////////////
  		      case 1:
  	            aff.afficheMagasin(prod.getMagasin());
  	            i = Integer.parseInt(aff.affichePhrase("vous voulez 1- ajouter un produit, 2- modifier un produit, 3-supprimer un produit? :", sc));
  		        switch(i){
  	              case 1:
  	                nom = aff.affichePhrase("entrez un nom", sc);
                    type = aff.affichePhrase("entrez un type",sc);
                    prix = Float.parseFloat(aff.affichePhrase("entrez un prix",sc));
                    quantites = Integer.parseInt(aff.affichePhrase("entrez un quantites",sc));
                    IProduit p = null;
                    try {
                        p = prod.getMagasin().getProduits().get(0).getClass().newInstance();
                        p.setNom(nom);
                        p.setPrix(prix);
                        p.setType(type);
                    } catch (InstantiationException | IllegalAccessException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    maghand.ajouter(p, prod.getMagasin(), quantites);
  	                break;
  	                
  	              case 2:
    	            j = Integer.parseInt(aff.affichePhrase("quel produit? :", sc));
                    IProduit q = prod.getMagasin().getProduits().get(j);
                    j = Integer.parseInt(aff.affichePhrase("quel quantité ajouter/retirer? (retirer en negatif :", sc));
                    maghand.modifier(q, prod.getMagasin(), j);
                    break;
                    
  	              case 3:
  	                j = Integer.parseInt(aff.affichePhrase("quel produit? :", sc));
                    IProduit r = prod.getMagasin().getProduits().get(j);
                    maghand.supprimer(r, prod.getMagasin());
                    break;
	            }
		        break;
////////////////////////////////////////////////////////////////////////////
  		      default:
              //System.out.println("vous voulez 1- ajouter un produit, 2- modifier un produit, 3-valider le panier? :");
  		      i = Integer.parseInt(aff.affichePhrase("vous voulez 1- ajouter un produit, 2- modifier un produit, 3-valider le panier? :", sc));
              switch(i){
                case 1:
                  j = Integer.parseInt(aff.affichePhrase("quel produit? :", sc));
                  i = Integer.parseInt(aff.affichePhrase("quel quantité ajouter?", sc));
                  panhand.ajouter(prod.getMagasin().getProduits().get(j), prod.getMagasin(), i);
                  break;
                  
                case 2:
                  j = Integer.parseInt(aff.affichePhrase("quel produit? :", sc));
                  IProduit q = prod.getMagasin().getPanier().getContenu().get(j);
                  j = Integer.parseInt(aff.affichePhrase("quel quantité ajouter/retirer? (retirer en negatif :", sc));
                  panhand.modifier(q, prod.getMagasin(), j);
                  break;
              
                case 3:
                  panhand.valider(prod.getMagasin(), aff);
                  break;
		        
		    }
              break;
		    }
            aff.afficheMagasin(prod.getMagasin());
            aff.affichePanier(prod.getMagasin().getPanier());
            
//			aff.afficheMagasin(prod.getMagasin());
//			aff.affichePanier(prod.getMagasin().getPanier());
//			i = Integer.parseInt(aff.affichePhrase("quel produit prendre?"));
//			j = Integer.parseInt(aff.affichePhrase("et en quelle quantite?"));
//			panhand.ajouter(prod.getMagasin().getProduits().get(i), prod.getMagasin(), j);
//			aff.afficheMagasin(prod.getMagasin());
//			aff.affichePanier(prod.getMagasin().getPanier());
//			i = Integer.parseInt(aff.affichePhrase("valider? (oui=1;non=0)"));
//			if(i == 1){
//				panhand.valider(prod.getMagasin());
//			}
		}
//		System.out.println("resultat: ");
//		aff.afficheMagasin(prod.getMagasin());
//		aff.affichePanier(prod.getMagasin().getPanier());
	}

}

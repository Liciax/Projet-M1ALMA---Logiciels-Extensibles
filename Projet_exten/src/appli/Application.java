package appli;

import java.util.ArrayList;
import java.util.Scanner;

import donnees.IProducteur;
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
		System.out.println("resultat: ");
		aff.afficheMagasin(prod.getMagasin());
		aff.affichePanier(prod.getMagasin().getPanier());
	}

}

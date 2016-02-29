package appli;

import java.util.Scanner;
import java.util.Vector;

import donnees.ProducteurDefaut;
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
		Vector<String> listeExtention = Plateforme.getPlateforme().getExtensions();
		int i;
		System.out.println("Liste des extensions proposees :");
		for (i = 0; i < listeExtention.size(); i++) {
			System.out.println(" - " + listeExtention.get(i));
		}
		System.out.println("--------------------------------");
		Scanner sc = new Scanner(System.in);
		System.out.println("Quel affichage ? ");
		i = sc.nextInt();
		IAfficheur aff = null;
		try {
			aff = (IAfficheur) Plateforme.getPlateforme().CreaInstance(listeExtention.get(i));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Quel producteur ? ");
		i = sc.nextInt();
		ProducteurDefaut prod = null;
		try {
			prod = (ProducteurDefaut) Plateforme.getPlateforme().CreaInstance(listeExtention.get(i));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("--------------------------------");
		System.out.println("Voici le magasin que IProducteur a choisi de creer :");
		aff.afficheMagasin(prod.getMagasin());
	}

}

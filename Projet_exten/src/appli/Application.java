package appli;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import donnees.IProducteur;
import actuateur.IActuateur;
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
		System.out.println("Liste des extensions proposees :");
		for (i = 0; i < listeExtention.size(); i++) {
			System.out.println(i + " - " + listeExtention.get(i));
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
		IProducteur prod = null;
		try {
			prod = (IProducteur) Plateforme.getPlateforme().CreaInstance(listeExtention.get(i));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("Quel actuateur ?");
		i = sc.nextInt();
		IActuateur actu = null;
		try {
			actu = (IActuateur) Plateforme.getPlateforme().CreaInstance(listeExtention.get(i));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("--------------------------------");
		System.out.println("utilisation de l'actuateur sur les donnees...");
//		System.out.println(prod.getMagasin().getPanier());
        actu.Modifier(prod);
        //actu.Modifier(prod);
		System.out.println("resultat: ");
		aff.afficheMagasin(prod.getMagasin());
		aff.affichePanier(prod.getMagasin().getPanier());
	}

}

package appli;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

import donnees.IProducteur;

import afficheur.IAfficheur;

import plateforme.Plateforme;

public class Application {
	

	public void doIt() {
		Vector<String> listeExtention = Plateforme.getPlateforme().getExtensions();
		int i;
		for (i = 0; i < listeExtention.size(); i++) {
			System.out.println((listeExtention.get(i).split(";")[1]).split("=")[1]);
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("quel affichage?");
		i = sc.nextInt();
		IAfficheur aff = null;
		try {
			aff = (IAfficheur) Plateforme.getPlateforme().CreaInstance((listeExtention.get(i).split(";")[0]).split("=")[1]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("quel producteur?");
		i = sc.nextInt();
		IProducteur prod = null;
		try {
			prod = (IProducteur) Plateforme.getPlateforme().CreaInstance((listeExtention.get(i).split(";")[0]).split("=")[1]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		aff.afficheMagasin(prod.getMagasin());
	}

}

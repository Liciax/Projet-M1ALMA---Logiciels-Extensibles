package appli;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

import afficheur.IAfficheur;

import plateforme.Plateforme;

public class Application {
	

	public void doIt() {
		Vector<String> listeExtention = Plateforme.getPlateforme().getExtension();
		
//		IAfficheur aff = (IAfficheur) Plateforme.getPlateforme().getIAfficheur();
//		IProducteur prod = Plateforme.getPlateforme().getIProducteur();
//		aff.afficheMagasin(prod.getMagasin());
	}

}

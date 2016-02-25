package donnees;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;

public class IProducteur {

	private HashMap<String, String> mapDonnees;
	
	
	public IProducteur() {
		super();
		mapDonnees = new HashMap<String, String>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/donnees/donnees.txt"));
			String ligne;
			while((ligne = br.readLine())!=null) {
				mapDonnees.put(ligne.split("; ")[0].split("=")[1],ligne.split("; ")[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Produit getProduit(){
	
	}
	
	public Magasin getMagasin() {
		
	}
}

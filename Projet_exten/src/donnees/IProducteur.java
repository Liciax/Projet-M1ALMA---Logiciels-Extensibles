package donnees;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class IProducteur {

	private ArrayList<String> donnees;
	
	public IProducteur() {
		super();
		donnees = new ArrayList<String>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/donnees/donnees.txt"));
			String ligne;
			while((ligne = br.readLine())!=null) {
				donnees.add(ligne);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Produit getProduit(){
		Class<?> produit = null;
		Object oProduit = null;
		for (String s : donnees) {
			if(s.contains("class=donnees.Produit")) {
				try {
					produit = Class.forName(s.split("; ")[0].split("=")[1]);
					oProduit = produit.newInstance();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return (Produit)oProduit;
	}
	
	public Magasin getMagasin() {
		Class<?> magasin = null;
		Object oMagasin = null;
		for (String s : donnees) {
			if(s.contains("donnees.Magasin")) {
				try {
					magasin = Class.forName(s.split("; ")[0].split("=")[1]);
					oMagasin = magasin.newInstance();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return (Magasin)oMagasin;
	}
}

package donnees;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ProducteurAvecPanier {

private ArrayList<String> donnees;
	
	public ProducteurAvecPanier() {
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

	public ArrayList<IProduit> getProduits(){
		Class<?> produit = null;
		IProduit concret = null;
		ArrayList<IProduit> oProduit = new ArrayList<IProduit>();
		for (String s : donnees) {
			if(s.contains("class=donnees.Produit")) {
				try {
					produit = Class.forName(s.split(";")[0].split("=")[1]);
				
						concret = (IProduit) produit.newInstance();
						concret.setNom(s.split(";")[1].split("=")[1]);
						concret.setType(s.split(";")[2].split("=")[1]);
	                    concret.setPrix(Float.parseFloat(s.split(";")[3].split("=")[1]));
	                    concret.setQuantites(Integer.parseInt(s.split(";")[4].split("=")[1]));
	                    oProduit.add(concret);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return oProduit;
	}
	
	public IPanier getPanier(){
		Class<?> produit = null;
		IPanier concret = null;
		
		for (String s : donnees) {
			if(s.contains("class=donnees.Panier")) {
				try {
					produit = Class.forName(s.split(";")[0].split("=")[1]);
				
						concret = (IPanier) produit.newInstance();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return concret;
	}
	
	public IMagasin getMagasin() {
		Class<?> magasin = null;
		IMagasin oMagasin = null;
		ArrayList<IProduit> stock = getProduits();
		IPanier p = getPanier();
		for (String s : donnees) {
			if(s.contains("donnees.Magasin")) {
				try {
					magasin = Class.forName(s.split(";")[0].split("=")[1]);
					oMagasin = (IMagasin) magasin.newInstance();
					oMagasin.setNomMag(s.split(";")[1].split("=")[1]);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
//		oMagasin.//attention: merde avec setpanier inexistant!
		oMagasin.setProduits(stock);
		return (IMagasin)oMagasin;
	}
}

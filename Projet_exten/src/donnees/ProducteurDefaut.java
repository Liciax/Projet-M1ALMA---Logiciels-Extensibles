package donnees;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ProducteurDefaut implements IProducteur {

	private ArrayList<String> donnees;
	
	public ProducteurDefaut() {
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
	                    oProduit.add(concret);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return oProduit;
	}
	
	public IMagasin getMagasin() {
		Class<?> magasin = null;
		IMagasin oMagasin = null;
		ArrayList<IProduit> stock = getProduits();
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
		
		oMagasin.setProduits(stock);
		return (IMagasin)oMagasin;
	}
}

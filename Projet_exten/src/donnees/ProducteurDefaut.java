package donnees;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ProducteurDefaut implements IProducteur {

	private ArrayList<String> donnees;
	private IMagasin Magasin;
	
	public ProducteurDefaut() {
		super();
		donnees = new ArrayList<String>();
		Magasin = null;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("donnees/donnees.txt"));
			String ligne;
			while((ligne = br.readLine())!=null) {
				donnees.add(ligne);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<IProduit> getProduits(IMagasin oMagasin){
		Class<?> produit = null;
		IProduit concret = null;
		ArrayList<IProduit> oProduit = new ArrayList<IProduit>();
		for (String s : donnees) {
			if(s.contains("class=donnees.Produit")) {//c'est un produit, on va maintenant verifier que c'est un produit du bon magasin.
			    if(s.split(";")[5].split("=")[1].equals(oMagasin.getNomMag())) {//bon mag
    				try {
    						concret = newProduit(s);
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
		}
		return oProduit;
	}

	private IProduit newProduit(String s) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
//		Class<?> produit;
		IProduit concret;
//		produit = Class.forName(s.split(";")[0].split("=")[1]);
//			
//			concret = (IProduit) produit.newInstance();
		concret = new ProduitConcret();
		return concret;
	}
	
	public IMagasin getMagasin() {
	  if(Magasin == null) {
        ArrayList<String> magPos = new ArrayList<String>();
        System.out.println("liste des magasins: ");
        for (String s : donnees) {
            if(s.contains("donnees.Magasin")) {
                magPos.add(s.split(";")[0].split("=")[1]);
                System.out.println(s.split(";")[1].split("=")[1]);
                if(s.split(";")[2].split("=")[1].equals("now")) {
                  System.out.println("load obligatoire, debut...");
                    try {
                      Magasin = newMagasin(s);
                      Magasin.setNomMag(s.split(";")[1].split("=")[1]);
                      
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        ArrayList<IProduit> stock = getProduits(Magasin);
        Magasin.setProduits(stock);
	  }
	  return Magasin;
	}

	private IMagasin newMagasin(String s) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
//		Class<?> magasin;
//		magasin = Class.forName(s.split(";")[0].split("=")[1]);
		IMagasin magasin = new MagasinConcret();
//		Magasin = (IMagasin) magasin.newInstance();
		return magasin;
	}
}

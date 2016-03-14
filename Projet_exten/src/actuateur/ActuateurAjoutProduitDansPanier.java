package actuateur;

import java.util.Scanner;

import donnees.IMagasin;
import donnees.IPanier;
import donnees.IProducteur;
import donnees.IProduit;

public class ActuateurAjoutProduitDansPanier implements IActuateur {

	// ajoute au panier un nombre de produits disponible dans le magasin
	public boolean ajouter(IPanier panier, IMagasin magasin, IProduit produit, int quantite) {
		boolean existe = false;
		for(IProduit p: magasin.getProduits()){
			if(produit.getNom().equals(p.getNom())) {
				existe = true;
				p.setQuantites(p.getQuantites()-quantite);
				produit.setQuantites(produit.getQuantites()+quantite);
				panier.getContenu().add(produit);
			}
		}
		return existe;
	}
	
	@Override
	public void Modifier(IProducteur p) {
		 Scanner sc = new Scanner(System.in);
		 
		 	String choixProd;
		 	int nbProd;
		    try {
		    	System.out.println("Quel produit voulez-vous ajouter au panier (nom): ");
		    	choixProd = sc.next();
		    	System.out.println("Quel produit voulez-vous ajouter au panier (nom): ");
		    	choixProd = sc.next();
		    	//TODO ALICIA
		    	//ajouter(p.getMagasin());
		      
		    } catch (Exception e) {
		      e.printStackTrace();
		    }     
		  
	}
}

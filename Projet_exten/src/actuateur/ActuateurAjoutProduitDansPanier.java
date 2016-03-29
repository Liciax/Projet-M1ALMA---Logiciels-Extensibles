package actuateur;

import java.util.Scanner;

import donnees.IMagasin;
import donnees.IPanier;
import donnees.IProducteur;
import donnees.IProduit;
import donnees.ProduitConcret;

public class ActuateurAjoutProduitDansPanier implements IActuateur {

	// ajoute au panier un nombre de produits disponible dans le magasin
	public boolean ajouter(IPanier panier, IMagasin magasin, IProduit produit, int quantite) {
		boolean existe = false;
		for(IProduit p: magasin.getProduits()){
			if(produit.getNom().equals(p.getNom())) {
				existe = true;
				p.setQuantites(p.getQuantites()-quantite);
				produit.setType(p.getType());
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
		    	System.out.println("Quel produit voulez-vous ajouter au panier (nom) : ");
		    	choixProd = sc.next();
		    	IProduit nouvProd = new ProduitConcret();
		    	nouvProd.setNom(choixProd);
		    	System.out.println("Combien de produits voulez vous ajouter (quantites) : ");
		    	nbProd = sc.nextInt();

		    	ajouter(p.getMagasin().getPanier(), p.getMagasin(), nouvProd, nbProd);
		  
		      
		    } catch (Exception e) {
		      e.printStackTrace();
		    }     
		  
	}
}

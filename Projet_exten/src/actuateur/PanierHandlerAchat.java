package actuateur;
import donnees.IMagasin;
import donnees.IProduit;


public class PanierHandlerAchat implements IPanierHandler {

	// ajoute au panier un nombre de produits disponible dans le magasin
	public void ajouter(IProduit produit, IMagasin magasin, int quantite) {
		
//		if(!(magasin.getPanier().getContenu().contains(produit))) {
//			IProduit nouvProd = null;
//			try {
//				nouvProd = produit.getClass().newInstance();
//				nouvProd.setNom(produit.getNom());
//				nouvProd.setPrix(produit.getPrix());
//				nouvProd.setType(produit.getType());
//				nouvProd.setQuantites(quantite);
//			} catch (InstantiationException | IllegalAccessException e) {
//				e.printStackTrace();
//			}
//			magasin.getPanier().getContenu().add(nouvProd);
//		}else {
//			modifier(produit, magasin, quantite);
//		}
		
		for(IProduit p: magasin.getProduits()){
			if(produit.getNom().equals(p.getNom())) {
				IProduit prod = null;
				try {
					prod = produit.getClass().newInstance();
					prod.setNom(produit.getNom());
					prod.setPrix(produit.getPrix());
					prod.setType(produit.getType());
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
				boolean trouve = false;
				for(IProduit q: magasin.getPanier().getContenu()){
					if(produit.getNom().equals(q.getNom())) {
						System.out.println("passé par la");
						modifier(prod, magasin, quantite);//existe deja dans panier
						trouve = true;
					}
					
				}
				if(!trouve) {
					prod.setQuantites(quantite);
					magasin.getPanier().getContenu().add(prod);
				}
			}
		}
		
	}

	// modifie le nombre de produits ajoute dans un panier
	public void modifier(IProduit produit, IMagasin magasin, int quantite) {
		for(IProduit p: magasin.getPanier().getContenu()){
			if(produit.getNom().equals(p.getNom())) {
				p.setQuantites(p.getQuantites() + quantite);
			}
		}
	}
	
	// valide simule un achat, donc vidage du contenu du panier
	public boolean valider(IMagasin magasin) {
		int prix = 0;
		for(IProduit proPan: magasin.getPanier().getContenu()){
			for (IProduit proMag : magasin.getProduits()) {
				if(proMag.getNom().equals(proPan.getNom())) {
					if(proMag.getQuantites() < proPan.getQuantites()) { // si pas assez de quantites en magasin
						return false;
					}
				}
			}
		}
		//quantité dans panier ok, on peut modif magasin
		for(IProduit proPan: magasin.getPanier().getContenu()){
			for (IProduit proMag : magasin.getProduits()) {
				
				if(proMag.getNom().equals(proPan.getNom())) {
					if(proMag.getQuantites() >= proPan.getQuantites()) { // si assez de quantites en magasin
						prix += proPan.getPrix() * proPan.getQuantites();
						proMag.setQuantites(proMag.getQuantites() - proPan.getQuantites());
						magasin.getPanier().getContenu().remove(proPan);
					} else { // sinon manque de stock dans magasin
						int reste = Math.abs(proMag.getQuantites() - proPan.getQuantites());
						prix += proPan.getPrix() * (proPan.getQuantites() - reste);	
						proMag.setQuantites(0);
						proPan.setQuantites(reste);
						//modifier(proPan, magasin, reste);
						return false;
					}
				}
			}
		}
	
		System.out.println("Vous allez devoir payer : " + prix + " €.");
		return true;
	}
	
}

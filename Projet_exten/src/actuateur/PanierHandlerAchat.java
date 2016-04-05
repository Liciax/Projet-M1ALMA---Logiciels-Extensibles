package actuateur;
import afficheur.IAfficheur;
import donnees.IMagasin;
import donnees.IProduit;


public class PanierHandlerAchat implements IPanierHandler {

	// ajoute au panier un nombre de produits disponible dans le magasin
	public void ajouter(IProduit produit, IMagasin magasin, int quantite) {		
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
	
	// supprime le produit du panier
	public void supprimer(IProduit produit, IMagasin magasin) {
		if(magasin.getProduits().contains(produit)) {
			magasin.getProduits().remove(produit);
		}else {
			System.out.println("Erreur : ce produit n'est pas dans le magasin.");
		}
	}
	
	@Override
	public String calculePrix(IMagasin magasin) {
		int prix = 0;
		for(IProduit proPan2: magasin.getPanier().getContenu()){
			prix += proPan2.getPrix() * proPan2.getQuantites();
		}
		return "Vous allez devoir payer : " + prix + " €";
	}
	
	// valide simule un achat, donc vidage du contenu du panier
	public boolean valider(IMagasin magasin) {
		float prix = 0;
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
		for(IProduit proPan2: magasin.getPanier().getContenu()){
			for (IProduit proMag2 : magasin.getProduits()) {
				if(proMag2.getNom().equals(proPan2.getNom())) {
					prix += proPan2.getPrix() * proPan2.getQuantites();
					proMag2.setQuantites(proMag2.getQuantites() - proPan2.getQuantites());						
				}
			}
		}
		magasin.getPanier().getContenu().clear();
		return true;
	}
	
}

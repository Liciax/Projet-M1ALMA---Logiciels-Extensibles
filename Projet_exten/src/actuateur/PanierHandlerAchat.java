package actuateur;
import donnees.IMagasin;
import donnees.IProduit;


public class PanierHandlerAchat implements IPanierHandler {

	// ajoute au panier un nombre de produits disponible dans le magasin
	public void ajouter(IProduit produit, IMagasin magasin, int quantite) {
		for(IProduit p: magasin.getProduits()){
			if(produit.getNom().equals(p.getNom())) {
				produit.setType(p.getType());
				produit.setQuantites(quantite);
				magasin.getPanier().getContenu().add(produit);
			}
		}
	}

	// modifie le nombre de produits ajoute dans un panier
	public void modifier(IProduit produit, IMagasin magasin, int quantite) {
		for(IProduit p: magasin.getPanier().getContenu()){
			if(produit.getNom().equals(p.getNom())) {
				p.setQuantites(produit.getQuantites() + quantite);
			}
		}     
	}
	
	// valide simule un achat, donc vidage du contenu du panier
	public boolean valider(IMagasin magasin) {
		int prix = 0;
		for(IProduit p: magasin.getPanier().getContenu()){
			prix += p.getPrix() * p.getQuantites();
		}
		System.out.println("Vous allez devoir payer : " + prix + " €.");
		return true;
	}
	
}

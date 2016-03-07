package actuateur;

import donnees.IMagasin;
import donnees.IPanier;
import donnees.IProducteur;
import donnees.IProduit;
import donnees.ProduitConcret;

public class ActuateurConcret implements IActuateur{

	public boolean ajouter(IProduit prod, IPanier pan){
		boolean trouve = false;
		for(IProduit ip: (pan).getContenu()){
			if(prod.getNom().equals(ip.getNom())) {
				ip.setQuantites(ip.getQuantites() + 1);
				prod.setQuantites(prod.getQuantites() - 1);
				trouve = true;
			}
		}
		if(!trouve){
			IProduit nouv = new ProduitConcret();
			nouv.setNom(prod.getNom());
			nouv.setType(prod.getType());
			nouv.setPrix(prod.getPrix());
			nouv.setQuantites(1);
			pan.getContenu().add(nouv);
			trouve = true;
			prod.setQuantites(prod.getQuantites() - 1);
		}
		System.out.println(" ici panier : " + pan.getContenu().size());
		return trouve;
		
	}
	
	@Override
	public void Modifier(IProducteur p) {
		int i = 0;
		boolean trouve = false;
		while(!trouve) {
			if(( i < p.getMagasin().getProduits().size())) {
				if(p.getMagasin().getProduits().get(i).getQuantites() == 0) {
					i++;
				} else {
					trouve = true;
					ajouter(p.getMagasin().getProduits().get(i),p.getMagasin().getPanier());
				}
			}
			
		}
	}

}

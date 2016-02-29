package afficheur;

import java.util.Iterator;

import donnees.Magasin;
import donnees.Produit;

public class AfficheurConsoleBeau implements IAfficheur{

	@Override
	public void afficheProduit(Produit p) {
		System.out.println("____________________________");
		System.out.println("Nom : "+p.getNom());
		System.out.println("Type : "+p.getType());
		System.out.println("Prix :"+p.getPrix()+"€");
		
	}

	@Override
	public void afficheMagasin(Magasin mag) {
		for (int i = 0; i < mag.getProduits().size(); i++) {
			afficheProduit(mag.getProduits().get(i));
		}
		
	}

}

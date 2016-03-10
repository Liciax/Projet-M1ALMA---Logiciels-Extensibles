package afficheur;

import java.util.Iterator;

import donnees.IMagasin;
import donnees.IPanier;
import donnees.IProduit;

public class AfficheurConsoleBeau implements IAfficheur{

	@Override
	public void afficheProduit(IProduit p) {
		System.out.println("____________________________");
		System.out.println("Nom : "+p.getNom());
		System.out.println("Type : "+p.getType());
		System.out.println("Prix :"+p.getPrix()+"€");
		System.out.println("Quantites :"+p.getQuantites());
		
	}

	@Override
	public void afficheMagasin(IMagasin mag) {
		for (int i = 0; i < mag.getProduits().size(); i++) {
			afficheProduit(mag.getProduits().get(i));
		}
	}
	
	@Override
	public void affichePanier(IPanier pan) {
		//System.out.println("____________________________");
		for (IProduit p : pan.getContenu()) {
			afficheProduit(p);
		}
	}

}

package afficheur;

import donnees.IMagasin;
import donnees.IProduit;

public class AfficheurConsole implements IAfficheur{

	public void afficheProduit(IProduit p) {
		System.out.println(p.toString());
	}
	
	public void afficheMagasin(IMagasin mag) {
		System.out.println(mag.toString());
	}
}

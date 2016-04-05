package donnees;


import donnees.IMagasin;

public interface IProducteur {

	//public ArrayList<IProduit> getProduits();
	
	/*
	* creer les donnees contenu dans le fichier donnees.txt
	*/
	public IMagasin getMagasin();
}

package afficheur;

import java.util.Scanner;

import donnees.IMagasin;
import donnees.IPanier;
import donnees.IProduit;

public interface IAfficheur {

	/*
	* affiche le nom, le type, le prix et la quantités d'un produit
	*/
	public void afficheProduit(IProduit p);
	
	/*
	* affiche le nom, la liste des produits et le panier (si il en possede un) d'un magasin
	*/
	public void afficheMagasin(IMagasin mag);
	
	/*
	* affiche la liste des produits contenu dans le panier
	*/
	public void affichePanier(IPanier pan);
	
	/*
	* affiche la phrase contenu dans s et attend ou non une reponse de l'utilisateur.
	* cette methode sert a informer l'utilisateur pour differente action
	*/
	public String affichePhrase(String s, boolean estQuestion);
	
}

package actuateur;

import java.util.Scanner;

import donnees.IProducteur;
import donnees.IProduit;

public class ActuateurAjoutDirect implements IActuateur {

  @Override
  public void Modifier(IProducteur p) {
    Scanner sc = new Scanner(System.in);
    String nom;
    String type;
    float prix;
    int quantites;
    IProduit prod;
    try {
      prod = p.getMagasin().getProduits().get(0).getClass().newInstance();
      System.out.print("nom du produit? :");
      nom = sc.next();
      prod.setNom(nom);
      
      System.out.print("type du produit? :");
      type = sc.next();
      prod.setType(type);
      
      System.out.print("prix du produit? :");
      prix = sc.nextFloat();
      prod.setPrix(prix);
      
      System.out.print("quantite du produit? :");
      quantites = sc.nextInt();
      prod.setQuantites(quantites);
      
      p.getMagasin().getProduits().add(prod);
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }

}

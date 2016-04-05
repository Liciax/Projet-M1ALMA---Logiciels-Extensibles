package afficheur;


import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import appli.Application;
import donnees.IMagasin;
import donnees.IPanier;
import donnees.IProduit;

public class AfficheurGraphique implements IAfficheur{

	
	private FenetreInitiale frameMagasin;
	private FenetrePanier framePanier;
	
	@Override
	public void afficheProduit(IProduit p) {
	}
	
	public Panel afficheProduitGraphique(IProduit p) {
		//Creation de 3 labels
		JLabel nom = new JLabel("Nom : " + p.getNom());
		JLabel type = new JLabel("Type : " + p.getType());
		JLabel prix = new JLabel("Prix : " + p.getPrix());
		JLabel quantites = new JLabel("Quantites : " + p.getQuantites());
		
		nom.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		type.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		prix.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		quantites.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		
		// insertion des boutons dans une gridLayout
		Panel pan = new Panel();
		GridLayout gl = new GridLayout(3, 1);
		pan.setLayout(gl);
		pan.add("nom", nom);
		pan.add("type",type);
		pan.add("Prix",prix);
		pan.add("Quantites",quantites);
		
		return pan;
	}
	
	public void afficheProduit(IProduit p, JFrame f){
	
	}

	@Override
	public void afficheMagasin(IMagasin mag) {
		frameMagasin = new FenetreInitiale(mag);
		frameMagasin.setSize(500, 400);		
	}
	
	@Override
	public void affichePanier(IPanier pan) {
		
		framePanier = new FenetrePanier(pan);
		framePanier.setSize(500,400);
		frameMagasin.setFramePanier(framePanier);
		framePanier.setFrameMagasin(frameMagasin);
		framePanier.setTitre(Application.getAppli().getiPanHandler().calcule(frameMagasin.getMag()));
	}
	
    public String affichePhrase(String s , boolean estQuestion) {
      System.out.println(s);
      String obj = null;
      if(estQuestion){
        Scanner sc = new Scanner(System.in);
        obj = sc.next();
      }
      return obj;
    }
	
}

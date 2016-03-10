package afficheur;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import donnees.IMagasin;
import donnees.IPanier;
import donnees.IProduit;

public class AfficheurGraphique implements IAfficheur{

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
		JFrame frame = new JFrame("Aplication");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,600);
		
		
		JLabel label = new JLabel("Bienvenue au magasin "+mag.getNomMag());
		label.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		
		GridLayout gl = new GridLayout(mag.getProduits().size()+1, 1);
		gl.setVgap(10); 
		frame.setLayout(gl);
		
		
		//Box hbox = Box.createVerticalBox();
		frame.getContentPane().add(label);
		
		for (int i = 0; i < mag.getProduits().size(); i++) {
			Panel b = afficheProduitGraphique(mag.getProduits().get(i));
			frame.getContentPane().add(b);
		}
		
		//Container contentpane = frame.getContentPane();
		//contentpane.add(hbox);		
		
		frame.setVisible(true);			
	}
	
	@Override
	public void affichePanier(IPanier pan) {
		// a faire en graphique, vu que je sais pas comment on fait 
		for (IProduit p : pan.getContenu()) {
			Panel b = afficheProduitGraphique(p);
		}
	}
	
}

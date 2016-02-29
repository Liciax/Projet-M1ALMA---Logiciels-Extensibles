package afficheur;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import donnees.Magasin;
import donnees.Produit;

public class AfficheurGraphique implements IAfficheur{

	@Override
	public void afficheProduit(Produit p) {
	}
	
	public Box afficheProduitGraphique(Produit p) {
		JLabel nom = new JLabel("Nom : " + p.getNom());
		JLabel type = new JLabel("Type : " + p.getType());
		JLabel prix = new JLabel("Prix : " + p.getPrix());
		
		Box hbox = Box.createHorizontalBox();
		hbox.add(nom);
		hbox.add(type);
		hbox.add(prix);
		
		return hbox;
	}
	
	public void afficheProduit(Produit p, JFrame f){
		JPanel panel = new JPanel();
		BoxLayout bl=new BoxLayout(panel,BoxLayout.Y_AXIS);
		panel.setLayout(bl);
		
		
		f.setContentPane(panel);		
	}

	@Override
	public void afficheMagasin(Magasin mag) {
		JFrame frame = new JFrame("Aplication");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,300);
		
		
		JLabel label = new JLabel("Bienvenue dans ma modeste application");
		
		
		Box hbox = Box.createHorizontalBox();
		hbox.add(label);
		
		for (int i = 0; i < mag.getProduits().size(); i++) {
			Box b = afficheProduitGraphique(mag.getProduits().get(i));
			hbox.add(b);
		}
		
		Container contentpane = frame.getContentPane();
		contentpane.add(hbox);
		
		
		
		frame.setVisible(true);
		
		
	}

}

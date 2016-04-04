package afficheur;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import appli.Application;

import donnees.IMagasin;
import donnees.IProduit;

public class InterfaceInitiale extends JFrame{

	
	private JTextArea textPane = new JTextArea();
	
	private JPanel layout = new JPanel();
	
	private JScrollPane scroll = new JScrollPane(layout);
	
	
	
	
	
	public InterfaceInitiale(final IMagasin mag) {
		
		this.setLocationRelativeTo(null);
	    this.setTitle("Magasin");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(500, 500);

	    
	    layout.setLayout(new BoxLayout(layout, BoxLayout.PAGE_AXIS));
	    //layout.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    
	    for (int i = 0; i < mag.getProduits().size(); i++) {
	    	JLabel lab = afficheProduitGraphique(mag.getProduits().get(i));
			layout.add(lab);
		}

	    JButton bouton =  new JButton("Nouveau produit");
	    
	    bouton.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent e){  
	    	  
	    	  DialogueAjout zd = new DialogueAjout(null, "Ajouter un produit", true);
	          IProduit zInfo = zd.showZDialog(); 
	          //JOptionPane jop = new JOptionPane();
	          //jop.showMessageDialog(null, zInfo.toString(), "Informations produit", JOptionPane.INFORMATION_MESSAGE);
	          
	          //TODO
	          // Ajouter le produit dans le magasin avec l'actuateur 
	          
	          //TODO 
	          // Recharger le magasin dans la fenêtre
	        
	        
	      }
	    });
	    
	    JLabel titre = new JLabel("Bienvenue dans le Magasin : "+mag.getNomMag());
	    
	    this.getContentPane().add(titre, BorderLayout.NORTH);
	      
	    //On ajoute l'objet au content pane de notre fenêtre
	    this.getContentPane().add(scroll, BorderLayout.CENTER);
	    
	    //On aurait pu aussi écrire
	    //this.getContentPane().add(new JScrollPane(textPane), BorderLayout.CENTER);
	    this.getContentPane().add(bouton, BorderLayout.SOUTH);
	    this.setVisible(true);
	    
	}
	
	
	public JLabel afficheProduitGraphique(IProduit p) {
		JLabel infos = new JLabel("<html>Nom : " + p.getNom() +"<br/>Type : "+ p.getType() + "<br/>Prix : "+ p.getPrix() + "<br/>Quantité : "+ p.getQuantites() + "</html>");
		
		//infos.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		
		
		infos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		return infos;
	}
}

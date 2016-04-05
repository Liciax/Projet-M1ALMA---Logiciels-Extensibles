package afficheur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.border.BevelBorder;

import appli.Application;

import donnees.IMagasin;
import donnees.IProduit;

public class FenetreInitiale extends JFrame{

	
	private JPanel layout = new JPanel();
	
	private FenetrePanier framePanier;
	private IMagasin mag;
	
	private JPanel panelProduit;
	
	/**
	 * @return the mag
	 */
	public IMagasin getMag() {
		return mag;
	}


	/**
	 * @param mag the mag to set
	 */
	public void setMag(IMagasin mag) {
		this.mag = mag;
	}


	/**
	 * @return the framePanier
	 */
	public JFrame getFramePanier() {
		return framePanier;
	}


	/**
	 * @param framePanier the framePanier to set
	 */
	public void setFramePanier(FenetrePanier framePanier) {
		this.framePanier = framePanier;
	}


	public FenetreInitiale(final IMagasin magasin) {
		this.mag = magasin;
		this.setLocationRelativeTo(null);
		this.setLocation(50, 50);
	    this.setTitle("Magasin");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(500, 400);
	    
	    
	    panelProduit = new JPanel();
	    panelProduit.setLayout(new GridLayout(mag.getProduits().size(),1));
	    for (int i = 0; i < mag.getProduits().size(); i++) {
	    	JPanel pan = afficheProduitGraphique(mag.getProduits().get(i), panelProduit, mag);
			panelProduit.add(pan);

			pan.setBorder(BorderFactory.createLineBorder(Color.black));
		}
	    
	    JScrollPane scrollPane = new JScrollPane(panelProduit);
	    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    scrollPane.setBounds(0, 0, 500, 300);
	    JPanel contentPane = new JPanel(null);
	    contentPane.setPreferredSize(new Dimension(500, 300));
	    contentPane.add(scrollPane);
	    this.setLayout(new BorderLayout());
	    this.pack();
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    

	    JButton bouton =  new JButton("Nouveau produit");
	    
	    
	    bouton.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent e){  
	    	  
	    	  DialogueAjout fenetreAjout = new DialogueAjout(null, "Ajouter un produit", true);
	          IProduit nouveauProduit = fenetreAjout.showZDialog(); 
	          System.out.println(nouveauProduit);
	          
	          
	          // Ajouter le produit dans le magasin avec l'actuateur 
	          try {
	        	  Application.getAppli().getiMagHandler().ajouter(nouveauProduit, mag);
			} catch (Exception e2) {
				System.out.println("marche pas");
				System.out.println(Application.getAppli().getiMagHandler());
			}
	          
	          
	          // Recharger le magasin dans la fenêtre
	          rechargerMagasin();

	        
	      }
	    });
	    
	    JLabel titre = new JLabel("Bienvenue dans le Magasin : "+mag.getNomMag());
	    
	    this.getContentPane().add(titre, BorderLayout.NORTH);
	      
	    //On ajoute l'objet au content pane de notre fenêtre
	    this.getContentPane().add(contentPane, BorderLayout.CENTER);
	    
	    //On aurait pu aussi écrire
	    //this.getContentPane().add(new JScrollPane(textPane), BorderLayout.CENTER);
	    this.getContentPane().add(bouton, BorderLayout.SOUTH);
	    this.setSize(500, 500);
	    this.setVisible(true);
	    
	}
	
	
	public JPanel afficheProduitGraphique(final IProduit p, final JPanel panelProduit, final IMagasin mag) {
		
		JLabel labelNom = new JLabel("Nom : " + p.getNom());
        JLabel labelType = new JLabel("Type : " + p.getType());
        JLabel labelQuantite = new JLabel("Quantité : "+ p.getQuantites());
        JLabel labelPrix = new JLabel("Prix : "+ p.getPrix());
        
		
		JPanel panelTexte = new JPanel();
        panelTexte.setPreferredSize(new Dimension(300, 100));
        panelTexte.setLayout(new GridLayout(4, 1));
        panelTexte.add(labelNom);
        panelTexte.add(labelType);
        panelTexte.add(labelQuantite);
        panelTexte.add(labelPrix);
        
        
        
        JPanel panelBouton = new JPanel();
        JButton boutonModif = new JButton("Modifier");
        JButton boutonPanier = new JButton("Ajouter au panier");
        JButton boutonSupprimer = new JButton("Supprimer");
        panelBouton.setLayout(new GridLayout(3,1));
        panelBouton.add(boutonModif);
        panelBouton.add(boutonPanier);
        panelBouton.add(boutonSupprimer);
        
        
        
        JPanel panelTotal = new JPanel();
        panelTotal.setLayout(new BorderLayout());
        panelTotal.add(panelTexte, BorderLayout.WEST);
        panelTotal.add(panelBouton, BorderLayout.EAST);
        
        
        boutonModif.addActionListener(new ActionListener(){
  	      public void actionPerformed(ActionEvent e){
  	    	  DialogueModif fenetreModif = new DialogueModif(null, "Modifier un produit", true, p);
  	    	  IProduit nouveauProduit = fenetreModif.showZDialog(); 
  	    	  
  	    	try {
	        	  Application.getAppli().getiMagHandler().modifier(p, mag, nouveauProduit);
			} catch (Exception e2) {
				System.out.println("Erreur lors de la modification");
				System.out.println(Application.getAppli().getiMagHandler());
			}
  	    	
  	    	rechargerMagasin();
  	    	  
  	      }
        });
        
        boutonSupprimer.addActionListener(new ActionListener(){
    	      public void actionPerformed(ActionEvent e){
    	    	  try {
    	        	  Application.getAppli().getiMagHandler().supprimer(p, mag);
    			} catch (Exception e2) {
    				System.out.println("Erreur lors de la suppression");
    				System.out.println(Application.getAppli().getiMagHandler());
    			}
      	    	
      	    	rechargerMagasin();
    	      }
          });
        
        
        boutonPanier.addActionListener(new ActionListener(){
  	      public void actionPerformed(ActionEvent e){
  	    	  
  	    	String s = (String)JOptionPane.showInputDialog(
  	    		   null,
  	    		   "Quelle quantité voulez-vous ajouter au panier ?",
  	    		   "Ajout au panier",
  	    		   JOptionPane.QUESTION_MESSAGE,
  	    		   null,
  	    		   null,
  	    		   p.getQuantites());
  	    	
	    	  try {
	    		  //if ((s != null) && (s.length() > 0) && Integer.parseInt(s)<=p.getQuantites() && Integer.parseInt(s)>0 ){
	    		  if ((s != null) && (s.length() > 0) && Integer.parseInt(s)>0 ){
	    			  System.out.println("Produit ajouté au panier");
	    			  Application.getAppli().getiPanHandler().ajouter(p, mag, Integer.parseInt(s));
	    			  framePanier.rechargerPanier();
	    			  
	    		  }
	    		  else{
	    			  System.out.println("Produit non ajouté");
	    		  }
	        	  //Application.getAppli().getiPanHandler().ajouter(p, magasin, quantite);
			} catch (Exception e2) {
				System.out.println("Erreur lors de la suppression");
				System.out.println(Application.getAppli().getiMagHandler());
			}
  	    	
  	    	rechargerMagasin();
	      }
      });
        
        
        return panelTotal;
	}
	
	
	public void rechargerMagasin(){
		panelProduit.removeAll();
        panelProduit.setLayout(new GridLayout(mag.getProduits().size(),1));
	    for (int i = 0; i < mag.getProduits().size(); i++) {
	    	JPanel pan = afficheProduitGraphique(mag.getProduits().get(i), panelProduit, mag);
			panelProduit.add(pan);
			pan.setBorder(BorderFactory.createLineBorder(Color.black));
		}
        panelProduit.updateUI();
	}
}

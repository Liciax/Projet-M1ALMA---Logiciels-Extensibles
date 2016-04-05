package afficheur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import appli.Application;

import donnees.IMagasin;
import donnees.IPanier;
import donnees.IProduit;

public class FenetrePanier extends JFrame {

	private FenetreInitiale frameMagasin;
	
	private IPanier pan;
	private JPanel panelProduit;
	
	private String titre;
	
	private JLabel labelTitre;
	
	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	private float prixPanier;
	private String titrePanier;
	
	/**
	 * @return the frameMagasin
	 */
	public JFrame getFrameMagasin() {
		return frameMagasin;
	}

	/**
	 * @param frameMagasin the frameMagasin to set
	 */
	public void setFrameMagasin(FenetreInitiale frameMagasin) {
		this.frameMagasin = frameMagasin;
	}




	public FenetrePanier(IPanier lePan){
		prixPanier = 0;
		this.pan = lePan;
		this.setLocationRelativeTo(null);
		this.setLocation(550, 50);
	    this.setTitle("Panier");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(500, 400);
	    
	    final JPanel panProduit = new JPanel();
	    panProduit.setLayout(new GridLayout(pan.getContenu().size(),1));
	    for (int i = 0; i < pan.getContenu().size(); i++) {
	    	JPanel panier = afficheProduitGraphique(pan.getContenu().get(i), panProduit, pan);
			panProduit.add(panier);

			panier.setBorder(BorderFactory.createLineBorder(Color.black));
		}
	    
	    this.panelProduit = panProduit;
	    
	    JScrollPane scrollPane = new JScrollPane(panProduit);
	    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    scrollPane.setBounds(0, 0, 500, 300);
	    JPanel contentPane = new JPanel(null);
	    contentPane.setPreferredSize(new Dimension(500, 300));
	    contentPane.add(scrollPane);
	    this.setLayout(new BorderLayout());
	    this.pack();
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    

	    JButton bouton =  new JButton("Valider");
	    
	    labelTitre = new JLabel(titre);
	    
	    this.getContentPane().add(labelTitre, BorderLayout.NORTH);
	    
	    bouton.addActionListener(new ActionListener(){
	  	      public void actionPerformed(ActionEvent e){
	  	    	  try {
	  	        	  Application.getAppli().getiPanHandler().valider(frameMagasin.getMag());
	  			} catch (Exception e2) {
	  				System.out.println("Erreur lors de la suppression");
	  				System.out.println(Application.getAppli().getiMagHandler());
	  			}
	    	    	
	    	    	rechargerPanier();
	    	    	frameMagasin.rechargerMagasin();
	  	      }
	        });
	      
	    //On ajoute l'objet au content pane de notre fenêtre
	    this.getContentPane().add(contentPane, BorderLayout.CENTER);
	    
	    //On aurait pu aussi écrire
	    //this.getContentPane().add(new JScrollPane(textPane), BorderLayout.CENTER);
	    this.getContentPane().add(bouton, BorderLayout.SOUTH);
	    this.setSize(500, 500);
	    this.setVisible(true);
	    
	}
	
	
public JPanel afficheProduitGraphique(final IProduit p, final JPanel panelProduit, final IPanier pan) {
		
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
        JButton boutonSupp = new JButton("Supprimer");
        JButton boutonModif = new JButton("Modifier");
        panelBouton.setLayout(new GridLayout(2,1));
        panelBouton.add(boutonModif);
        panelBouton.add(boutonSupp);

        
        
        
        JPanel panelTotal = new JPanel();
        panelTotal.setLayout(new BorderLayout());
        panelTotal.add(panelTexte, BorderLayout.WEST);
        panelTotal.add(panelBouton, BorderLayout.EAST);
        
        
        boutonSupp.addActionListener(new ActionListener(){
  	      public void actionPerformed(ActionEvent e){
  	    	  try {
  	        	  Application.getAppli().getiPanHandler().supprimer(p, pan);
  			} catch (Exception e2) {
  				System.out.println("Erreur lors de la suppression");
  				System.out.println(Application.getAppli().getiMagHandler());
  			}
    	    	
    	    	rechargerPanier();
  	      }
        });
        
        
        boutonModif.addActionListener(new ActionListener(){
  	      public void actionPerformed(ActionEvent e){
  	    	  
  	    	String s = (String)JOptionPane.showInputDialog(
   	    		   null,
   	    		   "Modifier la quantité ?",
   	    		   "Ajout au panier",
   	    		   JOptionPane.QUESTION_MESSAGE,
   	    		   null,
   	    		   null,
   	    		   p.getQuantites());
  	    	
  	    	  try {
  	    		  
  	    		if ((s != null) && (s.length() > 0) ){
  	    			Application.getAppli().getiPanHandler().modifier(p, frameMagasin.getMag(), Integer.parseInt(s));
  	    			rechargerPanier();
  	    		}
  	        	  
  			} catch (Exception e2) {
  				System.out.println("Erreur lors de la modification");
  				System.out.println(Application.getAppli().getiMagHandler());
  			}
    	    	
    	    	rechargerPanier();
  	      }
        });
        
        
        return panelTotal;
	}

	public void rechargerPanier(){
		prixPanier = 0;
		panelProduit.removeAll();
		panelProduit.setLayout(new GridLayout(pan.getContenu().size(),1));
		for (int i = 0; i < pan.getContenu().size(); i++) {
			JPanel panier = afficheProduitGraphique(pan.getContenu().get(i), panelProduit, pan);
			panelProduit.add(panier);
			panier.setBorder(BorderFactory.createLineBorder(Color.black));
			prixPanier = prixPanier + (pan.getContenu().get(i).getPrix() * pan.getContenu().get(i).getQuantites());
		}
	    labelTitre.setText(Application.getAppli().getiPanHandler().calculePrix(frameMagasin.getMag()));
		panelProduit.updateUI();
}


}

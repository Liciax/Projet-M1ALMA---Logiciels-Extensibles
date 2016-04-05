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
	
	private JLabel titre;
	
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
	    
	    titrePanier = "Votre panier : " + prixPanier + "€";
	    titre = new JLabel(titrePanier);
	    
	    this.getContentPane().add(titre, BorderLayout.NORTH);
	    
	    bouton.addActionListener(new ActionListener(){
	  	      public void actionPerformed(ActionEvent e){
	  	    	  try {
	  	        	  Application.getAppli().getiPanHandler().valider(frameMagasin.getMag());
	  			} catch (Exception e2) {
	  				System.out.println("Erreur lors de la suppression");
	  				System.out.println(Application.getAppli().getiMagHandler());
	  			}
	    	    	
	    	    	rechargerPanier();
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
        panelBouton.setLayout(new GridLayout(1,1));
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
		titrePanier = "Votre panier : " + prixPanier + "€";
	    titre.setText(titrePanier);
		panelProduit.updateUI();
}


}

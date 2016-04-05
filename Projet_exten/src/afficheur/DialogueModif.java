package afficheur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import donnees.IProduit;
import donnees.ProduitConcret;

public class DialogueModif extends JDialog{
	
	private IProduit newProduit;
	private boolean sendData;
	
	private JTextField nom;
	private JLabel nomLabel;
	
	private JTextField type;
	private JLabel typeLabel;
	
	private JTextField quantite;
	private JLabel quantiteLabel;
	
	private JTextField prix;
	private JLabel prixLabel;
	
	public DialogueModif(JFrame parent, String title, boolean modal, IProduit produit){
		 super(parent, title, modal);
		 newProduit = produit;
		 
		 this.setSize(570, 270);
		 this.setLocationRelativeTo(null);
		 this.setResizable(false);
		 this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		 this.initComponent();
	}
	
	public IProduit showZDialog(){
	    this.sendData = false;
	    this.setVisible(true);      
	    return this.newProduit;      
	  }
	
	private void initComponent(){
		//Le nom du produit
				JPanel panNom = new JPanel();
			    panNom.setBackground(Color.white);
			    panNom.setPreferredSize(new Dimension(260, 70));
			    nom = new JTextField();
			    nom.setText(newProduit.getNom());
			    nom.setPreferredSize(new Dimension(100, 25));
			    panNom.setBorder(BorderFactory.createTitledBorder("Nom du produit"));
			    nomLabel = new JLabel("Saisir le nom :");
			    panNom.add(nomLabel);
			    panNom.add(nom);
			    
			    
			    //Le type du produit
			    JPanel panType = new JPanel();
			    panType.setBackground(Color.white);
			    panType.setPreferredSize(new Dimension(260, 70));
			    type = new JTextField();
			    type.setText(newProduit.getType());
			    type.setPreferredSize(new Dimension(100, 25));
			    panType.setBorder(BorderFactory.createTitledBorder("Type du produit"));
			    typeLabel = new JLabel("Saisir le type :");
			    panType.add(typeLabel);
			    panType.add(type);
			    
			    //La quantité du produit
			    JPanel panQuantite = new JPanel();
			    panQuantite.setBackground(Color.white);
			    panQuantite.setPreferredSize(new Dimension(260, 70));
			    quantite = new JTextField();
			    quantite.setText(""+newProduit.getQuantites());
			    quantite.setPreferredSize(new Dimension(100, 25));
			    panQuantite.setBorder(BorderFactory.createTitledBorder("Quantité du produit"));
			    quantiteLabel = new JLabel("Saisir la quantité :");
			    panQuantite.add(quantiteLabel);
			    panQuantite.add(quantite);
			    
			    
			    //Le prix du produit
			    JPanel panPrix = new JPanel();
			    panPrix.setBackground(Color.white);
			    panPrix.setPreferredSize(new Dimension(260, 70));
			    prix = new JTextField();
			    prix.setText(""+newProduit.getPrix());
			    prix.setPreferredSize(new Dimension(100, 25));
			    panPrix.setBorder(BorderFactory.createTitledBorder("Prix du produit"));
			    prixLabel = new JLabel("Saisir le prix à l'unité :");
			    panPrix.add(prixLabel);
			    panPrix.add(prix);
			    
			    
			    JPanel content = new JPanel();
			    content.setBackground(Color.white);
			    content.add(panNom);
			    content.add(panType);
			    content.add(panQuantite);
			    content.add(panPrix);
			    
			    JPanel control = new JPanel();
			    JButton okBouton = new JButton("OK");
			    
			    
			    
			    okBouton.addActionListener(new ActionListener(){
			        public void actionPerformed(ActionEvent arg0) { 
			        	if(nom.getText().equals("") || type.getText().equals("") || quantite.getText().equals("") || prix.getText().equals("")){
			        		JOptionPane.showMessageDialog(null, "Compléter tous les champs");
			        	}
			        	else{
			        		
			        		try {
			        			newProduit = new ProduitConcret(nom.getText(), type.getText(), Float.parseFloat(prix.getText()), Integer.parseInt(quantite.getText()));
			        			setVisible(false);
			        			}
			        			catch (Exception e) {
			        				JOptionPane.showMessageDialog(null, "La quantité et le prix doivent être des entiers.");
			        			}
			        	}
			        }    
			      });
			    
			    
			    
			    JButton cancelBouton = new JButton("Annuler");
			    cancelBouton.addActionListener(new ActionListener(){
			    	
			      public void actionPerformed(ActionEvent arg0) {
			        setVisible(false);
			      }      
			    });
			    
			    
			    control.add(okBouton);
			    control.add(cancelBouton);

			    this.getContentPane().add(content, BorderLayout.CENTER);
			    this.getContentPane().add(control, BorderLayout.SOUTH);
	}
	
	

}

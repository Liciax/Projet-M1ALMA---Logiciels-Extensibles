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
	    this.setSize(500, 400);

	    
	    /*layout.setLayout(new BoxLayout(layout, BoxLayout.PAGE_AXIS));
	    //layout.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    
	    for (int i = 0; i < mag.getProduits().size(); i++) {
	    	JLabel lab = afficheProduitGraphique(mag.getProduits().get(i));
			layout.add(lab);
		}*/
	    
	    
	     final JPanel panel = new JPanel();
	    panel.setLayout(new GridLayout(mag.getProduits().size(),1));
	    for (int i = 0; i < mag.getProduits().size(); i++) {
	    	JPanel pan = afficheProduitGraphique(mag.getProduits().get(i));
			panel.add(pan);
		}
	    
	    JScrollPane scrollPane = new JScrollPane(panel);
	    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    scrollPane.setBounds(0, 0, 500, 300);
	    JPanel contentPane = new JPanel(null);
	    contentPane.setPreferredSize(new Dimension(500, 300));
	    contentPane.add(scrollPane);
	    //this.setContentPane(contentPane);
	    this.setLayout(new BorderLayout());
	    this.pack();
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    

	    JButton bouton =  new JButton("Nouveau produit");
	    
	    bouton.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent e){  
	    	  
	    	  DialogueAjout zd = new DialogueAjout(null, "Ajouter un produit", true);
	          IProduit zInfo = zd.showZDialog(); 
	          System.out.println(zInfo);
	          //JOptionPane jop = new JOptionPane();
	          //jop.showMessageDialog(null, zInfo.toString(), "Informations produit", JOptionPane.INFORMATION_MESSAGE);
	          
	          
	          // Ajouter le produit dans le magasin avec l'actuateur 
	          try {
	        	  Application.getAppli().getiMagHandler().ajouter(zInfo, mag, zInfo.getQuantites());
			} catch (Exception e2) {
				System.out.println("marche pas");
				System.out.println(Application.getAppli().getiMagHandler());
			}
	          
	          
	          
	          //TODO 
	          // Recharger le magasin dans la fenêtre
	          panel.removeAll();
	          panel.setLayout(new GridLayout(mag.getProduits().size(),1));
	  	    for (int i = 0; i < mag.getProduits().size(); i++) {
	  	    	JPanel pan = afficheProduitGraphique(mag.getProduits().get(i));
	  			panel.add(pan);
	  		}
	          panel.updateUI();

	        
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
	
	
	public JPanel afficheProduitGraphique(IProduit p) {
		
		JPanel pan = new JPanel();
        pan.setBackground(Color.white);
        //pan.setPreferredSize(new Dimension(500, 500));
        JLabel label1 = new JLabel("Nom : " + p.getNom());
        JLabel label2 = new JLabel("Type : " + p.getType());
        JLabel label3 = new JLabel("Quantité : "+ p.getQuantites());
        JLabel label4 = new JLabel("Prix : "+ p.getPrix());
        
        pan.setLayout(new GridLayout(4, 1));
        pan.add(label4); pan.add(label3); pan.add(label2); pan.add(label1);
        
        JPanel pan2 = new JPanel();
        JButton b = new JButton("Modifier");
        
        pan2.setLayout(new BorderLayout());
        pan2.add(pan, BorderLayout.WEST);
        pan2.add(b, BorderLayout.EAST);
        
        return pan2;
	}
}

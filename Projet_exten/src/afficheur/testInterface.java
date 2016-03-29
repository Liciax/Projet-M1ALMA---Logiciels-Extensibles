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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import donnees.IMagasin;
import donnees.IProduit;

public class testInterface extends JFrame{

	
	private JTextArea textPane = new JTextArea();
	
	private JPanel layout = new JPanel();
	
	private JScrollPane scroll = new JScrollPane(layout);
	
	
	
	
	
	public testInterface(final IMagasin mag) {
		
		this.setLocationRelativeTo(null);
	    this.setTitle("Gérer vos conteneur");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(500, 500);
	    
	    //GridLayout gl = new GridLayout(6, 1);
	    
	    layout.setLayout(new BoxLayout(layout, BoxLayout.PAGE_AXIS));
	    //layout.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    
	    for (int i = 0; i < mag.getProduits().size(); i++) {
	    	JLabel lab = afficheProduitGraphique(mag.getProduits().get(i));
	    	//lab.setText(afficheProduitGraphique(mag.getProduits().get(i)));
			layout.add(lab);
		}

	    JButton bouton =  new JButton("Bouton");
	    
	    bouton.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent e){
	        System.out.println("Texte écrit dans le JTextArea : ");
	        System.out.println("--------------------------------");
	        System.out.println(textPane.getText());            
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
		
		infos.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		
		// insertion des boutons dans une gridLayout
		Panel pan = new Panel();
		GridLayout gl = new GridLayout(1, 3);
		pan.setLayout(gl);

		pan.add("Infos",infos);
		
		infos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		return infos;
	}
}

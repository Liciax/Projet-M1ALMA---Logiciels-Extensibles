package afficheur;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.text.TextAction;

import donnees.IMagasin;
import donnees.IProduit;

public class FenetreGraphique extends JPanel{


	IMagasin mag;
	JList list;
	DefaultListModel model;
	int counter;

	
	public FenetreGraphique(final IMagasin mag) {
		this.mag = mag;
		counter = mag.getProduits().size();
		
		setLayout(new BorderLayout());
	    model = new DefaultListModel();
	    list = new JList(model);
	    
	    JScrollPane pane = new JScrollPane(list);
	    JButton addButton = new JButton("Add Element");
	    JButton removeButton = new JButton("Refresh");
	   
	    for (int i = 0; i < mag.getProduits().size(); i++){
	    	TextArea text = new TextArea("test");
	    	model.addElement(text);
	    }
	      //model.addElement(mag.getProduits().get(i).getNom() + " " + mag.getProduits().get(i).getPrix()+"Euros");

	    
	    
	    addButton.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        model.addElement("banana 58Euros");
	        counter++;
	      }
	    });
	    removeButton.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	    	  JScrollPane pane = new JScrollPane(list);
	  	    JButton addButton = new JButton("Add Element");
	  	    JButton removeButton = new JButton("Refresh");
	  	   
	  	    for (int i = 0; i < mag.getProduits().size(); i++){
	  	    	
	  	    }
	  	      //model.addElement(mag.getProduits().get(i).getNom() + " " + mag.getProduits().get(i).getPrix()+"Euros");
	  	    	//model.addElement(afficheProduitGraphique(mag.getProduits().get(i)));
	      }
	    });

	    add(pane, BorderLayout.NORTH);
	    add(addButton, BorderLayout.WEST);
	    add(removeButton, BorderLayout.EAST);
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
		//pan.add("type",type);
		//pan.add("Prix",prix);
		//pan.add("Quantites",quantites);
		
		return pan;
	}

	
}

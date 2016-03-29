package afficheur;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import donnees.IMagasin;

public class testInterface extends JFrame{

	
	private JTextArea textPane = new JTextArea();
	
	private JPanel layout = new JPanel();
	
	private JScrollPane scroll = new JScrollPane(new JPanel());
	
	
	public testInterface(final IMagasin mag) {
		
		this.setLocationRelativeTo(null);
	    this.setTitle("Gérer vos conteneur");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(200, 200);

	    JButton bouton =  new JButton("Bouton");
	    
	    bouton.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent e){
	        System.out.println("Texte écrit dans le JTextArea : ");
	        System.out.println("--------------------------------");
	        System.out.println(textPane.getText());            
	      }
	    });
	      
	    //On ajoute l'objet au content pane de notre fenêtre
	    this.getContentPane().add(scroll, BorderLayout.CENTER);
	    
	    //On aurait pu aussi écrire
	    //this.getContentPane().add(new JScrollPane(textPane), BorderLayout.CENTER);
	    this.getContentPane().add(bouton, BorderLayout.SOUTH);
	    this.setVisible(true);
	    
	}
}

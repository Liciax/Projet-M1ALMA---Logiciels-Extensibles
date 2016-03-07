package afficheur;

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import donnees.IMagasin;
import donnees.MagasinConcret;

public class FenetreGraphique extends JFrame{

	public FenetreGraphique(IMagasin m) {
		super("Application");

		WindowListener l = new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
				}
		};
		addWindowListener(l);
		setSize(400,300);
		setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		
		JLabel label = new JLabel("Bienvenue dans ma modeste application");
		 
		panel.add(label);
		
		setContentPane(panel);
	}
	
}

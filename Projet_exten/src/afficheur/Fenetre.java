package afficheur;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import donnees.IProduit;

public class Fenetre extends JFrame {
  private JButton bouton = new JButton("Appel à la ZDialog");

  public Fenetre(){      
    this.setTitle("Ma JFrame");
    this.setSize(300, 100);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);      
    this.getContentPane().setLayout(new FlowLayout());
    this.getContentPane().add(bouton);
    bouton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {
        DialogueAjout zd = new DialogueAjout(null, "Ajouter un produit", true);
        IProduit zInfo = zd.showZDialog(); 
        JOptionPane jop = new JOptionPane();
        jop.showMessageDialog(null, zInfo.toString(), "Informations produit", JOptionPane.INFORMATION_MESSAGE);
      }         
    });      
    this.setVisible(true);      
  }
   
  public static void main(String[] main){
    Fenetre fen = new Fenetre();
  }   
}
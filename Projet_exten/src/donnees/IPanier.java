package donnees;

import java.util.ArrayList;

public interface IPanier {

	public ArrayList<IProduit> getContenu();
	
	public void valider();
	
	public void vider();

}

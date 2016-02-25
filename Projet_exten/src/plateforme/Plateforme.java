package plateforme;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.Vector;

public class Plateforme {
	
	public Class loadAppli() {
		BufferedReader br;
		int i;
		String templigne;
//		Vector<Class> listeClass = new Vector<Class>();
		Vector<String> listeClass = new Vector<String>();
		Class app;
		//on va lire le fichier
		try {
			//lecture...
			br = new BufferedReader(new FileReader("node.txt"));
			while((templigne= br.readLine()) != null) {
				//cas ou la ligne n'est pas un commentaire
				if(!templigne.split(":")[0].equals("#")) {
					listeClass.add((templigne.split(";")[0]).split("=")[1]);
					System.out.println((templigne.split(";")[1]).split("=")[1]);
				}
				
			}
			Scanner sc = new Scanner(System.in);
			System.out.println("lequel?");
			i = sc.nextInt();
			app = (Class) Class.forName(listeClass.get(i-1));
		} catch (Exception e) {
			app = null;
		}
		return app;
	}
	
	public void makeClassDoIt(Class app) throws Exception {
		Object obj = app.newInstance();
		String temp = "doIt";
		Method m1 = app.getMethod(temp, String.class);
		m1.invoke(obj, null);
	}
	
	public void main(String args[]) {
		try {
			makeClassDoIt(loadAppli());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
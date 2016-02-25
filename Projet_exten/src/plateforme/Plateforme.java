package plateforme;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.Vector;

public class Plateforme {
	
	private Vector<String> liste_extensions ;
	private static Plateforme plateforme;
	
	private Plateforme(){
		liste_extensions = new Vector<String>();
	}
	
	public void loadExten() {
		BufferedReader br;
		int i;
		String templigne = "";
		//on va lire le fichier
		try {
			//lecture...
			br = new BufferedReader(new FileReader("src/plateforme/node.txt"));
			templigne= br.readLine();
			while(templigne != null) {
				liste_extensions.add(templigne);
				templigne= br.readLine();
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Object loadAppli() {
		int i;
		for(i = 0; i < liste_extensions.size(); i++) {
			System.out.println((liste_extensions.get(i).split(";")[1]).split("=")[1]);
			if((liste_extensions.get(i).split(";")[2]).split("=")[1].equals("now")){
				System.out.println("on le charge tout de suite!");
				try {
					return Class.forName((liste_extensions.get(i).split(";")[0]).split("=")[1]).newInstance();//ne trouve pas la classe! 
				} catch (InstantiationException | IllegalAccessException
						| ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		return null;
	}
	
	
//	public static Object loadAppli() {
//		BufferedReader br;
//		int i;
//		String templigne;
//		Vector<String> listeClass = new Vector<String>();
//		Object app;
//		//on va lire le fichier
//		try {
//			//lecture...
//			br = new BufferedReader(new FileReader("src/plateforme/node.txt"));
//			while((templigne= br.readLine()) != null) {
//				//cas ou la ligne n'est pas un commentaire
//				if(!templigne.split(":")[0].equals("#")) {
//					listeClass.add((templigne.split(";")[0]).split("=")[1]);
//					System.out.println((templigne.split(";")[1]).split("=")[1]);
//				}
//				
//			}
//			Scanner sc = new Scanner(System.in);
//			System.out.println("lequel?");
//			i = sc.nextInt();
//			app = Class.forName(listeClass.get(i)).newInstance();
//		} catch (Exception e) {
//			app = null;
//		}
//		return app;
//	}
	
	public static void makeClassDoIt(Object obj) throws Exception {
		String temp = "doIt";
		Method m1 = obj.getClass().getMethod(temp, String.class);
		m1.invoke(obj, null);
	}
	
	public Vector<String> getExtensions() {
		BufferedReader br;
		int i;
		String templigne;
//		Vector<Class> listeClass = new Vector<Class>();
		Vector<String> listeClass = new Vector<String>();
		Object classe;
		try {
			//lecture...
			br = new BufferedReader(new FileReader("nodeExtensions.txt"));
			while((templigne= br.readLine()) != null) {
				//cas ou la ligne n'est pas un commentaire
				if(!templigne.split(":")[0].equals("#")) {
					listeClass.add((templigne.split(";")[0]).split("=")[1]);
				}
				
			}
		} catch (Exception e) {
			classe = null;
		}
		return listeClass;
	}
	
	public Object CreaInstance(String nomClasse) throws Exception{
		return Class.forName(nomClasse).newInstance();
	}
	
//	public Object getIAfficheur() {
//		
//		BufferedReader br;
//		int i;
//		String templigne;
////		Vector<Class> listeClass = new Vector<Class>();
//		Vector<String> listeClass = new Vector<String>();
//		Object classe;
//		try {
//			//lecture...
//			br = new BufferedReader(new FileReader("nodeAfficheur.txt"));
//			while((templigne= br.readLine()) != null) {
//				//cas ou la ligne n'est pas un commentaire
//				if(!templigne.split(":")[0].equals("#")) {
//					listeClass.add((templigne.split(";")[0]).split("=")[1]);
//				}
//				
//			}
//			Scanner sc = new Scanner(System.in);
//			System.out.println("l'afficheur?");
//			i = sc.nextInt();
//			classe = Class.forName(listeClass.get(i)).newInstance();
//		} catch (Exception e) {
//			classe = null;
//		}
//		return classe;
//		
//	}
//	
//	public Object getIProducteur() {
//		BufferedReader br;
//		int i;
//		String templigne;
////		Vector<Class> listeClass = new Vector<Class>();
//		Vector<String> listeClass = new Vector<String>();
//		Object classe;
//		//on va lire le fichier
//		try {
//			//lecture...
//			br = new BufferedReader(new FileReader("nodeProducteur.txt"));
//			while((templigne= br.readLine()) != null) {
//				//cas ou la ligne n'est pas un commentaire
//				if(!templigne.split(":")[0].equals("#")) {
//					listeClass.add((templigne.split(";")[0]).split("=")[1]);
//				}
//				
//			}
//			Scanner sc = new Scanner(System.in);
//			System.out.println("le producteur?");
//			i = sc.nextInt();
//			classe = Class.forName(listeClass.get(i)).newInstance();
//		} catch (Exception e) {
//			classe = null;
//		}
//		return classe;
//	}
	
	
	
	public Vector<String> getListe_extensions() {
		return liste_extensions;
	}

	public void setListe_extensions(Vector<String> liste_extensions) {
		this.liste_extensions = liste_extensions;
	}

	public static void main(String args[]) {
		try {
			Plateforme plat = null;
			plat.getPlateforme().loadExten();
			Object c = plat.getPlateforme().loadAppli();
			makeClassDoIt(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Plateforme getPlateforme() {
		if(plateforme == null) {
			plateforme = new Plateforme();
		}
		return plateforme;
	}

}

package plateforme;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Paths;
import java.util.ArrayList;

import actuateur.IPanierHandler;

import proxyHandler.PanierHandler;

public class Plateforme {
	/*
	private ArrayList<String> liste_extensions ;
	private static Plateforme plateforme;
	private static URLClassLoader urlLoader;
	private ArrayList<URL> liste_URLs;
	
	private Plateforme(){
		liste_extensions = new ArrayList<String>();
		urlLoader = new URLClassLoader(loadURL());
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
		System.out.println("Voici la liste des applications que vous pouvez charger :");
		for(i = 0; i < liste_extensions.size(); i++) {
			System.out.println(" - " + (liste_extensions.get(i).split(";")[1]).split("=")[1]);
			if((liste_extensions.get(i).split(";")[2]).split("=")[1].equals("now")){
				System.out.println("Cette application doit se charger automatiquement. Chargement...");
				System.out.println("--------------------------------");
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
	
	public static void makeClassDoIt(Object obj) throws Exception {
		String temp = "doIt";
		Method m1 = obj.getClass().getMethod(temp, null);
		m1.invoke(obj, null);
	}
	
	public Vector<String> getExtensions() {
		//modif: on ajoute un champ classpath et on reduit class a son nom. on charge pareil mais newinstance fait le load url
		BufferedReader br;
		int i;
		String templigne;
		Vector<String> listeClass = new Vector<String>();
		try {
			//lecture...
			br = new BufferedReader(new FileReader("src/plateforme/nodeExtension.txt"));
			templigne= br.readLine();
			while(templigne != null) {
				listeClass.add((templigne.split(";")[0]).split("=")[1]);
	            templigne= br.readLine();
				
			}
		} catch (Exception e) {
		  e.printStackTrace();
		}
		return listeClass;
	}
	
	public Object CreaInstance(String nomClasse) throws Exception{
		
		return Class.forName(nomClasse).newInstance();
	}	
	
	public ArrayList<String> getListe_extensions() {
		return liste_extensions;
	}

	public void setListe_extensions(ArrayList<String> liste_extensions) {
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
	
	
	
	public void loadURL() {
		BufferedReader br;
		int i;
		String templigne;
		ArrayList<URL> classLoaderUrls = new ArrayList<URL>();
		
		try {
			//lecture...
			br = new BufferedReader(new FileReader("src/plateforme/listeUrls.txt"));
			templigne= br.readLine();
			String path = new File("").getAbsolutePath();
			while(templigne != null) {
				URL url = Paths.get(path,templigne).toUri().toURL();
				System.out.println(url);
				liste_URLs.add(url);
				templigne= br.readLine();
			}
			br.close();
		} catch (Exception e) {
		  e.printStackTrace();
		}
	}
	
	public Vector<URL> getURLs() {
      //modif: on ajoute un champ classpath et on reduit class a son nom. on charge pareil mais newinstance fait le load url
      BufferedReader br;
      int i;
      String templigne;
      Vector<String> listeClass = new Vector<String>();
      try {
          //lecture...
          br = new BufferedReader(new FileReader("src/plateforme/nodeExtension.txt"));
          templigne= br.readLine();
          while(templigne != null) {
              listeClass.add((templigne.split(";")[0]).split("=")[1]);
              templigne= br.readLine();
              
          }
      } catch (Exception e) {
        e.printStackTrace();
      }
      return listeClass;
  }
	
	*/
  
  private static Plateforme plateforme;
  private static URLClassLoader urlExtLoader;
  private static URLClassLoader urlAppliLoader;
  private ArrayList<String> liste_extensions;
  private ArrayList<String> liste_applis;
  
  private Plateforme(){
    liste_extensions = new ArrayList<String>();
    liste_applis = new ArrayList<String>();
    readApplicationsAvailable();
    readExtensionsAvailable();
    urlExtLoader = new URLClassLoader(loadExtURL());
    urlAppliLoader = new URLClassLoader(loadAppURL());
  }
  

  public void readApplicationsAvailable() {//recupere la liste des applications et la sauvegarde
    if(liste_applis.size() <1) {
      BufferedReader br;
      int i;
      String templigne = "";
      //on va lire le fichier
      try {
          //lecture...
          br = new BufferedReader(new FileReader("plateforme/node.txt"));
          templigne= br.readLine();
          while(templigne != null) {
              liste_applis.add(templigne);
              templigne= br.readLine();
          }
          br.close();
      } catch (Exception e) {
          e.printStackTrace();
      }
    } 
  }
  
  public URL[] loadAppURL() {//genere l'URLClassloader pour les applis
    URL[] listeURL = new URL[liste_applis.size()];
    String path = new File("").getAbsolutePath();
    String templigne = "";
    for(int i = 0; i < liste_applis.size(); i++) {
      templigne = liste_applis.get(i).split(";")[0].split("=")[1];
      URL url ;
      try {
        url = Paths.get(path,templigne).toUri().toURL();
        System.out.println(url);
        listeURL[i] = url;
      } catch (MalformedURLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      templigne= "";
    }
    return listeURL;
  }

  
  public Object loadAppli(){
    int i;
    System.out.println("Voici la liste des applications que vous pouvez charger :");
    for(i = 0; i < liste_extensions.size(); i++) {
        System.out.println(" - " + (liste_applis.get(i).split(";")[1]).split("=")[1]);
        if((liste_applis.get(i).split(";")[2]).split("=")[1].equals("now")){
            System.out.println("Cette application doit se charger automatiquement. Chargement...");
            System.out.println("--------------------------------");
            try {
//                return Class.forName((liste_extensions.get(i).split(";")[0]).split("=")[1]).newInstance();//ne trouve pas la classe! 
              Class<?> appli = urlAppliLoader.loadClass((liste_applis.get(i).split(";")[0]).split("=")[1]);
              Object app = appli.newInstance();
              return app;
            } catch (ClassNotFoundException | SecurityException | InstantiationException | IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }
    return null;
  }
  
  public void readExtensionsAvailable() {//recupere la liste des applications et la sauvegarde
    if(liste_extensions.size() <1) {
      BufferedReader br;
      int i;
      String templigne = "";
      //on va lire le fichier
      try {
          //lecture...
          br = new BufferedReader(new FileReader("plateforme/nodeExtension.txt"));
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
  }
  
  public URL[] loadExtURL() {//genere l'URLClassloader pour les applis
    URL[] listeURL = new URL[liste_extensions.size()];
    String path = new File("").getAbsolutePath();
    String templigne = "";
    for(int i = 0; i < liste_extensions.size(); i++) {
      templigne = liste_extensions.get(i).split(";")[0].split("=")[1];
      URL url ;
      try {
        url = Paths.get(path,templigne).toUri().toURL();
        System.out.println(url);
        listeURL[i] = url;
      } catch (MalformedURLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      templigne= "";
    }
    return listeURL;
  }
  
  public ArrayList<String> getExtensions() {
    if(liste_extensions.size() <1) {
      readExtensionsAvailable();
    }
    return liste_extensions;
  }
  
  public Object CreaInstance(String nomClasse) throws Exception{
	  Object target = urlAppliLoader.loadClass((nomClasse.split(";")[0]).split("=")[1]).newInstance();
	  if(nomClasse.contains("proxy=true")){
		  if(nomClasse.contains("type=IPanierHandler")){
			  Class[] interfaces = {IPanierHandler.class};
		      Object inst = Proxy.newProxyInstance(urlAppliLoader, interfaces, new PanierHandler(target));
		      return inst;
		  } else {
			  System.out.println("demande de proxy refusée");
		  }
	  }
      return target;
  }   
  
  public ArrayList<String> getListe_extensions() {
      return liste_extensions;
  }
  
  public void setListe_extensions(ArrayList<String> liste_extensions) {
      this.liste_extensions = liste_extensions;
  }
  
  public static void makeClassDoIt(Object obj) throws Exception {
    String temp = "doIt";
    Method m1 = obj.getClass().getMethod(temp, null);
    m1.invoke(obj, null);
}
  
  public static void main(String args[]) {
      try {
          Plateforme plat = null;
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

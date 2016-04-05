package plateforme;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.*;
import java.util.ArrayList;

import proxyHandler.PanierProxy;

public class Plateforme {
  
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
  
  /*
   * lis la liste des applications disponibles et la sauvegarde (à condition que le fichier n'ait pas déjà été lu et que le fichier contienne au moins 1 application)  
   * 
   */
  public void readApplicationsAvailable() {
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
  
  /*
   * génère l'URLClassloader pour les applications a partir d'appli.jar
   * 
   */
  public URL[] loadAppURL() {

    URL[] listeURL = new URL[1];
    String path = new File("").getAbsolutePath();
    String templigne = "appli.jar";
    URL url ;
    try {
      url = Paths.get(path,templigne).toUri().toURL();
      System.out.println(url);
      listeURL[0] = url;
    } catch (MalformedURLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return listeURL;
  }

  /*
   * affiche toutes les applications disponibles puis demande a l'utilisateur de choisir laquelle lancer. 
   * Ce choix peut etre outrepassé si une application est specifiée comme devant etre chargée immediatement.
   * 
   */
  public Object loadAppli(){
    int i;
    System.out.println("Voici la liste des applications que vous pouvez charger :");
    for(i = 0; i < liste_extensions.size(); i++) {
        System.out.println(" - " + (liste_applis.get(i).split(";")[1]).split("=")[1]);
        if((liste_applis.get(i).split(";")[2]).split("=")[1].equals("now")){
            System.out.println("Cette application doit se charger automatiquement. Chargement...");
            System.out.println("--------------------------------");
            try {
              Class<?> appli = urlAppliLoader.loadClass((liste_applis.get(i).split(";")[0]).split("=")[1]);
              Method m = appli.getDeclaredMethod("getAppli");
              
              Object app = m.invoke(null);
              return app;
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
        }
        
    }
    return null;
  }
  
  /*
   * lis la liste des extensions disponibles et la sauvegarde (à condition que le fichier n'ait pas déjà été lu et que le fichier contienne au moins 1 extension)  
   * 
   */
  public void readExtensionsAvailable() {
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
  
  /*
   * génère l'URLClassloader pour les extensions a partir d'extension.jar
   * 
   */
  public URL[] loadExtURL() {

    URL[] listeURL = new URL[1];
    String path = new File("").getAbsolutePath();
    String templigne = "extension.jar";
    URL url ;
    try {
      url = Paths.get(path,templigne).toUri().toURL();
      System.out.println(url);
      listeURL[0] = url;
    } catch (MalformedURLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    templigne= "";
          
    return listeURL;
  }
  
  public ArrayList<String> getListe_extensions() {
    if(liste_extensions.size() <1) {
      readExtensionsAvailable();
    }
    return liste_extensions;
  }
  
  /*
   * genere une instance a partir de nomClasse qui est la ligne dans le fichier listant les Extensions decrivant l'extension souhaitée (avec possibilité de proxy)
   * 
   */
  public Object creaInstance(String nomClasse) throws Exception{
	  Object target = null;
	  if(nomClasse.contains("proxy=")){
	    Class<?>[] interfaces = {urlExtLoader.loadClass((nomClasse.split(";")[2]).split("=")[1])};
	    target = Proxy.newProxyInstance(urlExtLoader, interfaces, new PanierProxy(nomClasse, urlExtLoader ));
	    return target;
	  } else {
	    target = urlExtLoader.loadClass((nomClasse.split(";")[0]).split("=")[1]).newInstance();
	  }
      return target;
  }   
  
  
  public void setListe_extensions(ArrayList<String> liste_extensions) {
      this.liste_extensions = liste_extensions;
  }
  
  /*
   * demande a l'application de commencer son execution
   * 
   */
  public static void makeClassDoIt(Object obj) throws Exception {
    String temp = "doIt";
    Method m1 = obj.getClass().getMethod(temp);
    m1.invoke(obj);
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

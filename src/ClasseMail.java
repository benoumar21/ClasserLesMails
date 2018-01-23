import java.io.BufferedReader;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

import javax.swing.JFileChooser;

public class ClasseMail {


	public  List<File> ChargerLeDossier () {

		try {
			List<File> filesInFolder = Files.walk(Paths.get("C:\\Users\\ODRAME\\Desktop\\Mes Cours\\PRM2 Didier Certain\\TP\\TP2\\fileTP"))
					.filter(Files::isRegularFile)
					.map(Path::toFile)
					.collect(Collectors.toList());
			return filesInFolder;
			//			for (File file : filesInFolder) {
			//			    if (file.isFile()) {
			//			        System.out.println(file.getName());
			//			    }
			//			}


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public  File ChargerLecsv () {
		List<File> filesInFolder1;
		try {
			filesInFolder1 = Files.walk(Paths.get("C:\\Users\\ODRAME\\Desktop\\Mes Cours\\PRM2 Didier Certain\\TP\\TP2\\vocabulaire.txt"))
					.filter(Files::isRegularFile)
					.map(Path::toFile)
					.collect(Collectors.toList());

			for (File file : filesInFolder1) {
				if (file.isFile()) {
					return file;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public static void RecursivePrint(File[] arr, int level) 
	{
		// for-each loop for main directory files
		for (File f : arr) 
		{
			// tabs for internal levels
			for (int i = 0; i < level; i++)
				System.out.print("\t");

			if(f.isFile()) 
				System.out.println(f.getName());

			else if(f.isDirectory()) 
			{ 
				System.out.println("[" + f.getName() + "]");

				// recursion for sub-directories
				RecursivePrint(f.listFiles(), level + 1);
			}
		}
	}


//	public List<File> SeparerLesFichiers () throws IOException {
//
//		List<File> listFile = new ArrayList<File>();
//		//List<String> listChaqueFile = new ArrayList<String>();
//
//		List<String> listvoc = new ArrayList<String>();
//		List<String> listChaquefile = new ArrayList<String>();
//
//
//		if(ChargerLecsv() != null  && ChargerLeDossier() != null) {
//			File Vocabulaire = ChargerLecsv();
//			List<File> filesInFolder = ChargerLeDossier();
//			List<File>  filesInFolderOut;
//			List<File> filesInFolderOut1 =  Files.walk(Paths.get("C:\\Users\\ODRAME\\Desktop\\Mes Cours\\PRM2 Didier Certain\\TP\\TP2\\FichiersImportant"))
//					.filter(Files::isRegularFile)
//					.map(Path::toFile)
//					.collect(Collectors.toList());
//
//
//			for (File file : filesInFolder) {
//				if (file.isFile()) {
//
//
//
//					Reader reader;Reader readervocabulaire;
//					try {
//						reader = new InputStreamReader(new FileInputStream(file), "ascii");
//						readervocabulaire = new InputStreamReader(new FileInputStream(file), "ascii");
//
//						StringBuilder builder = new StringBuilder();
//						char[] buffer = new char[512];
//						int nbRead = reader.read(buffer);
//
//						StringBuilder buildervoc = new StringBuilder();
//						char[] buffervoc = new char[512];
//						int nbReadvoc = readervocabulaire.read(buffer);
//
//						while(nbReadvoc > 0) {
//
//							builder.append(buffervoc, 0, nbReadvoc);
//							nbReadvoc = readervocabulaire.read(buffervoc);
//
//
//							/*
//							 *    
//							 */
//							 File dataFilevoc = Vocabulaire;
//							 try {
//								 InputStream ipsvoc = new FileInputStream(dataFilevoc);
//								 InputStreamReader ipsrvoc = new InputStreamReader(ipsvoc);
//								 BufferedReader brvoc = new BufferedReader(ipsrvoc);
//								 String lignevoc;
//								 int i = 0;
//								 while ((lignevoc = brvoc.readLine()) != null){
//									 // recuperation de la ligne courante
//									 //System.out.println("Contenu de la ligne:" + lignevoc);
//
//									 // separation de la ligne avec le toke " " (espace)
//									 String tokenvoc = " ";
//									 StringTokenizer stringTokenizervoc = new StringTokenizer(lignevoc, tokenvoc);
//									 // Parcours des tokens de la ligne
//									 while (stringTokenizervoc.hasMoreElements()) {
//										 String elementvoc = (String) stringTokenizervoc.nextElement();
//										 //System.out.println("Element : " + elementvoc);	
//
//										 while(nbRead > 0) {
//
//											 builder.append(buffer, 0, nbRead);
//											 nbRead = reader.read(buffer);
//
//											 /*
//											  *    
//											  */
//											 File dataFile = file;
//											 try {
//												 InputStream ips = new FileInputStream(dataFile);
//												 InputStreamReader ipsr = new InputStreamReader(ips);
//												 BufferedReader br = new BufferedReader(ipsr);
//												 String ligne;
//
//												 while ((ligne = br.readLine()) != null) {
//
//													 // recuperation de la ligne courante
//													 //System.out.println("Contenu de la ligne:" + ligne);
//													 // separation de la ligne avec le toke " " (espace)
//													 // 
//													 String token = " ";
//													 StringTokenizer stringTokenizer = new StringTokenizer(ligne, token);
//													 // Parcours des tokens de la ligne
//													 while (stringTokenizer.hasMoreElements()) {
//
//														 String element = (String) stringTokenizer.nextElement();
//														 //System.out.println("valeur  : " + element.compareTo(elementvoc));
//														 if(element.indexOf(elementvoc) > 0) {
//															 //System.out.println("valeur  : " + element.compareTo(elementvoc));
//															 //System.out.println("Element : " + element);
//															 listFile.add(file);
//															 System.out.println("I have add file " +file.getName()+" >"+ i++);
//															 //System.out.println("Sa taille est de :"+listFile.size());
//															 break;
//										    	         } 
//														 }
//
//													 }	
//												 
//												 br.close();
//											 } catch (Exception e) {
//												 System.out.println(e.toString());
//											 }
//
//
//
//											 /*
//											  * 
//											  */
//
//											 //								    	    System.out.println(builder.toString());
//											 //return builder.toString();
//										 }
//									 }	
//								 }
//								 brvoc.close();
//							 } catch (Exception e) {
//								 System.out.println(e.toString());
//							 }
//
//
//
//							 /*
//							  * 
//							  */
//						}
//
//					} catch (UnsupportedEncodingException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} catch (FileNotFoundException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//
//
//
//					//					        System.out.println(file.getName());
//				}
//			}
//		}
//
//		for (File file : listFile) {
//			System.out.println("-----------------"+file.getName());
//		}
//		return listFile;
//		
//	}

	public 	double NormeDuVecteur (Vector vecteur){
				double res = 0;
		for (Enumeration<Integer> v = vecteur.elements(); v.hasMoreElements();) {
			int i = v.nextElement();
			res += i*i; 
//			System.out.println(v.nextElement());
		}
		
		return Math.sqrt(res);
		
	}
	public 	int ProdScalaireDuVecteur (Vector vecteur, Vector vecteur2){
		int res = 0;
		Vector vv = new Vector();
		for (int i = 0; i < vecteur.size(); i++){
			int val = (int) vecteur.elementAt(i);
			res += val*val;
		}
		return res;
	
	}
	
	public 	Vector vectorVocabulaire (File file) throws IOException{
		File vocabulaire = ChargerLecsv();
		Vector v = new Vector();
		ArrayList<String> listFile = new ArrayList<String>();
		
		Scanner s1;
		try {
			s1 = new Scanner(file);
			while (s1.hasNext()){
				listFile.add(s1.next());
			}
			s1.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		InputStream ipsvoc = new FileInputStream(vocabulaire);
		InputStreamReader ipsrvoc = new InputStreamReader(ipsvoc);
		BufferedReader brvoc = new BufferedReader(ipsrvoc);
		String lignevoc;

		while ((lignevoc = brvoc.readLine()) != null){
			String tokenvoc = "\\Z";
			StringTokenizer stringTokenizervoc = new StringTokenizer(lignevoc, tokenvoc);
			// Parcours des tokens de la ligne
			
			while (stringTokenizervoc.hasMoreElements()) {
				String elementvoc = (String) stringTokenizervoc.nextElement();
				int nbOcurrence = Collections.frequency(listFile, elementvoc);
				//System.out.println(elementvoc+" "+nbOcurrence );
				v.add(nbOcurrence);
			}
		}
		return v;
	}
	
	
	public 	double cosinus (Vector vecteur, Vector vecteurvoc){
		
		int scalaire = ProdScalaireDuVecteur(vecteur, vecteurvoc);
		double norme = NormeDuVecteur(vecteur);
		double normeVoc = NormeDuVecteur(vecteurvoc);
		
		return scalaire/(norme*normeVoc);
	}
	
	
	
	
	public Map<String,Integer> CreerUnVector () throws IOException{
		int countMAilonSpam = 0;int countMAilonNonSpam = 0;

		List<Map<String,Integer>> allListword = new ArrayList<>();

		Map <String,List<Map<String,Integer>>> fileAndArrayWord = new HashMap<>();
		Map<String,Integer> tabledemap = new HashMap<String,Integer>();
		Vector monvectorVocabulaire = new Vector ();
		if(ChargerLecsv() != null  && ChargerLeDossier() != null) {
			File vocabulaire = ChargerLecsv();
			List<File> filesInFolder = ChargerLeDossier();
			List<String> list = new ArrayList<String>();
			
			/*
			 * 
			 */
				int nbfile = 0;
				
			for (File file : filesInFolder) {
				if (file.isFile()) {
					Vector monvector = new Vector ();
					nbfile++;
					Reader reader; Reader readervocabulaire;
					reader = new InputStreamReader(new FileInputStream(file), "ascii");
					readervocabulaire = new InputStreamReader(new FileInputStream(file), "ascii");

					StringBuilder builder = new StringBuilder();
					char[] buffer = new char[512];
					int nbRead = reader.read(buffer);


					InputStream ips = new FileInputStream(file);
					InputStreamReader ipsr = new InputStreamReader(ips);
					BufferedReader br = new BufferedReader(ipsr);

					Scanner s = new Scanner(file);
					ArrayList<String> listFile = new ArrayList<String>();
					while (s.hasNext()){
						listFile.add(s.next());
					}
					s.close();
					

					//System.out.println(file.getName());


					/*
					 * 
					 */
					// Vocabulaire 

					readervocabulaire = new InputStreamReader(new FileInputStream(file), "ascii");

					StringBuilder buildervoc = new StringBuilder();
					char[] buffervoc = new char[512];
					int nbReadvoc = readervocabulaire.read(buffer);

					while(nbReadvoc > 0) {

						buildervoc.append(buffervoc, 0, nbReadvoc);
						nbReadvoc = readervocabulaire.read(buffervoc);
					}


						/*
						 * 
						 */
							
						InputStream ipsvoc = new FileInputStream(vocabulaire);
						InputStreamReader ipsrvoc = new InputStreamReader(ipsvoc);
						BufferedReader brvoc = new BufferedReader(ipsrvoc);
						String lignevoc;
						int i = 0;
						while ((lignevoc = brvoc.readLine()) != null){
							String tokenvoc = "\\Z";
							StringTokenizer stringTokenizervoc = new StringTokenizer(lignevoc, tokenvoc);
							// Parcours des tokens de la ligne
							
							while (stringTokenizervoc.hasMoreElements()) {
								String elementvoc = (String) stringTokenizervoc.nextElement();
								//System.out.println("Element : " + elementvoc);	
								
								int nbOcurrence = Collections.frequency(listFile, elementvoc);
								monvector.add(nbOcurrence);
								//System.out.println(elementvoc+ ":" + monvector);
								// Fin Vocabulaire 

								/*
								 * 
								 */

							}
						}
						if(cosinus(monvector, vectorVocabulaire(vocabulaire)) > 0.75) {
							countMAilonSpam++;
							//System.out.println(">>> : " + countMAilonSpam +" --> "+ file.getName());
						}
						else {
							System.out.println("<<<< : " + countMAilonNonSpam++ +" --< "+ file.getName());
						}
						
						//System.out.println(cosinus(monvector, vectorVocabulaire(vocabulaire)));
						//System.out.println( ":" + monvector);
				}
				//System.out.println(file.getName()+ ">>> : " + nbfile);
			}
//			System.out.println(">>> : " + countMAilonSpam);
			//System.out.println(vectorVocabulaire(vocabulaire));
		}
		
//						System.out.println(fileAndArrayWord);

					
				return new HashMap<>();

			
			}
}

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * Temps pour programmer cette partie: 1H.h
 */

public class Main {

	private final int nbPoints = 6;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[][] lectureFichier(String fichier){
		int[][] output = null;
		try {
			//Initialisation de la lecture du fichier
			FileReader fr = new FileReader(fichier);
			BufferedReader br = new BufferedReader(fr);
			//Initialisation du tableau qu'on va recuperer
			//On sait que la premiere ligne contient forcement le nombre de lignes
			int numLignes = Integer.parseInt(br.readLine());
			output = new int[numLignes][2];
			//On boucle pour remplir notre tableau a partir des donnees du .txt
			for (int i = 1; i<numLignes; i++) {
				String[] ligne = br.readLine().split(" ");
				for (int j = 0; j<ligne.length; j++) {
					output[i][j] = Integer.parseInt(ligne[j]);
				}
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return output;
	}
	
	public int[][] matriceAdjacence(String fichier){
		//Extraction des donnees
		int[][] data = lectureFichier(fichier);
		//Initialisation de la matrice resultat
		int[][] mat = new int[nbPoints][nbPoints];
		for (int i = 0; i<nbPoints; i++) {
			for (int j = 0; j<nbPoints; j++) {
				mat[i][j] = 0;
			}
		}
		//Traitement des donnees pour remplir la matrice resultat. On suppose que tous
		// les points ont un poids de 1
		for (int i = 0; i<data.length; i++) {
			int a = data[i][0];
			int b = data[i][1];
			mat[a-1][b-1]=1; //On ajoute un correectif de -1 au cas où le point 1 soit numerote 0
			mat[b-1][a-1]=1;
		}
		return mat;		 
	}
	

}

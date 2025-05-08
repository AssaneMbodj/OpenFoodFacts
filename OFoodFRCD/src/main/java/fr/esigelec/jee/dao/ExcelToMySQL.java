package fr.esigelec.jee.dao;


/**
 * Fichier permettant d'importer un fichier CSV dans une table MySQL
 * Ce Script utilise le mode transactionnel afin de respecter l'approche ACID (Atomicit�, Coh�rence, Isolation, Durabilit�) 
 * qui permet d'assurer l'int�grit� des donn�es au sein d'une base de donn�es. 
 * @author Serais S�bastien
 */
import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class ExcelToMySQL{
	// nom de la machine h�te qui h�berge le SGBD Mysql
	final static String host = "localhost";
	// nom de la BDD sur le serveur Mysql
	final static String nomBase = "bddmn";
	// login de la BDD
	final static String login = "root";
	// mot de passe
	final static String motDePasse = "root";
	// chemin fichier csv � importer	final static String nomFichier = "\"C:\\Users\\NEYA CLOVIS MARIEL\\Desktop\\Dossier du Projet JavaEE\\DIS_PLV_2024.txt\"";
	final static String nomFichier = "C:\\Users\\assan\\OneDrive\\Bureau\\ISN\\GestionProjetsLogiciels\\produso.csv";

	// caract�re de s�paration des colonne
	final static String separateur = ",";
	final static String nomTable = "Produits";

	public static void main(String[] args) {
		Connection con = null;			//objet connexion
		PreparedStatement stmt = null;	//prepareStatement
		int compteurLignesAjoutees = 0;	//compteur de lignes effectivement ajout�es
		String ligne = null;			//ligne lue dans le fichier
		String tab[];					//tableau issu du split
		int retour;						//nb de lign�es ins�r�es
		Scanner sc = new Scanner(System.in);
		String reponse;
		
		// chargement du pilote MySQL
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e2) {

			System.err.println("pilote mysql non trouv� : com.mysql.cj.jdbc.Driver");
			System.exit(-1);
		}

		try {
			// Connexion avec choix de l'encodage
			con = DriverManager.getConnection("jdbc:mysql://" + host + "/" + nomBase + "?characterEncoding=UTF-8",
					login, motDePasse);

			// activation du mode transactionnel
			con.setAutoCommit(false);
			// Creation du flux de lecture en mode caract�res
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(nomFichier)));
			// nombre de lignes ins�r�es dans le BDD
			
			do {

				try {
					ligne = br.readLine();
					if (ligne != null) {
						System.out.println(ligne);

						tab = ligne.split(separateur);
						System.out.println("nb colonnes=" + tab.length);

						for (int i = 0; i < tab.length; i++) {

							System.out.print(tab[i] + "**");
						}
						System.out.println("");

						// TODO configurer la requete SQL en fonction des colonnes
						String requete = "insert into " + nomTable + " (nom,ingredients,codeBarres,urlPhoto) values (?,?,?,?,?)";
						stmt = con.prepareStatement(requete);
						System.out.println(requete);

						// TODO injection des donn�es dans la requete au format souhait�
						stmt.setString(1, tab[1]);
						stmt.setString(2, tab[2]);
						stmt.setString(3, tab[3]);
						stmt.setString(4, tab[7]);
						stmt.setString(5, tab[10]);



						// ex�cution de la requete
						retour = stmt.executeUpdate();
						// incr�mentation du nb de lign�es ins�r�es
						compteurLignesAjoutees = compteurLignesAjoutees + retour;

						if (retour != 1) {
							System.out.println("**********************************ERREUR ..." + requete);
							throw new Exception();
						}

					}
				} catch (SQLIntegrityConstraintViolationException doublon) {

					System.out.println("doublon ignor� ...");
					doublon.printStackTrace();
				}

			} while (ligne != null);

			// On demande si l'utilisateur souhaite valider la transaction compl�te
			System.out.println("VALIDER les requetes ? (O/N)");

			reponse = sc.nextLine();
			if ("O".equalsIgnoreCase(reponse)) {
				System.out.println("COMMIT");
				con.commit();
				System.out.println("lignes ajout�es : " + compteurLignesAjoutees);
			} else {
				System.out.println("ROLLBACK");
				con.rollback();
			}

		} catch (Exception e) {
			e.printStackTrace();
			try {
				System.out.println("ROLLBACK");
				con.rollback();

			} catch (SQLException e1) {

				e1.printStackTrace();
			}

			e.printStackTrace();
		} finally {

			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
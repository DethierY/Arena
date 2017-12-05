package classes.arene;

import java.util.Scanner;

import classes.personnages.Combattant;
import classes.personnages.Joueur;
import classes.personnages.Monstre;

public class Arene {
	private Joueur joueur;
	private Combattant monstre;
	
	int compteur = 1;
		
	public Arene () {
		this.joueur = null;
		this.monstre = null;
	}
	
	// initialisation artificielle provisoire
	public void initialiserJoueur () {
		this.joueur = new Joueur ("Drakthar", 5, 16, 16, 16);
		this.joueur.configurerCombattant();
	}

	
	// lancer les combats
	public void lancerLesJeux () {
		Scanner sc = new Scanner (System.in);
		while (joueur.getPointsVie() > 0) {
			String reponse = "";
			while (!reponse.equals("o") && !reponse.equals("n")) {			
				System.out.println("Voulez-vous organiser un combat (o/n)?");
				reponse = sc.nextLine();
				}
			if (reponse.equals("o")) {
				joueur.setPointsVie(joueur.getPointsVieMax());
				this.creerMonstre();
				this.lancerCombat();
			}
			else {
				break;
			}
		}
		sc.close();
	}
	
	// creer monstre
	private void creerMonstre () {
		String nom = "Monstre " + compteur;
		int niv = (int) (Math.random() * 10 +1);
		int forc = (int) (Math.random() * 20 +1);
		int dext = (int) (Math.random() * 20 +1);
		int cons = (int) (Math.random() * 20 +1);		
		this.monstre = new Monstre (nom, niv, forc, dext, cons);
		compteur++;
	}
	
	// lancer le combat
	private void lancerCombat () {
		joueur.presenterLeCombattant();
		monstre.presenterLeCombattant();
		int round = 1;
		while (this.joueur.getPointsVie() > 0 && monstre.getPointsVie() > 0) {
			System.out.println("Round " + round);
			faireUnRound(this.joueur, monstre);
			this.joueur.afficherPointsDeVie();
			monstre.afficherPointsDeVie();
			round = round + 1;
		}
		this.joueur.annoncerResultat();
		monstre.annoncerResultat();
	}
	
	private void faireUnRound (Combattant adversaire1, Combattant adversaire2) {
		int initAdv1 = adversaire1.determinerInit();
		int initAdv2 = adversaire2.determinerInit();
		if (initAdv1 == initAdv2) {
			adversaire1.attaquer(adversaire2);
			adversaire2.attaquer(adversaire1);
		}
		else if (initAdv1 > initAdv2) {
			adversaire1.attaquer(adversaire2);
			if (adversaire2.getPointsVie() > 0) {
				adversaire2.attaquer(adversaire1);
				}
		}
		else {
			adversaire2.attaquer(adversaire1);
			if (adversaire1.getPointsVie() > 0) {
				adversaire1.attaquer(adversaire2);
			}
		}
	}
	
	
}

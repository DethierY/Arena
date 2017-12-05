package classes.personnages;

public class Joueur extends Combattant {
	
	// attributs
	private int experience = 0;
	private int pointsVieMax;

	// constructeur
	public Joueur(String nom, int niveau, int force, int dexterite, int constitution) {
		super(nom, niveau, force, dexterite, constitution);
		this.pointsVieMax = this.getPointsVie();
	}

	// getters & setters
	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	public int getPointsVieMax () {
		return this.pointsVieMax;
	}

}

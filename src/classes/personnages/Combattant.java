package classes.personnages;

public abstract class Combattant {
	
	// attributs
	
	String nom;
	protected int niveau;
	protected int force;
	protected int constitution;
	protected int dexterite;
	private int attaque;
	private int defense;
	private int initiative;
	private int degats;
	private int pointsVie;
	
	// bonus carac
	static int [] bonusAttaque = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	static int [] bonusCarac = {-5, -4, -4, -3, -3, -2, -2, -1, -1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5};
	
	// constructeur
	public Combattant (String nom, int niveau, int force, int dexterite, int constitution) {
		this.nom = nom;
		this.niveau = niveau;
		this.force = force;
		this.dexterite = dexterite;
		this.constitution = constitution;
		this.attaque = this.calculerAttaque();
		this.defense = this.calculerDefense();
		this.initiative = this.calculerinit();
		this.pointsVie = this.calculerPointstVie();
		this.degats = this.calculerDegats();
	}
	
	
	// calculer points de vie
	private int calculerPointstVie() {
		int total = 0;
		for (int i = 0; i < this.niveau; i++) {
		total = total + (int) (Math.random() * 10) +1 + bonusCarac[this.constitution-1];
		}
		return total;
	}
	// calculer bonus attaque
	private int calculerAttaque () {
		return bonusAttaque[this.niveau-1] + bonusCarac[this.force-1];
	}
	
	// calculer defense
	private int calculerDefense () {
		return 10 + bonusCarac[this.dexterite-1];
	}
	
	// calculer bonus initiative
	private int calculerinit () {
		return bonusCarac[this.dexterite-1];
	}
	
	// calculer degats
	private int calculerDegats () {
		return 5 + bonusCarac[this.force-1];
	}
	
	// calculer points de vie
	private void calculerPointsDeVie () {
		this.pointsVie = this.pointsVie + bonusCarac[this.constitution-1];
	}
	
	// configuration du combattant
	public void configurerCombattant () {
		this.calculerAttaque();
		this.calculerDegats();
		this.calculerinit();
		this.calculerPointsDeVie();
		this.calculerDefense();
	}
	
	// presentation du combattant
	public void presenterLeCombattant() {
		System.out.println(this.nom + ", Niveau " + this.niveau + ", Force: " + this.force + ", Dexterite: " + this.dexterite + ", Constitution: " + this.constitution);
	}

	
	// tirer l'initiative pendant combat
	public int determinerInit () {
		return (int) (Math.random() * 20) + 1 + this.initiative;
	}

	// attaquer	
	public void attaquer (Combattant adversaire) {
		int de = (int) (Math.random () * 20) + 1;
		if (this.attaque + de >= adversaire.getDefense()) {
			adversaire.setPointsVie(adversaire.getPointsVie () - this.degats);
			System.out.println(this.nom + " a infligé " + this.degats + " points de dégats.");
		}
		else {
			System.out.println(this.nom + " a raté son attaque!");
		}
	}
	
	// afficher les degats
	public void afficherDegats () {
		System.out.println(this.nom + " a infligé " + this.degats + " points de dégats.");
	}
	
	// afficher les points de vie
	public void afficherPointsDeVie () {
		int pdv = this.pointsVie;
		if (this.pointsVie <= 0) {
			pdv = 0;
		}
		System.out.println("Il reste " + pdv + " au combattant " + this.nom);
	}
	// annoncer le resultat
	public void annoncerResultat() {
		if (this.pointsVie > 0) {
			System.out.println(this.nom + " a remporté le combat!");
		}
		else {
			System.out.println(this.nom + " est mort...");
		}
	}
	
	// getters & setters
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getDexterite() {
		return dexterite;
	}

	public void setDexterite(int dexterite) {
		this.dexterite = dexterite;
	}
	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public int getConstitution() {
		return constitution;
	}

	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}
	
	public int getPointsVie() {
		return this.pointsVie;
	}
	
	public void setPointsVie(int pointsVie) {
		this.pointsVie = pointsVie;
	}
	
	private int getDefense() {
		return this.defense;
	}
	

}

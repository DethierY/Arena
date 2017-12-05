package classes.personnages;

public abstract class Arme {
	
	// attributs
	int nbreMains;
	int seuilCritique;
	int multiplicateurCritique;
	int typeDesDegat;
	int nbreDesDegat;
	String typeDegats;
	
	// constructeur
	public Arme (int nbreMains, int seuilCritique, int multiplicateurCritique, int typeDesDegat, int nbreDesDegat, String typeDegats) {
		this.nbreMains = nbreMains;
		this.seuilCritique = seuilCritique;
		this.multiplicateurCritique = multiplicateurCritique;
		this.typeDesDegat = typeDesDegat;
		this.nbreDesDegat = nbreDesDegat;
		this.typeDegats = typeDegats;
	}

	public int calculerDegat () {
		int degats = 0;
		for (int i = 0; i <= this.nbreDesDegat; i++) {
			degats = degats +(int) (Math.random() * this.typeDesDegat + 1);
		}
		return degats;
	}
}

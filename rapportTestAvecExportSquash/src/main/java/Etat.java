
public enum Etat {

	N_A("N/A","UNTESTABLE"), //

	No_run("No run", "READY"), //

	En_cours("En cours", "RUNNING"), //

	Passed("Passed","SUCCESS"), //

	Failed("Failed","FAILURE"); //

	//Etat sur le Excel
	private final String etatExcel;
	//Etat sur l'export Squash
	private final String etatSquash;

	Etat (final String etatExcel, final String etatSquash) {
		this.etatExcel = etatExcel;
		this.etatSquash = etatSquash;
	}

	public static Etat valueOfByCode(final String etatSquash) {

		if (etatSquash == null || etatSquash.isEmpty()) {
			throw new IllegalArgumentException("L'état sur Squash ne peut pas etre vide.");
		}

		for (Etat etat : values()) {
			if (etat.etatSquash.equalsIgnoreCase(etatSquash)) {
				return etat;
			}
		}

		throw new IllegalArgumentException("L'état du cas de test n'a pas d'équivalent pour Excel");
	}




	//Getters
	public String getEtatExcel() {
		return etatExcel;
	}


	public String getEtatSquash() {
		return etatSquash;
	}

}

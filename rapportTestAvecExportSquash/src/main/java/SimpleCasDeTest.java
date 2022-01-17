public class SimpleCasDeTest implements CasDeTest {

	////Intitulés DLM (laisser vide)
	private String intituleDlm;

	//N° du script
	private int nScript;

	//Nom du script
	private String nomScript;

	//Etat des test, utilise enum Etat
	private Etat etat;

	//N° ticket si anomalie mineure
	private String mineure;

	//N° ticket si anomalie moyenne
	private String moyenne;

	//N° ticket si anomalie majeure
	private String majeure;

	//N° ticket si anomalie bloquante
	private String bloquante;

	//Si anomalie bloquante en cours, avancement de la correction (laisser vide)
	private String avancementBloquant;

	//Personne responsable du test
	private String ressource;

	//Commentaire spécifique sur l'exécution (laisser vide)
	private String commentaire;

	//1 si test exécuter, 0 sinon
	private int ava;

	//1 si test en Succes, 0 sinon
	private int ok;

	//1 si test en Echec, 0 sinon
	private int ko;

	//Nombre d'exécution du test
	private int nb;

	//1 si test Non Applicable, 0 sinon
	private int na;

	//1 si test en cours, 0 sinon (0 par défaut)
	private int enCours;

	//1 si test Non exécuté, 0 sinon (0 par défaut) 
	private int noRun;

	//??? Aucune idée de pourquoi 2 fois En cours (0 par défaut)
	private int enCours2;

	public SimpleCasDeTest() {

	}

	public SimpleCasDeTest (final int nScript) {

		this.nScript = nScript;
	}

	public SimpleCasDeTest (final int nScript, final Etat etat) {

		this(nScript);
		this.etat = etat;

	}


	//Setters et getters
	public int getNScript() {
		return nScript;
	}
	public void setNScript(int nScript) {
		this.nScript = nScript;
	}


	public String getNomScript() {
		return nomScript;
	}
	public void setNomScript(String nomScript) {
		this.nomScript = nomScript;
	}


	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
	}


	public String getRessource() {
		return ressource;
	}
	public void setRessource(String ressource) {
		this.ressource = ressource;
	}


	public int getAva() {
		return ava;
	}
	public void setAva(int ava) {
		this.ava = ava;
	}


	public int getOk() {
		return ok;
	}
	public void setOk(int ok) {
		this.ok = ok;
	}


	public int getKo() {
		return ko;
	}
	public void setKo(int ko) {
		this.ko = ko;
	}


	public int getNb() {
		return nb;
	}
	public void setNb(int nb) {
		this.nb= nb;
	}


	public int getNa() {
		return na;
	}
	public void setNa(int na) {
		this.na = na;
	}


	public int getEnCours() {
		return enCours;
	}
	public void setEnCours(int enCours) {
		this.enCours = enCours;
	}


	public int getNoRun() {
		return noRun;
	}
	public void setNoRun(int noRun) {
		this.noRun = noRun;
	}


	public int getEnCours2() {
		return enCours2;
	}
	public void setEnCours2(int enCours2) {
		this.enCours2 = enCours2;
	}


	public String getMineure() {
		return mineure;
	}
	public void setMineure(String mineure) {
		this.mineure = mineure;
	}


	public String getMoyenne() {
		return moyenne;
	}
	public void setMoyenne(String moyenne) {
		this.moyenne = moyenne;
	}


	public String getMajeure() {
		return majeure;
	}
	public void setMajeure(String majeure) {
		this.majeure = majeure;
	}


	public String getBloquante() {
		return bloquante;
	}
	public void setBloquante(String bloquante) {
		this.bloquante = bloquante;
	}


	public String getAvancementBloquant() {
		return avancementBloquant;
	}
	public void setAvancementBloquant(String avancementBloquant) {
		this.avancementBloquant = avancementBloquant;
	}


	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}


	public String getIntituleDlm() {
		return intituleDlm;
	}

	public void setIntituleDlm(String intituleDlm) {
		this.intituleDlm = intituleDlm;
	}

}
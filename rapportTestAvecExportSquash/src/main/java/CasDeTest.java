import java.io.Serializable;

public interface CasDeTest extends Serializable {
	
	//Intitul�s DLM
	String getIntituleDlm();
	
	//N� du script
	int getNScript();
	
	//Nom du script
	String getNomScript();
	
	//Etat des test, utilise enum Etat
	Etat getEtat();
	
	//N� ticket si anomalie mineure (laisser vide)
	String getMineure();
	
	//N� ticket si anomalie moyenne (laisser vide)
	String getMoyenne();
	
	//N� ticket si anomalie majeure (laisser vide)
	String getMajeure();
	
	//N� ticket si anomalie bloquante (laisser vide)
	String getBloquante();
	
	//Si anomalie bloquante en cours, avancement de la correction (laisser vide)
	String getAvancementBloquant();
	
	//Personne responsable du test
	String getRessource();
	
	//Commentaire sp�cifique sur l'ex�cution (laisser vide)
	String getCommentaire();
	
	//1 si test ex�cuter, 0 sinon
	int getAva();
	
	//1 si test en Succes, 0 sinon
	int getOk();
	
	//1 si test en Echec, 0 sinon
	int getKo();
	
	//Nombre d'ex�cution du test
	int getNb();
	
	//1 si test Non Applicable, 0 sinon
	int getNa();
	
	//1 si test en cours, 0 sinon (0 par d�faut)
	int getEnCours();
	
	//1 si test Non ex�cut�, 0 sinon (0 par d�faut) 
	int getNoRun();
	
	//??? Aucune id�e de pourquoi 2 fois En cours (0 par d�faut)
	int getEnCours2();
	
}
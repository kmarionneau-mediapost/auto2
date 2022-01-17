import java.io.File;


public class Boite_a_Outils{
	
	public static boolean verifierFichierExistant(String chemin, String nom) {
		boolean verif = false;
		File[] listFiles = new File(chemin).listFiles();

		for (int i = 0; i < listFiles.length; i++) {

			if (listFiles[i].isFile()) {
				String fileName = listFiles[i].getName();
				if (fileName.startsWith(nom)) {
					verif = true;
				}
			}
		}
		return verif;
	}
}
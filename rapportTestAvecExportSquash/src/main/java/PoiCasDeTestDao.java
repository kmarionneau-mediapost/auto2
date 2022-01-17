import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class PoiCasDeTestDao implements CasDeTestDao{
	
	private String exportSquash;

	//@Override
	public List<CasDeTest> findAllCasDeTest() {
		
		//R�cup�rer l'export Squash
		final File file = new File (exportSquash);
		
		//Cr�ation de la liste CasDeTest
		final List<CasDeTest> lCasDeTest = new ArrayList<CasDeTest>();
		
	    try {
	    	
	    	//Ouvrir l'export
	        final Workbook workbook = WorkbookFactory.create(file);
	        //R�cup�rer le 1er onglet
	        final Sheet sheet = workbook.getSheet("Worksheet");
	        
			//Commencer � la 2�re ligne (la 1�re est pour les titres)
			int i = 1;
			
			//R�cup�re la ligne i dans l'onglet sheet
			Row row = sheet.getRow(i++);
			
			//Tant que la ligne n'est pas nulle
			while (row != null) {
				
				//Enregistrer la ligne dans la variable casDeTest
				final CasDeTest casDeTest = rowToCasDeTest(row);
				
				//Ajouter le casDeTest dans la liste lCasDeTest
				lCasDeTest.add(casDeTest);
				
				//Permet de passer � la ligne suivant
				row = sheet.getRow(i++);
				
			}

	    } catch (IOException e) {
	        e.printStackTrace();
    }
	    return lCasDeTest;
	}
    
    public PoiCasDeTestDao (final String exportSquash) {
    	super();
    	this.exportSquash = exportSquash;
    }
    
    public static CasDeTest rowToCasDeTest(final Row row) {
    	
    	final SimpleCasDeTest casDeTest = new SimpleCasDeTest();
    	
    	//Mettre intitul� DLM
    	casDeTest.setIntituleDlm("");
    	
    	//Mettre n� Script
    	final int nScript = row.getRowNum();
    	casDeTest.setNScript(nScript);
    	
    	//Mettre le nom du script
    	final String nomScript = row;
    			
    			return casDeTest;
    }
	
}

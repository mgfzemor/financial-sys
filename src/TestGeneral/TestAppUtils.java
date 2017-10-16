package TestGeneral;

import static org.junit.Assert.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import finantials.*;
import general.AppUtils;
import general.AppUtils.CSV;

public class TestAppUtils {
	
	final String csv_path = "resources/Modelo_Controle_Orcamentario_Completo.csv";
	final String realized_csv_path = "resources/RealizadoMensal_Janeiro.csv";
	
	@Test
	public void testReadBasePlan() throws Exception {
		BasePlan basePlan = AppUtils.readBasePlan(csv_path);
		boolean rubricHasName = false;
		for (RubricBase rubricBase : basePlan.getRubricsBase()) {
			rubricHasName = rubricBase.getName().length() > 0;
		}
		
		assertTrue("Esperado plano base ter pelo menos uma rubrica",  rubricHasName);
	}
	
	@Test
	public void testRealizedLastYear() throws Exception {
		final float Jan1stRubricValue = 593650;
		final int January = 0;
		
		RealizedYear realizedYear = AppUtils.readRealizedLastYear(csv_path);
		Iterator<Realized> realized = realizedYear.getAllRealizeds().iterator();
		
		boolean hasJan1stRubricValueCorrect = false;
		
		while (realized.hasNext()) {
			Realized currentRealized = realized.next();
			Iterator<Rubric> rubric = currentRealized.getAllRubrics().iterator();
			
			while (rubric.hasNext()) {
				Rubric currentRubric = rubric.next();
				if (currentRubric.CalcResult() == Jan1stRubricValue && currentRealized.getMonth() == January) {
					hasJan1stRubricValueCorrect = true;
				}
			}
		}
		
		assertTrue("Esperado valor da rubrica extraída é de R$ 593650", hasJan1stRubricValueCorrect);
	}
	
	@Test
	public void testRealizedMonth() throws Exception {
		Realized realizedJan = AppUtils.readRealizedMonth(realized_csv_path);
		assertTrue("Esperado que o nome da rubrica com código 100 seja 'RESULTADO -'", realizedJan.getRubric(100).getName().equals("RESULTADO -"));
		assertTrue("Esperado que seja realizado do mês de janeiro", realizedJan.getMonth() == 0);
	}
	
	@Test
	public void testParseComaSeparatedCSVFile() throws Exception {
		final String parsingCSVMethodName = "parsingCSV";
		Method parsingCSV = AppUtils.class.getDeclaredMethod(parsingCSVMethodName, new Class[] {String.class, Character.class});
		parsingCSV.setAccessible(true);
		CSV csv = (CSV)parsingCSV.invoke(AppUtils.class, realized_csv_path, ',');
		String expected = "536.602,37";
		String contentL2C3 = csv.getString(2, 3);
		//TODO: resolve round problems
		assertTrue("Esperado extrair corretamente o conteúdo do CSV", contentL2C3.equals(expected));		
	}
	
	@Test
	public void testParseCSVFile() throws Exception {
		final String parsingCSVMethodName = "parsingCSV";
		Method parsingCSV = AppUtils.class.getDeclaredMethod(parsingCSVMethodName, String.class);
		parsingCSV.setAccessible(true);
		List<List<String>> csv = (List<List<String>>)parsingCSV.invoke(AppUtils.class, csv_path);
		String expected = "ISSQN s/ Servicos";
		String contentL1C0 = csv.get(8).get(2);
		assertTrue("Esperado extrair corretamente o conteúdo do CSV", contentL1C0.equals(expected));
	}
}

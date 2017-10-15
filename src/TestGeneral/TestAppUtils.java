package TestGeneral;

import static org.junit.Assert.*;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import finantials.*;
import general.AppUtils;

public class TestAppUtils {
	
	final String csv_path = "resources/Modelo_Controle_Orcamentario_Completo.csv";
	final String basePlanPath = "resources/BasePlan.csv";
	
	@Test
	public void testReadBasePlan() throws Exception {
		BasePlan basePlan = AppUtils.readBasePlan(basePlanPath);
		RubricBase rubricBase = basePlan.getRubricsBase().get(0);
		assertTrue("Esperado plano base ter pelo menos uma rubrica", rubricBase.getName().length() > 0);
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

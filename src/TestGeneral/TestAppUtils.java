package TestGeneral;

import static org.junit.Assert.*;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.junit.Test;
import finantials.BasePlan;
import finantials.RubricBase;
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
	public void testParseCSVFile() throws Exception {
		final String parsingCSVMethodName = "parsingCSV";
		Method parsingCSV = AppUtils.class.getDeclaredMethod(parsingCSVMethodName, String.class);
		parsingCSV.setAccessible(true);
		List<List<String>> csv = (List<List<String>>)parsingCSV.invoke(AppUtils.class, csv_path);
		String expected = "classificação";
		String contentL1C0 = csv.get(1).get(0);
		System.out.println(contentL1C0);
		assertTrue("Esperado extrair corretamente o conteúdo do CSV", contentL1C0.equals(expected));
	}
}

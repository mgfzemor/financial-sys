package TestGeneral;

import static org.junit.Assert.*;
import java.lang.reflect.Method;
import java.util.List;
import org.junit.Test;
import finantials.BasePlan;
import finantials.RubricBase;
import general.AppUtils;

public class TestAppUtils {
	
	final String ModeloControleOrcamentarioCompleto_csv_path = "resources/Modelo_Controle_Orcamentario_Completo.csv";
	final String basePlanPath = "resources/BasePlan.csv";
	
	@Test
	public void testReadBasePlan() throws Exception {
		BasePlan basePlan = AppUtils.readBasePlan(basePlanPath);
		RubricBase rubricBase = basePlan.getRubricsBase().get(0);
		assertTrue("Esperado plano base ter pelo menos uma rubrica", rubricBase.getName().length() > 0);
	}
	
	@Test
	public void testParseCSVFile() throws Exception {
		final String MethodName = "parsingCSV";
		Method method = AppUtils.class.getDeclaredMethod(MethodName, String.class);
		method.setAccessible(true);
		Object csvObject = method.invoke(AppUtils.class, ModeloControleOrcamentarioCompleto_csv_path);
		List<List<String>> csv = (List<List<String>>)csvObject;
		String expected = "classificação";
		String contentL1C0 = csv.get(1).get(0);
		assertSame("Esperado extrair corretamente o conteúdo do CSV", expected, contentL1C0);
	}
}

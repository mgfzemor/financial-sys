package general;

import finantials.*;
import java.io.*;
import java.nio.charset.Charset;
import java.text.*;
import java.util.*;

public final class AppUtils {

	private static final int FIRST_CSV_LINE_CONTENT = 2;
	private static final int FIRST_CSV_COLUMN_CONTENT = 3;
	
	
	public static String formatDate(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(date);
	}
	
	public static BasePlan readBasePlan(String pathFile) {
		return null;
	}

	public static RealizedYear readRealizedLastYear(String pathFile) {
		RealizedYear realizedYear = null;
		try {
			CSV csv = parsingCSV(pathFile);
			BasePlan basePlan = extractBasePlanFromRealizedYearCSV(csv);
			realizedYear = extractRealizedYear(csv, basePlan);			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return realizedYear;
	}

	public static Realized readRealizedMonthly(String pathFile) {
		return null;
	}

	private static RealizedYear extractRealizedYear(CSV csv, BasePlan basePlan) {
		
		RealizedYear realizedYear = new RealizedYear();
		for (int j = FIRST_CSV_COLUMN_CONTENT, month = 0;j < csv.columnsSize();j++, month++) {			
			Realized realized = extractRealizedMonth(csv, month, basePlan);
			realizedYear.setRealized(realized);
		}
		
		return realizedYear;
	}
	
	private static Realized extractRealizedMonth(CSV csv, int month, BasePlan basePlan) {
		
		Realized realized = new Realized();
		List<Rubric> rubrics = basePlan.getRubrics();
		
		int monthColumn = month + FIRST_CSV_COLUMN_CONTENT;
		
		// Get rubric by rubric and set it to realized
		for (int i = FIRST_CSV_LINE_CONTENT, rubricIdx = 0;i < csv.rowsSize();i++, rubricIdx++) {
			
			RubricBase rubricBase = rubrics.get(rubricIdx);
			Rubric rubric = new Rubric();
			int value = csv.getInt(i, monthColumn);
			rubric.setClassification(rubricBase.getClassification());
			rubric.setCode(rubricBase.getCode());
			rubric.setName(rubricBase.getName());
			rubric.setValue(value);
			
			realized.setRubric(rubric);
		}
		
		realized.setMonth(month);
		
		return realized;
	}
	
	private static BasePlan extractBasePlanFromRealizedYearCSV(CSV csv) {
		BasePlan basePlan = new BasePlan();
		List<Rubric> rubrics = readAllRubrics(csv);
		basePlan.setRubricsBase(rubrics);		
		return basePlan;
	}
	
	private static List<Rubric> readAllRubrics(CSV csv) {
		List<Rubric> rubrics = new ArrayList<>();
		
		for (int i = FIRST_CSV_LINE_CONTENT;i < csv.size();i++) {
			int classification = csv.getInt(i, 0);
			int code = csv.getInt(i, 1);
			String name = csv.getString(i, 2);
			Rubric rubric = createRubric(classification, code, name);
			rubrics.add(rubric);
		}
		
		return rubrics;
	}
	
	private static Rubric createRubric(int classification, int code, String name) {
		Rubric rubric = new Rubric();
		rubric.setClassification(classification);
		rubric.setCode(code);
		rubric.setName(name);
		return rubric;
	}
	
	/**
	 * Given a path of csv file with fields separated with semicolon, parses it's content and return as list of list of strings
	 * @param pathFile
	 * @return List<List<String>> */
	private static CSV parsingCSV(String pathFile) throws IOException {
		return parsingCSV(pathFile, ';');
	}
	
	private static CSV parsingCSV(String pathFile, final char SEPARATOR) throws IOException {
		File csvFile = new File(pathFile);
		CSV content = new CSV();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
			String line = "";
			while ((line = reader.readLine()) != null) {				
				List<String> fields = new ArrayList<>();
				
				String field = "";
				final char QUOTE = '"';

				boolean isContent = false;
				
				for (int i = 0;i < line.length();i++) {
					
					final char c = line.charAt(i);
					if (i == 0 && c != SEPARATOR) isContent = true;
					else if (c == QUOTE && i != 0) isContent = !isContent;
					else if (c == SEPARATOR || i == line.length() - 1) {
						fields.add(field);
						field = "";
					}
					
					if (isContent && c != SEPARATOR) field += c;
				}
				
				content.add(fields);
			}	
		}
		
		return content;		
	}
	
	private static class CSV extends ArrayList<List<String>> {

		public int getInt(int i, int j) {
			String content = getString(i, j);
			int value = 0;
			
			for (int idx = 0;idx < content.length();idx++) {
				final char c = content.charAt(idx);
				if (Character.isDigit(c)) {
					value *= 10;
					value += Character.getNumericValue(c);
				}
			}
			
			return value;
		}
		
		public String getString(int i, int j) {
			return get(i).get(j);
		}
		
		public int columnsSize() {
			return get(0).size();
		}
		
		public int rowsSize() {
			return size();
		}
	}
}

package general;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVResource implements TableResource {

	private CSV csv;
	
	public CSVResource() {
		csv = new CSV();
	}
	
	public void loadFromFile(String filePath) {
		try {			
			csv = parsingCSV(filePath);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void saveToFile(String filePath) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			for (int i = 0; i < csv.rowsSize(); i++) {
				for (int j = 0; j < csv.columnsSize(); j++) {
					String value = csv.getString(i, j) + ";";
					writer.write(value);
				}
				writer.newLine();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setValue(int i, int j, String value) {
		csv.setValue(i, j, value);
	}

	public void setValue(int i, int j, float value) {
		csv.setValue(i, j, value);
	}

	public void setValue(int i, int j, int value) {
		csv.setValue(i, j, value);
	}

	public String getString(int i, int j) {
		return csv.getString(i, j);
	}

	public float getFloat(int i, int j) {
		return csv.getFloat(i, j);
	}

	public int getInt(int i, int j) {
		return csv.getInt(i, j);
	}
	
	public int rowCount() {
		return csv.rowsSize();
	}
	
	public int columnCount() {
		return csv.columnsSize();
	}

	/**
	 * Given a path of csv file with fields separated with semicolon, parses it's content and return as list of list of strings
	 * @param pathFile
	 * @return List<List<String>> */
	private static CSV parsingCSV(String pathFile) throws IOException {
		return parsingCSV(pathFile, ';');
	}
	
	private static CSV parsingCSV(String pathFile, final Character SEPARATOR) throws IOException {
		File csvFile = new File(pathFile);
		CSV content = new CSV();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
			String line = "";
			while ((line = reader.readLine()) != null) {				
				List<String> fields = new ArrayList<>();
				
				String field = "";
				final char QUOTE = '"';

				boolean isContent = false;
				boolean inQuotesContent = false;
				for (int i = 0;i < line.length();i++) {
					
					final char c = line.charAt(i);
					if (i == 0 && c != SEPARATOR) isContent = true;
					if (c == QUOTE) inQuotesContent = !inQuotesContent;
					if (!inQuotesContent && (c == SEPARATOR || i == line.length() - 1)) {
						fields.add(field);
						field = "";
					}
					else if (isContent && c != QUOTE) field += c;
				}
				
				content.add(fields);
			}	
		}
		
		return content;		
	}
	
	public static class CSV extends ArrayList< List<String>> {

		private static final long serialVersionUID = 1L;

		public float getFloat(int i, int j) {
			String content = getString(i, j);
			
			double value = 0;
			double division = 0.1f;
			boolean fractionPart = false;
			for (int idx = 0;idx < content.length();idx++) {
				final char c = content.charAt(idx);
				if (Character.isDigit(c)) {
					value *= 10;
					value += Character.getNumericValue(c);
				}
				
				if (c == ',') fractionPart = true;
				if (fractionPart) division *= 10;
			}
			
			return (float)(value / division);
		}
		
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
		
		public void setValue(int i, int j, Object value) {
			this.get(i).set(j, String.valueOf(value)); 
		}
		
		public int columnsSize() {
			return get(0).size();
		}
		
		public int rowsSize() {
			return size();
		}
	}
}

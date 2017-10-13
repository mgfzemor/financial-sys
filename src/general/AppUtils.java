package general;

import finantials.BasePlan;
import finantials.RealizedYear;
import finantials.Realized;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public final class AppUtils {

	public static BasePlan readBasePlan(String pathFile) {
		return null;
	}

	public static RealizedYear readRealizedLastYear(String pathFile) {
		return null;
	}

	/**
	 *  
	 */
	public static Realized readRealizedMonthly(String pathFile) {
		return null;
	}
	
	private static List<List<String>> parsingCSV(String pathFile) throws IOException {
		return parsingCSV(pathFile, ';');
	}
	
	private static List<List<String>> parsingCSV(String pathFile, final char SEPARATOR) throws IOException {
		File csvFile = new File(pathFile);
		List<List<String>> content = new ArrayList<>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
			String line = "";
			while ((line = reader.readLine()) != null) {				
				List<String> fields = new ArrayList<>();//Arrays.asList(line.split(";"));
				
				String field = "";
				final char QUOTE = '"';

				boolean isContent = false;
				
				for (int i = 0;i < line.length();i++) {
					
					final char c = line.charAt(i);
					if (i == 0) isContent = true;
					else if (c == QUOTE && i != 0) isContent = !isContent;
					else if (c == SEPARATOR || i == line.length() - 1) {
						fields.add(field);
						field = "";
					}
					
					if (isContent) field += c;
				}
				
				content.add(fields);
			}	
		}
		
		return content;		
	}
	
	public static String formatDate(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(date);
	}

}

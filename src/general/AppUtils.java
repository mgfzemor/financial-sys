package general;

import finantials.BasePlan;
import finantials.RealizedYear;
import finantials.Realized;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

	private static List<List<String>> parsingCSV(String pathFile) {
		return null;
	}
	
	public static String formatDate(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(date);
	}

}

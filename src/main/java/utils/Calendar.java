package utils;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import pages.BasePage;

public class Calendar extends BasePage {

	public static Date obterDataComDiferencaDias(int dias) {
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.add(java.util.Calendar.DAY_OF_MONTH, dias);
		return calendar.getTime();
	}

	public static String obterDataFormatada(Date data) {
		DateFormat format = new SimpleDateFormat("dd/MM/YYYY");
		return format.format(data);

	}

}

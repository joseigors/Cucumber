package br.ce.ig.Utills;

import java.util.Calendar;
import java.util.Date;

public class DateUtills {
	
	public static Date obterDataDiferencaDias(int dias) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, dias);
		return cal.getTime();
	}
	
}

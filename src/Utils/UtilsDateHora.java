package Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UtilsDateHora {  

	private static SimpleDateFormat formatador1 = new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat formatador2 = new SimpleDateFormat("H:mm:ss");


	public static Date getDate(){
		return Calendar.getInstance().getTime();
	}

	public static String getFormatDate (){
		String novoFormato = formatador1.format(getDate());  
		return novoFormato;
	}
	public static String getFormatTime (){
		String novoFormato = formatador2.format(getDate());  
		return novoFormato;
	}
}





package logGenerator.logGenerating.recordformatting;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class RequestTimeFormatter {
	public String format(Date time) throws IllegalArgumentException{
		if(time == null)
			throw new IllegalArgumentException("Null pointer : time");
                Locale loc = new Locale("en");
		SimpleDateFormat format = new SimpleDateFormat("dd/MMM/yyyy:hh:mm:ss Z", loc);
		
		return format.format(time);
	}
}

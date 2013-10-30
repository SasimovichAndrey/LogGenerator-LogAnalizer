package logGenerator.logGenerating.recordformatting;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RequestTimeFormatter {
	public String format(Date time) throws IllegalArgumentException{
		if(time == null)
			throw new IllegalArgumentException("Null pointer : time");
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy:hh:mm:ss");
		
		return format.format(time);
	}
}

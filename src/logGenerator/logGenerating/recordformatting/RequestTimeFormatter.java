package logGenerator.logGenerating.recordformatting;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RequestTimeFormatter {
	public String format(Date time) throws FormatException{
		if(time == null)
			throw new FormatException("Null pointer : time", new NullPointerException());
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy:hh:mm:ss");
		
		return format.format(time);
	}
}

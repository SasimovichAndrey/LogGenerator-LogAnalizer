package logGenerator.logGenerating.logFileRecord;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RequestTime {
	private Date time;
	
	public RequestTime(Date rndDate) {
		this.time = rndDate;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String toString(){
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy:hh:mm:ss");
		
		return format.format(time);
	}
}

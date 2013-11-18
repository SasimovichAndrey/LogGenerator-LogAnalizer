package logGenerator.recordformatting;

import logGenerator.logFileRecord.LogFileRecord;
import logGenerator.recordformatting.IPAdressFormatter;
import logGenerator.recordformatting.RequestInfoFormatter;
import logGenerator.recordformatting.RequestTimeFormatter;

public class LogRecordFormatter {
	public LogRecordFormatter(){
		super();
	}
	
	public String format(LogFileRecord record) throws IllegalArgumentException{
		StringBuffer res = new StringBuffer();

		res.append(new IPAdressFormatter().format(record.getIpAddress()));
		res.append(" - - [");
		res.append(new RequestTimeFormatter().format(record.getRequestTime()));
		res.append("] \"");
		res.append(new RequestInfoFormatter().format(record.getRequestInfo()));
		res.append("\" ");
		res.append(record.getStatusCode().getIntegerCode());
		res.append(" ");
		res.append(record.getBytesReturned());
		
		return res.toString();
	}
}

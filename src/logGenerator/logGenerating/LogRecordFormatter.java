package logGenerator.logGenerating;

import logGenerator.logGenerating.logFileRecord.LogFileRecord;
import logGenerator.logGenerating.recordformatting.IPAdressFormatter;
import logGenerator.logGenerating.recordformatting.RequestInfoFormatter;
import logGenerator.logGenerating.recordformatting.RequestTimeFormatter;

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

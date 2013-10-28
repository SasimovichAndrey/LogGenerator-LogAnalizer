package logGenerator.logGenerating;

import logGenerator.logGenerating.logFileRecord.LogFileRecord;
import logGenerator.logGenerating.recordformatting.FormatException;
import logGenerator.logGenerating.recordformatting.IPAdressFormatter;
import logGenerator.logGenerating.recordformatting.RequestInfoFormatter;
import logGenerator.logGenerating.recordformatting.RequestTimeFormatter;

public class LogRecordFormatter {
	private String separator = " "; 

	public LogRecordFormatter(){
		super();
	}
	
	public LogRecordFormatter(String separator){
		
	}
	
	public String format(LogFileRecord record) throws FormatException{
		StringBuffer res = new StringBuffer();

		res.append(new IPAdressFormatter().format(record.getIpAddress()));
		res.append(separator);
		res.append(new RequestTimeFormatter().format(record.getRequestTime()));
		res.append(separator);
		res.append(new RequestInfoFormatter().format(record.getRequestInfo()));
		res.append(separator);
		res.append(record.getStatusCode().getIntegerCode());
		res.append(separator);
		res.append(record.getBytesReturned());
		
		return res.toString();
	}
}

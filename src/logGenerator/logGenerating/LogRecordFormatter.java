package logGenerator.logGenerating;

import logGenerator.logGenerating.logFileRecord.LogFileRecord;

public class LogRecordFormatter {
	public String format(LogFileRecord record){
		StringBuffer res = new StringBuffer();

		res.append(record.getIpAddress().toString());
		res.append(" ");
		res.append(record.getRequestTime().toString());
		res.append(" ");
		res.append(record.getRequestInfo().toString());
		res.append(" ");
		res.append(record.getStatusCode().getIntegerCode());
		res.append(" ");
		res.append(record.getBytesReturned());
		
		return res.toString();
	}
}

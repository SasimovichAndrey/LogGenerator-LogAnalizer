package logGenerator.logGenerating;

import java.io.PrintWriter;
import java.util.List;

import logGenerator.logGenerating.logFileRecord.LogFileRecord;

public class AccessLogPrinter {
	public void printToTxt(AccessLog log, PrintWriter writer) throws LogWriteException{
		LogRecordFormatter formatter = new LogRecordFormatter();
		List<LogFileRecord> logRecords = log.getLogRecords();
		for(int i = 0; i < logRecords.size(); i++){
			try{
				writer.write(formatter.format(logRecords.get(i)));
			}
			catch(IllegalArgumentException e){
				throw new LogWriteException("Some of record fields are invalid", e);
			}
			writer.write(System.getProperty("line.separator"));
		}
	}
}

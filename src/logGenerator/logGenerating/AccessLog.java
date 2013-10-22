package logGenerator.logGenerating;

import java.io.PrintWriter;
import java.util.List;

import logGenerator.logGenerating.logFileRecord.LogFileRecord;

public class AccessLog {
	private List<LogFileRecord> logRecords;
	
	public AccessLog(List<LogFileRecord> logRecords){
		this.logRecords = logRecords;
	}
	
	public void SaveToTxt(PrintWriter writer){
		LogRecordFormatter formatter = new LogRecordFormatter();
		for(int i = 0; i < logRecords.size(); i++){
			writer.write(formatter.format(logRecords.get(i)));
			writer.write(System.getProperty("line.separator"));
		}
	}
}

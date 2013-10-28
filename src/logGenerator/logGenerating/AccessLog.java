package logGenerator.logGenerating;

import java.util.List;

import logGenerator.logGenerating.logFileRecord.LogFileRecord;

public class AccessLog {
	private List<LogFileRecord> logRecords;
	
	public AccessLog(List<LogFileRecord> logRecords){
		this.logRecords = logRecords;
	}

	public List<LogFileRecord> getLogRecords() {
		return logRecords;
	}

	public void setLogRecords(List<LogFileRecord> logRecords) {
		this.logRecords = logRecords;
	}
}

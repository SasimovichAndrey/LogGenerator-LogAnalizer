package logGenerator.logGenerating.logFileRecord;

public enum ProtocolType{
	HTTP("HTTP"),
	FTP("FTP"),
	SHHTP("SHTTP"),
	SSL("SSL");
	
	private String protocolStringName;
	
	private ProtocolType(String name) {
		protocolStringName = name;
	}
	
	public String getProtocolString(){
		return protocolStringName;
	}
}

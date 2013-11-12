package logGenerator.logGenerating.logFileRecord;

public enum ProtocolType{
	HTTP11("HTTP/1.1"),
        HTTP10("HTTP/1.0"),
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

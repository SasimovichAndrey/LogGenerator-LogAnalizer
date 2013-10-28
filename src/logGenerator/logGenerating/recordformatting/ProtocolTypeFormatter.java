package logGenerator.logGenerating.recordformatting;

import java.util.HashMap;
import java.util.Map;

import logGenerator.logGenerating.logFileRecord.ProtocolType;

public class ProtocolTypeFormatter {
	private static final Map<ProtocolType, String> protTypeMap = protTypeMapInit(); 
	
	private static Map<ProtocolType, String> protTypeMapInit(){
		Map<ProtocolType, String> map = new HashMap<ProtocolType, String>();
		map.put(ProtocolType.FTP, "FTP");
		map.put(ProtocolType.HTTP, "HTTP");
		map.put(ProtocolType.SSL, "SSL");
		map.put(ProtocolType.SHHTP, "SHTTP");
		
		return map;
	}
	
	public String format(ProtocolType type) throws FormatException{
		if(type == null)
			throw new FormatException("Null pointer: type", new NullPointerException());
		
		StringBuilder builder = new StringBuilder();
		
		builder.append(protTypeMap.get(type));
		
		return builder.toString();
	}
}

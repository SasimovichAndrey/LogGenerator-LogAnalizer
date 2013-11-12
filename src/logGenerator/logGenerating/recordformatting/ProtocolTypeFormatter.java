package logGenerator.logGenerating.recordformatting;

import java.util.HashMap;
import java.util.Map;

import logGenerator.logGenerating.logFileRecord.ProtocolType;

public class ProtocolTypeFormatter {
	private static final Map<ProtocolType, String> protTypeMap = protTypeMapInit(); 
	
	private static Map<ProtocolType, String> protTypeMapInit(){
		Map<ProtocolType, String> map = new HashMap<>();
		map.put(ProtocolType.FTP, "FTP");
		map.put(ProtocolType.HTTP11, "HTTP/1.1");
                map.put(ProtocolType.HTTP10, "HTTP/1.0");
		map.put(ProtocolType.SSL, "SSL");
		map.put(ProtocolType.SHHTP, "SHTTP");
		
		return map;
	}
	
	public String format(ProtocolType type) throws IllegalArgumentException{
		if(type == null)
			throw new IllegalArgumentException("Null pointer: type");
		
		StringBuilder builder = new StringBuilder();
		
		builder.append(protTypeMap.get(type));
		
		return builder.toString();
	}
}

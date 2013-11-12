package logGenerator.logParsing.recordfieldparsers;

import java.util.HashMap;
import java.util.Map;
import logGenerator.logGenerating.logFileRecord.ProtocolType;

public class ProtocolTypeParser {
    private static final Map<String, ProtocolType> protTypeMap = protTypeMapInit(); 
	
	private static Map<String, ProtocolType> protTypeMapInit(){
		Map<String, ProtocolType> map = new HashMap<>();
		map.put("FTP", ProtocolType.FTP);
		map.put("HTTP/1.0", ProtocolType.HTTP10);
                map.put("HTTP/1.1", ProtocolType.HTTP11);
		map.put("SSL",ProtocolType.SSL);
		map.put("SHTTP", ProtocolType.SHHTP);
		
		return map;
	}
    
    public ProtocolType parse(String string){
        if(string == null)
            throw new IllegalArgumentException("Parameter 'string' is null");
        
        return protTypeMap.get(string);
    }
}

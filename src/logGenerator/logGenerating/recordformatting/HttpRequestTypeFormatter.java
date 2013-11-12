package logGenerator.logGenerating.recordformatting;

import java.util.HashMap;
import java.util.Map;

import logGenerator.logGenerating.logFileRecord.HttpRequestType;

public class HttpRequestTypeFormatter {
	private static final Map<HttpRequestType, String> reqTypeMap = reqTypeMapInit(); 
        
	private static Map<HttpRequestType, String> reqTypeMapInit(){
		Map<HttpRequestType, String> map = new HashMap<HttpRequestType, String>();
		map.put(HttpRequestType.GET, HttpRequestType.GET_STRING);
		map.put(HttpRequestType.POST, HttpRequestType.POST_STRING);
		return map;
	}
	
	public String format(HttpRequestType type) throws IllegalArgumentException{
		if(type == null)
			throw new IllegalArgumentException("Null pointer: type");
		
		StringBuilder builder = new StringBuilder();
		builder.append(reqTypeMap.get(type));
		
		return builder.toString();
	}
}

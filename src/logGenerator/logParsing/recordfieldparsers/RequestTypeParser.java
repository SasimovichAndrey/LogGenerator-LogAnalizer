package logGenerator.logParsing.recordfieldparsers;

import java.util.HashMap;
import java.util.Map;
import logGenerator.logFileRecord.HttpRequestType;

public class RequestTypeParser {
    private static final Map<String, HttpRequestType> reqTypeMap = reqTypeMapInit(); 
    
    private static Map<String, HttpRequestType> reqTypeMapInit(){
		Map<String, HttpRequestType> map = new HashMap<>();
		map.put(HttpRequestType.GET_STRING, HttpRequestType.GET);
		map.put(HttpRequestType.POST_STRING, HttpRequestType.POST);
		return map;
    }
    
    public HttpRequestType parse(String string) throws IllegalArgumentException{
        if(string == null)
            throw new IllegalArgumentException("Parameter 'string' is null");
        return reqTypeMap.get(string);
    }
}

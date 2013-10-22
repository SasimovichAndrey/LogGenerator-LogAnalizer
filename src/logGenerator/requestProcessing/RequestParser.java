package logGenerator.requestProcessing;

import java.util.HashMap;

public class RequestParser {
	public HashMap<String, String> parse(String [] params){
		HashMap<String, String> paramMap = new HashMap<String, String>();
		
		for(int i = 0; i < params.length; i++){
			String[] splitedParam = params[i].split("=");
			if(splitedParam.length > 1){
				paramMap.put(splitedParam[0], splitedParam[1]);
			}
		}
		
		return paramMap;		
	}
}

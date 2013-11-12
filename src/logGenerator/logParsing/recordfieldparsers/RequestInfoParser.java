package logGenerator.logParsing.recordfieldparsers;

import logGenerator.logGenerating.logFileRecord.RequestInfo;
import logGenerator.logParsing.recordfieldparsers.exceptions.FormatException;

public class RequestInfoParser {
    public RequestInfoParser(){
        super();
    }
    
    public RequestInfo parse(String string) throws FormatException{
        if(string == null)
            throw new IllegalArgumentException("Parameter 'string' is null");
        
        RequestInfo resInfo = new RequestInfo();
        String [] splited = string.split(" ");
        
        try{
            resInfo.setRequestType(new RequestTypeParser().parse(splited[0]));
            resInfo.setRequestedSource(splited[1]);
            resInfo.setProtocol(new ProtocolTypeParser().parse(splited[2]));
        }
        catch(IndexOutOfBoundsException e){
            throw new FormatException("Invalid number of fields in request-info string");
        }
        
        return resInfo;
    }
}

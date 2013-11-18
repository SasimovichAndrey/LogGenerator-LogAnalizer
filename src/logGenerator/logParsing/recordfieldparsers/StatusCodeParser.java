package logGenerator.logParsing.recordfieldparsers;

import logGenerator.logFileRecord.StatusCode;
import logGenerator.logParsing.recordfieldparsers.exceptions.FormatException;

public class StatusCodeParser {
    public StatusCode parse(String string) throws FormatException, IllegalArgumentException{
        if(string == null)
            throw new IllegalArgumentException("Parameter 'string' is null");
        int intCode = Integer.parseInt(string);
        for(StatusCode code : StatusCode.values()){
            if(code.getIntegerCode() == intCode)
                return code;
        }
        throw new FormatException("Invalid status code - "+intCode);
    }
}

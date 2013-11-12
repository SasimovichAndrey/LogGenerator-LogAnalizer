package logGenerator.logParsing.recordfieldparsers;

import logGenerator.logGenerating.logFileRecord.StatusCode;
import logGenerator.logParsing.recordfieldparsers.exceptions.FormatException;

public class StatusCodeParser {
    public StatusCode parse(String string) throws FormatException{
        int intCode = Integer.parseInt(string);
        for(StatusCode code : StatusCode.values()){
            if(code.getIntegerCode() == intCode)
                return code;
        }
        throw new FormatException("Invalid status code - "+intCode);
    }
}

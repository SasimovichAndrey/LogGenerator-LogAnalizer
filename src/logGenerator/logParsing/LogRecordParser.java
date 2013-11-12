package logGenerator.logParsing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import logGenerator.logGenerating.logFileRecord.LogFileRecord;
import logGenerator.logParsing.recordfieldparsers.IPAdressParser;
import logGenerator.logParsing.recordfieldparsers.RequestInfoParser;
import logGenerator.logParsing.recordfieldparsers.RequestTimeParser;
import logGenerator.logParsing.recordfieldparsers.StatusCodeParser;
import logGenerator.logParsing.recordfieldparsers.exceptions.FormatException;

public class LogRecordParser {
    
    // Return field-array from specified string. 0 - ip, 1 - request time, 2 - request info, 3 - status code, 4 - bytes returned
    private String [] toFieldArray(String string) throws FormatException{
        String pattern = "(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})\\s-\\s-\\s\\[(\\d{1,2}/[A-ZА-Яа-яa-z]{3}" 
                +"/\\d{4}:\\d{1,2}:\\d{1,2}:\\d{1,2}\\s\\+\\d{4})\\]\\s\"(\\w+\\s[\\w|/|:|\\.]+\\s[\\w|/|\\.]+)\""
                +"\\s(\\d{3})\\s(\\d+)";
        Pattern recordPattern = Pattern.compile(pattern);
        Matcher matcher = recordPattern.matcher(string);
        
        if(!matcher.matches())
            throw new FormatException("Log file record " + string + " is not valid.");
        
        String [] fieldArray = new String[5];
        for(int i=1; i <= matcher.groupCount(); i++){
            fieldArray[i-1] = matcher.group(i);
        }
        
        return fieldArray;
    }
    
    public LogFileRecord parse(String string) throws IllegalArgumentException, FormatException{
        if(string == null)
            throw new IllegalArgumentException("Parameter 'string' is null");
        
        String [] fields = toFieldArray(string);
        LogFileRecord logRecord = new LogFileRecord();
        logRecord.setIpAddress(new IPAdressParser().parse(fields[0]));
        logRecord.setRequestTime(new RequestTimeParser().parse(fields[1]));
        logRecord.setRequestInfo(new RequestInfoParser().parse(fields[2]));
        logRecord.setStatusCode(new StatusCodeParser().parse(fields[3]));
        logRecord.setBytesReturned(Integer.parseInt(fields[4]));
        
        return logRecord;
    }
}

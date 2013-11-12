package logGenerator.logParsing.recordfieldparsers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import logGenerator.logParsing.recordfieldparsers.exceptions.FormatException;

public class RequestTimeParser {
    public Date parse(String string) throws IllegalArgumentException, FormatException{
        if(string == null)
            throw new IllegalArgumentException("Parameter 'string' is null");
        
        Date resDate = null;
        Locale loc = new Locale("en");
        SimpleDateFormat df = new SimpleDateFormat("dd/MMM/yyyy:hh:mm:ss Z", loc);
        try{
            resDate = df.parse(string);
        }
        catch(ParseException e){
            throw new FormatException("Invalid string date format");
        }
        
        return resDate;
    }
}

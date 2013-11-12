package logGenerator.logParsing.recordfieldparsers;

import logGenerator.exceptions.IllegalValueException;
import logGenerator.logGenerating.logFileRecord.IpAddress;
import logGenerator.logParsing.recordfieldparsers.exceptions.FormatException;

public class IPAdressParser {
    public IpAddress parse(String string) throws FormatException{
        if(string == null)
            throw new IllegalArgumentException("Parameter 'string' is null");
        String [] splited = string.split("\\.");
        
        IpAddress ipaddress = new IpAddress();
        
        for(int octet = 0; octet < 4; octet++){
            try {
                ipaddress.setOctet(octet, Short.parseShort(splited[octet]));
            } catch (IllegalValueException ex) {
                throw new FormatException("Invalid string format");
            }
        }
        
        return ipaddress;
    }
}

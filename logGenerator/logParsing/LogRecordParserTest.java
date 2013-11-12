package logParsing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import logGenerator.exceptions.IllegalValueException;
import logGenerator.logGenerating.LogRecordFormatter;
import logGenerator.logGenerating.logFileRecord.HttpRequestType;
import logGenerator.logGenerating.logFileRecord.IpAddress;
import logGenerator.logGenerating.logFileRecord.LogFileRecord;
import logGenerator.logGenerating.logFileRecord.ProtocolType;
import logGenerator.logGenerating.logFileRecord.RequestInfo;
import logGenerator.logGenerating.logFileRecord.StatusCode;
import logGenerator.logParsing.LogRecordParser;
import logGenerator.logParsing.recordfieldparsers.exceptions.FormatException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LogRecordParserTest {
    
    @Test
    public void testGenerateParse() throws IllegalValueException, ParseException, IllegalArgumentException, FormatException{
        System.out.println("generate-parse");
        
        LogFileRecord expResult = new LogFileRecord();
        
        IpAddress ip = new IpAddress();
        ip.setOctet(0, (short)127);
        ip.setOctet(1, (short)0);
        ip.setOctet(2, (short)0);
        ip.setOctet(3, (short)1);
        expResult.setIpAddress(ip);
        
        Date reqTime = new Date();
        expResult.setRequestTime(reqTime);
        
        RequestInfo reqInfo = new RequestInfo();
        reqInfo.setProtocol(ProtocolType.HTTP11);
        reqInfo.setRequestType(HttpRequestType.GET);
        reqInfo.setRequestedSource("/xampp/splash.php");
        expResult.setRequestInfo(reqInfo);
        
        expResult.setBytesReturned(1325);
        
        expResult.setStatusCode(StatusCode.C200);
        
        String parsedRecord = new LogRecordFormatter().format(expResult);
        
        LogFileRecord result = new LogRecordParser().parse(parsedRecord);
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void testParse() throws IllegalArgumentException, FormatException, IllegalValueException, ParseException {
        System.out.println("parse");
        String testLine = "127.0.0.1 - - [26/Apr/2012:18:55:51 +0300] \"GET /xampp/splash.php HTTP/1.1\" 200 1325";
        LogRecordParser instance = new LogRecordParser();
        
        LogFileRecord expResult = new LogFileRecord();
        
        IpAddress ip = new IpAddress();
        ip.setOctet(0, (short)127);
        ip.setOctet(1, (short)0);
        ip.setOctet(2, (short)0);
        ip.setOctet(3, (short)1);
        expResult.setIpAddress(ip);
        
        SimpleDateFormat df = new SimpleDateFormat("dd/MMM/yyyy:hh:mm:ss Z");
        Date reqTime = df.parse("26/крс/2012:18:55:51 +0300");
        expResult.setRequestTime(reqTime);
        
        RequestInfo reqInfo = new RequestInfo();
        reqInfo.setProtocol(ProtocolType.HTTP11);
        reqInfo.setRequestType(HttpRequestType.GET);
        reqInfo.setRequestedSource("/xampp/splash.php");
        expResult.setRequestInfo(reqInfo);
        
        expResult.setBytesReturned(1325);
        
        expResult.setStatusCode(StatusCode.C200);
        
        LogFileRecord result = instance.parse(testLine);
        
        assertEquals(expResult, result);
    }
}

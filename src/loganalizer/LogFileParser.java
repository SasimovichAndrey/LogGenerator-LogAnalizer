package loganalizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import logGenerator.logFileRecord.LogFileRecord;
import logGenerator.logParsing.LogRecordParser;
import logGenerator.logParsing.recordfieldparsers.exceptions.FormatException;
import loganalizer.exceptions.ParseException;

public class LogFileParser {
    private String targetFilePath;
    
    public LogFileParser(String path) throws FileNotFoundException{
        File file = new File(path);
        if(!file.exists())
            throw new FileNotFoundException("File " + path + " doesn't exist.");
        
        this.targetFilePath = path;
    }
    
    public List<LogFileRecord> parse() throws ParseException, FileNotFoundException{
        Scanner scanner = new Scanner(new File(targetFilePath));
        List<LogFileRecord> records = new ArrayList<LogFileRecord>();
        LogRecordParser parser = new LogRecordParser();
        
        int line_number = 1;
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            try{
                records.add(parser.parse(line));
            }
            catch(FormatException e){
                throw new ParseException("Invalid line format at line " + line_number, e);
            }
            line_number++;
        }
        
        return records;
    }
}

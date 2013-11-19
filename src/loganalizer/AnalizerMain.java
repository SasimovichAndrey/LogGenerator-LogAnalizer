package loganalizer;

import loganalizer.commandprocessing.UserCommandProcessor;
import loganalizer.commandprocessing.UserCommandType;
import loganalizer.textinterface.TextInterface;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import logGenerator.logFileRecord.LogFileRecord;
import loganalizer.exceptions.IntCommandFormatException;

public class AnalizerMain {
    public static void main(String [] args){
        String fileName = "lalla/1.log";
        List<LogFileRecord> records = null;
        try{
            LogFileParser fileParser = new LogFileParser(fileName);
            records = fileParser.parse();
        }
        catch (FileNotFoundException | loganalizer.exceptions.ParseException ex) {
            ex.printStackTrace(System.out);
            System.exit(1);
        }
        
        TextInterface txtInterface = new TextInterface();
        txtInterface.setMenuString(AnalyzerConstants.menuString);
        PrintWriter writer = new PrintWriter(System.out);
        UserCommandType command = null;
        UserCommandProcessor commandProcessor = new UserCommandProcessor(records);
        
        do{
            try{
                txtInterface.printMenu(writer);
                command = txtInterface.getCommand(System.in);

                if(command == null)
                    System.out.println("Such command doesn't exist");
                else{
                    commandProcessor.process(command);
                }
                
            }
            catch(IntCommandFormatException ex){
                System.out.println("Input an integer command value");
            }
        }while(true);
    }
}

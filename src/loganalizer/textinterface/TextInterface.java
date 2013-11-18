package loganalizer.textinterface;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import loganalizer.commandprocessing.UserCommandType;
import loganalizer.commandprocessing.CommandResult;
import loganalizer.exceptions.IntCommandFormatException;
import loganalizer.textinterface.resultprinters.IResultPrinter;
import loganalizer.textinterface.resultprinters.ShowCodeStatPrinter;
import loganalizer.textinterface.resultprinters.ShowStatByHourPrinter;
import loganalizer.textinterface.resultprinters.exceptions.UserCommandTypeException;

public class TextInterface {
    private String menuString = null;
    private static final Map<Integer, UserCommandType> commandMap = initCommandMap();
    private static PrintWriter writer = new PrintWriter(System.out);
    private static final Map<UserCommandType, IResultPrinter> printerMap = initPrinterMap();
    
    private static Map<Integer, UserCommandType> initCommandMap(){
        Map<Integer, UserCommandType> map = new HashMap<Integer, UserCommandType>();
        
        map.put(0, UserCommandType.EXIT);
        map.put(1, UserCommandType.SHOW_STATUS_STATISTICTS);
        map.put(2, UserCommandType.SHOW_REQUEST_BY_HOUR_STATISTICS);
        
        return map;
    }
    
    private static Map<UserCommandType, IResultPrinter> initPrinterMap(){
        Map<UserCommandType, IResultPrinter> map = new HashMap<UserCommandType, IResultPrinter>();
        
        map.put(UserCommandType.SHOW_STATUS_STATISTICTS, new ShowCodeStatPrinter(writer));
        map.put(UserCommandType.SHOW_REQUEST_BY_HOUR_STATISTICS, new ShowStatByHourPrinter(writer));
        
        return map;
    }
    
    public void setMenuString(String menuString){
        this.menuString = menuString;
    }
    
    public UserCommandType getCommand(InputStream stream) throws IntCommandFormatException{
        Scanner scanner = new Scanner(stream);
        
        int commandInt;
        try{
            commandInt = Integer.parseInt(scanner.nextLine());
        }
        catch(NumberFormatException ex){
            throw new IntCommandFormatException("Cant read int command from specified stream", ex);
        }
        
        UserCommandType command = commandMap.get(commandInt);
        
        return command;
    }
    
    public void printMenu(PrintWriter stream){
        stream.write(menuString);
        stream.flush();
    }
    
    public void printResult(CommandResult result){
        try {
            printerMap.get(result.getCommand()).printResult(result);
        } catch (UserCommandTypeException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }
}

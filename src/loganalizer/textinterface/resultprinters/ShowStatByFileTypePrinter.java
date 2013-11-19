package loganalizer.textinterface.resultprinters;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import logGenerator.logFileRecord.StatusCode;
import loganalizer.commandprocessing.CommandResult;
import loganalizer.commandprocessing.UserCommandType;
import loganalizer.textinterface.resultprinters.exceptions.UserCommandTypeException;

public class ShowStatByFileTypePrinter implements IResultPrinter{
    private PrintWriter writer;
    
    public ShowStatByFileTypePrinter(PrintWriter writer){
        this.writer = writer;
    }
    
    @Override
    public void setWriter(PrintWriter writer) {
        this.writer = writer;
    }

    @Override
    public void printResult(CommandResult result) throws UserCommandTypeException {
        if(result.getCommand() != UserCommandType.SHOW_REQUEST_BY_FILE_TYPE_STATISTICS)
            throw new UserCommandTypeException("Cant process result of type" + UserCommandType.SHOW_REQUEST_BY_FILE_TYPE_STATISTICS.toString() + " with " + ShowStatByFileTypePrinter.class.getName());
        
        Map resMap = result.getResultMap();
        
        Set entrySet = resMap.entrySet();
        Iterator it = entrySet.iterator();
        
        while(it.hasNext()){
            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>)it.next();
            writer.write(entry.getKey() + " " + entry.getValue() + "\n");
        }
        
        writer.flush();
    }

}

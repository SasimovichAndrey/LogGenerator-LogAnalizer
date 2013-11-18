package loganalizer.textinterface.resultprinters;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import logGenerator.logFileRecord.StatusCode;
import loganalizer.commandprocessing.CommandResult;
import loganalizer.commandprocessing.UserCommandType;
import loganalizer.textinterface.resultprinters.exceptions.UserCommandTypeException;

public class ShowStatByHourPrinter implements IResultPrinter{
    private PrintWriter writer;
    
    public ShowStatByHourPrinter(PrintWriter writer){
        this.writer = writer;
    }
    
    @Override
    public void setWriter(PrintWriter writer) {
        this.writer = writer;
    }

    @Override
    public void printResult(CommandResult result) throws UserCommandTypeException {
        if(result.getCommand() != UserCommandType.SHOW_REQUEST_BY_HOUR_STATISTICS)
            throw new UserCommandTypeException("Cant process result of type" + UserCommandType.SHOW_REQUEST_BY_HOUR_STATISTICS.toString() + " with " + ShowStatByHourPrinter.class.getName());
        
        Map resMap = result.getResultMap();
        
        writer.write("Hour  Request count\n");

        for(int i = 0; i < 24; i++){
            writer.write(i + "\t" + resMap.get(i) + "\n");
        }
                
        writer.flush();
    }
    
}

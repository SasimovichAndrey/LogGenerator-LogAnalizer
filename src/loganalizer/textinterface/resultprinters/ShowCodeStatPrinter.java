package loganalizer.textinterface.resultprinters;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import logGenerator.logFileRecord.StatusCode;
import loganalizer.commandprocessing.UserCommandType;
import loganalizer.commandprocessing.CommandResult;
import loganalizer.textinterface.resultprinters.exceptions.UserCommandTypeException;

public class ShowCodeStatPrinter implements IResultPrinter{
    private PrintWriter writer;
    
    public ShowCodeStatPrinter(){
        writer = new PrintWriter(System.out);
    }
    
    public ShowCodeStatPrinter(PrintWriter writer){
        this.writer = writer;
    }
    
    @Override
    public void printResult(CommandResult result) throws UserCommandTypeException {
        if(result.getCommand() != UserCommandType.SHOW_STATUS_STATISTICTS)
            throw new UserCommandTypeException("Cant process result of type" + UserCommandType.SHOW_STATUS_STATISTICTS.toString() + " with " + ShowCodeStatPrinter.class.getName());
        
        Map resMap = result.getResultMap();
        
        Set entrySet = resMap.entrySet();
        Iterator it = entrySet.iterator();
        
        while(it.hasNext()){
            Entry<StatusCode, Integer> entry = (Entry<StatusCode, Integer>)it.next();
            writer.write(entry.getKey() + " " + entry.getValue() + "\n");
        }
        
        writer.flush();
    }

    @Override
    public void setWriter(PrintWriter writer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

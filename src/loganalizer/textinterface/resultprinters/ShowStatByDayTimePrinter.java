package loganalizer.textinterface.resultprinters;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import loganalizer.commandprocessing.CommandResult;
import loganalizer.commandprocessing.UserCommandType;
import loganalizer.commandprocessing.processors.TimeOfDay;
import loganalizer.textinterface.resultprinters.exceptions.UserCommandTypeException;

public class ShowStatByDayTimePrinter implements IResultPrinter{
    private Map<TimeOfDay, String> timeNames = mapInit();
    
    private static Map<TimeOfDay, String> mapInit(){
        Map<TimeOfDay, String> map = new HashMap<TimeOfDay, String>();
        
        map.put(TimeOfDay.NIGHT, "Night");
        map.put(TimeOfDay.MORNING, "Morning");
        map.put(TimeOfDay.DAYTIME, "Day time");
        map.put(TimeOfDay.AFTERNOON, "Afternoon");
        
        return map;
    }
    
    private PrintWriter writer;
    
    public ShowStatByDayTimePrinter(PrintWriter writer){
        this.writer = writer;
    }
    
    @Override
    public void setWriter(PrintWriter writer) {
        this.writer = writer;
    }

    @Override
    public void printResult(CommandResult result) throws UserCommandTypeException {
        if(result.getCommand() != UserCommandType.SHOW_REQUEST_BY_DAY_TIME_STATISTICS)
            throw new UserCommandTypeException("Cant process result of type" + UserCommandType.SHOW_REQUEST_BY_DAY_TIME_STATISTICS.toString() + " with " + ShowStatByDayTimePrinter.class.getName());
        
        Map resMap = result.getResultMap();
        
        writer.write("Time of day  Request count\n");

        for(TimeOfDay timeOfDay : TimeOfDay.values()){
            if(result.getResultMap().containsKey(timeOfDay))
                writer.write(timeNames.get(timeOfDay) + "\t" + result.getResultMap().get(timeOfDay) + "\n");
        }
        
        writer.flush();
    }
}

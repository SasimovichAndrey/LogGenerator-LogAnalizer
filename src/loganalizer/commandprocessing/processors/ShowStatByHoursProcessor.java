package loganalizer.commandprocessing.processors;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import loganalizer.RecordSetProcessor;
import loganalizer.commandprocessing.CommandResult;
import loganalizer.commandprocessing.UserCommandType;

public class ShowStatByHoursProcessor implements ICommandProcessor{

    @Override
    public CommandResult process(RecordSetProcessor processor) {
        CommandResult result = new CommandResult();
        result.setCommand(UserCommandType.SHOW_REQUEST_BY_HOUR_STATISTICS);
        Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < 24; i++){
            resultMap.put(new Integer(i), new Integer(processor.getRecordsByAccessHour(i).size()));
        }
        result.setResultMap(resultMap);
        
        return result;
    }
}

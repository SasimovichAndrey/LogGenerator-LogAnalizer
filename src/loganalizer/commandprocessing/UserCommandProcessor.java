package loganalizer.commandprocessing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import logGenerator.logFileRecord.LogFileRecord;
import loganalizer.RecordSetProcessor;
import loganalizer.commandprocessing.CommandResult;
import loganalizer.commandprocessing.processors.ExitProcessor;
import loganalizer.commandprocessing.processors.ICommandProcessor;
import loganalizer.commandprocessing.processors.ShowCodeStatProcessor;
import loganalizer.commandprocessing.processors.ShowFileTypeStatProcessor;
import loganalizer.commandprocessing.processors.ShowStatByDayTimeProcessor;
import loganalizer.commandprocessing.processors.ShowStatByHoursProcessor;
import loganalizer.textinterface.TextInterface;

public class UserCommandProcessor {
    private List<LogFileRecord> records;
    private RecordSetProcessor rsProcessor;
    private final TextInterface txtInterface = new TextInterface();
    
    private static final Map<UserCommandType, ICommandProcessor> procMap = initMap();
    
    private static Map<UserCommandType, ICommandProcessor> initMap(){
        Map<UserCommandType, ICommandProcessor> map = new HashMap<UserCommandType, ICommandProcessor>();
        
        map.put(UserCommandType.EXIT, new ExitProcessor());
        map.put(UserCommandType.SHOW_STATUS_STATISTICTS, new ShowCodeStatProcessor());
        map.put(UserCommandType.SHOW_REQUEST_BY_HOUR_STATISTICS, new ShowStatByHoursProcessor());
        map.put(UserCommandType.SHOW_REQUEST_BY_FILE_TYPE_STATISTICS, new ShowFileTypeStatProcessor());
        map.put(UserCommandType.SHOW_REQUEST_BY_DAY_TIME_STATISTICS, new ShowStatByDayTimeProcessor());
        
        return map;
    }
    
    public UserCommandProcessor(List<LogFileRecord> records){
        rsProcessor = new RecordSetProcessor(records);
    }
    
    public void process(UserCommandType command){
        CommandResult result = procMap.get(command).process(rsProcessor);
        txtInterface.printResult(result);
    }
}

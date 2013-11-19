package loganalizer.commandprocessing.processors;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import loganalizer.RecordSetProcessor;
import loganalizer.commandprocessing.CommandResult;
import loganalizer.commandprocessing.UserCommandType;

public class ShowFileTypeStatProcessor implements ICommandProcessor{
    @Override
    public CommandResult process(RecordSetProcessor processor) {
        Map<String, Integer> resultMap = new HashMap<String, Integer>();
        
        CommandResult result = new CommandResult();
        result.setCommand(UserCommandType.SHOW_REQUEST_BY_FILE_TYPE_STATISTICS);
        result.setResultMap(resultMap);
        
        List<String> extensions = processor.getFileTypes();
        
        for(String ext : extensions){
            resultMap.put(ext, processor.getRecordsByFileExtension(ext).size());
        }
        
        return result;
    }
}

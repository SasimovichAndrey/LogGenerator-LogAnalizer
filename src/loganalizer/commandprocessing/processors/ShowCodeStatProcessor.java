package loganalizer.commandprocessing.processors;

import com.sun.org.apache.bcel.internal.classfile.Code;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import logGenerator.logFileRecord.StatusCode;
import loganalizer.RecordSetProcessor;
import loganalizer.commandprocessing.CommandResult;
import loganalizer.commandprocessing.UserCommandType;

public class ShowCodeStatProcessor implements ICommandProcessor{

    @Override
    public CommandResult process(RecordSetProcessor processor) {
        List<StatusCode> codeList = processor.getStatuses();
        Map<StatusCode, Integer> resultMap = new HashMap<StatusCode, Integer>();

        for(StatusCode code : codeList){
            resultMap.put(code, processor.getRecordsByStatusCode(code).size());
        }
        
        CommandResult commRes = new CommandResult();
        commRes.setResultMap(resultMap);
        commRes.setCommand(UserCommandType.SHOW_STATUS_STATISTICTS);
        
        return commRes;
    }
}

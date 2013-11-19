package loganalizer.commandprocessing;

import java.util.Map;

public class CommandResult {
    private Map resultMap;
    private UserCommandType command;

    public Map getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map resultMap) {
        this.resultMap = resultMap;
    }

    public UserCommandType getCommand() {
        return command;
    }

    public void setCommand(UserCommandType command) {
        this.command = command;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof CommandResult != true) return false;
        
        CommandResult commRes = (CommandResult)obj;
        if(!(resultMap == null ? commRes.resultMap == null : resultMap.equals(commRes.resultMap))) return false;
        if(!(command == null ? commRes.command == null : command.equals(commRes.command))) return false;
        
        return true;
    }
}

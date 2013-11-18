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
}

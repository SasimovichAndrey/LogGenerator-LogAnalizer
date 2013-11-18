package loganalizer.commandprocessing;

import java.util.Map;

public class UserCommand {
    private UserCommandType type;
    private Map params;

    public UserCommandType getType() {
        return type;
    }

    public void setType(UserCommandType type) {
        this.type = type;
    }

    public Map getParams() {
        return params;
    }

    public void setParams(Map params) {
        this.params = params;
    }
}

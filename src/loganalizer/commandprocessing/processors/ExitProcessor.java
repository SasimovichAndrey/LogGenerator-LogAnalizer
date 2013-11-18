package loganalizer.commandprocessing.processors;

import loganalizer.RecordSetProcessor;
import loganalizer.commandprocessing.CommandResult;

public class ExitProcessor implements ICommandProcessor{

    @Override
    public CommandResult process(RecordSetProcessor processor) {
        System.exit(0);
        
        return null;
    }
}

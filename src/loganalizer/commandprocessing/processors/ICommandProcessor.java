/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package loganalizer.commandprocessing.processors;

import java.util.Map;
import loganalizer.RecordSetProcessor;
import loganalizer.commandprocessing.CommandResult;

/**
 *
 * @author Sinitsin
 */
public interface ICommandProcessor {
    public CommandResult process(RecordSetProcessor processor);
}

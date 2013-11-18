/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package loganalizer.textinterface.resultprinters;

import java.io.PrintWriter;
import loganalizer.commandprocessing.CommandResult;
import loganalizer.textinterface.resultprinters.exceptions.UserCommandTypeException;

/**
 *
 * @author Sinitsin
 */
public interface IResultPrinter {
    public void setWriter(PrintWriter writer);
    
    public void printResult(CommandResult result) throws UserCommandTypeException;
}

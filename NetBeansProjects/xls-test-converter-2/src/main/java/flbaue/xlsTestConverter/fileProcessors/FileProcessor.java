/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flbaue.xlsTestConverter.fileProcessors;

import flbaue.xlsTestConverter.Ticket;
import java.io.File;

/**
 *
 * @author florianbauer
 */
public interface FileProcessor {

    public Ticket[] getTicketsFromFile(File file);
}

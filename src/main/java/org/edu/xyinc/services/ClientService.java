/**
 * 
 */
package org.edu.xyinc.services;

import org.edu.xyinc.domains.Client;
import org.edu.xyinc.exceptionhandler.XyApplicationException;

/**
 * @author Eduardo Silva Rosa
 *         edus.silva.rosa@gmail.com
 *         17/01/2018 11:12:34
 */
public interface ClientService {

    public void saveClient( Client client ) throws XyApplicationException;

}

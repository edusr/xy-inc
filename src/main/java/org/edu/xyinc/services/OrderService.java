/**
 * 
 */
package org.edu.xyinc.services;

import org.edu.xyinc.domains.Order;
import org.edu.xyinc.exceptionhandler.XyApplicationException;

/**
 * @author Eduardo Silva Rosa
 *		   edus.silva.rosa@gmail.com
 * 		   17/01/2018 11:12:57
 */
public interface OrderService {
    
    public void saveOrder( Order order ) throws XyApplicationException;

}

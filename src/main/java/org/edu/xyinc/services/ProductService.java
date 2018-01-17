/**
 * 
 */
package org.edu.xyinc.services;

import org.edu.xyinc.domains.Product;
import org.edu.xyinc.exceptionhandler.XyApplicationException;

/**
 * @author Eduardo Silva Rosa
 *		   edus.silva.rosa@gmail.com
 * 		   17/01/2018 11:13:10
 */
public interface ProductService {
    
    public void saveProduct(Product product) throws XyApplicationException;

}

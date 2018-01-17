/**
 * 
 */
package org.edu.xyinc.services;

import org.edu.xyinc.domains.Product;
import org.edu.xyinc.exceptionhandler.XyApplicationException;
import org.edu.xyinc.repository.ProductRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Eduardo Silva Rosa
 *         edus.silva.rosa@gmail.com
 *         16/01/2018 09:22:27
 */
@Service
class ProductServiceImpl implements ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public void saveProduct(Product product) throws XyApplicationException {
        try {
            productRepository.save( product );
        }catch (ConstraintViolationException e) {
            throw new XyApplicationException( e.getCause().getMessage() );
        }
    }

}

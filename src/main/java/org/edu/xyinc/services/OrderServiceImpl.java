/**
 * 
 */
package org.edu.xyinc.services;

import org.edu.xyinc.domains.Order;
import org.edu.xyinc.exceptionhandler.XyApplicationException;
import org.edu.xyinc.repository.OrderRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Eduardo Silva Rosa
 *		   edus.silva.rosa@gmail.com
 * 		   16/01/2018 09:22:16
 */
@Service
class OrderServiceImpl implements OrderService {
    
    @Autowired
    private OrderRepository ordertRepository;
    
    public void saveOrder(Order order) throws XyApplicationException {
        try {
            ordertRepository.save( order );
        }catch (ConstraintViolationException e) {
            throw new XyApplicationException( e.getCause().getMessage() );
        }
    }

}

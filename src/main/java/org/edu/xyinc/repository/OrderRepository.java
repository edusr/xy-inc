/**
 * 
 */
package org.edu.xyinc.repository;

import org.edu.xyinc.domains.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Eduardo Silva Rosa
 *		   eduardosr@peixoto.com
 * 		   16/01/2018 12:28:07
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

}

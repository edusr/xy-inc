/**
 * 
 */
package org.edu.xyinc.repository;

import org.edu.xyinc.domains.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Eduardo Silva Rosa
 *		   eduardosr@peixoto.com
 * 		   16/01/2018 12:27:47
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

}

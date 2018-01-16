/**
 * 
 */
package org.edu.xyinc.repository;

import org.edu.xyinc.domains.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Eduardo Silva Rosa
 *		   eduardosr@peixoto.com
 * 		   16/01/2018 12:27:27
 */
public interface ClientRepository extends JpaRepository<Client, Long> {

}

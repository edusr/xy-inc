/**
 * 
 */
package org.edu.xyinc.services;

import org.edu.xyinc.domains.Client;
import org.edu.xyinc.exceptionhandler.XyApplicationException;
import org.edu.xyinc.repository.ClientRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Eduardo Silva Rosa
 *		   edus.silva.rosa@gmail.com
 * 		   16/01/2018 09:22:27
 */
@Service
class ClientServiceImpl implements ClientService{
    
    @Autowired
    private ClientRepository clienttRepository;

    public void saveClient(Client client) throws XyApplicationException {
        try {
            clienttRepository.save( client );
        }catch (ConstraintViolationException e) {
            throw new XyApplicationException( e.getCause().getMessage() );
        }
    }
}

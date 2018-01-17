/**
 * 
 */
package org.edu.xyinc.exceptionhandler;


/**
 * @author Eduardo Silva Rosa
 * 		   17/01/2018 09:20:10
 */
public class XyApplicationException extends Exception {

    private static final long serialVersionUID = -972126063078614274L;

    public XyApplicationException() {}

    public XyApplicationException(String message) {

        super(message);
    }

    public XyApplicationException(String message, Throwable cause) {

        super(message, cause);
    }

    public XyApplicationException(Throwable cause) {

        super(cause);
    }
    
    public XyApplicationException(Exception e) {

        super(e);
    }
}

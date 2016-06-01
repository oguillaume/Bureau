/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

/**
 *
 * @author HP-G61
 */
public class BDDException extends RuntimeException{
    public BDDException( String message ) {
        super( message );
    }

    public BDDException( String message, Throwable cause ) {
        super( message, cause );
    }

    public BDDException( Throwable cause ) {
        super( cause );
    }
    
}

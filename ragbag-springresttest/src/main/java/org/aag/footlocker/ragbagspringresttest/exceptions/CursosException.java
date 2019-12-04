package org.aag.footlocker.ragbagspringresttest.exceptions;

public class CursosException extends Exception {
    public CursosException(String message){
        super(message,null);
    }
    public CursosException(){
        super("Error in RestController",null);
    }

}


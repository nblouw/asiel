package Asiel.exceptions;

import javax.ejb.ApplicationException;

// @ApplicationException
public class MyNotFoundException extends RuntimeException {

//    public MyNotFoundException() {
//    }

    public MyNotFoundException(String message) {
        super(message);
    }


}

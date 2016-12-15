/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.library;

/**
 *
 * @author mhorvath
 */
public class NotExistingLibraryItemException extends RuntimeException{

    public NotExistingLibraryItemException() {
    //it's ok sonar
    }

    public NotExistingLibraryItemException(String message) {
        super(message);
    }

    public NotExistingLibraryItemException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotExistingLibraryItemException(Throwable cause) {
        super(cause);
    }

    public NotExistingLibraryItemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}

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
public class AlreadyBorrowedLibraryItemException extends RuntimeException{

    public AlreadyBorrowedLibraryItemException() {
    //it's ok sonar
    }

    public AlreadyBorrowedLibraryItemException(String message) {
        super(message);
    }

    public AlreadyBorrowedLibraryItemException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlreadyBorrowedLibraryItemException(Throwable cause) {
        super(cause);
    }

    public AlreadyBorrowedLibraryItemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}

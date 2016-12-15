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
public class NotBorrowedByThisPersonException extends RuntimeException{

    public NotBorrowedByThisPersonException() {
    //it's ok sonar
    }

    public NotBorrowedByThisPersonException(String message) {
        super(message);
    }

    public NotBorrowedByThisPersonException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotBorrowedByThisPersonException(Throwable cause) {
        super(cause);
    }

    public NotBorrowedByThisPersonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}

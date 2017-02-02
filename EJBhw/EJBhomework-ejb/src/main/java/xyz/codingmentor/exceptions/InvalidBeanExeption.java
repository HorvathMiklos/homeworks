
package xyz.codingmentor.exceptions;

/**
 *
 * @author mhorvath
 */
public class InvalidBeanExeption extends RuntimeException{

    public InvalidBeanExeption() {
    //Nothing to initialize empty on purpose
    }

    public InvalidBeanExeption(String message) {
        super(message);
    }
}
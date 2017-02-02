
package xyz.codingmentor.exceptions;

/**
 *
 * @author mhorvath
 */
public class InvalidBeanExeption extends RuntimeException{

    public InvalidBeanExeption() {
     super();
    }

    public InvalidBeanExeption(String message) {
        super(message);
    }
}
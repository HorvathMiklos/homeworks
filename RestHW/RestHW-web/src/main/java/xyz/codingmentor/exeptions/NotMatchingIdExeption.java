
package xyz.codingmentor.exeptions;

/**
 *
 * @author mhorvath
 */
public class NotMatchingIdExeption extends RuntimeException{

    public NotMatchingIdExeption() {
        super();
    }
    
    public NotMatchingIdExeption(String message) {
        super(message);
    }
    
}

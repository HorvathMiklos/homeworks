
package xyz.codingmentor.dto;

/**
 *
 * @author mhorvath
 */
public class ErrorDTO {
    private String message;

    public ErrorDTO() {
    //nothing to initialize empty on purpose
    }
    
    public ErrorDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}

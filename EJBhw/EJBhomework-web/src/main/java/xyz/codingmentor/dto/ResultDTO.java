package xyz.codingmentor.dto;

/**
 *
 * @author mhorvath
 */
public class ResultDTO<T> {

    public enum ResultType {
        ERROR,
        SUCCESS;
    }

    private ResultType result;
    private T message;

    public ResultDTO() {
        //needed by json mapper
    }

    public ResultDTO(ResultType result, T message) {
        this.result = result;
        this.message = message;
    }

    public ResultType getResult() {
        return result;
    }

    public void setResult(ResultType result) {
        this.result = result;
    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

}

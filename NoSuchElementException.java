public class NoSuchElementException extends RuntimeException {
    private String message;
    public NoSuchElementException(String msg){
        super(msg);
        message = msg;
    }
    public String getMessage(){
        return message;
    }
}

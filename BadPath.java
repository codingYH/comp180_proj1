public class BadPath extends RuntimeException {
    private String message;
    public BadPath(String msg){
        super(msg);
        message = msg;
    }
    public String getMessage(){
        return message;
    }
}
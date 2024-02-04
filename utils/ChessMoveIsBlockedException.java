package utils;

public class ChessMoveIsBlockedException extends Exception {
    public ChessMoveIsBlockedException(){
        super();
    }
    public ChessMoveIsBlockedException(String errorMessage){
        super(errorMessage);
    }
}
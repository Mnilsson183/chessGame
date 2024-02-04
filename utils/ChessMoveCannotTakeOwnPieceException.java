package utils;

public class ChessMoveCannotTakeOwnPieceException extends Exception {
    public ChessMoveCannotTakeOwnPieceException(){
        super();
    }
    public ChessMoveCannotTakeOwnPieceException(String errorMessage){
        super(errorMessage);
    }
}

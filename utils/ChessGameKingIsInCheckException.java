package utils;

public class ChessGameKingIsInCheckException extends Exception{
    public ChessGameKingIsInCheckException(){
        super();
    }
    public ChessGameKingIsInCheckException(String errorMessage){
        super(errorMessage);
    }
}

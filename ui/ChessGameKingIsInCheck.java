package ui;

public class ChessGameKingIsInCheck extends Exception{
    public ChessGameKingIsInCheck(){
        super();
    }
    public ChessGameKingIsInCheck(String errorMessage){
        super(errorMessage);
    }
}

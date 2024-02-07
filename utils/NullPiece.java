package utils;
import board.Board;
import pieces.Piece;

public class NullPiece extends Piece{

    public NullPiece(char side){
        super(' ', ' ');
    }

    public boolean isValidMove(int row, int column, int finalRow, int finalColumn, Board board){
        return false;
    }
}
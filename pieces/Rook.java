package pieces;

import board.Board;
public class Rook extends Piece {
    
    public Rook(char side){
        super(side, 'r');
    }

    @Override
    public boolean isValidMove(int my_row, int my_column, int end_row, int end_column, Board board) {
        return isStraight(my_row, my_column, end_row, end_column) || !isBlocked(my_row, my_column, end_row, end_column, board);
    }

    private boolean isStraight(int my_row, int my_column, int end_row, int end_column){
        return (my_row == end_row) ^ (my_column == end_column);
    }

    private boolean isBlocked(int initialRow, int initialColumn, int finalRow, int finalColumn, Board board){
        if(initialRow != finalRow){
            for(int i = 0; i + initialRow < finalRow; i++){
                if(!board.isEmpty(initialRow + i, initialColumn)) return false;
            }
        } else if(initialColumn != finalColumn){
            for(int i = 0; i + initialColumn < finalColumn; i++){
                if(!board.isEmpty(initialRow, initialColumn + i)) return false;
            }
        }
        return true;
    }
}

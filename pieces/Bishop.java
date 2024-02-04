package pieces;

import board.Board;
public class Bishop extends Piece{

    public Bishop(char side){
        super(side);
        this.setType('b');
    }
    
    @Override
    public boolean isValidMove(int my_row, int my_column, int end_row, int end_column, Board board) {
        return isDiagonal(my_row, my_column, end_row, end_column) || !isBlocked(my_row, my_column, end_row, end_column, board);
    }

    private boolean isDiagonal(int my_row, int my_column, int end_row, int end_column){
        int change_row = Math.abs(end_row - my_row);
        int change_column = Math.abs(end_column - my_column);
        return change_row == change_column;
    }

    private boolean isBlocked(int initialRow, int initialColumn, int finalRow, int finalColumn, Board board){
        for(int offset = 0; offset < initialColumn - finalColumn; offset++){
            if(initialColumn - finalColumn < 0){
                if(!board.isEmpty(initialRow - offset, initialColumn - offset)){
                    return false;
                }
            } else {
                if(!board.isEmpty(initialRow + offset, initialColumn + offset)){
                    return false;
                }
            }
        }
        return true;
    }
    
}
package pieces;

import board.Board;
public class Bishop extends Piece{

    public Bishop(char side){
        super(side, 'b');
    }
    
    @Override
    public boolean isValidMove(int my_row, int my_column, int end_row, int end_column, Board board) {
        if(end_column >= board.getBoardMaxColumn() || end_column < 0){
            return false;
        } else if(end_row >= board.getBoardMaxRow() || end_row < 0){
            return false;
        }
        return isDiagonal(my_row, my_column, end_row, end_column) && !isBlocked(my_row, my_column, end_row, end_column, board);
    }

    private boolean isDiagonal(int my_row, int my_column, int end_row, int end_column){
        int change_row = Math.abs(end_row - my_row);
        int change_column = Math.abs(end_column - my_column);
        return change_row == change_column;
    }

    private boolean isBlocked(int initialRow, int initialColumn, int finalRow, int finalColumn, Board board){

            int rowDiff = Math.abs(initialColumn - finalColumn);
            if(initialColumn > finalColumn){
                if(initialRow > finalRow){
                    for(int i = 1; i < rowDiff; i++){
                        if(!board.isEmpty(initialRow - i, initialColumn - i)) return true;
                    }
                } else if(initialRow < finalRow){
                    for(int i = 1; i < rowDiff; i++){
                        if(!board.isEmpty(initialRow + i, initialColumn - i)) return true;
                    }
                }
            } else if(initialColumn < finalColumn){
                if(initialRow > finalRow){
                    for(int i = 1; i < rowDiff; i++){
                        if(!board.isEmpty(initialRow - i, initialColumn + i)) return true;
                    }
                } else if(initialRow < finalRow){
                    for(int i = 1; i < rowDiff; i++){
                        if(!board.isEmpty(initialRow + i, initialColumn + i)) return true;
                    }
                }
            }
            return false;
    }
    
}
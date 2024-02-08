package pieces;

import board.Board;

public class Knight extends Piece {
    
    public Knight(char side){
        super(side, 'k');
    }
 
    @Override
    public boolean isValidMove(int my_row, int my_column, int end_row, int end_column, Board board){
        if(end_column >= board.getBoardMaxColumn() || end_column < 0){
            return false;
        } else if(end_row >= board.getBoardMaxRow() || end_row < 0){
            return false;
        }
		if((Math.abs(my_row - end_row) == 2) && (Math.abs(my_column - end_column) == 1)){
			return true;
		} else if((Math.abs(my_column - end_column) == 2) && (Math.abs(my_row - end_row) == 1)){
		    return true;
        } else{
            return false;
        }
	}
}

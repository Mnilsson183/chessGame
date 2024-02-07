package pieces;

import board.Board;

public class Knight extends Piece {
    
    public Knight(char side){
        super(side, 'k');
    }
 
    @Override
    public boolean isValidMove(int my_row, int my_column, int end_row, int end_column, Board board){
        System.out.println("" + my_row + my_column + end_row + end_column);
		if((Math.abs(my_row - end_row) == 2) && (Math.abs(my_column - end_column) == 1)){
			return true;
		} else if((Math.abs(my_column - end_column) == 2) && (Math.abs(my_row - end_row) == 1)){
		    return true;
        } else{
            return false;
        }
	}
}

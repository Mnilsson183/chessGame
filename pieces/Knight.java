package pieces;

import board.Board;

/**
 * The Knight class represents a knight piece in the chess game.
 * It extends the Piece class and defines the behavior of a knight.
 */
public class Knight extends Piece {
    
    /**
     * Constructs a new Knight object with the specified side.
     * @param side The side of the knight ('w' for white, 'b' for black).
     */
    public Knight(char side){
        super(side, 'k');
    }
 
    /**
     * Checks if the knight's move from the initial position to the final position is valid.
     * @param my_row The initial row of the knight.
     * @param my_column The initial column of the knight.
     * @param end_row The final row of the knight.
     * @param end_column The final column of the knight.
     * @param board The game board.
     * @return true if the move is valid, false otherwise.
     */
    @Override
    public boolean isValidMove(int my_row, int my_column, int end_row, int end_column, Board board){
        // Check if the final position is within the board boundaries
        if(end_column >= board.getBoardMaxColumn() || end_column < 0 || end_row >= board.getBoardMaxRow() || end_row < 0){
            return false;
        }
        // Check if the move follows the L-shaped pattern of a knight
		return ((Math.abs(my_row - end_row) == 2) && (Math.abs(my_column - end_column) == 1))
            || ((Math.abs(my_column - end_column) == 2) && (Math.abs(my_row - end_row) == 1));
	}
}

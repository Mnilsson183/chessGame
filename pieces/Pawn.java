package pieces;

import board.Board;

/**
 * The Pawn class represents a pawn piece in the chess game.
 * It extends the Piece class and defines the behavior of a pawn.
 */
public class Pawn extends Piece{
    boolean firstMove;
    
    /**
     * Constructs a new Pawn object with the specified side.
     * Initializes the firstMove attribute to true.
     * @param side The side of the pawn ('w' for white, 'b' for black).
     */
    public Pawn(char side){
        super(side, 'p');
        this.firstMove = true;
    }

    /**
     * Checks if the pawn's move from the initial position to the final position is valid.
     * @param my_row The initial row of the pawn.
     * @param my_column The initial column of the pawn.
     * @param end_row The final row of the pawn.
     * @param end_column The final column of the pawn.
     * @param board The game board.
     * @return true if the move is valid, false otherwise.
     */
    @Override
    public boolean isValidMove(int my_row, int my_column, int end_row, int end_column, Board board) {
        // Check if the final position is within the board boundaries
        if(end_column >= board.getBoardMaxColumn() || end_column < 0 || end_row >= board.getBoardMaxRow() || end_row < 0){
            return false;
        }
        int rowDiff = Math.abs(my_row-end_row);
        int columnDiff = Math.abs(my_column-end_column);
        
        // Handling different movement scenarios for the pawn
        if(columnDiff != 1){
            if(!board.isEmpty(end_row, end_column)){
                return false;
            }
        }
        if(this.firstMove){
            if((rowDiff == 1 || rowDiff == 2) && columnDiff == 0){
                boolean b = my_column == end_column;
                if(b){
                    this.firstMove = false;
                    return true;
                } else return false;
            }
        } else if(rowDiff == 1 && columnDiff == 0){
            return my_column == end_column;
        } else if(rowDiff == 1 && columnDiff == 1){
            if((this.getSide() == 'w') && (end_row - my_row < 0) && (!board.isEmpty(end_row, end_column))){
                return true;
            } else if((this.getSide() == 'b') && (end_row - my_row > 0) && (!board.isEmpty(end_row, end_column))){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the pawn is on the promotion square of the opposite side.
     * @param row The current row of the pawn.
     * @param board The game board.
     * @return true if the pawn is on the promotion square, false otherwise.
     */
    public boolean isOnPromotionSquare(int row, Board board){
        if(this.getSide() == 'w' && board.getBlackSide() == row){
            return true;
        } else if(this.getSide() == 'b' && board.getWhiteSide() == row){
            return true;
        } else return false;
    }
}

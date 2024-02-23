package pieces;
import board.Board;

/**
 * The Queen class represents a queen chess piece.
 * It extends the Piece class and defines the specific behavior of a queen.
 */
public class Queen extends Piece{

    /**
     * Constructs a new Queen object with the specified side.
     * @param side The side of the queen ('w' for white, 'b' for black).
     */
    public Queen(char side){
        super(side, 'q');
    }

    /**
     * Checks if a move from the initial position to the final position is valid for the queen.
     * @param my_row The initial row of the queen.
     * @param my_column The initial column of the queen.
     * @param end_row The final row of the queen.
     * @param end_column The final column of the queen.
     * @param board The game board.
     * @return true if the move is valid, false otherwise.
     */
    @Override
    public boolean isValidMove(int my_row, int my_column, int end_row, int end_column, Board board) {
        if(end_column >= board.getBoardMaxColumn() || end_column < 0){
            return false;
        } else if(end_row >= board.getBoardMaxRow() || end_row < 0){
            return false;
        }
        return (isStraight(my_row, my_column, end_row, end_column) ^ isDiagonal(my_row, my_column, end_row, end_column)) && !isBlocked(my_row, my_column, end_row, end_column, board);
    }

    /**
     * Checks if the move is along a diagonal path.
     * @param my_row The initial row of the queen.
     * @param my_column The initial column of the queen.
     * @param end_row The final row of the queen.
     * @param end_column The final column of the queen.
     * @return true if the move is along a diagonal path, false otherwise.
     */
    private boolean isDiagonal(int my_row, int my_column, int end_row, int end_column){
        int change_row = Math.abs(end_row - my_row);
        int change_column = Math.abs(end_column - my_column);
        return change_row == change_column;
    }

    /**
     * Checks if the move is along a straight path.
     * @param my_row The initial row of the queen.
     * @param my_column The initial column of the queen.
     * @param end_row The final row of the queen.
     * @param end_column The final column of the queen.
     * @return true if the move is along a straight path, false otherwise.
     */
    private boolean isStraight(int my_row, int my_column, int end_row, int end_column){
        return (my_row == end_row) ^ (my_column == end_column);
    }

    /**
     * Checks if there are any pieces blocking the queen's path between the initial and final positions.
     * @param initialRow The initial row of the queen.
     * @param initialColumn The initial column of the queen.
     * @param finalRow The final row of the queen.
     * @param finalColumn The final column of the queen.
     * @param board The game board.
     * @return true if there are any pieces blocking the path, false otherwise.
     */
    public boolean isBlocked(int initialRow, int initialColumn, int finalRow, int finalColumn, Board board){
        if(isStraight(initialRow, initialColumn, finalRow, finalColumn)){
            if(initialRow < finalRow){
                for(int i = 1; i + initialRow < finalRow; i++){
                    if(!board.isEmpty(initialRow + i, initialColumn)) return true;
                }
            } else if(initialRow > finalRow){
                for(int i = 1;  initialRow - i > finalRow; i++){
                    if(!board.isEmpty(initialRow - i, initialColumn)) return true;
                }
            } else if(initialColumn < finalColumn){
                for(int i = 1; i + initialColumn < finalColumn; i++){
                    if(!board.isEmpty(initialRow, initialColumn + i)) return true;
                }
            } else if(initialColumn > finalColumn){
                for(int i = 1;  initialColumn - i > finalColumn; i++){
                    if(!board.isEmpty(initialRow, initialColumn - i)) return true;
                }
            }
            return false;
        } else if(isDiagonal(initialRow, initialColumn, finalRow, finalColumn)){
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
        } else{
            return true;
        }
    }

}

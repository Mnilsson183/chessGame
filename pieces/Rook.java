package pieces;

import board.Board;

public class Rook extends Piece {
    
    /**
     * Creates a rook with the specified side.
     * @param side The side of the rook ('w' for white, 'b' for black).
     */
    public Rook(char side){
        super(side, 'r');
    }

    /**
     * Checks if the rook's move is valid.
     * @param my_row The initial row of the rook.
     * @param my_column The initial column of the rook.
     * @param end_row The final row of the rook.
     * @param end_column The final column of the rook.
     * @param board The game board.
     * @return True if the move is valid, false otherwise.
     */
    @Override
    public boolean isValidMove(int my_row, int my_column, int end_row, int end_column, Board board) {
        if(end_column >= board.getBoardMaxColumn() || end_column < 0){
            return false;
        } else if(end_row >= board.getBoardMaxRow() || end_row < 0){
            return false;
        }
        return isStraight(my_row, my_column, end_row, end_column) && !isBlocked(my_row, my_column, end_row, end_column, board);
    }

    /**
     * Checks if the move is straight (either horizontal or vertical).
     * @param my_row The initial row.
     * @param my_column The initial column.
     * @param end_row The final row.
     * @param end_column The final column.
     * @return True if the move is straight, false otherwise.
     */
    private boolean isStraight(int my_row, int my_column, int end_row, int end_column){
        return (my_row == end_row) ^ (my_column == end_column);
    }

    /**
     * Checks if there are any pieces blocking the rook's path.
     * @param initialRow The initial row.
     * @param initialColumn The initial column.
     * @param finalRow The final row.
     * @param finalColumn The final column.
     * @param board The game board.
     * @return True if there are pieces blocking the path, false otherwise.
     */
    private boolean isBlocked(int initialRow, int initialColumn, int finalRow, int finalColumn, Board board){
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
    }
}

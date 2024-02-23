package pieces;

import board.Board;

/**
 * The Bishop class represents a bishop piece in the chess game.
 * It extends the Piece class and defines the behavior of a bishop.
 */
public class Bishop extends Piece {

    /**
     * Constructs a new Bishop object with the specified side.
     * @param side The side of the bishop ('w' for white, 'b' for black).
     */
    public Bishop(char side) {
        super(side, 'b');
    }

    /**
     * Checks if the bishop's move from the initial position to the final position is valid.
     * @param my_row The initial row of the bishop.
     * @param my_column The initial column of the bishop.
     * @param end_row The final row of the bishop.
     * @param end_column The final column of the bishop.
     * @param board The game board.
     * @return true if the move is valid, false otherwise.
     */
    @Override
    public boolean isValidMove(int my_row, int my_column, int end_row, int end_column, Board board) {
        // Check if the final position is within the board boundaries
        if (end_column >= board.getBoardMaxColumn() || end_column < 0 || end_row >= board.getBoardMaxRow() || end_row < 0) {
            return false;
        }
        // Check if the move is diagonal and not blocked
        return isDiagonal(my_row, my_column, end_row, end_column) && !isBlocked(my_row, my_column, end_row, end_column, board);
    }

    /**
     * Checks if the move is diagonal.
     * @param my_row The initial row of the bishop.
     * @param my_column The initial column of the bishop.
     * @param end_row The final row of the bishop.
     * @param end_column The final column of the bishop.
     * @return true if the move is diagonal, false otherwise.
     */
    private boolean isDiagonal(int my_row, int my_column, int end_row, int end_column) {
        int change_row = Math.abs(end_row - my_row);
        int change_column = Math.abs(end_column - my_column);
        return change_row == change_column;
    }

    /**
     * Checks if there are any pieces blocking the bishop's move.
     * @param initialRow The initial row of the bishop.
     * @param initialColumn The initial column of the bishop.
     * @param finalRow The final row of the bishop.
     * @param finalColumn The final column of the bishop.
     * @param board The game board.
     * @return true if there are blocking pieces, false otherwise.
     */
    private boolean isBlocked(int initialRow, int initialColumn, int finalRow, int finalColumn, Board board) {
        int rowDiff = Math.abs(initialColumn - finalColumn);
        // Check if there are any pieces blocking the diagonal path
        if (initialColumn > finalColumn) {
            if (initialRow > finalRow) {
                for (int i = 1; i < rowDiff; i++) {
                    if (!board.isEmpty(initialRow - i, initialColumn - i)) return true;
                }
            } else if (initialRow < finalRow) {
                for (int i = 1; i < rowDiff; i++) {
                    if (!board.isEmpty(initialRow + i, initialColumn - i)) return true;
                }
            }
        } else if (initialColumn < finalColumn) {
            if (initialRow > finalRow) {
                for (int i = 1; i < rowDiff; i++) {
                    if (!board.isEmpty(initialRow - i, initialColumn + i)) return true;
                }
            } else if (initialRow < finalRow) {
                for (int i = 1; i < rowDiff; i++) {
                    if (!board.isEmpty(initialRow + i, initialColumn + i)) return true;
                }
            }
        }
        return false;
    }
}

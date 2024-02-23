package pieces;
import board.Board;
import board.Tile;

/**
 * The King class represents a king piece in the chess game.
 * It extends the Piece class and defines the behavior of a king.
 */
public class King extends Piece {

    /**
     * Constructs a new King object with the specified side.
     * @param side The side of the king ('w' for white, 'b' for black).
     */
    public King(char side) {
        super(side, 'K');
    }

    /**
     * Checks if the king's move from the initial position to the final position is valid.
     * @param my_row The initial row of the king.
     * @param my_column The initial column of the king.
     * @param end_row The final row of the king.
     * @param end_column The final column of the king.
     * @param board The game board.
     * @return true if the move is valid, false otherwise.
     */
    @Override
    public boolean isValidMove(int my_row, int my_column, int end_row, int end_column, Board board) {
        // Check if the final position is within the board boundaries
        if (end_column >= board.getBoardMaxColumn() || end_column < 0 || end_row >= board.getBoardMaxRow() || end_row < 0) {
            return false;
        }
        // Check if the move is within one tile in any direction
        return Math.abs(end_row - my_row) < 2 && Math.abs(end_column - my_column) < 2;
    }

    /**
     * Checks if the king has any available move.
     * @param board The game board.
     * @return true if the king has at least one available move, false otherwise.
     */
    public boolean hasAvailableMove(Board board) {
        // Get the tile where the king is located
        Tile kingTile = board.tileSearch(this.getType(), this.getType())[0];

        // Array representing the row and column offsets for adjacent tiles
        int[][] offsets = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}
        };

        // Iterate through adjacent tiles
        for (int[] offset : offsets) {
            int newRow = kingTile.getRow() + offset[0];
            int newColumn = kingTile.getColumn() + offset[1];

            // Check if the new position is within the board boundaries
            if (newRow >= 0 && newRow < board.getBoardMaxRow() && newColumn >= 0 && newColumn < board.getBoardMaxColumn()) {
                // Check if the king can move to the adjacent tile
                if (this.isValidMove(kingTile.getRow(), kingTile.getColumn(), newRow, newColumn, board)) {
                    return true; // If a valid move is found, return true
                }
            }
        }

        // If no valid move is found for any adjacent tile, return false
        return false;
    }
}

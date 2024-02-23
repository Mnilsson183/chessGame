package board;
import pieces.Piece;

/**
 * The Tile class represents a tile on the chess board.
 * It contains information about its position, the piece it contains, and methods for checking validity of moves.
 */
public class Tile {

    /** The row index of the tile. */
    private final int row;

    /** The column index of the tile. */
    private final int column;

    /** The piece placed on the tile. */
    private Piece piece;

    /** 
     * Constructs a new Tile object with default position (0, 0).
     * Initializes the row and column to 0.
     */
    public Tile() {
        this.row = 0;
        this.column = 0;
    }

    /**
     * Constructs a new Tile object with the specified position.
     * @param x The row index of the tile.
     * @param y The column index of the tile.
     */
    public Tile(int x, int y) {
        this.row = x;
        this.column = y;
    }

    /**
     * Retrieves the row index of the tile.
     * @return The row index of the tile.
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Retrieves the column index of the tile.
     * @return The column index of the tile.
     */
    public int getColumn() {
        return this.column;
    }

    /**
     * Checks if the given tile is diagonally aligned with this tile.
     * @param tile The tile to check against.
     * @return true if the tiles are diagonally aligned, false otherwise.
     */
    public boolean isDiagonal(Tile tile) {
        return (this.getRow() - tile.getRow()) == (this.getColumn() - tile.getColumn());
    }

    /**
     * Checks if the given tile is in a straight line (horizontally or vertically) with this tile.
     * @param tile The tile to check against.
     * @return true if the tiles are in a straight line, false otherwise.
     */
    public boolean isStraight(Tile tile) {
        return this.getRow() == tile.getRow() ^ this.getColumn() == tile.getColumn();
    }

    /**
     * Retrieves the piece placed on the tile.
     * @return The piece placed on the tile.
     */
    public Piece getBoardPiece() {
        return this.piece;
    }

    /**
     * Sets the piece placed on the tile.
     * @param piece The piece to be placed on the tile.
     */
    public void setBoardPiece(Piece piece) {
        this.piece = piece;
    }

    /**
     * Checks if moving to the given tile is a valid move.
     * @param tile The target tile to move to.
     * @param board The chess board.
     * @return true if the move is valid, false otherwise.
     */
    public boolean isValidMove(Tile tile, Board board) {
        return this.getBoardPiece().isValidMove(this.getRow(), this.getColumn(), tile.getRow(), tile.getColumn(), board);
    }

    /**
     * Retrieves the side (color) of the piece on the tile.
     * @return The side (color) of the piece.
     */
    public char getSide() {
        return this.getBoardPiece().getSide();
    }

    /**
     * Checks if the tile is empty (contains no piece).
     * @return true if the tile is empty, false otherwise.
     */
    public boolean isEmpty() {
        return this.getBoardPiece().getType() == ' ';
    }
}

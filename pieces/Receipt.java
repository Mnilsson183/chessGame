package pieces;

import board.Tile;
import utils.utils;

/**
 * The Receipt class represents a record of a move in the chess game.
 * It contains information about the initial and final positions of the moved piece,
 * the side making the move, the move number, and the pieces involved.
 */
public class Receipt {
    private final int initialRow;
    private final int initialColumn;
    private final int finalRow;
    private final int finalColumn;
    private final char side;
    private final int moveNumber;
    private final Piece pieceMoved;
    private final Piece pieceTaken;

    /**
     * Constructs a new Receipt object with the specified information.
     * @param initialTile The initial tile of the moved piece.
     * @param finalTile The final tile of the moved piece.
     * @param moveNumber The move number.
     * @param pieceMoved The piece that was moved.
     * @param pieceTaken The piece taken (if any).
     */
    public Receipt(Tile initialTile, Tile finalTile, int moveNumber, Piece pieceMoved, Piece pieceTaken){
        this.initialRow = initialTile.getRow();
        this.initialColumn = initialTile.getColumn();
        this.finalRow = finalTile.getRow();
        this.finalColumn = finalTile.getColumn();
        this.side = finalTile.getSide();
        this.moveNumber = moveNumber;
        this.pieceMoved = pieceMoved;
        this.pieceTaken = pieceTaken;
    }

    /**
     * Constructs a new Receipt object with the specified information.
     * @param initialRow The initial row of the moved piece.
     * @param initialColumn The initial column of the moved piece.
     * @param finalRow The final row of the moved piece.
     * @param finalColumn The final column of the moved piece.
     * @param side The side making the move.
     * @param moveNumber The move number.
     * @param pieceMoved The piece that was moved.
     * @param pieceTaken The piece taken (if any).
     */
    public Receipt(int initialRow, int initialColumn, int finalRow, int finalColumn, char side, int moveNumber, Piece pieceMoved, Piece pieceTaken){
        this.initialRow = initialRow;
        this.initialColumn = initialColumn;
        this.finalRow = finalRow;
        this.finalColumn = finalColumn;
        this.side = side;
        this.moveNumber = moveNumber;
        this.pieceMoved = pieceMoved;
        this.pieceTaken = pieceTaken;
    }

/**
 * Gets the initial row of the moved piece.
 * @return The initial row.
 */
public int getInitialRow() {
    return initialRow;
}

/**
 * Gets the initial column of the moved piece.
 * @return The initial column.
 */
public int getInitialColumn() {
    return initialColumn;
}

/**
 * Gets the final row of the moved piece.
 * @return The final row.
 */
public int getFinalRow() {
    return finalRow;
}

/**
 * Gets the final column of the moved piece.
 * @return The final column.
 */
public int getFinalColumn() {
    return finalColumn;
}

/**
 * Gets the side making the move.
 * @return The side making the move.
 */
public char getSide() {
    return side;
}

/**
 * Gets the move number.
 * @return The move number.
 */
public int getMoveNumber(){
    return this.moveNumber;
}

/**
 * Gets the piece that was moved.
 * @return The piece that was moved.
 */
public Piece getPieceMoved(){
    return this.pieceMoved;
}

/**
 * Gets the piece taken (if any).
 * @return The piece taken (if any).
 */
public Piece getPieceTaken(){
    return this.pieceTaken;
}


    /**
     * Prints the receipt information.
     */
    public void printReceipt(){
        String currentSide = utils.convertSideCharToString(this.pieceMoved.getSide());
        String endSide = utils.convertSideCharToString(this.pieceTaken.getSide());

        System.out.println("-------------------------------------------------");
        System.out.println(currentSide + " " + endSide);
        System.out.println(" " + this.pieceMoved.getType() + "  ->  " + this.pieceTaken.getType());
        System.out.printf("(%d, %d)(%d, %d)\n", initialRow, initialColumn, finalRow, finalColumn);
        System.out.println("-------------------------------------------------");
    }
}

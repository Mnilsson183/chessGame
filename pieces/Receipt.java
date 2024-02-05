package pieces;

import board.Tile;
import utils.utils;

public class Receipt {
    private final int initialRow;
    private final int initialColumn;
    private final int finalRow;
    private final int finalColumn;
    private final char side;
    private final int moveNumber;
    private final Piece pieceMoved;
    private final Piece pieceTaken;

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

    // Getters
    public int getInitialRow() {
        return initialRow;
    }

    public int getInitialColumn() {
        return initialColumn;
    }

    public int getFinalRow() {
        return finalRow;
    }

    public int getFinalColumn() {
        return finalColumn;
    }

    public char getSide() {
        return side;
    }

    public int getMoveNumber(){
        return this.moveNumber;
    }

    public Piece getPieceMoved(){
        return this.pieceMoved;
    }

    public Piece getPieceTaken(){
        return this.pieceTaken;
    }

    public void printReceipt(){
		String currentSide = utils.convertSideCharToString(this.pieceMoved.getSide());
		String endSide = utils.convertSideCharToString(this.pieceTaken.getSide());

		System.out.println(currentSide + " " + endSide);
		System.out.println(" " + this.pieceMoved.getType() + "  ->  " + this.pieceTaken.getType());
		System.out.printf("(%d, %d)(%d, %d)\n", initialRow, initialColumn, finalRow, finalColumn);
    }
}
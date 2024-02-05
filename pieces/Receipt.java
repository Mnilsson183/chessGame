package pieces;

import board.Tile;

public class Receipt {
    private final int initialRow;
    private final int initialColumn;
    private final int finalRow;
    private final int finalColumn;
    private final char side;
    private final int moveNumber;
    private final char pieceMoved;
    private final char pieceTaken;

    public Receipt(Tile initialTile, Tile finalTile, int moveNumber){
        this.initialRow = initialTile.getRow();
        this.initialColumn = initialTile.getColumn();
        this.finalRow = finalTile.getRow();
        this.finalColumn = finalTile.getColumn();
        this.side = finalTile.getSide();
        this.moveNumber = moveNumber;
    }

    public Receipt(int initialRow, int initialColumn, int finalRow, int finalColumn, char side, int moveNumber){
        this.initialRow = initialRow;
        this.initialColumn = initialColumn;
        this.finalRow = finalRow;
        this.finalColumn = finalColumn;
        this.side = side;
        this.moveNumber = moveNumber;
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

    public void printReceipt(){
        Piece current = this.getPiece(row, column);
		String currentSide = utils.convertSideCharToString(current.getSide());
		Piece end = this.getPiece(end_row, end_column);
		String endSide = utils.convertSideCharToString(end.getSide());

		System.out.println(currentSide + " " + endSide);
		System.out.println(" " + current.getType() + "  ->  " + end.getType());
		System.out.printf("(%d, %d)(%d, %d)\n", row, column, end_row, end_column);
    }
}
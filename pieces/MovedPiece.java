package pieces;

import board.Tile;

public class MovedPiece {
    private final int initialRow;
    private final int initialColumn;
    private final int finalRow;
    private final int finalColumn;
    private final char side;

    public MovedPiece(Tile initialTile, Tile finalTile){
        this.initialRow = initialTile.getRow();
        this.initialColumn = initialTile.getColumn();
        this.finalRow = finalTile.getRow();
        this.finalColumn = finalTile.getColumn();
        this.side = finalTile.getSide();
    }

    public MovedPiece(int initialRow, int initialColumn, int finalRow, int finalColumn, char side){
        this.initialRow = initialRow;
        this.initialColumn = initialColumn;
        this.finalRow = finalRow;
        this.finalColumn = finalColumn;
        this.side = side;
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
}
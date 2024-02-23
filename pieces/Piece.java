package pieces;

import board.Board;
import utils.utils;

/**
 * The Piece class represents a generic chess piece.
 * It defines common attributes and methods for all chess pieces.
 */
public class Piece {

    private char type; // Type of the piece ('p' for pawn, 'r' for rook, etc.)
    private int value; // Value of the piece
    private char side; // Side of the piece ('w' for white, 'b' for black)

    /**
     * Constructs a new Piece object with the specified side and type.
     * @param side The side of the piece ('w' for white, 'b' for black).
     * @param type The type of the piece.
     */
    public Piece(char side, char type){
        this.side = side;
        this.type = type;
    }

    /**
     * Returns the value of the piece.
     * @return The value of the piece.
     */
    public int getValue(){
        return value;
    }

    /**
     * Returns the side of the piece.
     * @return The side of the piece ('w' for white, 'b' for black).
     */
    public char getSide(){
        return side;
    }

    /**
     * Returns the type of the piece.
     * @return The type of the piece.
     */
    public char getType(){
        return type;
    }

    /**
     * Checks if a move from the initial position to the final position is valid for the piece.
     * This method is overridden by specific piece classes.
     * @param row The initial row of the piece.
     * @param column The initial column of the piece.
     * @param finalRow The final row of the piece.
     * @param finalColumn The final column of the piece.
     * @param board The game board.
     * @return true if the move is valid, false otherwise.
     */
    public boolean isValidMove(int row, int column, int finalRow, int finalColumn, Board board) {
        System.out.println("This should not be used as it is not real code");
        Thread.dumpStack();
        return false;
    }

    /**
     * Returns a string representation of the piece.
     * @return A string representation of the piece including its type and side.
     */
    public String toString(){
        return "" + utils.convertTypeCharToString(this.getType()) + " on side " + utils.convertSideCharToString(this.getSide());
    }
}

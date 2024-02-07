package pieces;
import board.Board;

public class Piece {

	private char type;
	private int value;
	private char side;

	public Piece(char side, char type){
		this.side = side;
		this.type = type;
	}

	public int getValue(){
		return value;
	}

	public char getSide(){
		return side;
	}

	public char getType(){
		return type;
	}

	public boolean isValidMove(int row, int column, int finalRow, int finalColumn, Board board) {
        System.out.println("This should not be used as it is not real code");
        Thread.dumpStack();
		return false;
	}
}


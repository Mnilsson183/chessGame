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

	public boolean isValidMove(int row, int column, int my_row, int my_column, Board board) {
		return false;
	}
}


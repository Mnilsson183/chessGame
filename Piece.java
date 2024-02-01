
class Piece {

	private char type;
	private int value;
	private char side;

	public Piece(char side){
		this.side = side;
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

	public void setType(char type){
		this.type = type;
	}

	public boolean isValidMove(int row, int column, int my_row, int my_column, Board board) {
		return false;
	}

	private boolean isBlocked(int initialRow, int initialColumn, int finalRow, int finalColumn, Board board){
		return true;
	}
}


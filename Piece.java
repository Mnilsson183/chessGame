
class Piece {

	private char type;
	private int value;
	private char side;

	public int getValue(){
		return value;
	}

	public char getSide(){
		return side;
	}

	public char getType(){
		return type;
	}

	public boolean isValidMove(int x, int y, int my_x, int my_y) {
		return false;
	}

}


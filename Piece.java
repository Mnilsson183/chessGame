
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

	public boolean isValidMove(int x, int y, int my_x, int my_y) {
		return false;
	}

}


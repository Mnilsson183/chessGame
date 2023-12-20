
class Piece {

	private char type;
	private int value;
	private char side;
	public Piece(char type, char side){
		this.type = type;
		this.side = side;
		switch (type) {
			case 'p':
				value = 1;
				break;
			case 'k':
				value = 3;
				break;
			case 'b':
				value = 3;
				break;
			case 'r':
				value = 5;
				break;
			case 'q':
				value = 9;
				break;
			case ' ':
				value = 0;
				break;
		}
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
}

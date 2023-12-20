
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

	public boolean isValidMove(int x, int y, int my_x, int my_y){
		char c = this.getSide();
		boolean isValid = false;
		switch (this.getType()) {
			case 'p':
				switch (c) {
					case 'w':
							if(my_y - 1 == y && my_x == x) isValid = true;
						break;
				
					case 'b':
							if(my_y + 1 == y && my_x == x) isValid = true;
						break;
				}
				break;
		
			case 'r':
				isValid = isStraight(x, y, my_x, my_y);
				break;

			case 'b':
				isValid = isDiagonal(x, y, my_x, my_y);
				break;
			case 'q':
				isValid = (isStraight(x, y, my_x, my_y) ^ isDiagonal(x, y, my_x, my_y));
				break;
			case 'K':
				isValid =  Math.abs(x - my_x) < 1 && Math.abs(y - my_y) < 1;
				break;
			
		}
		return isValid;
	}

	private boolean isDiagonal(int x, int y, int my_x, int my_y){
		int change_x = x - my_x;
		int change_y = y - my_y;
		return change_x == change_y;
	}

	private boolean isStraight(int x, int y, int my_x, int my_y){
		return my_x == x ^ my_y == y;
	}
}

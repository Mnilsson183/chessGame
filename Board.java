class Board {

	char[][] defaultBoard  = {
			{'r', 'k', 'b', 'q', 'K', 'b', 'k', 'r'},
			{'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
			{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
			{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
			{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
			{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
			{'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
			{'r', 'k', 'b', 'q', 'K', 'b', 'k', 'r'},
		};

	Piece[][] board = new Piece[8][8];

	int moveNumber;
	int boardMax_x = 8;
	int boardMax_y = 8;

	public Board(){
		for(int x = 0; x < defaultBoard.length; x++){
			for(int y = 0; y < defaultBoard[0].length; y++){
				switch (defaultBoard[x][y]) {
					case 'r':
						board[x][y] = new Piece('r', y < 2 ? 'b' : 'w');
						break;

					case 'k':
						board[x][y] = new Piece('k', y < 2 ? 'b' : 'w');
						break;
					case 'b':
						board[x][y] = new Piece('b', y < 2 ? 'b' : 'w');
						break;
					case 'q':
						board[x][y] = new Piece('q', y < 2 ? 'b' : 'w');
						break;
					case 'K':
						board[x][y] = new Piece('K', y < 2 ? 'b' : 'w');
						break;
					case 'p':
						board[x][y] = new Piece('p', y < 2 ? 'b' : 'w');
						break;
					case ' ':
						board[x][y] = new Piece(' ', ' ');
						break;
				}
			}
		}
		moveNumber = 0;
	}

    public Piece getPiece(int x, int y) {
	    return board[x][y];
    }

	public boolean isEmpty(int x, int y){
		return board[x][y].getType() == ' ' ? false : true;
	}

    public void movePiece(int x, int y, int end_x, int end_y, char side){
		if(end_x < 0 || end_x > board[0].length){
			throw new ArrayIndexOutOfBoundsException();
		}

		if(end_y < 0 || end_y > board.length){
			throw new ArrayIndexOutOfBoundsException();
		}
		
		if(this.getPiece(end_x, end_y).getSide() != side && this.getPiece(x, y).getSide() == side 
			&& this.getPiece(x, y).isValidMove(end_x, end_y, x, y))
		{
			board[end_x][end_y] = board[x][y];
			board[x][y] = new Piece(' ', ' ');
		} else if(this.getPiece(end_x, end_y).getSide() == side){
			System.out.println("Cannot take own piece");
		} else if(this.getPiece(x, y).getSide() == ' ') {
			System.out.println("There is no piece there to move");
		} else if(this.getPiece(x, y).getSide() != side){
			System.out.println("Cannot move opponents pieces");
		} else if(this.getPiece(x, y).isValidMove(end_x, end_y, x, y) == false){
			System.out.println("Not a valid move for that piece");
		}
    }

	public int getPieceValue(int x, int y){
		return board[x][y].getValue();
	}

	public int getValueOnBoard(char side){
		int sum = 0;
		for(int x = 0; x < boardMax_x; x++){
			for(int y = 0; y < boardMax_y; y++){
				if(board[x][y].getSide() == side){
					sum += board[x][y].getValue();
				}
			}
		}
		return sum;
	}

	public int getMoveNumber(){
		return moveNumber;
	}

	public void printBoard(Board board){
		System.out.println("Black");
		for(int x = 0; x < boardMax_x; x++){
			for(int y = 0; y < boardMax_y; y++){
				System.out.printf("%c ", board.getPiece(x, y).getType());
			}
			System.out.println();
		}
		System.out.println("White");
		System.out.println();
	}
}		

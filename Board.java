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

	public Board(){
		for(int x = 0; x < defaultBoard.length; x++){
			for(int y = 0; y < defaultBoard[0].length; y++){
				switch (defaultBoard[x][y]) {
					case 'r':
						board[x][y] = new Piece('r', y < 2 ? 'B' : 'W');
						break;

					case 'k':
						board[x][y] = new Piece('k', y < 2 ? 'B' : 'W');
						break;

					case 'b':
						board[x][y] = new Piece('b', y < 2 ? 'B' : 'W');
						break;
				
					case 'q':
						board[x][y] = new Piece('q', y < 2 ? 'B' : 'W');
						break;

					case 'K':
						board[x][y] = new Piece('K', y < 2 ? 'B' : 'W');
						break;

					case 'p':
						board[x][y] = new Piece('p', y < 2 ? 'B' : 'W');
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
		return board[x][y] == null ? false : true;
	}

    public void movePiece(int x, int y, int end_x, int end_y){
		// TODO will need rewrite
		if(end_x < 0 || end_x > board[0].length){
			throw new ArrayIndexOutOfBoundsException();
		}
		if(end_y < 0 || end_y > board.length){
			throw new ArrayIndexOutOfBoundsException();
		}
		if(isEmpty(end_x, end_y) || board[end_x][end_y].getSide() != board[x][y].getSide()){
			board[end_x][end_y] = board[x][y];
			board[x][y] = null;
		}
    }

	public int getPieceValue(int x, int y){
		return board[x][y].getValue();
	}

	public int getValueOnBoard(char side){
		int sum = 0;
		for(int x = 0; x < board.length; x++){
			for(int y = 0; y < board[0].length; y++){
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
}		

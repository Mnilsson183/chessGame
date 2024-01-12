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
	int boardMax_row = 8;
	int boardMax_column = 8;

	public Board(){
		for(int row = 0; row < defaultBoard.length; row++){
			for(int column = 0; column < defaultBoard[0].length; column++){
				switch (defaultBoard[row][column]) {
					case 'r': board[row][column] = new Rook(row < 2 ? 'b' : 'w'); break;
					case 'k': board[row][column] = new Knight(row < 2 ? 'b' : 'w'); break;
					case 'b': board[row][column] = new Bishop(row < 2 ? 'b' : 'w'); break;
					case 'q': board[row][column] = new Queen(row < 2 ? 'b' : 'w'); break;
					case 'K': board[row][column] = new King(row < 2 ? 'b' : 'w'); break;
					case 'p': board[row][column] = new Pawn(row < 2 ? 'b' : 'w'); break;
					case ' ': board[row][column] = new NullPiece(' '); break;
				}
			}
		}
		moveNumber = 0;
	}

    public Piece getPiece(int row, int column) {
	    return board[row][column];
    }

	public boolean isEmpty(int row, int column){
		return board[row][column].getType() == ' ' ? false : true;
	}

    public boolean movePiece(int row, int column, int end_row, int end_column, char side){
		boolean success = false;
		if(end_row < 0 || end_row > board[0].length){
			throw new ArrayIndexOutOfBoundsException();
		}

		if(end_column < 0 || end_column > board.length){
			throw new ArrayIndexOutOfBoundsException();
		}
		
		if(this.getPiece(end_row, end_column).getSide() != side && this.getPiece(row, column).getSide() == side 
			&& this.getPiece(row, column).isValidMove(end_row, end_column, row, column))
		{
			board[end_row][end_column] = board[row][column];
			board[row][column] = new Piece(' ');
			moveNumber++;
			success = true;
		} else if(this.getPiece(end_row, end_column).getSide() == side){
			System.out.println("Cannot take own piece");
		} else if(this.getPiece(row, column).getSide() == ' ') {
			System.out.println("There is no piece there to move");
		} else if(this.getPiece(row, column).getSide() != side){
			System.out.println("Cannot move opponents pieces");
		} else if(this.getPiece(row, column).isValidMove(row, column, end_row, end_column) == false){
			System.out.println("Not a valid move for that piece");
		}

		printMovePiece(row, column, end_row, end_column);
		return success;
    }

	private void printMovePiece(int row, int column, int end_row, int end_column){
		Piece current = this.getPiece(row, column);
		String currentSide = utils.convertSideCharToString(current.getSide());
		Piece end = this.getPiece(end_row, end_column);
		String endSide = utils.convertSideCharToString(end.getSide());

		System.out.println(currentSide + " " + endSide);
		System.out.println(" " + current.getType() + "  ->  " + end.getType());
		System.out.printf("(%d, %d)(%d, %d)\n", row, column, end_row, end_column);
	}

	public int getPieceValue(int row, int column){
		return board[row][column].getValue();
	}

	public int getValueOnBoard(char side){
		int sum = 0;
		for(int row = 0; row < boardMax_row; row++){
			for(int column = 0; column < boardMax_column; column++){
				if(board[row][column].getSide() == side){
					sum += board[row][column].getValue();
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
		for(int row = 0; row < boardMax_row; row++){
			for(int y = 0; y < boardMax_column; y++){
				System.out.printf("%c ", board.getPiece(row, y).getType());
			}
			System.out.println();
		}
		System.out.println("White");
		System.out.println();
	}
}		


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

	Tile[][] board = new Tile[8][8];

	int moveNumber;
	int boardMax_row = 8;
	int boardMax_column = 8;

	public Board(){

		for(int row = 0; row < defaultBoard.length; row++){
			for(int column = 0; column < defaultBoard[0].length; column++){
				board[row][column] = new Tile(row, column);
			}
		}
		for(int row = 0; row < defaultBoard.length; row++){
			for(int column = 0; column < defaultBoard[0].length; column++){
				switch (defaultBoard[row][column]) {
					case 'r': board[row][column].setBoardPiece(new Rook(row < 2 ? 'b' : 'w')); break;
					case 'k': board[row][column].setBoardPiece(new Knight(row < 2 ? 'b' : 'w')); break;
					case 'b': board[row][column].setBoardPiece(new Bishop(row < 2 ? 'b' : 'w')); break;
					case 'q': board[row][column].setBoardPiece(new Queen(row < 2 ? 'b' : 'w')); break;
					case 'K': board[row][column].setBoardPiece(new King(row < 2 ? 'b' : 'w')); break;
					case 'p': board[row][column].setBoardPiece(new Pawn(row < 2 ? 'b' : 'w')); break;
					case ' ': board[row][column].setBoardPiece(new NullPiece(' ')); break;
				}
			}
		}
		moveNumber = 0;
	}

	public Piece getPiece(Tile tile){
		return getPiece(tile.getRow(), tile.getColumn());
	}

    public Piece getPiece(int row, int column) {
	    return board[row][column].getBoardPiece();
    }

	public boolean isEmpty(Tile tile){
		return tile.getBoardPiece().getType() == ' ' ? false : true;
	}
	public boolean isEmpty(int row, int column){
		return board[row][column].getBoardPiece().getType() == ' ' ? false : true;
	}

	public boolean movePiece(int initialX, int initialY, int endX, int endY, char side){
		return movePiece(board[initialX][initialY], board[endX][endY], side);
	}

	public boolean movePiece(Tile initialTile, Tile finalTile, char side){
		boolean success = false;
		printMovePiece(initialTile, finalTile);
		try {
			if(finalTile.getRow() < 0 || finalTile.getRow() > board[0].length){
				throw new BoardOutOfBoundsException("The row to be moved to or from is out of range");
			}
	
			if(finalTile.getColumn() < 0 || finalTile.getColumn() > board.length){
				throw new BoardOutOfBoundsException("The column to be moved to or from is out of range");
			}	
		} catch (BoardOutOfBoundsException e) {
			return false;
		}
		
		if(finalTile.getSide() != side && initialTile.getSide() == side 
			&& initialTile.isValidMove(finalTile))
		{
			finalTile.setBoardPiece(initialTile.getBoardPiece());
			initialTile.setBoardPiece(new Piece(' '));
			moveNumber++;
			success = true;
		} else if(finalTile.getBoardPiece().getSide() == side){
			System.out.println("Cannot take own piece");
		} else if(initialTile.getBoardPiece().getSide() == ' ') {
			System.out.println("There is no piece there to move");
		} else if(initialTile.getBoardPiece().getSide() != side){
			System.out.println("Cannot move opponents pieces");
		} else if(initialTile.isValidMove(finalTile) == false){
			System.out.println("Not a valid move for that piece");
		}

		return success;
	}

	private void printMovePiece(Tile initialTile, Tile finalTile){
		printMovePiece(initialTile.getRow(), initialTile.getColumn(), finalTile.getRow(), finalTile.getColumn());
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

	public int getPieceValue(Tile tile){
		return tile.getBoardPiece().getValue();
	}

	public int getPieceValue(int row, int column){
		return board[row][column].getBoardPiece().getValue();
	}

	public int getValueOnBoard(char side){
		int sum = 0;
		for(int row = 0; row < boardMax_row; row++){
			for(int column = 0; column < boardMax_column; column++){
				if(board[row][column].getBoardPiece().getSide() == side){
					sum += board[row][column].getBoardPiece().getValue();
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

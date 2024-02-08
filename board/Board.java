package board;
import java.util.Vector;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Receipt;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;
import utils.BoardOutOfBoundsException;
import utils.NullPiece;
import utils.utils;

public class Board {

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

	private int moveNumber;
	private int boardMax_row = 8;
	private int boardMax_column = 8;
	private final int blackSide = 0;
	private final int whiteSide = 7;

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

	public Board(char[][] defaultBoard){
		this.defaultBoard = defaultBoard;
		
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
		return tile.isEmpty();
	}
	public boolean isEmpty(int row, int column){
		return board[row][column].isEmpty();
	}

	// returns the fist source of check
	public Tile[] isChecked(Tile kingTile){
		Vector<Tile> checkedFrom = new Vector<>(); 
		for(int row = 0; row < boardMax_row; row++){
			for(int column = 0; column < boardMax_column; column++){
				if(board[row][column].isValidMove(kingTile, this)) checkedFrom.add(board[row][column]);
			}
		}
		return tileVectorToArray(checkedFrom);
	}

	private Tile[] tileVectorToArray(Vector<Tile> tiles){
		Tile[] tilesArray = new Tile[tiles.size()];
		for(int i = 0; i < tiles.size(); i++){
			tilesArray[i] = tiles.get(i);
		}
		return tilesArray;
	}

	public Tile[] pieceSearch(char piece, char side){
		Vector<Tile> rTiles = new Vector<Tile>();
		for(int row = 0; row < boardMax_row; row++){
			for(int column = 0; column < boardMax_column; column++){
				Tile tile = board[row][column];
				if(((tile.getBoardPiece().getType() == piece) || piece == 'A') && ((tile.getBoardPiece().getSide() == side) || (side == 'A'))){
					rTiles.add(tile);
				}
			}
		}
		return vectorToTileArray(rTiles);
	}

	private Tile[] vectorToTileArray(Vector<Tile> vec){
		Tile[] tiles = new Tile[vec.size()];
		for(int i = 0; i < vec.size(); i++){
			tiles[i] = vec.get(i);
		}
		return tiles;
	}

	private void printIsChecked(Tile[] tiles){
		if(tiles.length == 0) return;
		for(int i = 0; i < tiles.length; i++){
			System.out.println(utils.convertTypeCharToString(tiles[i].getBoardPiece().getType()) + "At (" + tiles[i].getRow() + ", " + tiles[i].getColumn() + ")");
		}
	}

	public Receipt movePiece(int initialRow, int initialColumn, int endRow, int endColumn, char side){
		return movePiece(board[initialRow][initialColumn], board[endRow][endColumn], side);
	}

	public Receipt movePiece(Tile initialTile, Tile finalTile, char side){
		Receipt receipt = null;
		printMovePiece(initialTile, finalTile);
		try {
			if(finalTile.getRow() < 0 || finalTile.getRow() > board[0].length){
				throw new BoardOutOfBoundsException("The row to be moved to or from is out of range");
			}
	
			if(finalTile.getColumn() < 0 || finalTile.getColumn() > board.length){
				throw new BoardOutOfBoundsException("The column to be moved to or from is out of range");
			}	
		} catch (BoardOutOfBoundsException e) {
			return receipt;
		}
		
		if(finalTile.getSide() != side && initialTile.getSide() == side 
			&& initialTile.isValidMove(finalTile, this) && !this.isChecked(pieceSearch('K', side)[0])[0].isEmpty())
		{
			receipt = new Receipt(initialTile, finalTile, this.moveNumber, initialTile.getBoardPiece(), finalTile.getBoardPiece());
			finalTile.setBoardPiece(initialTile.getBoardPiece());
			initialTile.setBoardPiece(new Piece(' ',' '));
			moveNumber++;
		} else if(finalTile.getBoardPiece().getSide() == side){
			System.out.println("Cannot take own piece");
		} else if(initialTile.getBoardPiece().getSide() == ' ') {
			System.out.println("There is no piece there to move");
		} else if(initialTile.getBoardPiece().getSide() != side){
			System.out.println("Cannot move opponents pieces");
		} else if(initialTile.isValidMove(finalTile, this) == false){
			System.out.println("Not a valid move for that piece");
		} else if(!this.isChecked(pieceSearch('K', side)[0])[0].isEmpty()){
			System.out.println("Your king is in check");
			System.out.print("From");
			printIsChecked(this.isChecked(pieceSearch('K', side)[0]));
		}

		return receipt;
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

	public int getBoardMaxRow(){
		return this.boardMax_row;
	}

	public int getBoardMaxColumn(){
		return this.boardMax_column;
	}

	public int getBlackSide(){
		return this.blackSide;
	}

	public int getWhiteSide(){
		return this.whiteSide;
	}
}		

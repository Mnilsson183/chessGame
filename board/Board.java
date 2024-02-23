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

/**
 * The Board class represents the chess board.
 * It manages the arrangement of pieces on the board,
 * checks for valid moves, and keeps track of the game state.
 */

public class Board {

	/** The default arrangement of pieces on the board. */
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

	/** The 2D array representing the board tiles. */
    Tile[][] board = new Tile[8][8];

    /** The number of moves made on the board. */
    private int moveNumber;

    /** The maximum number of rows on the board. */
    private int boardMax_row = 8;

    /** The maximum number of columns on the board. */
    private int boardMax_column = 8;

    /** The index representing the black side of the board. */
    private final int blackSide = 0;

    /** The index representing the white side of the board. */
    private final int whiteSide = 7;

	/**
     * Constructs a new Board object with the default arrangement of pieces.
     */
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

	/**
     * Constructs a new Board object with a custom arrangement of pieces.
     * @param defaultBoard The custom arrangement of pieces.
     */
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

	/**
     * Retrieves the piece at the specified tile.
     * @param tile The tile to retrieve the piece from.
     * @return The piece at the specified tile.
     */
	public Piece getPiece(Tile tile){
		return getPiece(tile.getRow(), tile.getColumn());
	}

	/**
     * Retrieves the piece at the specified row and column.
     * @param row The row index of the tile.
     * @param column The column index of the tile.
     * @return The piece at the specified row and column.
     */
    public Piece getPiece(int row, int column) {
	    return board[row][column].getBoardPiece();
    }

	/**
     * Checks if the specified tile is empty.
     * @param tile The tile to check.
     * @return True if the tile is empty, false otherwise.
     */
	public boolean isEmpty(Tile tile){
		return tile.isEmpty();
	}

	/**
     * Checks if the tile at the specified row and column is empty.
     * @param row The row index of the tile.
     * @param column The column index of the tile.
     * @return True if the tile is empty, false otherwise.
     */
	public boolean isEmpty(int row, int column){
		return board[row][column].isEmpty();
	}

	/**
     * Finds the tiles from which the specified king tile is checked.
     * @param kingTile The tile of the king.
     * @return An array of tiles from which the king is checked.
     */
	public Tile[] isChecked(Tile kingTile){
		Vector<Tile> checkedFrom = new Vector<>(); 
		for(int row = 0; row < boardMax_row; row++){
			for(int column = 0; column < boardMax_column; column++){
				if(!board[row][column].isEmpty()){
					if(board[row][column].isValidMove(kingTile, this)) checkedFrom.add(board[row][column]);
				}
			}
		}
		return tileVectorToArray(checkedFrom);
	}

	/**
	 * Converts a vector of tiles to an array of tiles.
	 * @param tiles The vector of tiles to convert.
	 * @return An array containing the tiles from the vector.
	 */
	private Tile[] tileVectorToArray(Vector<Tile> tiles){
		Tile[] tilesArray = new Tile[tiles.size()];
		for(int i = 0; i < tiles.size(); i++){
			tilesArray[i] = tiles.get(i);
		}
		return tilesArray;
	}

	/**
	 * Searches for tiles containing pieces of the specified type and side.
	 * @param piece The type of piece to search for. 'r' - Rook, 'k' - Knight, 'b' - Bishop,
	 *              'q' - Queen, 'K' - King, 'p' - Pawn, 'A' - Any type.
	 * @param side The side of the pieces to search for. 'b' - Black, 'w' - White, 'A' - Any side.
	 * @return An array of tiles containing the specified pieces.
	 */
	public Tile[] tileSearch(char piece, char side){
		Vector<Tile> rTiles = new Vector<Tile>();
		for(int row = 0; row < boardMax_row; row++){
			for(int column = 0; column < boardMax_column; column++){
				Tile tile = board[row][column];
				if(((tile.getBoardPiece().getType() == piece) || piece == 'A') && ((tile.getBoardPiece().getSide() == side) || (side == 'A'))){
					rTiles.add(tile);
				}
			}
		}
		System.out.println(vectorToTileArray(rTiles)[0].getBoardPiece());
		return vectorToTileArray(rTiles);
	}

	/**
	 * Converts a vector of tiles to an array of tiles.
	 * @param vec The vector of tiles to convert.
	 * @return An array containing the tiles from the vector.
	 */
	private Tile[] vectorToTileArray(Vector<Tile> vec){
		Tile[] tiles = new Tile[vec.size()];
		for(int i = 0; i < vec.size(); i++){
			tiles[i] = vec.get(i);
		}
		return tiles;
	}

	/**
	 * Prints the tiles from which the king is checked.
	 * @param tiles An array of tiles from which the king is checked.
	 */
	private void printIsChecked(Tile[] tiles){
		if(tiles.length == 0) return;
		for(int i = 0; i < tiles.length; i++){
			System.out.println(utils.convertTypeCharToString(tiles[i].getBoardPiece().getType()) + "At (" + tiles[i].getRow() + ", " + tiles[i].getColumn() + ")");
		}
	}

	/**
     * Moves a piece from the initial tile to the final tile.
     * @param initialRow The row index of the initial tile.
     * @param initialColumn The column index of the initial tile.
     * @param endRow The row index of the final tile.
     * @param endColumn The column index of the final tile.
     * @param side The side of the piece to be moved.
     * @return A receipt object containing information about the move.
     */
	public Receipt movePiece(int initialRow, int initialColumn, int endRow, int endColumn, char side){
		return movePiece(board[initialRow][initialColumn], board[endRow][endColumn], side);
	}

	public Receipt movePiece(Tile initialTile, Tile finalTile, char side){
		Receipt receipt = null;
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
			&& initialTile.isValidMove(finalTile, this) && this.isChecked(tileSearch('K', side)[0])[0].isEmpty() == false)
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
		} else if(this.isChecked(tileSearch('K', side)[0])[0].isEmpty() == false){
			System.out.println("Your king is in check");
			System.out.print("From");
			printIsChecked(this.isChecked(tileSearch('K', side)[0]));
		}

		return receipt;
	}

	/**
	 * Prints the details of a piece movement.
	 * @param row The row index of the initial tile.
	 * @param column The column index of the initial tile.
	 * @param end_row The row index of the final tile.
	 * @param end_column The column index of the final tile.
	 */
	private void printMovePiece(int row, int column, int end_row, int end_column){
		Piece current = this.getPiece(row, column);
		String currentSide = utils.convertSideCharToString(current.getSide());
		Piece end = this.getPiece(end_row, end_column);
		String endSide = utils.convertSideCharToString(end.getSide());

		System.out.println(currentSide + " " + endSide);
		System.out.println(" " + current.getType() + "  ->  " + end.getType());
		System.out.printf("(%d, %d)(%d, %d)\n", row, column, end_row, end_column);
	}

	/**
	 * Retrieves the value of the piece on the specified tile.
	 * @param tile The tile containing the piece.
	 * @return The value of the piece.
	 */
	public int getPieceValue(Tile tile) {
		return tile.getBoardPiece().getValue();
	}

	/**
	 * Retrieves the value of the piece on the tile at the specified row and column.
	 * @param row The row index of the tile.
	 * @param column The column index of the tile.
	 * @return The value of the piece.
	 */
	public int getPieceValue(int row, int column) {
		return board[row][column].getBoardPiece().getValue();
	}

	/**
	 * Retrieves the total value of the pieces on the board for the specified side.
	 * @param side The side of the pieces to calculate the value for. 'b' - Black, 'w' - White.
	 * @return The total value of the pieces.
	 */
	public int getValueOnBoard(char side) {
		int sum = 0;
		for (int row = 0; row < boardMax_row; row++) {
			for (int column = 0; column < boardMax_column; column++) {
				if (board[row][column].getBoardPiece().getSide() == side) {
					sum += board[row][column].getBoardPiece().getValue();
				}
			}
		}
		return sum;
	}

	/**
	 * Retrieves the number of moves made on the board.
	 * @return The number of moves made.
	 */
	public int getMoveNumber() {
		return moveNumber;
	}

	/**
	 * Retrieves the maximum number of rows on the board.
	 * @return The maximum number of rows.
	 */
	public int getBoardMaxRow() {
		return this.boardMax_row;
	}

	/**
	 * Retrieves the maximum number of columns on the board.
	 * @return The maximum number of columns.
	 */
	public int getBoardMaxColumn() {
		return this.boardMax_column;
	}

	/**
	 * Retrieves the index representing the black side of the board.
	 * @return The index representing the black side.
	 */
	public int getBlackSide() {
		return this.blackSide;
	}

	/**
	 * Retrieves the index representing the white side of the board.
	 * @return The index representing the white side.
	 */
	public int getWhiteSide() {
		return this.whiteSide;
	}
}		

package ui;

import board.Board;
import board.Tile;
import pieces.Piece;
import pieces.Receipt;
public class ChessGameTui extends ChessGameUi{
    Board board;
    public ChessGameTui(Board board){
        this.board = board;
    }

    public void renderChessBoard(Board board){
		int boardMaxRow = board.getBoardMaxRow();
		int boardMaxColumn = board.getBoardMaxColumn();
		char[] alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		System.out.println("Black");
		for(int row = 0; row < board.getBoardMaxRow(); row++){
			System.out.printf("%c|", alpha[boardMaxRow - row - 1]);
			for(int y = 0; y < board.getBoardMaxColumn(); y++){
				System.out.printf("%c ", board.getPiece(row, y).getType());
			}
			System.out.println();
		}
		for(int i = 0; i < boardMaxColumn; i++){
			System.out.printf("--");
		}
		System.out.println();
		System.out.print("  ");
		for(int i = 0; i < boardMaxColumn; i++){
			System.out.printf("%d ", i + 1);
		}
		System.out.printf("\nWhite\n");
		System.out.println();
	}

	public void printMovePiece(Receipt receipt){
		printMovePiece(initialTile.getRow(), initialTile.getColumn(), finalTile.getRow(), finalTile.getColumn());
	}

	public void printMovePiece(int row, int column, int end_row, int end_column){
		Piece current = this.getPiece(row, column);
		String currentSide = utils.convertSideCharToString(current.getSide());
		Piece end = this.getPiece(end_row, end_column);
		String endSide = utils.convertSideCharToString(end.getSide());

		System.out.println(currentSide + " " + endSide);
		System.out.println(" " + current.getType() + "  ->  " + end.getType());
		System.out.printf("(%d, %d)(%d, %d)\n", row, column, end_row, end_column);
	}


}

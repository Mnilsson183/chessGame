package ui;

import board.Board;
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



}

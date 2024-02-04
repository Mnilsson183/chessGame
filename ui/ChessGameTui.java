package ui;

import board.Board;
public class ChessGameTui extends ChessGameUi{
    Board board;
    public ChessGameTui(Board board){
        this.board = board;
    }

    public void renderChessBoard(Board board){
		System.out.println("Black");
		for(int row = 0; row < board.getBoardMaxRow(); row++){
			for(int y = 0; y < board.getBoardMaxColumn(); y++){
				System.out.printf("%c ", board.getPiece(row, y).getType());
			}
			System.out.println();
		}
		System.out.println("White");
		System.out.println();
	}



}

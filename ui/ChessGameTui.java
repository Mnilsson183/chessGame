package ui;

import board.Board;


/**
 * Text-based user interface (TUI) for the chess game.
 */
public class ChessGameTui extends ChessGameUi{
    private Board board;

    /**
     * Constructs a ChessGameTui object with the specified game board.
     * @param board The game board.
     */
    public ChessGameTui(Board board){
        this.board = board;
    }

    /**
     * Renders the chess board in the console.
     * @param board The game board to render.
     */
    public void renderChessBoard(Board board){
        int boardMaxRow = board.getBoardMaxRow();
        int boardMaxColumn = board.getBoardMaxColumn();
        char[] alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        String blueTerminalColor = "\u001B[34m";
        String redTerminalColor = "\u001B[31m";
        String whiteTerminalColor = "\u001B[37m";
        String printColor;
        System.out.println("Black");
        for(int row = 0; row < board.getBoardMaxRow(); row++){
            System.out.printf("%c|", alpha[boardMaxRow - row - 1]);
            for(int column = 0; column < board.getBoardMaxColumn(); column++){
                if(board.getPiece(row, column).getSide() == 'b') printColor = blueTerminalColor;
                else if(board.getPiece(row, column).getSide() == 'w') printColor = redTerminalColor;
                else printColor = whiteTerminalColor;
                System.out.print(printColor);
                System.out.printf("%c ", board.getPiece(row, column).getType());
                System.out.print(whiteTerminalColor);
            }
            System.out.println();
        }
        System.out.print(" +");
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

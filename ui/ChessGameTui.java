package ui;

import board.Board;
import controls.ChessGameCursor;
/**
 * Text-based user interface (TUI) for the chess game.
 */
public class ChessGameTui extends ChessGameUi{
    private Board board;
    ChessGameCursor player1;
    ChessGameCursor player2;

    /**
     * Constructs a ChessGameTui object with the specified game board.
     * @param board The game board.
     */
    public ChessGameTui(Board board){
        this.board = board;
        player1 = new ChessGameCursor(board.getBoardMaxRow(), board.getBoardMaxColumn());
        player2 = new ChessGameCursor(board.getBoardMaxRow(), board.getBoardMaxColumn());
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
        String blueCursorTerminalColor = "\u001B[46m";
        String redCursorTerminalColor = "\u001B[101m";
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
                if(row == player1.getRow() && column == player1.getColumn()){
                    System.out.print(blueCursorTerminalColor);
                } else if(row == player2.getRow() && column == player2.getColumn()){
                    System.out.print(redCursorTerminalColor);
                }
                System.out.printf("%c ", board.getPiece(row, column).getType());
                System.out.print(whiteTerminalColor);
                System.out.print("\u001B[0m");
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

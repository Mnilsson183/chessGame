import board.Board;
import board.Player;
import ui.ChessGameGui;
import ui.ChessGameTui;
import ui.ChessGameUi;

public class Game {
    public static void playGame(Board board, ChessGameUi chessGameUi){

        Player player_w = new Player('w');
        Player player_b = new Player('b');

        while(!isWinner(board)){
            board.printBoard(board);
            chessGameUi.renderChessBoard()
            while(player_w.makeMove(board) != null);
            board.printBoard(board);
            chessGameUi.renderChessBoard(board);
            while(player_b.makeMove(board) != null);
        }

        while(!isWinner(board)){
            chessGameUi.renderChessBoard(board);
            
        }
    }

    private static boolean isWinner(Board board){
        return false;
    }
}

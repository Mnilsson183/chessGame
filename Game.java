import board.Board;
import board.Player;
import ui.ChessGameUi;

public class Game {
    public static void playGame(Board board, ChessGameUi chessGameUi){

        Player player_w = new Player('w');
        Player player_b = new Player('b');

        while(!isWinner(board)){
            chessGameUi.renderChessBoard(board);
            while(player_w.makeMove(board) != null);
            chessGameUi.renderChessBoard(board);
            while (player_b.makeMove(board) != null);
            
        }
    }

    private static boolean isWinner(Board board){
        return false;
    }
}

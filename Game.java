import board.Board;
import board.Player;
import history.History;
import pieces.Receipt;
import ui.ChessGameUi;

public class Game {
    public static void playGame(Board board, ChessGameUi chessGameUi){

        Player player_w = new Player('w');
        Player player_b = new Player('b');

        History history = new History();
        Receipt returnedReceipt;   

        while(!isWinner(board)){
            chessGameUi.renderChessBoard(board);
            do{
                returnedReceipt = player_w.makeMove(board);
            } while(returnedReceipt == null);
            history.add(returnedReceipt);
            chessGameUi.renderChessBoard(board);
            do{
                returnedReceipt = player_b.makeMove(board);
            } while (returnedReceipt == null);
            
        }
    }

    private static boolean isWinner(Board board){
        return false;
    }
}

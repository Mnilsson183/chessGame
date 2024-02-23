package controls;
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

        chessGameUi.renderChessBoard(board);
        while(true){
            do{
                returnedReceipt = player_w.makeMove(board);
            } while(returnedReceipt == null);
            history.add(returnedReceipt);
            history.printReceipt();
            chessGameUi.renderChessBoard(board);
            if(checkIfWinner(board)) break;
            do{
                returnedReceipt = player_b.makeMove(board);
            } while (returnedReceipt == null);
            history.add(returnedReceipt);
            history.printReceipt();
            chessGameUi.renderChessBoard(board);
            if(checkIfWinner(board)) break;
        }
    }

    private static boolean checkIfWinner(Board board){
        return false;
    }
}

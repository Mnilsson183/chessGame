package controls;
import board.Board;
import ui.ChessGameGui;
import ui.ChessGameTui;
import ui.ChessGameUi;

public class Controller{
    public static void start(String[] s){
        Board board = new Board();
        ChessGameUi chessGameUi = null;
        if(s.length > 1 || s.length == 0){
            chessGameUi = new ChessGameGui();
        } else if(s[0].equals("--tui")){
            chessGameUi = new ChessGameTui(board);
        }
        Game.playGame(board, chessGameUi);
    }
}
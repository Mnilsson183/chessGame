package controls;
import board.Board;
import ui.ChessGameGui;
import ui.ChessGameTui;
import ui.ChessGameUi;

/**
 * The Controller class manages the starting of the chess game.
 * It initializes the game board and user interface based on command line arguments.
 */
public class Controller {

    static public ChessGameUi chessGameUi = null;
    static public Board board = null;
    /**
     * Starts the chess game.
     * @param cli Command line arguments passed to the program.
     */
    public static void start(String[] cli) {
        board = new Board();
        if (cli.length > 1 || cli.length == 0) {
            chessGameUi = new ChessGameGui();
        } else if (cli[0].equals("--tui")) {
            chessGameUi = new ChessGameTui(board);
        }
        Game.playGame(board, chessGameUi);
    }
}
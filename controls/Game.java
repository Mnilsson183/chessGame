package controls;
import board.Board;
import board.Player;
import history.History;
import pieces.Receipt;
import ui.ChessGameUi;

/**
 * The Game class manages the gameplay loop of the chess game.
 * It orchestrates player moves, maintains the game history, and checks for a winner.
 */
public class Game {

    /**
     * Plays the chess game.
     * @param board The game board.
     * @param chessGameUi The user interface for the game.
     */
    public static void playGame(Board board, ChessGameUi chessGameUi) {
        // Initialize players and history
        Player player_w = new Player('w');
        Player player_b = new Player('b');
        History history = new History();
        Receipt returnedReceipt;   

        // Render initial chess board
        chessGameUi.renderChessBoard(board);

        // Main game loop
        while (true) {
            // White player's turn
            do {
                returnedReceipt = player_w.makeMove(board, board.playerR);
            } while (returnedReceipt == null);
            history.add(returnedReceipt);
            history.printReceipt();
            chessGameUi.renderChessBoard(board);
            if (checkIfWinner(board)) break;

            // Black player's turn
            do {
                returnedReceipt = player_b.makeMove(board, board.playerB);
            } while (returnedReceipt == null);
            history.add(returnedReceipt);
            history.printReceipt();
            chessGameUi.renderChessBoard(board);
            if (checkIfWinner(board)) break;
        }
    }

    /**
     * Checks if there is a winner in the game.
     * @param board The game board.
     * @return true if there is a winner, false otherwise.
     */
    private static boolean checkIfWinner(Board board) {
        // Placeholder for checking win condition (e.g., checkmate)
        return false;
    }
}

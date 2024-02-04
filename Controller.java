import board.Board;
import ui.ChessGameUi;

class Controller{
    public Controller(){
        Board board = new Board();
        ChessGameUi chessGameUi = new ChessGameUi(board);
        Game.playGame(board, chessGameUi);
    }
}
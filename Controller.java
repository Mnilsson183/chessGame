import board.Board;
import ui.ChessGameGui;

class Controller{
    public Controller(){
        Board board = new Board();
        ChessGameGui chessGameUi = new ChessGameGui(board);
        Game.playGame(board, chessGameUi);
    }
}
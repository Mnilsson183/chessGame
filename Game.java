public class Game {
    public static void playGame(){

        Board board = new Board();
        Player player_w = new Player('w');
        Player player_b = new Player('b');

        while(!isWinner(board)){
            board.printBoard(board);
            player_w.makeMove(board);
            board.printBoard(board);
            player_b.makeMove(board);
        }
    }

    private static boolean isWinner(Board board){
        return false;
    }
}

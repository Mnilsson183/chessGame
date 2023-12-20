import java.util.Scanner;

public class Player {
    char side;

    public Player(char side){
        this.side = side;
    }
    
    public void makeMove(Board board){
        String s = getMove();
        Scanner input = new Scanner(s);
        board.movePiece(input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt());
        input.close();
    }

    private String getMove(){
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        input.close();
        return parseMove(s);
    }

    // parsed moves should be in the form " x y end_x end_y "
    private String parseMove(String lineIn){
        // TODO implement this
        return lineIn;
    }
}

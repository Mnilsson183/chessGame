package board;
import java.util.Scanner;

public class Player {
    char side;
    boolean isChecked;

    public Player(char side){
        this.side = side;
    }
    
    public boolean makeMove(Board board){
        String s = getMove();
        Scanner input = new Scanner(s);
        boolean b = board.movePiece(input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt(), this.side);
        input.close();
        return b;
    }

    private String getMove(){
        switch (this.getSide()) {
            case 'w':
                System.out.print("White ");
                break;
        
            case 'b':
                System.out.print("Black ");
                break;
        }
        System.out.println("make Move: ");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        return parseMove(s);
    }

    // parsed moves should be in the form " x y end_x end_y "
    private String parseMove(String lineIn){
        // TODO implement this
        return lineIn;
    }

    public char getSide(){
        return side;
    }
}

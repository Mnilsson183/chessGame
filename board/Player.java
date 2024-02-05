package board;
import java.util.Scanner;
import pieces.Receipt;
import utils.utils;
public class Player {
    char side;
    boolean isChecked;

    public Player(char side){
        this.side = side;
    }
    // TODO Note that the conversion in the utils
    // is not correct
    
    public Receipt makeMove(Board board){
        String s = getMove();
        Scanner input = new Scanner(s);
        Receipt receipt = board.movePiece(input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt(), this.side);
        input.close();
        return receipt;
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
        return utils.convertMixedForm(s);
    }

    public char getSide(){
        return side;
    }
}
package board;
import java.util.Scanner;
import pieces.Receipt;

public class Player {
    char side;
    boolean isChecked;

    public Player(char side){
        this.side = side;
    }
    
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
        return parseMove(s);
    }

    // parsed moves should be in the form "row column end_row end_column"
    // "A7 B6"
    private String parseMove(String lineIn){
        Scanner input = new Scanner(lineIn);

        String initial = input.next();
        String fin = input.next();
        
        String str = "" + convertAlphaRowToInt(initial.charAt(0)) + " " + initial.charAt(1);
        return str + " " + convertAlphaRowToInt(fin.charAt(0)) + " " + fin.charAt(1);
    }

    private int convertAlphaRowToInt(char c){
        char[] alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for(int i = 0; i < alpha.length; i++){
            if(alpha[i] == c){
                return i;
            }
        }
        return -1;
    }

    public char getSide(){
        return side;
    }
}

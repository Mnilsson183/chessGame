package board;
import java.util.Scanner;
import pieces.Receipt;
import utils.utils;

/**
 * The Player class represents a player in the chess game.
 * It manages the player's side (color) and provides methods for making moves.
 */
public class Player {

    /** The side (color) of the player. */
    char side;

    /** 
     * A flag indicating whether the player's king is currently in check. 
     * Initialized as false.
     */
    boolean isChecked;

    /**
     * Constructs a new Player object with the specified side.
     * @param side The side (color) of the player. 'w' - White, 'b' - Black.
     */
    public Player(char side){
        this.side = side;
    }
    
    /**
     * Makes a move on the board based on the player's input.
     * @param board The chess board on which the move is to be made.
     * @return A receipt object containing information about the move.
     */
    public Receipt makeMove(Board board){
        String s = getMove();
        Scanner input = new Scanner(s);
        Receipt receipt = board.movePiece(input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt(), this.side);
        input.close();
        return receipt;
    }

    /**
     * Retrieves the move input from the player.
     * @return The move input as a string.
     */
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
        String str = utils.convertMixedForm(s);
        return str;
    }

    /**
     * Gets the player's side (color).
     * @return The side of the player. 'w' - White, 'b' - Black.
     */
    public char getSide(){
        return side;
    }
}

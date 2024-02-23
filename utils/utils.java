package utils;

import java.util.Scanner;


/**
 * Utility class for various conversions and operations.
 */
public class utils {
    
    /**
     * Converts a character representing a side ('w' or 'b') to its corresponding string representation.
     * @param c The character representing the side.
     * @return The string representation of the side.
     */
    public static String convertSideCharToString(char c){
        if(c == 'w'){
            return "White";
        } else if(c == 'b'){
            return "Black";
        } else{
            return null;
        }
    }

    /**
     * Converts a character representing a piece type ('p', 'r', 'k', 'b', 'q', 'K') to its corresponding string representation.
     * @param c The character representing the piece type.
     * @return The string representation of the piece type.
     */
    public static String convertTypeCharToString(char c){
        switch (c) {
            case 'p':
                return "Pawn";
            case 'r':
                return "Rook";
            case 'k':
                return "Knight";
            case 'b':
                return "Bishop";
            case 'q':
                return "Queen";
            case 'K':
                return "King";
            default:
                return "";
        }
    }

    /**
     * Converts a mixed-formatted chess move string to the format used internally (e.g., "a2 a4" to "6 1 4 1").
     * @param lineIn The input string in mixed format.
     * @return The string representing the move in internal format.
     */
    public static String convertMixedForm(String lineIn){
        lineIn = lineIn.toLowerCase();
        Scanner input = new Scanner(lineIn);
        final int boardLength = 8; 

        String initial = input.next();
        String fin = input.next();
        
        String str = "" + (boardLength - convertAlphaRowToInt(initial.charAt(0)) - 1) + " " + (Integer.parseInt("" + initial.charAt(1)) - 1);
        return str + " " + (boardLength - convertAlphaRowToInt(fin.charAt(0)) - 1) + " " + (Integer.parseInt("" + fin.charAt(1)) - 1);
    }

    /**
     * Converts a character representing a row in chess notation to its integer representation.
     * @param c The character representing the row in chess notation.
     * @return The integer representation of the row.
     */
    private static int convertAlphaRowToInt(char c){
        char[] alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for(int i = 0; i < alpha.length; i++){
            if(alpha[i] == c){
                return i;
            }
        }
        return -1;
    }

    // TODO: Implement this method to convert internal format to mixed form
    // public static String convertToMixedForm(String lineIn){
    //     lineIn = lineIn.toLowerCase();
    //     return "";
    // }
}
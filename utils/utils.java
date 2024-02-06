package utils;

import java.util.Scanner;

public class utils {
    public static String convertSideCharToString(char c){
        if(c == 'w'){
            return "White";
        } else if(c == 'b'){
            return "Black";
        } else{
            return null;
        }
    }

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

    public static String convertMixedForm(String lineIn){
        lineIn = lineIn.toLowerCase();
        Scanner input = new Scanner(lineIn);
        final int boardLength = 8; 

        String initial = input.next();
        String fin = input.next();
        
        String str = "" + (boardLength - convertAlphaRowToInt(initial.charAt(0)) - 1) + " " + (Integer.parseInt("" + initial.charAt(1)) - 1);
        return str + " " + (boardLength - convertAlphaRowToInt(fin.charAt(0)) - 1) + " " + (Integer.parseInt("" + fin.charAt(1)) - 1);
    }

    private static int convertAlphaRowToInt(char c){
        char[] alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for(int i = 0; i < alpha.length; i++){
            if(alpha[i] == c){
                return i;
            }
        }
        return -1;
    }

    // TODO finish this to convert 1 1 4 0 to A4 B7 form
    public static String convertToMixedForm(String lineIn){
        lineIn = lineIn.toLowerCase();
        return "";
    }
}

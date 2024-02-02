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

    
}

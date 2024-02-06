package pieces;

import board.Board;
public class Bishop extends Piece{

    public Bishop(char side){
        super(side, 'b');
    }
    
    @Override
    public boolean isValidMove(int my_row, int my_column, int end_row, int end_column, Board board) {
        return isDiagonal(my_row, my_column, end_row, end_column) && !isBlocked(my_row, my_column, end_row, end_column, board);
    }

    private boolean isDiagonal(int my_row, int my_column, int end_row, int end_column){
        int change_row = Math.abs(end_row - my_row);
        int change_column = Math.abs(end_column - my_column);
        return change_row == change_column;
    }

    private boolean isBlocked(int initialRow, int initialColumn, int finalRow, int finalColumn, Board board){
            //  2 | 1
            // -------- (0,0) is the initial values
            //  3 | 4
            System.out.println("" + initialRow + initialColumn + finalRow + finalColumn);

            if(initialColumn > finalColumn){
                // quadrant 1
                if(initialRow > finalRow){
                    System.out.println("q1");
                    for(int i = 1; i + initialRow < finalRow; i++){
                        System.out.println("" + (initialRow + i) + (initialColumn + i));
                        if(!board.isEmpty(initialRow + i, initialColumn + i)) return true;
                    }
                // quadrant 4
                } else if(initialRow < finalRow){
                    System.out.println("q4");
                    for(int i = 1; initialRow - i < finalRow; i++){
                        if(!board.isEmpty(initialRow - i, initialColumn + i)) return true;
                    }
                }
            } else if(initialColumn < finalColumn){
                // quadrant 2
                if(initialRow > finalRow){
                    System.out.println("q2");
                    for(int i = 1; initialRow - i < finalRow; i++){
                        if(!board.isEmpty(initialRow + i, initialColumn - i)) return true;
                    }
                // quadrant 3
                } else if(initialRow < initialColumn){
                    System.out.println("q3");
                    for(int i = 1; initialRow - i > finalRow; i++){
                        if(!board.isEmpty(initialRow - i, initialColumn - i)) return true;
                    }
                }
            }
            return false;
    }
    
}
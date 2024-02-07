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

            // b  ->   
            // (3, 3)(4, 2)
            // q4
            

            if(initialColumn > finalColumn){
                if(initialRow > finalRow){
                    for(int i = 1; initialRow - i > finalRow; i++){
                        if(!board.isEmpty(initialRow - i, initialColumn - i)) return true;
                    }
                } else if(initialRow < finalRow){
                    for(int i = 1; initialRow - i < finalRow; i++){
                        if(!board.isEmpty(initialRow + i, initialColumn - i)) return true;
                    }
                }
            } else if(initialColumn < finalColumn){
                if(initialRow > finalRow){
                    System.out.println("q1");
                    for(int i = 1; initialRow - i > finalRow; i++){
                        if(!board.isEmpty(initialRow - i, initialColumn + i)) return true;
                    }
                } else if(initialRow < finalRow){
                    System.out.println("q4");
                    for(int i = 1; initialRow - i < finalRow; i++){
                        if(!board.isEmpty(initialRow + i, initialColumn + i)) return true;
                    }
                }
            }
            return false;
    }
    
}
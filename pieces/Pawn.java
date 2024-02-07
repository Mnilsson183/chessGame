package pieces;

import board.Board;
public class Pawn extends Piece{
    boolean firstMove;
    
    public Pawn(char side){
        super(side, 'p');
        this.firstMove = true;
    }

    @Override
    public boolean isValidMove(int my_row, int my_column, int end_row, int end_column, Board board) {
        boolean isValid = false;
        int rowDiff = Math.abs(my_row-end_row);
        if(!board.isEmpty(end_row, end_column)){
            return false;
        }

        if(this.firstMove){
            if(rowDiff == 1 || rowDiff == 2){
                boolean b = my_column == end_column;
                if(b){
                    this.firstMove = false;
                    return true;
                } else return false;
            }
        } else if(rowDiff == 1){
            return my_column == end_column;
        }

        return isValid || !isBlocked(my_row, my_column, end_row, end_column, board);
    }

    private boolean isFirstMove(int my_row){
        if(this.getSide() == 'w'){
            if(my_row == 6){
                return true;
            }
        } else if(this.getSide() == 'b'){
            if(my_row == 1){
                return true;
            }
        }

        return false;
    }

    private boolean isBlocked(int initialRow, int initialColumn, int finalRow, int finalColumn, Board board){
        for(int offset = 0; initialColumn + offset <= finalColumn; offset++){
            if(!board.isEmpty(initialRow, offset + initialColumn)){
                return true;
            }
        }
        return false;
    }
}
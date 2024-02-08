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
        if(end_column >= board.getBoardMaxColumn() || end_column < 0){
            return false;
        } else if(end_row >= board.getBoardMaxRow() || end_row < 0){
            return false;
        }
        int rowDiff = Math.abs(my_row-end_row);
        int columnDiff = Math.abs(my_column-end_column);
        if(columnDiff != 1){
            if(!board.isEmpty(end_row, end_column)){
                return false;
            }
        }

        if(this.firstMove){
            if((rowDiff == 1 || rowDiff == 2) && columnDiff == 0){
                boolean b = my_column == end_column;
                if(b){
                    this.firstMove = false;
                    return true;
                } else return false;
            }
        } else if(rowDiff == 1 && columnDiff == 0){
            return my_column == end_column;
        } else if(rowDiff == 1 && columnDiff == 1){
            System.out.println("" + this.getSide() + (end_row - my_row) + board.isEmpty(end_row,end_column));
            if((this.getSide() == 'w') && (end_row - my_row < 0) && (!board.isEmpty(end_row, end_column))){
                return true;
            } else if((this.getSide() == 'b') && (end_row - my_row > 0) && (!board.isEmpty(end_row, end_column))){
                return true;
            }
        }

        return false;
    }

    public boolean isOnPromotionSquare(int row, Board board){
        if(this.getSide() == 'w' && board.getBlackSide() == row){
            return true;
        } else if(this.getSide() == 'b' && board.getWhiteSide() == row){
            return true;
        } else return false;
    }

}
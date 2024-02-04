package pieces;
import board.Board;
public class King extends Piece{
    
    public King(char side){
        super(side);
        this.setType('K');
    }
    @Override
    public boolean isValidMove(int my_row, int my_column, int end_row, int end_column, Board board) {
        return Math.abs(end_row - my_row) < 1 && Math.abs(end_column - my_column) < 1;
    }
}

public class Bishop extends Piece{

    public Bishop(char side){
        super(side);
        this.setType('b');
    }
    
    @Override
    public boolean isValidMove(int my_row, int my_column, int end_row, int end_column) {
        return isDiagonal(my_row, my_column, end_row, end_column);
    }

    private boolean isDiagonal(int my_row, int my_column, int end_row, int end_column){
        int change_row = Math.abs(end_row - my_row);
        int change_column = Math.abs(end_column - my_column);
        return change_row == change_column;
    }
    
}
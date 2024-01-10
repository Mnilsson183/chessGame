public class Bishop extends Piece{

    public Bishop(char side){
        super(side);
        this.setType('b');
    }
    
    @Override
    public boolean isValidMove(int row, int column, int my_row, int my_column) {
        return isDiagonal(row, column, my_row, my_column);
    }

    private boolean isDiagonal(int row, int column, int my_row, int my_column){
        int change_row = row - my_row;
        int change_column = column - my_column;
        return change_row == change_column;
    }
    
}
public class Rook extends Piece {
    
    public Rook(char side){
        super(side);
        this.setType('r');
    }

    @Override
    public boolean isValidMove(int row, int column, int my_row, int my_column) {
        return isStraight(row, column, my_row, my_column);
    }

    private boolean isStraight(int row, int column, int my_row, int my_column){
        return (my_row == row) ^ (my_column == column);
    }
}

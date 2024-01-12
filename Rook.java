public class Rook extends Piece {
    
    public Rook(char side){
        super(side);
        this.setType('r');
    }

    @Override
    public boolean isValidMove(int my_row, int my_column, int end_row, int end_column) {
        return isStraight(my_row, my_column, end_row, end_column);
    }

    private boolean isStraight(int my_row, int my_column, int end_row, int end_column){
        return (my_row == end_row) ^ (my_column == end_column);
    }
}

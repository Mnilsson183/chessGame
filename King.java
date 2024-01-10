public class King extends Piece{
    
    public King(char side){
        super(side);
        this.setType('K');
    }
    @Override
    public boolean isValidMove(int row, int column, int my_row, int my_column) {
        return Math.abs(row - my_row) < 1 && Math.abs(column - my_column) < 1;
    }
}

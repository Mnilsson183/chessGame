public class Rook extends Piece {
    
    public Rook(char side){
        super(side);
        this.setType('r');
    }
    @Override
    public boolean isValidMove(int row, int column, int my_row, int my_column) {
        return ((my_row - row == 2 ^ my_column - column == 2) && (my_row - row == 1) ^ (my_column - column == 1));
    }
}

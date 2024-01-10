public class Pawn extends Piece{
    
    public Pawn(char side){
        super(side);
        this.setType('p');
    }
    @Override
    public boolean isValidMove(int row, int column, int my_row, int my_column) {
        boolean isValid = false;
        if(this.getSide() == 'w'){
            if(my_column - 1 == column && my_row == row) isValid = true;
        } else if(this.getSide() == 'b'){
            if(my_column + 1 == column && my_row == row) isValid = true;
        }

        return isValid;
    }
}
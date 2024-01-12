public class Pawn extends Piece{
    
    public Pawn(char side){
        super(side);
        this.setType('p');
    }

    @Override
    public boolean isValidMove(int my_row, int my_column, int end_row, int end_column) {
        boolean isValid = false;
        if(this.getSide() == 'w'){
            if(my_row - 1 == end_row && my_column == end_column) isValid = true;
        } else if(this.getSide() == 'b'){
            if(my_row + 1 == end_row && my_column == end_column) isValid = true;
        }

        return isValid;
    }
}
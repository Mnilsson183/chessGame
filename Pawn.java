public class Pawn extends Piece{
    
    public Pawn(char side){
        super(side);
        this.setType('p');
    }
    @Override
    public boolean isValidMove(int my_row, int my_column, int end_row, int end_column) {
        boolean isValid = false;
        System.out.println(end_row + " " + end_column + " " + my_row + " " + my_column);
        if(this.getSide() == 'w'){
            if(my_column - 1 == end_column && my_row == end_row) isValid = true;
        } else if(this.getSide() == 'b'){
            if(my_column + 1 == end_column && my_row == end_row) isValid = true;
        }
        System.out.println(isValid);

        return isValid;
    }
}
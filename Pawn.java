public class Pawn extends Piece{
    
    public Pawn(char side){
        super(side);
        this.setType('p');
    }
    @Override
    public boolean isValidMove(int x, int y, int my_x, int my_y) {
        boolean isValid = false;
        if(this.getSide() == 'w'){
            if(my_y - 1 == y && my_x == x) isValid = true;
        } else if(this.getSide() == 'b'){
            if(my_y + 1 == y && my_x == x) isValid = true;
        }

        return isValid;
    }
}
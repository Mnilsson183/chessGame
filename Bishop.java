public class Bishop extends Piece{

    public Bishop(char side){
        super(side);
        this.setType('b');
    }
    
    @Override
    public boolean isValidMove(int x, int y, int my_x, int my_y) {
        return isDiagonal(x, y, my_x, my_y);
    }

    private boolean isDiagonal(int x, int y, int my_x, int my_y){
        int change_x = x - my_x;
        int change_y = y - my_y;
        return change_x == change_y;
    }
    
}
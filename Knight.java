public class Knight extends Piece {
    
    public Knight(char side){
        super(side);
        this.setType('k');
    }
    @Override
    public boolean isValidMove(int x, int y, int my_x, int my_y) {
        return isStraight(x, y, my_x, my_y);
    }

    private boolean isStraight(int x, int y, int my_x, int my_y){
            return (my_x == x) ^ (my_y == y);
        }
}

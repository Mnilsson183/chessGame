public class King extends Piece{
    @Override
    public boolean isValidMove(int x, int y, int my_x, int my_y) {
        return Math.abs(x - my_x) < 1 && Math.abs(y = my_y) < 1;
    }
}

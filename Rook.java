public class Rook extends Piece {
    @Override
    public boolean isValidMove(int x, int y, int my_x, int my_y) {
        return ((my_x - x == 2 ^ my_y - y == 2) && (my_x - x == 1) ^ (my_y - y == 1));
    }
}
